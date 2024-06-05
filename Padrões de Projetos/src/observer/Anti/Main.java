package observer.Anti;

public static void main (String[] arg) {

    Stock appleStock = new Stock("AAPL", 150.0);
        
    Investor investor1 = new Investor("John");
    Investor investor2 = new Investor("Alice");
    
    appleStock.setPrice(155.0);
    
    investor1.update(appleStock);
    investor2.update(appleStock);
    
}