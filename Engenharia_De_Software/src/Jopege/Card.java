package Jopege2;

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;


public class Card {
	private String nome;
	private String descrição;
	private String tipo;
	private Habilidade hab;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String nome, String descrição, String tipo, Habilidade hab) {
		this.nome = nome;
		this.descrição = descrição;
		this.tipo = tipo;
		this.hab = hab;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Habilidade getHab() {
		return hab;
	}

	public void setHab(Habilidade hab) {
		this.hab = hab;
	}
	
	public String toString(){
		   return "\n ____________________________________"
	+ "\n Nome: " + this.nome + "\n Descrição: " + this.descrição + "\n Tipo:  " + this.tipo + "\n Habilidades: " + this.hab;
	}
}
