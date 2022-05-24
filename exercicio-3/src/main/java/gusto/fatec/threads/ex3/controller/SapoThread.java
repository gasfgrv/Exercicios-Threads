package gusto.fatec.threads.ex3.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SapoThread extends Thread {
	private final JLabel labelSapo;
	private final JButton btnInicial;
	private final Random random;
	private static int chegada;
	private static String podio = "Ordem de chegada: \n";

	public SapoThread(JLabel labelSapo, JButton btnInicial) {
		this.labelSapo = labelSapo;
		this.btnInicial = btnInicial;
		this.random = new Random();
	}

	@Override
	public void run() {
		btnInicial.setEnabled(false);
		correr();
	}

	private void correr() {
		moverSapo();
		setChegada();
		mostrarPodio(getName());
	}

	private static void mostrarPodio(String name) {
		podio += chegada + ") " + name + "\n";

		if (chegada == 5) {
			JOptionPane.showMessageDialog(null, podio, "Fim da corrida", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void moverSapo() {
		Rectangle posicao = labelSapo.getBounds();
		labelSapo.setBounds(posicao);

		while (posicao.getX() <= 600) {
			int saltoMax = 50;
			posicao.x += random.nextInt(saltoMax);
			labelSapo.setBounds(posicao);
			pararThread();
		}
	}

	private void pararThread() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	public synchronized void setChegada() {
		chegada++;
	}


}
