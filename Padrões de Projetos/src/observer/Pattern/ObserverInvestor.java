package observer.Pattern;

public class ObserverInvestor implements StockObserver{
    private String name;

    public ObserverInvestor(String name) {
        this.name = name;
    }

    public void update(ObserverStock stock) {
        System.out.println("Notificação para o investidor " + name + ": O preço da ação " + stock.getSymbol() + " mudou para " + stock.getPrice());
    }
}