package rest.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by magnus
 */
public class Order {
    private int id;
    private Date date;
    private Status status;
    private User customer;
    private User employee;
    private List<Product> products = new ArrayList<>();

    private static int counter = 1;

    public Order () {
        this.id = counter;
        counter++;
    }

    public Order(User customer, User employee, List<Product> products) {
        this.id = counter;
        counter++;
        this.date = new Date();
        this.status = Status.error;
        this.customer = customer;
        this.employee = employee;
        this.products = products;
    }

    public Order(Status status, User customer, User employee, List<Product> products) {
        this.id = counter;
        counter++;
        this.date = new Date();
        this.status = status;
        this.customer = customer;
        this.employee = employee;
        this.products = products;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public static int getNewInt () {
        counter++;
        return counter-1;
    }
}
