package rest.implementations;

import rest.DTO.Customer;
import rest.DTO.User;
import rest.interfaces.CustomerClient;

import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * Created by magnus
 */
public class CustomerClientImpl extends DefaultClientImpl<User> implements CustomerClient {
    public CustomerClientImpl() {
        super("customer", User.class, new GenericType<List<User>>() {});
    }
}
