package com.github.pablwoAraujo.textualSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextualSearchTask implements Runnable {

	private String fileName;
	private String name;

	public TextualSearchTask(String fileName, String name) {
		this.fileName = fileName;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int rowNumber = 1;

			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();

				if (row.toLowerCase().contains(name.toLowerCase())) {
					System.out.println(fileName + " - " + rowNumber + " - " + row);
				}

				rowNumber++;
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
