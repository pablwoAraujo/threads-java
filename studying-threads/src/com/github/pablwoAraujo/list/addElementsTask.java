package com.github.pablwoAraujo.list;

public class addElementsTask implements Runnable {

	private Lista lista;
	private int threadNumber;

	public addElementsTask(Lista lista, int threadNumber) {
		this.lista = lista;
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			lista.adicionaElementos("Thread " + threadNumber + " - " + i);
		}
	}

}
