import java.sql.*; // for standard JDBC programs
import java.math.*; // for BigDecimal and BigInteger support

public class DBConnection {
	public DBConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8080/softwaretestingdb", "andreas", "password");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Players");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			
			con.close();
			
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
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
