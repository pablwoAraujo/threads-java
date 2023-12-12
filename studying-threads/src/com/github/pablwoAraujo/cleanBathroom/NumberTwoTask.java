package com.github.pablwoAraujo.cleanBathroom;

public class NumberTwoTask implements Runnable {

	private Bathroom bathroom;

	public NumberTwoTask(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		bathroom.makeNumberTwo();
	}

}
