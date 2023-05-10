package Jopege;

public class Vida {
	private double valor = 1000;

	public Vida() {}
	public Vida(int valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	public String toString() {
		return "Vida: " + this.valor;
		
	}
}
