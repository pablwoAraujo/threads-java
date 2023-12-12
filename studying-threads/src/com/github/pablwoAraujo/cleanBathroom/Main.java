package com.github.pablwoAraujo.cleanBathroom;

public class Main {

	public static void main(String[] args) {
		Bathroom bathroom = new Bathroom();

		Thread cleaner = new Thread(new CleaningTask(bathroom), "Cleaner");
		cleaner.setDaemon(true);
		Thread guest01 = new Thread(new NumberOneTask(bathroom), "João");
		Thread guest02 = new Thread(new NumberTwoTask(bathroom), "Pedro");
		// Thread guest03 = new Thread(new NumberOneTask(bathroom), "Pablwo");
		// Thread guest04 = new Thread(new NumberTwoTask(bathroom), "Mattheus");

		guest01.start();
		guest02.start();
		cleaner.start();
		// guest03.start();
		// guest04.start();
	}
}
