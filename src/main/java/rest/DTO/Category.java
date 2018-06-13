package rest.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magnus
 */
public class Category {
    private int id;
    private String name;
    private List<Product> products = new ArrayList<>();

    private static int counter = 0;

    public Category() {
        this.id = counter;
        counter++;
    }

    public Category(String name) {
        this.id = counter;
        counter++;
        this.name = name;
    }

    public Category(String name, List<Product> products) {
        this.id = counter;
        counter++;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct (Product product) {
        this.products.add(product);
    }

    public static int getNewId () {
        counter++;
        return counter-1;
    }
}

