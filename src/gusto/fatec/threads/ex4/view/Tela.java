package gusto.fatec.threads.ex4.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gusto.fatec.threads.ex4.controller.CarroController;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 283);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(800, 0, 10, 100);
		contentPane.add(separator);
		
		JLabel lblCarro1 = new JLabel("Carro1");
		lblCarro1.setIcon(new ImageIcon("/Exercicios-Threads/src/gusto/fatec/threads/ex4/img/if_sportcar_285811.png"));
		lblCarro1.setBounds(12, 13, 64, 38);
		contentPane.add(lblCarro1);
		
		JLabel lblCarro2 = new JLabel("Carro2");
		lblCarro2.setIcon(new ImageIcon("/Exercicios-Threads/src/gusto/fatec/threads/ex4/img/if_sedan_285810.png"));
		lblCarro2.setBounds(12, 57, 64, 38);
		contentPane.add(lblCarro2);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(865, 198, 97, 25);
		contentPane.add(btnCorrer);
				
		JLabel resultado = new JLabel("");
		resultado.setHorizontalAlignment(SwingConstants.LEFT);
		resultado.setBounds(12, 113, 798, 110);
		contentPane.add(resultado);
		
		CarroController carro = new CarroController(lblCarro1, lblCarro2, btnCorrer, resultado);
		btnCorrer.addActionListener(carro);
	}
}
