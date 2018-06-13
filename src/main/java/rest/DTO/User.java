package rest.DTO;

import java.util.Date;

/**
 * Created by magnus
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Date date;
    private Role role;
    private Customer customer;

    private static int counter = 1;

    public User() {
        this.id = counter;
        counter++;
    }

    public User(String username, String password, String firstname, String lastname, Customer customer) {
        this.id = counter;
        counter++;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = new Date();
        this.role = Role.CUSTOMER;
        this.customer = customer;
    }

    public User(String username, String password, String firstname, String lastname) {
        this.id = counter;
        counter++;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = new Date();
        this.role = Role.EMPLOYEE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getNewId () {
        counter++;
        return counter-1;
    }

}
