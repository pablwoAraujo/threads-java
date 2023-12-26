package com.github.pablwoAraujo.server;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class CommandC2CallsWebService implements Callable<String> {

	private PrintStream output;

	public CommandC2CallsWebService(PrintStream output) {
		this.output = output;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Running C2 command - calling the web service");
		output.println("processing C2 command - calling the web service");

		Thread.sleep(20000);
		int randomNumber = new Random().nextInt(100) + 1;

		System.out.println("C2 command calling the web service successfully");
		return Integer.toString(randomNumber);
	}

}
