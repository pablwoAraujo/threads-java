package com.github.pablwoAraujo.synchronizedList;

import java.util.List;

public class addElementsTask implements Runnable {

	private List<String> lista;
	private int threadNumber;

	public addElementsTask(List<String> lista, int threadNumber) {
		this.lista = lista;
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.add("Thread " + threadNumber + " - " + i);
		}
	}

}
