package com.github.pablwoAraujo.list;

public class Main {

	public static void main(String[] args) {
		Lista lista = new Lista();
		for (int i = 0; i < 10; i++) {
			new Thread(new addElementsTask(lista, i)).start();
		}

		System.out.println(lista.toString());
	}
}
