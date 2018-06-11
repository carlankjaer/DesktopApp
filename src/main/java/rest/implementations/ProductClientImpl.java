package rest.implementations;

import rest.DTO.Product;
import rest.interfaces.ProductClient;

/**
 * Created by magnus
 */
public class ProductClientImpl extends DefaultClientImpl<Product> implements ProductClient {
    public ProductClientImpl(String servicePath) {
        super("product");
    }
}
