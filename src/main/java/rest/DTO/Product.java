package rest.DTO;

/**
 * Created by magnus
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private Company company;

    private static int counter = 0;

    public Product() {
    }

    public Product(String name, double price, Company company) {
        this.id = counter;
        counter++;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
