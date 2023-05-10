package Jopege2;


public class Habilidade {
	private int amor;
	private int defesa;
	private int ataque;
	private int psiquico;
	private int loucura;
	private int magia;

	public Habilidade() {}
	public Habilidade(int amor, int defesa, int ataque, int psiquico, int loucura, int magia) {
		this.amor = amor;
		this.defesa = defesa;
		this.ataque = ataque;
		this.psiquico = psiquico;
		this.loucura = loucura;
		this.magia = magia;
	}

	public int getAmor() {
		return amor;
	}

	public void setAmor(int amor) {
		this.amor = amor;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getPsiquico() {
		return psiquico;
	}

	public void setPsiquico(int psiquico) {
		this.psiquico = psiquico;
	}

	public int getLoucura() {
		return loucura;
	}

	public void setLoucura(int loucura) {
		this.loucura = loucura;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}
	public String toString(){
		   return "\n Amor: " + this.amor + "\n Defesa: " + this.defesa + "\n ataque:  " + this.ataque + "\n Psiquico: " + 
	this.psiquico + "\n Loucura: " + this.loucura + "\n magia: " + this.magia;
	}
}
