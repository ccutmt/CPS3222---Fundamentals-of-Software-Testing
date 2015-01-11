package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import Database.DBConnection;

public class ModelRunner {

	// specify how many threads(users) to create
	private final int USERS = 10;

	@Test
	public void runner() {
		long timeBefore = System.currentTimeMillis();
		ArrayList<Long> responseTimes = new ArrayList<>();
		// create threads
		ExecutorService thread_manager = Executors.newFixedThreadPool(USERS);
		DBConnection init = DBConnection.getInstance();

		try {
			// clear all tables to initialise conditions
			init.ExecuteQuery("DELETE FROM bets;");
			init.ExecuteQuery("DELETE FROM attempted_logins;");
			init.ExecuteQuery("DELETE FROM PLAYERS;");
		} catch (SQLException se) {
			se.printStackTrace();
		}

		for (int i = 0; i < USERS; i++) {
			Runnable ptest = new Model(responseTimes);
			thread_manager.execute(ptest);
		}
		thread_manager.shutdown();
		while (!thread_manager.isTerminated()) {
			// wait until executor service terminates safely
		}
		long timeAfter = System.currentTimeMillis();
		long total = 0;
		for (int i = 0; i < responseTimes.size(); i++) {
			total += responseTimes.get(i);
		}

		System.out.println("Total execution time for the test: "
				+ ((timeAfter - timeBefore) / 1000) + " seconds");

		System.out.println("Average response time per page: "
				+ (total / responseTimes.size()) + " milliseconds");
	}

}
