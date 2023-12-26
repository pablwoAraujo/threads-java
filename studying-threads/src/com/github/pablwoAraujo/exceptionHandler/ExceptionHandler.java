package com.github.pablwoAraujo.exceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Exceção " + e + " capturada na Thread " + t.getName());
	}
}
