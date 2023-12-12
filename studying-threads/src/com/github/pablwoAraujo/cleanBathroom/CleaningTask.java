package com.github.pablwoAraujo.cleanBathroom;

public class CleaningTask implements Runnable {

	private Bathroom bathroom;

	public CleaningTask(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		bathroom.cleanBathroom();
	}

}
