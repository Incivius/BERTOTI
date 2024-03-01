package observer.Anti;

public class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("O preço da ação " + symbol + " mudou para " + price);
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
