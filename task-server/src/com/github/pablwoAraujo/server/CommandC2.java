package com.github.pablwoAraujo.server;

import java.io.PrintStream;

public class CommandC2 implements Runnable {

	private PrintStream output;

	public CommandC2(PrintStream output) {
		this.output = output;
	}

	@Override
	public void run() {
		System.out.println("Running C2 command");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException("Throwing error!");
		//output.println("C2 command executed successfully!");
	}

}
