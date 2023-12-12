package com.github.pablwoAraujo.synchronizedList.printSynchronized;

public class PrintTask implements Runnable {

	private Lista lista;

	public PrintTask(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(i + " - " + lista.pegaElemento(i));
		}
	}

}
