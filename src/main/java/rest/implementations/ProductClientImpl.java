package rest.implementations;

import rest.DTO.Category;
import rest.DTO.Product;
import rest.interfaces.ProductClient;

import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * Created by magnus
 */
public class ProductClientImpl extends DefaultClientImpl<Product> implements ProductClient {
    public ProductClientImpl() {
        super("product", Product.class, new GenericType<List<Product>>() {});
    }
}
