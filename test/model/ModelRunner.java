package model;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ModelRunner {

	private final int USERS = 1;

	@Test
	public void runner() {
		long start_time = System.currentTimeMillis();
		ArrayList<Long> loadTimes = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(USERS);
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
