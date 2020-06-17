package gusto.fatec.threads.ex4.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroThread extends Thread {

	private JLabel carro;
	private JButton start;
	private JLabel result;
	private final int velMax = 100;
	private static int resultado;
	private static String podio;

	public CarroThread(JLabel carro, JButton start, JLabel result) {
		super();
		this.carro = carro;
		this.start = start;
		this.result = result;
	}

	private Rectangle initialBounds(JLabel carro) {
		Rectangle posicao = new Rectangle(12, carro.getY(), carro.getWidth(), carro.getHeight());

		return posicao;
	}

	private void corrida() {
		podio = "";

		result.setText(podio);
		Rectangle posicao = initialBounds(carro);
		Random arranque = new Random();
		start.setVisible(false);

		while (posicao.getX() <= 800) {
			posicao.x = posicao.x + arranque.nextInt(velMax);
			carro.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		resultado++;

		if (resultado == 1) {
			podio += "Vencedor: " + carro.getText() + " - ";
		}

		if (resultado == 2) {
			podio += "\n" + "Perdedor: " + carro.getText();
			start.setVisible(true);
			resultado = 0;
		}

		result.setText(podio);
	}

	@Override
	public void run() {
		corrida();
	}

}
