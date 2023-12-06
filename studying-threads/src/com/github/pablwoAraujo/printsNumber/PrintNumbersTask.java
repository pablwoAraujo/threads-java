package com.github.pablwoAraujo.printsNumber;

public class PrintNumbersTask implements Runnable {

	private int number;

	public PrintNumbersTask(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 1; i <= number; i++) {
			Thread currentThread = Thread.currentThread();
			System.out.println(currentThread.getId() + " - " + i);
		}
	}

}
