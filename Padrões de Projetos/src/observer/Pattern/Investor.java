package observer.Pattern;

public class Investor {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(Stock stock) {
        System.out.println("Notificação para o investidor " + name + ": O preço da ação " + stock.getSymbol() + " mudou para " + stock.getPrice());
    }
}