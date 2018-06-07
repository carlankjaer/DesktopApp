package rest.interfaces;

import rest.DTO.User;

import java.util.List;

/**
 * Created by magnus
 */
public interface EmployeeClient {
    List<User> getAllEmployees ();
    User getEmployeeById (int id);
    void addEmployee (User employee);
    void updateEmployee (int id, User employee);
    void removeEmployee (int id);
}
