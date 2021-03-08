package gusto.fatec.threads.ex5.view;

import gusto.fatec.threads.ex5.controller.Numeros;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
        setBounds(100, 100, 370, 213);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Font font = new Font("Tahoma", Font.PLAIN, 60);

        n1 = new JTextField();
        n1.setFont(font);
        n1.setHorizontalAlignment(SwingConstants.CENTER);
        n1.setEditable(false);
        n1.setBounds(12, 13, 100, 100);
        contentPane.add(n1);
        n1.setColumns(10);

        n2 = new JTextField();
        n2.setFont(font);
        n2.setHorizontalAlignment(SwingConstants.CENTER);
        n2.setEditable(false);
        n2.setBounds(124, 13, 100, 100);
        contentPane.add(n2);
        n2.setColumns(10);

        n3 = new JTextField();
        n3.setFont(font);
        n3.setHorizontalAlignment(SwingConstants.CENTER);
        n3.setEditable(false);
        n3.setBounds(236, 13, 100, 100);
        contentPane.add(n3);
        n3.setColumns(10);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(e -> iniciarThreads(btnIniciar));
        btnIniciar.setBounds(239, 126, 97, 25);
        contentPane.add(btnIniciar);
    }

    private void iniciarThreads(JButton button) {
        Thread t1 = new Numeros(n1, button);
        Thread t2 = new Numeros(n2, button);
        Thread t3 = new Numeros(n3, button);
        t1.start();
        t2.start();
        t3.start();
    }

}
