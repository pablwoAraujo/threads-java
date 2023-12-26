package com.github.pablwoAraujo.exceptionHandler;

import java.util.Properties;

public class main {

	public static void main(String[] args) {
		Properties properties = new Properties();
		Thread thread = new Thread(new LeitorPropriedades(properties, "assinaturas01.txt"));
		// definindo quem vai gerenciar os erros que acontecerem na thread
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
