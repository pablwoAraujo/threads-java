package com.github.pablwoAraujo.synchronizedList.printSynchronized;

public class Main {

	public static void main(String[] args) {

		Lista lista = new Lista();

		for (int i = 0; i < 10; i++) {
			new Thread(new addElementsTask(lista, i)).start();
		}

		// Essa thread pode executar antes que as threads de adicionar
		// terminem de adicionar todos os elementos
		new Thread(new PrintTask(lista)).start();
	}
}
