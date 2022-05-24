package gusto.fatec.threads.ex3.view;


import gusto.fatec.threads.ex3.controller.SapoController;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

    private static final long serialVersionUID = 1L;

    public Tela() {
        URL img = getClass().getClassLoader().getResource("img/frog-filled.png");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton btnIniciar = montarBotao();
        contentPane.add(btnIniciar);

        JLabel sapo1 = montarSapo(13, img);
        contentPane.add(sapo1);

        JLabel sapo2 = montarSapo(126, img);
        contentPane.add(sapo2);

        JLabel sapo3 = montarSapo(239, img);
        contentPane.add(sapo3);

        JLabel sapo4 = montarSapo(352, img);
        contentPane.add(sapo4);

        JLabel sapo5 = montarSapo(465, img);
        contentPane.add(sapo5);

        JPanel panel = montarLinhaDeChegada();
        contentPane.add(panel);

        btnIniciar.addActionListener(new SapoController(sapo1, sapo2, sapo3, sapo4, sapo5, btnIniciar));

        setContentPane(contentPane);
        setTitle("Corrida de Sapos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(img));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 784);
        setVisible(true);
    }

    private JPanel montarLinhaDeChegada() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(600, 13, 3, 552);
        return panel;
    }

    private JLabel montarSapo(int y, URL img) {
        JLabel sapo1 = new JLabel("Sapo 1");
        sapo1.setIcon(new ImageIcon(img));
        sapo1.setBounds(12, y, 100, 100);

        return sapo1;
    }

    private JButton montarBotao() {
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(623, 699, 97, 25);
        return btnIniciar;
    }
}