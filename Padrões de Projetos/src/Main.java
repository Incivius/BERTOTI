import observer.Anti.Investor;
import observer.Anti.Stock;
import observer.Pattern.ObserverInvestor;
import observer.Pattern.ObserverStock;

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


    Stock appleStock = new Stock("AAPL", 150.0);
        
        Investor investor1 = new Investor("John");
        Investor investor2 = new Investor("Alice");
        
        appleStock.setPrice(155.0);
        
        investor1.update(appleStock);
        investor2.update(appleStock);

    ObserverStock appleStockObserver = new ObserverStock("AAPL", 150.0);
        
        ObserverInvestor investorO1 = new ObserverInvestor("John");
        ObserverInvestor investorO2 = new ObserverInvestor("Alice");
        
        appleStockObserver.attach(investorO1);
        appleStockObserver.attach(investorO2);
        
        appleStock.setPrice(155.0);
}

}