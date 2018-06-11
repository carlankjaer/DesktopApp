package rest.implementations;

import rest.DTO.Employee;
import rest.interfaces.EmployeeClient;

/**
 * Created by magnus
 */
public class EmployeeClientImpl extends DefaultClientImpl<Employee> implements EmployeeClient {
    public EmployeeClientImpl(String servicePath) {
        super("employee");
    }
}
