package gusto.fatec.threads.ex1.view;

import gusto.fatec.threads.ex1.controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		Thread[] threads = new Thread[5];
		
		for (Thread thread : threads) {
			thread = new ThreadController();
			thread.start();
		}
	}

}
