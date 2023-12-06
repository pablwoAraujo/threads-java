package com.github.pablwoAraujo.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JLabel resultado;

	public ButtonAction(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Criando o código executável pela thread
		Runnable multiplication = new MultiplicationTask(primeiro, segundo, resultado);
		// Criando a Thread e passando o executável (runnable) e um nome
		Thread multiplicationThread = new Thread(multiplication, "Multiplication Thread");

		// iniciando a thread
		multiplicationThread.start();
	}
}
