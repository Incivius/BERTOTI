package composite.Anti;

public class Main {
    public static void main(String[] args) {
        Product pencil = new Product("Pencil", 1.50);
        Product notebook = new Product("Notebook", 10.0);

        System.out.println("Product: " + pencil.getName() + ", Price: " + pencil.getPrice());
        System.out.println("Product: " + notebook.getName() + ", Price: " + notebook.getPrice());
    }
}