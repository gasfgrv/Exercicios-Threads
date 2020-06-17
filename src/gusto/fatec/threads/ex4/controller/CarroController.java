package gusto.fatec.threads.ex4.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroController implements ActionListener {
	private JLabel carro1, carro2;
	private JLabel result;
	private JButton btnIniciar;

	public CarroController(JLabel carro1, JLabel carro2, JButton btnIniciar, JLabel result) {
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.btnIniciar = btnIniciar;
		this.result = result;
	}

	private void iniciar() {
		Thread c1 = new CarroThread(carro1, btnIniciar, result);
		Thread c2 = new CarroThread(carro2, btnIniciar, result);
		
		c1.start();
		c2.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		iniciar();
	}

}
