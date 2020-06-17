package gusto.fatec.threads.ex2.view;

import java.util.Random;

import gusto.fatec.threads.ex2.controller.MatrizController;

public class Main {

	public static void main(String[] args) {
		int[][] matriz = new int[3][5];
		Thread[] threads = new Thread[3];
		Random gerador = new Random();

		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 5; c++) {
				matriz[l][c] = gerador.nextInt(101);
			}
		}
		
		for (int l = 0; l < 3; l++) {
			threads[l] = new MatrizController(matriz, l);
			threads[l].start();
		}
	}

}
