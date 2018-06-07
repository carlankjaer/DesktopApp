package rest.interfaces;

import rest.DTO.Category;
import rest.DTO.Product;

import java.util.List;

/**
 * Created by magnus
 */
public interface ProductClient {
    Product getProductById (int id);
    void addProduct (Product product, int categoryid);
    void updateProduct (Product product);
    void removeProduct (int id);

    Category getCategoryById (int id);
    void addCategory (Category category);
    void updateCategory (Category category);
    void removeCategory (int id);
    List<Category> getAllCategories ();
}
