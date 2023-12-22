package com.github.pablwoAraujo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskServer {

	private static final int port = 12345;
	private ServerSocket server;
	private ExecutorService threadPool;
	private boolean running;

	public TaskServer() throws IOException {
		System.out.println("--- Starting the server ---");
		this.server = new ServerSocket(port);
		this.threadPool = Executors.newCachedThreadPool();
		this.running = true;
	}

	public static void main(String[] args) throws Exception {
		TaskServer taskServer = new TaskServer();
		taskServer.run();
		taskServer.stop();
	}

	private void run() throws IOException {
		while (this.running) {
			try {
				Socket socket = server.accept();
				System.out.println("Aceitando novo client na porta: " + socket.getPort());

				AllocateTasks allocateTasks = new AllocateTasks(socket, this);
				threadPool.execute(allocateTasks); // Buscando uma thread da pool para executar a tarefa
			} catch (SocketException e) {
				System.out.println(e);
			}
		}
	}

	public void stop() throws IOException {
		this.running = false;
		server.close();
		threadPool.shutdown();
	}

}
