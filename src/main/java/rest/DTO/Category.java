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
    private Company company;

    public Category() {
    }

    public Category(int id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Category(int id, String name, List<Product> products, Company company) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
}

