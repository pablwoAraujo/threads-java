package com.github.pablwoAraujo.synchronizedList.printSynchronized;

public class PrintTask implements Runnable {

	private Lista lista;

	public PrintTask(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		// Simulando um atrazo para começar a imprimir, nesse contexto
		// todas as threads já notificaram antes dessa thread chamar o wait()
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		synchronized (lista) {
			if (!lista.isFull()) {
				try {
					System.out.println("Esperando, aguardando notificacao");
					lista.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}

			for (int i = 0; i < lista.tamanho(); i++) {
				System.out.println(i + " - " + lista.pegaElemento(i));
			}
		}

	}

}
