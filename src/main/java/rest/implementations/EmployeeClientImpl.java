package rest.implementations;

import rest.DTO.User;
import rest.interfaces.EmployeeClient;

import javax.ws.rs.core.GenericType;
import java.util.List;

/*
 * Created by magnus
 */
public class EmployeeClientImpl extends DefaultClientImpl<User> implements EmployeeClient {
    public EmployeeClientImpl() {
        super("employee", User.class, new GenericType<List<User>>() {});
    }
}
