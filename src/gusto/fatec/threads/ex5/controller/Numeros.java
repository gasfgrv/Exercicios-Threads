package gusto.fatec.threads.ex5.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Numeros extends Thread {
	private JTextField num;
	private JButton start;
	private Random giros = new Random();
	private final int[] numeros = new int[] { 1, 2, 3, 4, 5, 6, 7 };
	private static int aux;

	public Numeros(JTextField num, JButton start) {
		this.num = num;
		this.start = start;
	}

	private void jogo() {
		for (int i = 0; i < giros.nextInt(151); i++) {
			start.setVisible(false);
			num.setText(Integer.toString(numeros[giros.nextInt(numeros.length)]));
		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		aux++;
		
		if (aux == 3) {
			start.setVisible(true);
			aux = 0;
		}

	}

	@Override
	public void run() {
		jogo();
	}
}
