package com.github.pablwoAraujo.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class AllocateTasks implements Runnable {

	private Socket socket;
	private TaskServer server;

	public AllocateTasks(Socket socket, TaskServer server) {
		this.socket = socket;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo as tarefas para o cliente: " + socket);

			Scanner inputClient = new Scanner(socket.getInputStream());
			PrintStream responseToClient = new PrintStream(socket.getOutputStream());

			while (inputClient.hasNextLine()) {
				String command = inputClient.nextLine();
				System.out.println("[" + socket.getLocalAddress() + ":" + socket.getPort() + "] " + command);

				switch (command) {
				case "c1": {
					responseToClient.println("c1 Command Confirmed");
					break;
				}
				case "c2": {
					responseToClient.println("c2 Command Confirmed");
					break;
				}
				case "close": {
					responseToClient.println("Shutting Down The Server");
					server.stop();
					break;
				}
				default: {
					responseToClient.println("Command Not Found");
					break;
				}
				}
			}

			responseToClient.close();
			inputClient.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
