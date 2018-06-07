package rest.implementations;

import rest.DTO.Category;
import rest.DTO.Product;
import rest.interfaces.ProductClient;

import java.util.List;

/**
 * Created by magnus
 */
public class ProductClientImpl implements ProductClient{
    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product, int categoryid) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void removeProduct(int id) {

    }

    @Override
    public Category getCategoryById(int id) {
        return null;
    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void removeCategory(int id) {

    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}
