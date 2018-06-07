package rest.interfaces;

import rest.DTO.User;

import java.util.List;

/**
 * Created by magnus
 */
public interface CustomerClient {
    List<User> getAllCustomers ();
    User getCustomerById (int id);
    void addCustomer (User customer);
    void updateCustomer (int id, User customer);
    void removeCustomer (int id);
}
