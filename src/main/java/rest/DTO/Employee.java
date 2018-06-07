package rest.DTO;

/**
 * Created by magnus
 */
public class Employee {
    private boolean admin;
    private Company company;

    public Employee () {
    }

    public Employee(boolean admin, Company company) {
        this.admin = admin;
        this.company = company;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
