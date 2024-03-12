package composite.Composite;

public class Main {
    public static void main(String[] args) {
        Composite box = new Composite("Box");

        Leaf pencil = new Leaf("Pencil", 1.50);
        Leaf notebook = new Leaf("Notebook", 10.0);

        box.addComponent(pencil);
        box.addComponent(notebook);

        System.out.println("Total Price: " + box.getPrice());
    }
}