package rest.implementations;

import rest.DTO.Category;
import rest.interfaces.CategoryClient;

import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * Created by magnus
 */
public class CategoryClientImpl extends DefaultClientImpl<Category> implements CategoryClient {
    public CategoryClientImpl() {
        super("product/category", Category.class, new GenericType<List<Category>>() {});
    }
}
