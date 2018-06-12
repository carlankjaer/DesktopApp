package rest.implementations;

import rest.DTO.Category;
import rest.interfaces.CategoryClient;

/**
 * Created by magnus
 */
public class CategoryClientImpl extends DefaultClientImpl<Category> implements CategoryClient {
    public CategoryClientImpl() {
        super("product/category");
    }
}
