package jogo.Modelo;

import javax.swing.JFrame;

public class Game extends JFrame{

	public Game() {
		add(new Fase());
		setTitle("JOPEGE");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Game();
	}

}
