package Jopege;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Menu {
	private ArrayList<Habilidade> Habs = new ArrayList<Habilidade>();
	private ArrayList<Habilidade> HabsI = new ArrayList<Habilidade>();
	private ArrayList<Usuario> users = new ArrayList<Usuario>();
	private ArrayList<Card> carta = new ArrayList<Card>();
	private ArrayList<Card> cartaI = new ArrayList<Card>();
	Vida vida = new Vida();
	Vida vidaInimigo = new Vida();
	Vida zero = new Vida(0);
	Scanner leia = new Scanner(System.in);
	Random random = new Random();
	
	private Arquetipo arqe;
	public Arquetipo getArqe() {
		return arqe;
	}

	public void setArqe(Arquetipo arqe) {
		this.arqe = arqe;
	}

	private int escolha;
	private int escolhaI = random.nextInt(3);
	private int jogada;
	private int jogadaI;
	private int pontos;
	
	public int getJogada() {
		return jogada;
	}

	public void setJogada(int jogada) {
		this.jogada = jogada;
	}

	public void cadastrar() {
		System.out.println("Qual o seu nome? ");
		String nome = leia.nextLine();
		System.out.println("Escolha seu Arquetipo: "
				+ "\n 1 - Coringa"
				+ "\n 2 - Abençoada"
				+ "\n 3 - Maromba"
				+ "\n 4 - Coach"
				+ "\n 5 - Mistica"
				+ "\n 6 - Emocionado");
		int numero = leia.nextInt();
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
			cadastrar();
			break;			
		}
		users.add(new Usuario(arqe, nome, 1));
		System.out.println("__________________________________________________________________________");
		}
	
	public void CriarCarta() {
			Habs.add(new Habilidade(40,50,80,90,20,40));
			Habs.add(new Habilidade(50,80,90,20,40,40));
			Habs.add(new Habilidade(80,90,20,40,40,50));
			carta.add(new Card("Cachorro caramelo", "Uma combinação unica de amor, carinho, malandragem e loucura, coisa de brasilehiro né? ", "É do Tipo amor", Habs.get(0)));
			carta.add(new Card("Dois caras em uma moto", "Você não quer encontrar esse monstro na rua a noite", "É do tipo Loucura", Habs.get(1)));
			carta.add(new Card("Lampião", "Dalhe peixada", "É do tipo Ataque", Habs.get(2)));
			System.out.println("\n ______ ESCOLHA UMA CARTA______");
			carta.forEach(System.out::println);
			System.out.println("\n _____________________________________________" + "\n Qual carta deseja escolher? 1 , 2 ou 3 (Apenas números, prfv)");
			escolha = leia.nextInt() - 1;
			System.out.println("Você escolheu: " + carta.get(escolha).toString());
			System.out.println("\n _____________________________________________");
	}
	
	public void CriarCartaInimiga() {
			HabsI.add(new Habilidade(40,50,70,60,20,70));
			HabsI.add(new Habilidade(60,80,80,90,30,50));
			HabsI.add(new Habilidade(70,40,90,50,20,40));
			cartaI.add(new Card("Boleto", "Eles vencem quando você menos espera", "ATAQUE", HabsI.get(0)));
			cartaI.add(new Card("FATEC", "Te mata aos poucos", "LOUCURA", Habs.get(1)));
			cartaI.add(new Card("Psicologo do SUS", "So manda brisa errada", "Psiquico", Habs.get(2)));
			System.out.println("O inimigo escolheu escolheu: " + cartaI.get(escolhaI).toString());
			System.out.println("\n _____________________________________________");
	}

	public int getEscolha() {
		return escolha;
	}

	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}

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

	public Vida lutarI(){
		if (arqe == Arquetipo.maromba) {
			vidaInimigo.setValor(vida.getValor() - (cartaI.get(escolha).getHab().getAtaque()* 1.2));
		}
		else {
			vidaInimigo.setValor(vida.getValor() - cartaI.get(escolha).getHab().getAtaque());
		}
		return vidaInimigo;
	}
	public Vida curarI(){
		if (arqe == Arquetipo.emocionado) {
			vida.setValor((cartaI.get(escolha).getHab().getAmor()* 1.2)	+ vidaInimigo.getValor());
		}
		else {
			vida.setValor(cartaI.get(escolha).getHab().getAmor()	+ vidaInimigo.getValor());
		}
		return vida;
	}
	public Vida defesaI(){
		if (arqe == Arquetipo.abençoada) {
			vida.setValor((cartaI.get(escolha).getHab().getDefesa() * 1.2) + vidaInimigo.getValor());
		}
		else {
			vida.setValor(cartaI.get(escolha).getHab().getDefesa() + vidaInimigo.getValor());
		}
			return vida;
	}
	public Vida encantamentoI(){
		if(arqe == Arquetipo.mistica) {
			vidaInimigo.setValor(vida.getValor() - (cartaI.get(escolha).getHab().getMagia() * 1.2));
		}
		else {
			vidaInimigo.setValor(vida.getValor() - cartaI.get(escolha).getHab().getMagia());
		}
			return vidaInimigo;
	}
	public Vida hipnoseI(){
		if(arqe == Arquetipo.coach) {
			vidaInimigo.setValor(vida.getValor() - (cartaI.get(escolha).getHab().getPsiquico() * 1.2));
		}
		else {
			vidaInimigo.setValor(vida.getValor() - cartaI.get(escolha).getHab().getPsiquico());
		}
			return vidaInimigo;
	}
	public Vida insanidadeI(){
		if(arqe == Arquetipo.coringa) {
			vidaInimigo.setValor(vida.getValor() - (cartaI.get(escolha).getHab().getLoucura() * 1.2));
		}
		else{ 
			vidaInimigo.setValor(vida.getValor() - cartaI.get(escolha).getHab().getLoucura());
		}
			return vidaInimigo;
	}
	public void jogadas() {
		while(pontos == 0) {
			if (vida.getValor() > 0 && vidaInimigo.getValor() > 0) {
			System.out.println("Qual jogada deseja fazer?"
					+ "\n 1 - LUTAR"
					+ "\n 2 - DEFENDER"
					+ "\n 3 - ENCANTAMENTO"
					+ "\n 4 - INSANIDADE "
					+ "\n 5 - HIPNOSE"
					+ "\n 6 - CURAR");
			jogada = leia.nextInt();
			jogadaI = random.nextInt(6);
			
			switch (jogada) {
			
			case 1:
				lutar();
				System.out.println(" Sua vida: " + vida
						+ "\n Vida do seu inimigo: " + vidaInimigo +
						"\n Sua Carta: " + carta.get(escolha).toString());
				System.out.println("__________________________________________");
				break;
			case 2:
				defesa();
				System.out.println(" Sua vida: " + vida
						+ "\n Vida do seu inimigo: " + vidaInimigo +
						"\n Sua Carta: " + carta.get(escolha).toString());
				System.out.println("__________________________________________");
				break;
			case 3:
				encantamento();
				System.out.println(" Sua vida: " + vida
						+ "\n Vida do seu inimigo: " + vidaInimigo +
						"\n Sua Carta: " + carta.get(escolha).toString());
				System.out.println("__________________________________________");
				break;
			case 4:
				insanidade();
				System.out.println(" Sua vida: " + vida
						+ "\n Vida do seu inimigo: " + vidaInimigo +
						"\n Sua Carta: " + carta.get(escolha).toString());
				System.out.println("__________________________________________");
				break;
			case 5:
				hipnose();
				System.out.println(" Sua vida: " + vida
						+ "\n Vida do seu inimigo: " + vidaInimigo +
						"\n Sua Carta: " + carta.get(escolha).toString());
				System.out.println("__________________________________________");
				break;
			case 6:
				curar();
				System.out.println(" Sua vida: " + vida
						+ "\n Vida do seu inimigo: " + vidaInimigo +
						"\n Sua Carta: " + carta.get(escolha).toString());
				System.out.println("__________________________________________");
				break;
				
			}
			switch (jogadaI) {
			
			case 1:
				lutarI();
				System.out.println(" Vida do Inimigo: " + vida
						+ "\n Sua vida: " + vidaInimigo +
						"\n Carta Inimiga: " + cartaI.get(escolhaI).toString());
				System.out.println("__________________________________________");
				break;
			case 2:
				defesaI();
				System.out.println(" Vida do Inimigo: " + vida
						+ "\n Sua vida: " + vidaInimigo +
						"\n Carta Inimiga: " + cartaI.get(escolhaI).toString());
				System.out.println("__________________________________________");
				break;
			case 3:
				encantamentoI();
				System.out.println(" Vida do Inimigo: " + vida
						+ "\n Sua vida: " + vidaInimigo +
						"\n Carta Inimiga: " + cartaI.get(escolhaI).toString());
				System.out.println("__________________________________________");
				break;
			case 4:
				insanidadeI();
				System.out.println(" Vida do Inimigo: " + vida
						+ "\n Sua vida: " + vidaInimigo +
						"\n Carta Inimiga: " + cartaI.get(escolhaI).toString());
				System.out.println("__________________________________________");
				break;
			case 5:
				hipnoseI();
				System.out.println(" Vida do Inimigo: " + vida
						+ "\n Sua vida: " + vidaInimigo +
						"\n Carta Inimiga: " + cartaI.get(escolhaI).toString());
				System.out.println("__________________________________________");
				break;
			case 6:
				curarI();
				System.out.println(" Vida do Inimigo: " + vida
						+ "\n Sua vida: " + vidaInimigo +
						"\n Carta Inimiga: " + cartaI.get(escolhaI).toString());
				System.out.println("__________________________________________");
				break;
				
			}
			
			if (vida.getValor() <= 0) {
				System.out.println("******* VOCÊ PERDEU **********");
				pontos = -1;
			}
			
			if (vidaInimigo.getValor() <= 0) {
				System.out.println("******* VOCÊ GANHOUUUU **********");
				pontos = 1;
			}
			}
		}
	}
}

