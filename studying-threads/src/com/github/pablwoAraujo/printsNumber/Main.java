package com.github.pablwoAraujo.printsNumber;

public class Main {

	public static void main(String[] args) {
		int number = 1000;

		Thread printNumbersThread01 = new Thread(new PrintNumbersTask(number));
		Thread printNumbersThread02 = new Thread(new PrintNumbersTask(number));

		printNumbersThread01.start();
		printNumbersThread02.start();
	}
}
