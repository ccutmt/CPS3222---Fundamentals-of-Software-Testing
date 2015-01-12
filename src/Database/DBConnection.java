package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; // for standard JDBC programs
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	//singleton class
	

	// stores a single record with any amount of fields
	private ArrayList<ArrayList<String>> result;

	private static DBConnection dbConnection = null;
	
	//ensures that constructor can never be called outside this class
	private DBConnection() {
		this.result = new ArrayList<>();
	}

	//if there is no instance, create one, else return it.
	public static DBConnection getInstance()
	{
		if(dbConnection == null)
		{
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	public ArrayList<ArrayList<String>> ExecuteQuery(String query) throws SQLException {
		//clear any previous results
		this.result = new ArrayList<>();
		try {
			//connect to mysql db. Username: andreas, Password: password
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
		return result;
	}
}
