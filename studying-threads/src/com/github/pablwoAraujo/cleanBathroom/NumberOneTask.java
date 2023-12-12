package com.github.pablwoAraujo.cleanBathroom;

public class NumberOneTask implements Runnable {

	private Bathroom bathroom;

	public NumberOneTask(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		bathroom.makeNumberOne();
	}

}
