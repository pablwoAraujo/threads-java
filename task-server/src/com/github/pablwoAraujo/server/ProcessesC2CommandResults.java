package com.github.pablwoAraujo.server;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ProcessesC2CommandResults implements Callable<Void> {

	private Future<String> futureDB;
	private Future<String> futureWS;
	private PrintStream output;

	public ProcessesC2CommandResults(Future<String> futureDB, Future<String> futureWS, PrintStream output) {
		this.futureDB = futureDB;
		this.futureWS = futureWS;
		this.output = output;
	}

	@Override
	public Void call() {
		System.out.println("Waiting for results from running the C2 Command");

		try {
			String resultDB = this.futureDB.get(20, TimeUnit.SECONDS);
			String resultWS = this.futureWS.get(20, TimeUnit.SECONDS);

			this.output.println("C2 Command Result (DB: " + resultDB + ", WS: " + resultWS + ")");
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Timeout: canceling execution of the C2 Command");
			this.output.println("Timeout on C2 Command");
			// Depois que ocorreu o timeout não faz mais sentido executar o código
			this.futureDB.cancel(true);
			this.futureWS.cancel(true);
		}

		System.out.println("Finishing processing C2 Command results");
		return null;
	}
}
