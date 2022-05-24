package gusto.fatec.threads.ex4.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroController implements ActionListener {
	private final JLabel carro1;
	private final JLabel carro2;
	private final JLabel result;
	private final JButton btnIniciar;

	public CarroController(JLabel carro1, JLabel carro2, JButton btnIniciar, JLabel result) {
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.btnIniciar = btnIniciar;
		this.result = result;
	}

	private void iniciar() {
		Thread c1 = new CarroThread(carro1, btnIniciar, result);
		c1.setName("Carro 1");
		c1.start();

		Thread c2 = new CarroThread(carro2, btnIniciar, result);
		c2.setName("Carro 2");
		c2.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		result.setText("");
		iniciar();
	}

}
