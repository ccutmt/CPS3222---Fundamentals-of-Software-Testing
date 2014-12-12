package Database;
import java.sql.*; // for standard JDBC programs

public class DBConnection {
	public DBConnection(String query) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/softwaretestingdb", "andreas", "password");
			
			ExecuteQuery(con, query);

//			while (rs.next()) {
//				System.out.println(rs.getString(1) + " " + rs.getString(2)+ rs.getString(3)+ rs.getString(4)
//						+ rs.getDate(5) + rs.getInt(6) + rs.getDate(7)+rs.getInt(8));
//			}
//			
//			rs.close();
			CloseConnection(con);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	
	public boolean ExecuteQuery(Connection con, String query) throws SQLException{
		Statement stmt = con.createStatement();
		return stmt.execute(query);
	}
	
	public boolean InsertElement(String table, String name){
		return false;
	}

	public void CloseConnection(Connection con) throws SQLException{
		con.close();
	}
	
//	public static Connection getConnection(String URL, String username,
//			String password) throws SQLException {
//		Connection con = DriverManager.getConnection(
//	"jdbc:mysql://localhost:8080/softwaretestingdb", username, password);
//
//		return con;
//	}

//	public Statement createStatment(Connection con) throws SQLException {
//		Statement stmt = con.createStatement();
//
//		return stmt;
//	}
//
//	public ResultSet executeQuery(String sql, Statement stmt)
//			throws SQLException {
//		ResultSet rs = stmt.executeQuery(sql);
//
//		while (rs.next()) {
//			System.out.println(rs.getInt(1) + " " + rs.getString(2));
//		}
//
//		return rs;
//	}
//
//	public void close(Connection con) throws SQLException {
//		con.close();
//	}

}