package com.github.pablwoAraujo.cleanBathroom;

public class CleaningTask implements Runnable {

	private Bathroom bathroom;

	public CleaningTask(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		while (true) {
			bathroom.cleanBathroom();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
