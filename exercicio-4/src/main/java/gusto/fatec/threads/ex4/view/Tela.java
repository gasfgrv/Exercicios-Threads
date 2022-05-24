package gusto.fatec.threads.ex4.view;

import gusto.fatec.threads.ex4.controller.CarroController;
import java.net.URL;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

    private static final long serialVersionUID = 1L;

    public Tela() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        JSeparator separator = montarLinhaDeChegada();
        contentPane.add(separator);

        JLabel carro1 = montarCarro(13, getClass().getClassLoader().getResource("img/if_sedan_285810.png"));
        contentPane.add(carro1);

        JLabel carro2 = montarCarro(57, getClass().getClassLoader().getResource("img/if_sportcar_285811.png"));
        contentPane.add(carro2);

        JLabel resultado = montarResultado();
        contentPane.add(resultado);

        JButton button = montarBotao();
        button.addActionListener(
                new CarroController(
                        carro1,
                        carro2,
                        button,
                        resultado
                )
        );
        contentPane.add(button);

        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 283);
        setVisible(true);
    }

    private JLabel montarResultado() {
        JLabel resultado = new JLabel("");
        resultado.setHorizontalAlignment(SwingConstants.LEFT);
        resultado.setBounds(12, 113, 798, 110);
        return resultado;
    }

    private JButton montarBotao() {
        JButton btnCorrer = new JButton("Correr");
        btnCorrer.setBounds(865, 198, 97, 25);
        return btnCorrer;
    }

    private JLabel montarCarro(int y, URL icone) {
        JLabel lblCarro = new JLabel("");
        lblCarro.setIcon(new ImageIcon(icone));
        lblCarro.setBounds(12, y, 64, 38);

        return lblCarro;
    }

    private JSeparator montarLinhaDeChegada() {
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(800, 0, 10, 100);

        return separator;
    }
}
