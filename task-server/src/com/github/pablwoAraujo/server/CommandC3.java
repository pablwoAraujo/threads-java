package com.github.pablwoAraujo.server;

import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;

public class CommandC3 implements Runnable {

	private String command;
	private BlockingQueue<String> queue;
	private PrintStream responseToClient;

	public CommandC3(BlockingQueue<String> queue, PrintStream responseToClient, String command) {
		this.command = command;
		this.queue = queue;
		this.responseToClient = responseToClient;
	}

	@Override
	public void run() {
		try {
			this.queue.put(command); // Ação bloqueante
			responseToClient.println("C3 Command Added to Queue");
		} catch (InterruptedException e) {
			System.out.println("Exception thrown in the Command Consume: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
