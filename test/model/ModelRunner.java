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
		DBConnection init = new DBConnection();

		try {
			init.ExecuteQuery("DELETE FROM bets;");
			init.ExecuteQuery("DELETE FROM attempted_logins;");
			init.ExecuteQuery("DELETE FROM PLAYERS;");
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
		for (int i = 0; i < loadTimes.size(); i++) {
			total += loadTimes.get(i);
			System.out.println(i);
		}

		System.out.println("Total execution time for the test: "
				+ ((end_time - start_time) / 1000) + " seconds");

		System.out.println("Average response time per page: " + (total
				/ loadTimes.size())+" milliseconds");
	}

}
