package com.github.pablwoAraujo.server;

import java.net.ServerSocket;
import java.net.Socket;

public class TaskServer {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting the server ---");
		int port = 12345;
		ServerSocket server = new ServerSocket(port);

		Socket socket = server.accept();

	}

}
