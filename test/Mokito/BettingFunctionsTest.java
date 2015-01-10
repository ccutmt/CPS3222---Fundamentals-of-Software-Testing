package Mokito;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Database.DBConnection;
import Functions.BettingFunctions;

public class BettingFunctionsTest {
	BettingFunctions betFunc;
	private DBConnection DB;
	
	@Before
	public void setUp() throws Exception {
		DB = Mockito.mock(DBConnection.class);
		
		betFunc = new BettingFunctions();
		
		try{
			DB.ExecuteQuery("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
					+ "VALUES ( \"betFuncTest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"1\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");");
			DB.ExecuteQuery("DELETE from Bets where BetID=\"1\";");
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

	@Test
	public void getAllLowBetTest() {
		try {
		DB.ExecuteQuery("INSERT INTO bets ( Username, BetID, RiskLevel, Amount)"
				+ "VALUES ( \"betFuncTest\", \"1\",\"0\",\"5\");");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("<tr><td>1</td><td>Low</td><td>5</td>\n</tr>",betFunc.getAllBets("betFuncTest"));
	}
	
	@Test
	public void getAllMediumBetTest() {
		try {
			DB.ExecuteQuery("INSERT INTO bets ( Username, BetID, RiskLevel, Amount)"
					+ "VALUES ( \"betFuncTest\", \"1\",\"1\",\"5\");");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		assertEquals("<tr><td>1</td><td>Medium</td><td>5</td>\n</tr>",betFunc.getAllBets("betFuncTest"));
	}
	
	@Test
	public void getAllHighBetTest() {
		try {
			DB.ExecuteQuery("INSERT INTO bets ( Username, BetID, RiskLevel, Amount)"
					+ "VALUES ( \"betFuncTest\", \"1\",\"2\",\"5\");");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		assertEquals("<tr><td>1</td><td>High</td><td>5</td>\n</tr>",betFunc.getAllBets("betFuncTest"));
	}
	
	@After
	public void tearDown() throws Exception {
		try {
			DB.ExecuteQuery("DELETE from Bets where username=\"betFuncTest\";");
			DB.ExecuteQuery("DELETE from Players where username=\"betFuncTest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
