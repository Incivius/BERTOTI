package Jopege;


public class Jogo {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.cadastrar();
		menu.CriarCarta();
		menu.CriarCartaInimiga();
		menu.jogadas();
		
		}
	}
