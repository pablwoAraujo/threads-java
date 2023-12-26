package com.github.pablwoAraujo.server;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	private static int number = 1;

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r, "Task Server Thread " + number);

		number++;
		thread.setUncaughtExceptionHandler(new ExceptionHandler());

		return thread;
	}

}
