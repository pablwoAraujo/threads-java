package com.github.pablwoAraujo.list;

import java.util.Arrays;

public class Lista {
	private String[] elementos = new String[1000];
	private int indice = 0;

	// protengendo o método de duas ou mais threads acessarem simultaneamente, garantindo a consistência
//	public void adicionaElementos(String elemento) {
//		synchronized(this){
//			this.elementos[indice] = elemento;
//			this.indice++;			
//		}
//	}

	// Outra maneira de sincronizar o método
	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
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
}