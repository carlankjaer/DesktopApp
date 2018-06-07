package rest.implementations;

import rest.DTO.User;
import rest.interfaces.EmployeeClient;

import java.util.List;

/**
 * Created by magnus
 */
public class EmployeeClientImpl implements EmployeeClient {
    @Override
    public List<User> getAllEmployees() {
        return null;
    }

    @Override
    public User getEmployeeById(int id) {
        return null;
    }

    @Override
    public void addEmployee(User employee) {

    }

    @Override
    public void updateEmployee(int id, User employee) {

    }

    @Override
    public void removeEmployee(int id) {

    }
}
