package gusto.fatec.threads.ex4.controller;

import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroThread extends Thread {

    private static int contador;
    private final JLabel carro;
    private final JButton start;
    private final JLabel resultado;
    private final Random random;

    public CarroThread(JLabel carro, JButton start, JLabel resultado) {
        super();
        this.carro = carro;
        this.start = start;
        this.resultado = resultado;
        this.random = new Random();
    }

    @Override
    public void run() {
        correr();
    }

    private void correr() {
        start.setVisible(false);

        moverCarro(posicaoInicial(carro));
        
        encerrarCorrida();

        mostrarResultado();

        start.setVisible(true);

    }

    private void mostrarResultado() {
        String podio = "";

        if (contador == 1) {
            podio = resultado.getText() + "Vencedor: " + getName() + ". ";
        }

        if (contador == 2) {
            podio = resultado.getText() + "Perdedor: " + getName() + ". ";
            reiniciarContador();
        }

        resultado.setText(podio);
    }

    private void moverCarro(Rectangle posicao) {
        while (posicao.getX() <= 800) {
            int velocidadeMaxima = 100;
            posicao.x += gerarAleatorio(velocidadeMaxima);
            carro.setBounds(posicao);

            pararThread();
        }
    }

    private void pararThread() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private int gerarAleatorio(int valorMaximo) {
        return random.nextInt(valorMaximo);
    }

    private Rectangle posicaoInicial(JLabel carro) {
        return new Rectangle(12, carro.getY(), carro.getWidth(), carro.getHeight());
    }

    public synchronized void reiniciarContador() {
        contador = 0;
    }

    public synchronized void encerrarCorrida() {
        contador += 1;
    }

}
