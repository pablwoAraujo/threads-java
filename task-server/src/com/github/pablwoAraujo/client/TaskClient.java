package com.github.pablwoAraujo.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClient {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting the client ---");
		int port = 12345;

		Socket socket = new Socket("localhost", port);
		System.out.println("--- Connection established ---");

		// Enviando comandos para o servidor
		Thread sendCommands = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("--- Ready to send commands to the server ---");

					PrintStream output = new PrintStream(socket.getOutputStream());
					Scanner scanner = new Scanner(System.in);

					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();

						if (line.trim().equals("")) {
							break;
						}

						output.println(line);
					}
					scanner.close();
					output.close();
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
		});

		// Recebendo a resposta do servidor
		Thread receiveResponse = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("--- Ready to listen for server response ---");

					Scanner serverResponse = new Scanner(socket.getInputStream());

					while (serverResponse.hasNextLine()) {
						String line = serverResponse.nextLine();
						System.out.println("[" + socket.getLocalAddress() + ":" + socket.getPort() + "] " + line);
					}

					serverResponse.close();
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
		});

		receiveResponse.start();
		sendCommands.start();

		sendCommands.join();
		System.out.println("--- Closing the socket ---");
		socket.close();
	}

}
