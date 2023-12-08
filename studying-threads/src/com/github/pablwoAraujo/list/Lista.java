package com.github.pablwoAraujo.list;

import java.util.Arrays;

public class Lista {
	private String[] elementos = new String[100];
	private int indice = 0;

	public void adicionaElementos(String elemento) {
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