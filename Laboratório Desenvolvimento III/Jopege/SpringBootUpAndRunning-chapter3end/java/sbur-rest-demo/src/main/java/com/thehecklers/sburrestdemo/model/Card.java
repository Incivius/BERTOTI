package com.thehecklers.sburrestdemo.model;

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;


public class Card {
	private String imagePath;
	private String id;
	private String nome;
	private String descrição;
	private String tipo;
	private Habilidade hab;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String imagePath, String id, String nome, String descrição, String tipo, Habilidade hab) {
		this.imagePath = imagePath;
		this.id = id;
		this.nome = nome;
		this.descrição = descrição;
		this.tipo = tipo;
		this.hab = hab;
	}

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

	public String getId() {
		return id;
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
