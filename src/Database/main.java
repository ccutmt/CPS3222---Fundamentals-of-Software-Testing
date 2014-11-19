package Database;
import java.sql.SQLException;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Printing table:");
			//DBConnection db = new DBConnection("SELECT * FROM PLAYERS");
			
			System.out.println("Inserting into table:");
			DBConnection db = new DBConnection("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV ) VALUES ( \"Test123\", \"test\", \"Chris\", \"Cutajar\", \"1994-12-12\", 1, 371449635398431, \"1994-12-12\", 123 );");
			
			System.out.println("Printing table:");
			//db = new DBConnection("SELECT * FROM PLAYERS");
		}catch (SQLException sc){
			System.out.println("DB Connection Error!");
			sc.printStackTrace();
		}
	}

}
