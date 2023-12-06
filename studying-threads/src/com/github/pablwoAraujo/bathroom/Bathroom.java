package com.github.pablwoAraujo.bathroom;

public class Bathroom {

	public void makeNumberOne() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Batendo na porta");

		synchronized (this) {
			System.out.println(name + " Entrando no banheiro");
			System.out.println(name + " Fazendo coisa rápida");
			threadSleep(5000);
			System.out.println(name + " Dando descarga");
			System.out.println(name + " Lavando as mãos");
			System.out.println(name + " Saindo no banheiro");
		}
	}

	public void makeNumberTwo() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Batendo na porta");

		synchronized (this) {
			System.out.println(name + " Entrando no banheiro");
			System.out.println(name + " Fazendo coisa demorada");
			threadSleep(10000);
			System.out.println(name + " Dando descarga");
			System.out.println(name + " Lavando as mãos");
			System.out.println(name + " Saindo no banheiro");
		}
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
