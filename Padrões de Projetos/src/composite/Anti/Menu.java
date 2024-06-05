public package composite.Anti;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public Menu() {
        this.categories = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addProduct(Product product, String categoryName) {
        this.products.add(product);

        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                category.addProduct(product);
                return;
            }
        }

        Category newCategory = new Category(categoryName);
        newCategory.addProduct(product);
        this.categories.add(newCategory);
    }
}