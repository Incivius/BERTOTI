package com.thehecklers.sburrestdemo.model;
import java.util.ArrayList;

public class Menu {
	static private ArrayList<Habilidade> habs = new ArrayList<Habilidade>();
	static private ArrayList<UsuarioJogo> users = new ArrayList<UsuarioJogo>();
	static private ArrayList<Card> carta = new ArrayList<Card>();
	Vida vida = new Vida();
	Vida vidaInimigo = new Vida();
	private Arquetipo arqe;
	private int escolha;
	
	public Double getVida() { return vida.getValor();
	}
	public Double getVidaInimigo() { return vidaInimigo.getValor();
	}
	// public ArrayList<Habilidade> getHabs() { return this.habs;
	// }
	// public ArrayList<Card> getCarta() { return this.carta;
	// }
	// public ArrayList<UsuarioJogo> getUser() { return this.users;
	// }
	

	public void cadastrar(String nome, int numero) {
		switch(numero){
		case 1:
			this.arqe = Arquetipo.coringa;
			break;
		case 2:
			this.arqe = Arquetipo.abençoada;
			break;
		case 3:
			this.arqe = Arquetipo.maromba;
			break;
		case 4:
			this.arqe = Arquetipo.coach;
			break;
		case 5:
			this.arqe = Arquetipo.mistica;
			break;
		case 6:
			this.arqe = Arquetipo.emocionado;
			break;
		default:
			break;
		}
		users.add(new UsuarioJogo(arqe, nome, 1));
	}
		
		public void mudarArqe(int numero) {
			switch(numero){
			case 1:
				arqe = Arquetipo.coringa;
				break;
			case 2:
				arqe = Arquetipo.abençoada;
				break;
			case 3:
				arqe = Arquetipo.maromba;
				break;
			case 4:
				arqe = Arquetipo.coach;
				break;
			case 5:
				arqe = Arquetipo.mistica;
				break;
			case 6:
				arqe = Arquetipo.emocionado;
				break;
			default:
				break;
			}
			users.get(0).setArquetipo(arqe);
		}
	// public void criarCartaUser(String nome, String descrição, String tipo, ArrayList<Habilidade> hab) {
	// 		carta.add(new Card(nome, descrição, tipo, habs.get(3)));

	// }
	
	// public void criarCarta(int cartaEscolhida) {
	// 		habs.add(new Habilidade(40,50,80,90,20,40));
	// 		habs.add(new Habilidade(50,80,90,20,40,40));
	// 		habs.add(new Habilidade(80,90,20,40,40,50));
	// 		carta.add(new Card("Cachorro caramelo", "Uma combinação unica de amor, carinho, malandragem e loucura, coisa de brasilehiro né? ", "É do Tipo amor", habs.get(0)));
	// 		carta.add(new Card("Dois caras em uma moto", "Você não quer encontrar esse monstro na rua a noite", "É do tipo Loucura", habs.get(1)));
	// 		carta.add(new Card("Lampião", "Dalhe peixada", "É do tipo Ataque", habs.get(2)));
	// 		this.escolha = cartaEscolhida - 1;
	// }


	public Vida lutar(){
		if (arqe == Arquetipo.maromba) {
			vidaInimigo.setValor(vidaInimigo.getValor() - (carta.get(escolha).getHab().getAtaque()* 1.2));
		}
		else {
			vidaInimigo.setValor(vidaInimigo.getValor() - carta.get(escolha).getHab().getAtaque());

			
		}
		return vidaInimigo;
	}
	public Vida curar(){
		if (arqe == Arquetipo.emocionado) {
			vida.setValor((carta.get(escolha).getHab().getAmor()* 1.2)	+ vida.getValor());
		}
		else {
			vida.setValor(carta.get(escolha).getHab().getAmor()	+ vida.getValor());
		}
		return vida;
	}
	public Vida defesa(){
		if (arqe == Arquetipo.abençoada) {
			vida.setValor((carta.get(escolha).getHab().getDefesa() * 1.2) + vida.getValor());
		}
		else {
			vida.setValor(carta.get(escolha).getHab().getDefesa() + vida.getValor());
		}
			return vida;
	}
	public Vida encantamento(){
		if(arqe == Arquetipo.mistica) {
			vidaInimigo.setValor(vidaInimigo.getValor() - (carta.get(escolha).getHab().getMagia() * 1.2));
		}
		else {
			vidaInimigo.setValor(vidaInimigo.getValor() - carta.get(escolha).getHab().getMagia());
		}
			return vidaInimigo;
	}
	public Vida hipnose(){
		if(arqe == Arquetipo.coach) {
			vidaInimigo.setValor(vidaInimigo.getValor() - (carta.get(escolha).getHab().getPsiquico() * 1.2));
		}
		else {
			vidaInimigo.setValor(vidaInimigo.getValor() - carta.get(escolha).getHab().getPsiquico());
		}
			return vidaInimigo;
	}
	public Vida insanidade(){
		if(arqe == Arquetipo.coringa) {
			vidaInimigo.setValor(vidaInimigo.getValor() - (carta.get(escolha).getHab().getLoucura() * 1.2));
		}
		else{
			vidaInimigo.setValor(vidaInimigo.getValor() - carta.get(escolha).getHab().getLoucura());
		}
			return vidaInimigo;
	}
	
	public void jogadas(int jogada, int i) {
		while(i == 0) {
			if (vida.getValor() > 0 && vidaInimigo.getValor() > 0) {
				i = 1;
				switch (jogada) {
				case 1:
					lutar();
					break;
				case 2:
					defesa();
					break;
				case 3:
					encantamento();
					break;
				case 4:
					insanidade();
					break;
				case 5:
					hipnose();
					break;
				case 6:
					curar();

					break;
					
				}
			if (vida.getValor() <= 0) {
				i = 1;
			}
			
			if (vidaInimigo.getValor() <= 0) {
				i = 1;
			}
		}
		}
	}
}

