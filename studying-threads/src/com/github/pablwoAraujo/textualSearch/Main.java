package com.github.pablwoAraujo.textualSearch;

public class Main {

	public static void main(String[] args) {
		String name = "dan";

		Thread signatureThread01 = new Thread(new TextualSearchTask("assinaturas1.txt", name));
		Thread signatureThread02 = new Thread(new TextualSearchTask("assinaturas2.txt", name));
		Thread signatureThread03 = new Thread(new TextualSearchTask("autores.txt", name));

		signatureThread01.start();
		signatureThread02.start();
		signatureThread03.start();
	}
}
