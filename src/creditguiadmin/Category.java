package creditguiadmin;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Product> productArrayList = new ArrayList<>();

    public Category () {
    }

    public Category(String name, List<Product> productArrayList) {
        this.name = name;
        this.productArrayList = productArrayList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(List<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

}
