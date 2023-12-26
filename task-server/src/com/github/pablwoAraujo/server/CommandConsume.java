package com.github.pablwoAraujo.server;

import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;

public class CommandConsume implements Runnable {

	private PrintStream responseToClient;
	private BlockingQueue<String> queue;

	public CommandConsume(BlockingQueue<String> queue, PrintStream responseToClient) {
		this.queue = queue;
		this.responseToClient = responseToClient;
	}

	@Override
	public void run() {
		try {
			this.queue.take(); // Ação bloqueante
			responseToClient.println("Element consumed from the queue");
		} catch (InterruptedException e) {
			System.out.println("Exception thrown in the Command Consume: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
