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
	private ArrayList<String> result = new ArrayList<>();

	public DBConnection(String query) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/softwaretestingdb", "andreas",
					"password");

			// stmt = con.prepareStatement(query);

			ExecuteQuery(con, query);
			// System.out.println("ResultSet size:" + results.next());

			// while (rs.next()) {
			// System.out.println(rs.getString(1) + " " + rs.getString(2)+
			// rs.getString(3)+ rs.getString(4)
			// + rs.getDate(5) + rs.getInt(6) + rs.getDate(7)+rs.getInt(8));
			// }
			//
			// rs.close();
			con.close();
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public void ExecuteQuery(Connection con, String query) throws SQLException {
		Statement stmt = con.createStatement();
		if (query.contains("INSERT") || query.contains("UPDATE")
				|| query.contains("DELETE")) {
			stmt.execute(query);
		} else if (query.contains("SELECT")) {
			ResultSet results = stmt.executeQuery(query);

			if (results.next()) {
				// get number of columns
				ResultSetMetaData rsmd = results.getMetaData();
				int columnsNumber = rsmd.getColumnCount();

				// add all columns to arraylist
				for (int i = 1; i <= columnsNumber; i++) {
					result.add(results.getString(i));
				}
			}
			results.close();

		} else
			System.out.println("Query Execution error");

		stmt.close();

		// // testing start
		// int size = 0;
		// if (results != null) {
		// results.beforeFirst();
		// results.last();
		// size = results.getRow();
		// }
		//
		// System.out.println("Testing result set locally: " + size);
		// // testing end
	}

	public boolean InsertElement(String table, String name) {
		return false;
	}

	public void CloseConnection(Connection con) throws SQLException {
		con.close();
	}

	// public String getUsername() {
	// return this.username;
	// }
	//
	// public String getPassword() {
	// return this.password;
	// }

	public ArrayList<String> getResults() {
		return this.result;
	}

	// public static Connection getConnection(String URL, String username,
	// String password) throws SQLException {
	// Connection con = DriverManager.getConnection(
	// "jdbc:mysql://localhost:8080/softwaretestingdb", username, password);
	//
	// return con;
	// }

	// public Statement createStatment(Connection con) throws SQLException {
	// Statement stmt = con.createStatement();
	//
	// return stmt;
	// }
	//
	// public ResultSet executeQuery(String sql, Statement stmt)
	// throws SQLException {
	// ResultSet rs = stmt.executeQuery(sql);
	//
	// while (rs.next()) {
	// System.out.println(rs.getInt(1) + " " + rs.getString(2));
	// }
	//
	// return rs;
	// }
	//
	// public void close(Connection con) throws SQLException {
	// con.close();
	// }

}
