package rest.implementations;

import rest.DTO.User;
import rest.interfaces.CustomerClient;

import java.util.List;

/**
 * Created by magnus
 */
public class CustomerClientImpl implements CustomerClient {
    @Override
    public List<User> getAllCustomers() {
        return null;
    }

    @Override
    public User getCustomerById(int id) {
        return null;
    }

    @Override
    public void addCustomer(User customer) {

    }

    @Override
    public void updateCustomer(int id, User customer) {

    }

    @Override
    public void removeCustomer(int id) {

    }
}
