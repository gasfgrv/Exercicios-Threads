package gusto.fatec.threads.ex3.view;

import gusto.fatec.threads.ex3.controller.SapoController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(Tela::iniciarTela);
	}

	private static void iniciarTela() {
		try {
			Tela frame = new Tela();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Tela() {
		String iconPath = "/Exercicios-Threads/src/gusto/fatec/threads/ex3/img/frog-filled.png";

		setIconImage(Toolkit.getDefaultToolkit().getImage(iconPath));
		setResizable(false);
		setTitle("Corrida de Sapos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 784);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(623, 699, 97, 25);
		contentPane.add(btnIniciar);

		JLabel sapo1 = new JLabel("Sapo 1");
		sapo1.setIcon(new ImageIcon(iconPath));
		sapo1.setBounds(12, 13, 100, 100);
		contentPane.add(sapo1);

		JLabel sapo2 = new JLabel("Sapo 2");
		sapo2.setIcon(new ImageIcon(iconPath));
		sapo2.setBounds(12, 126, 100, 100);
		contentPane.add(sapo2);

		JLabel sapo3 = new JLabel("Sapo 3");
		sapo3.setIcon(new ImageIcon(iconPath));
		sapo3.setBounds(12, 239, 100, 100);
		contentPane.add(sapo3);

		JLabel sapo4 = new JLabel("Sapo 4");
		sapo4.setIcon(new ImageIcon(iconPath));
		sapo4.setBounds(12, 352, 100, 100);
		contentPane.add(sapo4);

		JLabel sapo5 = new JLabel("Sapo 5");
		sapo5.setIcon(new ImageIcon(iconPath));
		sapo5.setBounds(12, 465, 100, 100);
		contentPane.add(sapo5);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(600, 13, 3, 552);
		contentPane.add(panel);
		SapoController sapo = new SapoController(sapo1, sapo2, sapo3, sapo4, sapo5, btnIniciar);
		btnIniciar.addActionListener(sapo);
	}
}
