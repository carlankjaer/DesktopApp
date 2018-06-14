package rest.interfaces;

import rest.DTO.Product;

/**
 * Created by magnus
 */
public interface ProductClient extends DefaultClient<Product> {
    Product postProduct (Product product, int categoryid);
}
