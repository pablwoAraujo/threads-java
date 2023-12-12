package com.github.pablwoAraujo.synchronizedList.printSynchronized;

import java.util.Arrays;

public class Lista {
	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;

		// Adicionando um delay na inserção
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.indice == this.tamanho()) {
			System.out.println("Lista está cheia, notificando");
			this.notify();
		}
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

	@Override
	public String toString() {
		return Arrays.toString(elementos);
	}

	public boolean isFull() {
		return this.indice == this.tamanho();
	}
}