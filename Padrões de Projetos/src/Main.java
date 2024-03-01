public class Main {

public static void main(String[] args) {
    
    CalculoIngressoAnti calculadora = new CalculoIngressoAnti();

    int idadeCrianca = 8;
    int idadeAdulto = 30;
    int idadeEstudante = 20;
    boolean estudante = true;

    double precoCrianca = calculadora.calcularPrecoCrianca(idadeCrianca);
    double precoAdulto = calculadora.calcularPrecoAdulto(idadeAdulto);
    double precoEstudante = calculadora.calcularPrecoEstudante(idadeEstudante, estudante);

    System.out.println("Preço do ingresso para criança: R$" + precoCrianca);
    System.out.println("Preço do ingresso para adulto: R$" + precoAdulto);
    System.out.println("Preço do ingresso para estudante: R$" + precoEstudante);

    CalculadoraIngresso calculadoraIngresso = new CalculadoraIngresso();

    calculadoraIngresso.setCalculadora(new CalculadoraPrecoCrianca());
    System.out.println("Preço do ingresso para criança: R$" + calculadoraIngresso.calcularPrecoIngresso(8));

    calculadoraIngresso.setCalculadora(new CalculadoraPrecoAdulto());
    System.out.println("Preço do ingresso para adulto: R$" + calculadoraIngresso.calcularPrecoIngresso(30));

    calculadoraIngresso.setCalculadora(new CalculadoraPrecoEstudante());
    System.out.println("Preço do ingresso para estudante: R$" + calculadoraIngresso.calcularPrecoIngresso(20));
}

}