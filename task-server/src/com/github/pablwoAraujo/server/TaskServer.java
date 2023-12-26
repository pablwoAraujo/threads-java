package com.github.pablwoAraujo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaskServer {

	private static final int port = 12345;
	private ServerSocket server;
	private ExecutorService threadPool;
	// Para evitar que cada thread faça o cache desse atributo e, quando houver
	// uma alteração, ela seja refletida diretamente na memória, utilizamos o
	// modificador "volatile"
	// private volatile boolean running;
	// Outra alternativa é usar o tipo "AtomicBoolean", que implementa por baixo
	// dos panos um boolean com o modificador "volatile".
	private AtomicBoolean running;
	private BlockingQueue<String> commandQueue;


	public TaskServer() throws IOException {
		System.out.println("--- Starting the server ---");
		this.server = new ServerSocket(port);

		// this.threadPool = Executors.newCachedThreadPool();
		this.threadPool = Executors.newFixedThreadPool(4, new CustomThreadFactory());

		this.running = new AtomicBoolean(true);
		
		// Instanciando a fila de comandos
		commandQueue = new ArrayBlockingQueue<String>(2);

	}

	public static void main(String[] args) throws Exception {
		TaskServer taskServer = new TaskServer();
		taskServer.run();
		taskServer.stop();
	}

	private void run() throws IOException {
		while (this.running.get()) {
			try {
				Socket socket = server.accept();
				System.out.println("Aceitando novo client na porta: " + socket.getPort());

				AllocateTasks allocateTasks = new AllocateTasks(threadPool, commandQueue, socket, this);
				// Buscando uma thread da pool para executar a tarefa
				threadPool.execute(allocateTasks);
			} catch (SocketException e) {
				System.out.println(e);
			}
		}
	}

	public void stop() throws IOException {
		this.running.set(false);
		server.close();
		threadPool.shutdown();
	}

}
