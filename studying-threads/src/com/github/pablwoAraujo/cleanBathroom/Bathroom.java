package com.github.pablwoAraujo.cleanBathroom;

public class Bathroom {

	private boolean dirty = true;

	public void makeNumberOne() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Batendo na porta");

		synchronized (this) {
			System.out.println(name + " Entrando no banheiro");

			while (dirty) {
				waitCleanBathroom(name);
			}

			System.out.println(name + " Fazendo coisa rápida");
			threadSleep(5000);
			this.dirty = true;

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

			while (dirty) {
				waitCleanBathroom(name);
			}

			System.out.println(name + " Fazendo coisa demorada");
			threadSleep(10000);
			this.dirty = true;

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

	private void waitCleanBathroom(String name) {
		System.out.println(name + " Banheiro está sujo");
		try {
			this.wait();
			// lock.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void cleanBathroom() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Batendo na porta");

		synchronized (this) {
			System.out.println(name + " Entrando no banheiro");

			if (!dirty) {
				System.out.println(name + " Verificou que o banheiro não está sujo");
				System.out.println(name + " Saindo no banheiro");
				return;
			}

			System.out.println(name + " Limpando o banheiro");

			threadSleep(13000);
			this.dirty = false;

			this.notifyAll();
			System.out.println(name + " Saindo no banheiro");
		}
	}
}
