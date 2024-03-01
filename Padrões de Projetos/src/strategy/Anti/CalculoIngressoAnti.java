public class CalculoIngressoAnti {

    public double calcularPrecoCrianca(int idade) {
        if (idade <= 10) {
            return 10.0;
        } else {
            return 20.0;
        }
    }

    public double calcularPrecoAdulto(int idade) {
        return 20.0;
    }

    public double calcularPrecoEstudante(int idade, boolean estudante) {
        if (estudante) {
            return 15.0;
        } else {
            return calcularPrecoAdulto(idade);
        }
    }
}
