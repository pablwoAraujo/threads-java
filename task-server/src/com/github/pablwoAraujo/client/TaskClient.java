package com.github.pablwoAraujo.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClient {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting the client ---");
		int port = 12345;

		Socket socket = new Socket("localhost", port);
		System.out.println("Conexao estabelecida");

		PrintStream print = new PrintStream(socket.getOutputStream());
		print.println("c1");

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		print.close();
		scanner.close();
		socket.close();
	}

}
