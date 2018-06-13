package rest.DTO;

import java.util.List;

/**
 * Created by magnus
 */
public class OrderRequest {
    private Status status;
    private int customerid;
    private int employeeid;
    private List<Product> products;

    public OrderRequest () {
    }

    public OrderRequest(int customerid, int employeeid, List<Product> products) {
        this.status = Status.error;
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.products = products;
    }

    public OrderRequest(Status status, int customerid, int employeeid, List<Product> products) {
        this.status = status;
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
