package gusto.fatec.threads.ex3.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SapoThread extends Thread {
	private final JLabel labelSapo;
	private final JButton btnInicial;
	private static int chegada;

	public SapoThread(JLabel labelSapo, JButton btnInicial) {
		this.labelSapo = labelSapo;
		this.btnInicial = btnInicial;
	}

	private void corrida() {
		String podio = "";
		btnInicial.setEnabled(false);
		Rectangle posicao = labelSapo.getBounds();
		labelSapo.setBounds(posicao);
		while (posicao.getX() <= 600) {
			int saltoMax = 50;
			posicao.x = posicao.x + new Random().nextInt(saltoMax);
			labelSapo.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setChegada();
		podio += chegada + "�: " + labelSapo.getText() + "\n";
		if (chegada == 5) {
			JOptionPane.showMessageDialog(null, podio, "Fim da corrida", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static void setChegada() {
		SapoThread.chegada = chegada + 1;
	}

	@Override
	public void run() {
		corrida();
	}
}
