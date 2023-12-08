package com.github.pablwoAraujo.synchronizedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// Uma alternativa é usar Collections.synchronizedList
		// List<String> lista = Collections.synchronizedList(new ArrayList<String>());

		// Vector já é uma implementação thread safe
		List<String> lista = new Vector<String>();

		for (int i = 0; i < 10; i++) {
			new Thread(new addElementsTask(lista, i)).start();
		}

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " - " + lista.get(i));
		}
	}
}
