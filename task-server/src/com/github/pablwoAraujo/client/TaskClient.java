package com.github.pablwoAraujo.client;

import java.net.Socket;

public class TaskClient {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting the client ---");
		int port = 12345;

		Socket socket = new Socket("localhost", port);
		System.out.println("Conexao estabelecida");
		socket.close();
	}

}
