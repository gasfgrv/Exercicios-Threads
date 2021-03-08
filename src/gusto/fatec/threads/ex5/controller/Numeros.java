package gusto.fatec.threads.ex5.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Numeros extends Thread {
	private final JTextField num;
	private final JButton start;
	private final Random giros = new Random();
	private final int[] numeros = { 1, 2, 3, 4, 5, 6, 7 };
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
				Thread.currentThread().interrupt();
			}
		}
		
		setAux();
		
		if (aux == 3) {
			start.setVisible(true);
			setAux(0);
		}

	}

	public static void setAux(int aux) {
		Numeros.aux = aux;
	}

	public static void setAux() {
		Numeros.aux = aux + 1;
	}

	@Override
	public void run() {
		jogo();
	}
}
