package com.github.pablwoAraujo.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AllocateTasks implements Runnable {

	private Socket socket;

	public AllocateTasks(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo as tarefas para o cliente: " + socket);

			Scanner inputClient = new Scanner(socket.getInputStream());

			while (inputClient.hasNextLine()) {
				String command = inputClient.nextLine();
				System.out.println(command);
			}

			inputClient.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
