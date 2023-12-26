package com.github.pablwoAraujo.server;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Exception in thread " + t.getName() + ", " + e.getMessage());
	}

}
