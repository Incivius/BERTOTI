package Jopege;
//import java.util.ArrayList;

public class Usuario {
	private Arquetipo arquetipo;
	private String nome;
	private int codigo;
	
	public Usuario() {}
	public Usuario(Arquetipo arqe, String nome, int codigo) {
		this.arquetipo = arqe;
		this.nome = nome;
		this.codigo = codigo;
	}

	public Arquetipo getArquetipo() {
		return arquetipo;
	}

	public void setArquetipo(Arquetipo arquetipo) {
		this.arquetipo = arquetipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

//	public ArrayList<Card> getCard() {
//		return card;
//	}

//	public void setCard(ArrayList<Card> card) {
//	this.card = card;
//	}
	
}
