class CalculadoraIngresso {
    private CalculadoraPreco calculadora;

    public void setCalculadora(CalculadoraPreco calculadora) {
        this.calculadora = calculadora;
    }

    public double calcularPrecoIngresso(int idade) {
        if (calculadora == null) {
            throw new IllegalStateException("A estratégia de cálculo de preço não foi definida.");
        }
        return calculadora.calcularPreco(idade);
    }
}