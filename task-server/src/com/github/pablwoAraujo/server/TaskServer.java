package com.github.pablwoAraujo.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskServer {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting the server ---");
		int port = 12345;
		int numberOfThreads = 2;

		ServerSocket server = new ServerSocket(port);
		ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads); // criando um pool de threads de tamanho estático

		while (true) {
			Socket socket = server.accept();
			System.out.println("Aceitando novo client na porta: " + socket.getPort());

			AllocateTasks allocateTasks = new AllocateTasks(socket);
			threadPool.execute(allocateTasks); // Buscando uma thread da pool para executar a tarefa
		}

	}

}
