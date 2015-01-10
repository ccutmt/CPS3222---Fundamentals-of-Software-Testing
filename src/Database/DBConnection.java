package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; // for standard JDBC programs
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {

	// stores a single record with any amount of fields
	private ArrayList<ArrayList<String>> result;

	private static DBConnection dbConnection = null;
	
	private DBConnection() {
		this.result = new ArrayList<>();
	}

	
	public static DBConnection getInstance()
	{
		if(dbConnection == null)
		{
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	public void ExecuteQuery(String query) throws SQLException {
		this.result.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/softwaretestingdb", "andreas",
					"password");

			Statement stmt = con.createStatement();
			if (query.contains("INSERT") || query.contains("UPDATE")
					|| query.contains("DELETE")) {
				stmt.execute(query);
			} else if (query.contains("SELECT")) {
				ResultSet results = stmt.executeQuery(query);

				// loop for all records using the while
				while (results.next()) {
					// get number of columns
					ResultSetMetaData rsmd = results.getMetaData();
					int columnsNumber = rsmd.getColumnCount();

					ArrayList<String> record = new ArrayList<>();
					// add all columns to arraylist
					for (int i = 1; i <= columnsNumber; i++) {
						record.add(results.getString(i));
					}
					result.add(record);
				}
				results.close();

			} else
				System.out.println("Query Execution error");

			stmt.close();

			con.close();
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public ArrayList<ArrayList<String>> getResults() {
		return this.result;
	}
}
