package gusto.fatec.threads.ex5.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gusto.fatec.threads.ex5.controller.Numeros;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField n1;
	private JTextField n2;
	private JTextField n3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		n1 = new JTextField();
		n1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		n1.setHorizontalAlignment(SwingConstants.CENTER);
		n1.setEditable(false);
		n1.setBounds(12, 13, 100, 100);
		contentPane.add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		n2.setHorizontalAlignment(SwingConstants.CENTER);
		n2.setEditable(false);
		n2.setBounds(124, 13, 100, 100);
		contentPane.add(n2);
		n2.setColumns(10);
		
		n3 = new JTextField();
		n3.setFont(new Font("Tahoma", Font.PLAIN, 60));
		n3.setHorizontalAlignment(SwingConstants.CENTER);
		n3.setEditable(false);
		n3.setBounds(236, 13, 100, 100);
		contentPane.add(n3);
		n3.setColumns(10);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new Numeros(n1, btnNewButton);
				Thread t2 = new Numeros(n2, btnNewButton);
				Thread t3 = new Numeros(n3, btnNewButton);
				t1.start();
				t2.start();
				t3.start();
			}
		});
		btnNewButton.setBounds(239, 126, 97, 25);
		contentPane.add(btnNewButton);
	}

}
