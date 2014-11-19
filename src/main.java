import java.sql.SQLException;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			DBConnection db = new DBConnection();
		}catch (SQLException sc){
			System.out.println("DB Connection Error!");
			sc.printStackTrace();
		}
	}

}
