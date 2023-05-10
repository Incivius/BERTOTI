package jogo.Modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Inimigo {
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	
	private static final int Largura = 938;
	private static int velocidade = 2;
	
	public Inimigo(int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
		
	}
	public void load() {
		ImageIcon referencia = new ImageIcon("");
		imagem = referencia.getImage();
	}

}
