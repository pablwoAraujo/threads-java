package com.github.pablwoAraujo.server;

import java.net.Socket;

public class AllocateTasks implements Runnable {

	private Socket socket;

	public AllocateTasks(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Distribuindo as tarefas para o cliente: " + socket);

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
