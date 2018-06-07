package rest.DTO;

/**
 * Created by magnus
 */
public class Account {
    private int id;
    private double balance;
    private int limit;
    private int company_id;
    private int customer_id;

    private static int counter = 0;

    public Account () {
    }

    public Account(double balance, int limit, int company_id, int customer_id) {
        this.id = counter;
        counter++;
        this.balance = balance;
        this.limit = limit;
        this.company_id = company_id;
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    //Function taken from CDIO-final (2. semester) (Writer: Magnus Stjernborg Koch)
    public void withdraw (double amount) {
        //Ensure that that a negative value would function
        this.balance -= Math.abs(amount);
    }

    //Function taken from CDIO-final (2. semester) (Writer: Magnus Stjernborg Koch)
    public void deposit (double amount) {
        //Ensure that that a negative value would function
        this.balance += Math.abs(amount);
    }
}
