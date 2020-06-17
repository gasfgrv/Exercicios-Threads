package gusto.fatec.threads.ex3.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SapoThread extends Thread {
	private JLabel labelSapo;
	private JButton btnInicial;
	private final int saltoMax = 50;
	private static int chegada;
	private static String podio;

	public SapoThread(JLabel labelSapo, JButton btnInicial) {
		this.labelSapo = labelSapo;
		this.btnInicial = btnInicial;
	}

	private void corrida() {
		podio = "";
		Random distanciaSalto = new Random();
		btnInicial.setEnabled(false);
		Rectangle posicao = labelSapo.getBounds();
		labelSapo.setBounds(posicao);
		while (posicao.getX() <= 600) {
			posicao.x = posicao.x + distanciaSalto.nextInt(saltoMax);
			labelSapo.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		chegada++;
		podio += chegada + "�: " + labelSapo.getText() + "\n";
		if (chegada == 5) {
			JOptionPane.showMessageDialog(null, podio, "Fim da corrida", JOptionPane.PLAIN_MESSAGE);
		}
	}

	@Override
	public void run() {
		corrida();
	}
}
