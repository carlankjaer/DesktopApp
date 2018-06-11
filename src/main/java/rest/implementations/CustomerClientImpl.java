package rest.implementations;

import rest.DTO.Customer;
import rest.interfaces.CustomerClient;

/**
 * Created by magnus
 */
public class CustomerClientImpl extends DefaultClientImpl<Customer> implements CustomerClient {
    public CustomerClientImpl() {
        super("customer");
    }
}
