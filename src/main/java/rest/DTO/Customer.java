package rest.DTO;

/**
 * Created by magnus
 */
public class Customer {
    private String phonenumber;
    private String mail;
    private String address;
    private Account account;

    public Customer() {
        this.account = new Account(0,0);
    }

    public Customer(String phonenumber, String mail, String address) {
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.address = address;
        this.account = new Account(0,0);
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
