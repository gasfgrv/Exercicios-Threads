package gusto.fatec.threads.ex3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SapoController implements ActionListener {
	private final JLabel sapo1;
	private final JLabel sapo2;
	private final JLabel sapo3;
	private final JLabel sapo4;
	private final JLabel sapo5;
	private final JButton btnIniciar;


	public SapoController(JLabel sapo1, JLabel sapo2, JLabel sapo3, JLabel sapo4, JLabel sapo5, JButton btnIniciar) {
		this.sapo1 = sapo1;
		this.sapo2 = sapo2;
		this.sapo3 = sapo3;
		this.sapo4 = sapo4;
		this.sapo5 = sapo5;
		this.btnIniciar = btnIniciar;
	}

	private void correr() {
		Thread t1 = new SapoThread(sapo1, btnIniciar);
		t1.setName("Sapo 1");
		t1.start();

		Thread t2 = new SapoThread(sapo2, btnIniciar);
		t2.setName("Sapo 2");
		t2.start();

		Thread t3 = new SapoThread(sapo3, btnIniciar);
		t3.setName("Sapo 3");
		t3.start();

		Thread t4 = new SapoThread(sapo4, btnIniciar);
		t4.setName("Sapo 4");
		t4.start();

		Thread t5 = new SapoThread(sapo5, btnIniciar);
		t5.setName("Sapo 5");
		t5.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		correr();
	}

}
