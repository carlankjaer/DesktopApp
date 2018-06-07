package rest.DTO;

import java.util.List;

/**
 * Created by magnus
 */
public class OrderRequest {
    private int companyid;
    private Status status;
    private int customerid;
    private int employeeid;
    private List<Product> products;

    public OrderRequest () {

    }

    public OrderRequest(int companyid, Status status, int customerid, int employeeid, List<Product> products) {
        this.companyid = companyid;
        this.status = status;
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.products = products;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
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
