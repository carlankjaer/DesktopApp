package rest.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magnus
 */
public class Company {
    private int id;
    private String name;
    private String address;
    public static List<Company> companies = new ArrayList<>();

    static {
        companies.add(new Company(1, "PF"));
        companies.add(new Company(2, "Køge frisør"));
        companies.add(new Company(3, "Netto"));
    }

    public Company() {}

    public Company(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
