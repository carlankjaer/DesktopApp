package rest.DTO;

import java.util.List;

/**
 * Created by magnus
 */
public class Customer {
    private String phonenumber;
    private String mail;
    private String address;
    private List<Account> accounts;

    public Customer() {}

    public Customer(String phonenumber, String mail, String address) {
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount (Account account) {
        this.accounts.add(account);
    }
}
