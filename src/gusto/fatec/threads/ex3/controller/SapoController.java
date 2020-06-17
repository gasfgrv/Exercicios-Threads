package gusto.fatec.threads.ex3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SapoController implements ActionListener {
	private JLabel sapo1, sapo2, sapo3, sapo4, sapo5;
	private JButton btnIniciar;


	public SapoController(JLabel sapo1, JLabel sapo2, JLabel sapo3, JLabel sapo4, JLabel sapo5, JButton btnIniciar) {
		this.sapo1 = sapo1;
		this.sapo2 = sapo2;
		this.sapo3 = sapo3;
		this.sapo4 = sapo4;
		this.sapo5 = sapo5;
		this.btnIniciar = btnIniciar;
	}

	private void corrida() {
		Thread t1 = new SapoThread(sapo1, btnIniciar);
		Thread t2 = new SapoThread(sapo2, btnIniciar);
		Thread t3 = new SapoThread(sapo3, btnIniciar);
		Thread t4 = new SapoThread(sapo4, btnIniciar);
		Thread t5 = new SapoThread(sapo5, btnIniciar);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		corrida();
	}

}
