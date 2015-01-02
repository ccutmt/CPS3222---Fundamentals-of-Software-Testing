package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import Database.DBConnection;

public class ModelRunner {

	private final int USERS = 5;

	@Test
	public void runner() {
		long start_time = System.currentTimeMillis();
		ArrayList<Long> loadTimes = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(USERS);
		
		try {
			new DBConnection("DELETE FROM bets;");
			new DBConnection("DELETE FROM attempted_logins;");
			new DBConnection("DELETE FROM PLAYERS;");
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		for (int i = 0; i < USERS; i++) {
			Runnable ptest = new Model(loadTimes);
			executor.execute(ptest);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		long end_time = System.currentTimeMillis();
		long total = 0;
		for (long i : loadTimes) {
			total += i;
		}

		System.out.println("Total execution time for the test: "
				+ (start_time - end_time));

		System.out.println("Average response time per page: " + total
				/ loadTimes.size());
	}

}
