package gusto.fatec.threads.ex5.view;

import gusto.fatec.threads.ex5.controller.Numeros;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

    public Tela() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane.add(montarTextField(12), 0);
        contentPane.add(montarTextField(124), 1);
        contentPane.add(montarTextField(236), 2);
        contentPane.add(montarBotao(), 3);

        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 370, 213);
        setVisible(true);
    }

    private JTextField montarTextField(int x) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 60));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(false);
        textField.setBounds(x, 13, 100, 100);
        textField.setColumns(10);

        return textField;
    }

    private JButton montarBotao() {
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(e -> iniciarThreads(btnIniciar));
        btnIniciar.setBounds(239, 126, 97, 25);
        return btnIniciar;
    }

    private void iniciarThreads(JButton button) {
        JPanel contentPane = (JPanel) getContentPane();

        Thread t1 = new Numeros((JTextField) contentPane.getComponent(0), button);
        t1.start();

        Thread t2 = new Numeros((JTextField) contentPane.getComponent(1), button);
        t2.start();

        Thread t3 = new Numeros((JTextField) contentPane.getComponent(2), button);
        t3.start();
    }

}
