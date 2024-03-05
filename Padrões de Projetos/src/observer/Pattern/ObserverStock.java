package observer.Pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverStock {
    private String symbol;
    private double price;
    private List<ObserverInvestor> investors = new ArrayList<>();

    public ObserverStock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void attach(ObserverInvestor investor) {
        investors.add(investor);
    }

    public void detach(ObserverInvestor investor) {
        investors.remove(investor);
    }

    private void notifyInvestors() {
        for (ObserverInvestor investor : investors) {
            investor.update(this);
        }
    }
}
