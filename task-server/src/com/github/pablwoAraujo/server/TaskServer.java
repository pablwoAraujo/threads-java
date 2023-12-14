package com.github.pablwoAraujo.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskServer {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting the server ---");
		int port = 12345;

		ServerSocket server = new ServerSocket(port);
		// Criando um pool de threads de tamanho estático
		// ExecutorService threadPool = Executors.newFixedThreadPool(2);

		// Criando um pool de threads de tamanho dinâmico
		ExecutorService threadPool = Executors.newCachedThreadPool();

		while (true) {
			Socket socket = server.accept();
			System.out.println("Aceitando novo client na porta: " + socket.getPort());

			AllocateTasks allocateTasks = new AllocateTasks(socket);
			threadPool.execute(allocateTasks); // Buscando uma thread da pool para executar a tarefa
		}

	}

}
