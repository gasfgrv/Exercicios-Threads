package gusto.fatec.threads.ex4.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroThread extends Thread {

	private final JLabel carro;
	private final JButton start;
	private final JLabel result;
	private static int resultado;

	public CarroThread(JLabel carro, JButton start, JLabel result) {
		super();
		this.carro = carro;
		this.start = start;
		this.result = result;
	}

	private Rectangle initialBounds(JLabel carro) {
		return new Rectangle(12, carro.getY(), carro.getWidth(), carro.getHeight());
	}

	private void corrida() {
		String podio = "";

		result.setText(podio);
		Rectangle posicao = initialBounds(carro);
		start.setVisible(false);

		while (posicao.getX() <= 800) {
			int velMax = 100;
			posicao.x = posicao.x + new Random().nextInt(velMax);
			carro.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

		setResultado();

		if (resultado == 1) {
			podio += "Vencedor: " + carro.getText() + " - ";
		}

		if (resultado == 2) {
			podio += "\n" + "Perdedor: " + carro.getText();
			start.setVisible(true);
			setResultado(0);
		}

		result.setText(podio);
	}

	public static void setResultado(int resultado) {
		CarroThread.resultado = resultado;
	}

	public static void setResultado() {
		CarroThread.resultado = resultado + 1;
	}

	@Override
	public void run() {
		corrida();
	}

}
