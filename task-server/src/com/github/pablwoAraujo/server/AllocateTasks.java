package com.github.pablwoAraujo.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class AllocateTasks implements Runnable {

	private Socket socket;
	private TaskServer server;
	private ExecutorService threadPool;

	public AllocateTasks(ExecutorService threadPool, Socket socket, TaskServer server) {
		this.socket = socket;
		this.server = server;
		this.threadPool = threadPool;
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
					CommandC1 c1 = new CommandC1(responseToClient);
					threadPool.execute(c1);
					break;
				}
				case "c2": {
					responseToClient.println("c2 Command Confirmed");
					CommandC2AccessDatabase c2DB = new CommandC2AccessDatabase(responseToClient);
					CommandC2CallsWebService c2WS = new CommandC2CallsWebService(responseToClient);

					Future<String> futureDB = threadPool.submit(c2DB);
					Future<String> futureWS = threadPool.submit(c2WS);

					this.threadPool.submit(new ProcessesC2CommandResults(futureDB, futureWS,responseToClient));
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
