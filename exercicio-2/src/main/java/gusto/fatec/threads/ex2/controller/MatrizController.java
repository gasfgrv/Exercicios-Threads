package gusto.fatec.threads.ex2.controller;

public class MatrizController extends Thread {
	private int[][] matriz = new int[3][5];
	private int linha;
	
	public MatrizController(int[][] matriz, int linha) {
		this.matriz = matriz;
		this.linha = linha;
	}
	
	private void calcLinha(int[][] matriz, int linha) {
		int soma = 0;
		for (int i = 0; i < matriz[linha].length; i++) {
			soma += matriz[linha][i];
		}
		System.out.println("Linha: " + (linha+1) + " = " + soma);
	}
	
	@Override
	public void run() {
		calcLinha(matriz, linha);
	}
}
