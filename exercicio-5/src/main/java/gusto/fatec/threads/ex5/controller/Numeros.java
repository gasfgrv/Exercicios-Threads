package gusto.fatec.threads.ex5.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Numeros extends Thread {

	private static int concluidos;
	private final int[] numeros = { 1, 2, 3, 4, 5, 6, 7 };
	private final Random giros = new Random();
	private final JTextField textField;
	private final JButton button;

	public Numeros(JTextField textField, JButton button) {
		this.textField = textField;
		this.button = button;
	}

	@Override
	public void run() {
		jogar();
	}

	private void jogar() {
		int totalDeGiros = giros.nextInt(151);
		apresentarOsNumeros(totalDeGiros);

		concluirRodada();
		
		if (concluidos == 3) {
			button.setVisible(true);
			reiniciarContagem();
		}

	}

	private void apresentarOsNumeros(int totalDeGiros) {
		for (int i = 0; i < totalDeGiros; i++) {
			button.setVisible(false);

			int posicao = giros.nextInt(numeros.length);
			String texto = Integer.toString(numeros[posicao]);
			textField.setText(texto);

			pararThread();
		}
	}

	private void pararThread() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void reiniciarContagem() {
		concluidos = 0;
	}

	public synchronized void concluirRodada() {
		concluidos += 1;
	}
}
