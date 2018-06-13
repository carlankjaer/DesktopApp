package rest.DTO;

/**
 * Created by magnus
 */
public class Product {
    private int id;
    private String name;
    private double price;

    private static int counter = 1;

    public Product() {
        id = counter;
        counter++;
    }

    public Product(String name, double price) {
        this.id = counter;
        counter++;
        this.name = name;
        this.price = price;
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

    public static int getNewId () {
        counter++;
        return counter-1;
    }
}
