package rest.DTO;

/**
 * Created by magnus
 */
public class Account {
    private double balance;
    private int limit;

    public Account () {
        this.balance = 0;
        this.limit = 0;
    }

    public Account(double balance, int limit) {
        this.balance = balance;
        this.limit = limit;
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
