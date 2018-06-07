package creditguiadmin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.*;


public class ScrollPaneController implements Initializable {

    private static final double BUTTON_PADDING = 10;
    public ScrollPane scrollPane;
    public Button categoriesButton;
    public TableView productTable;

    Product product1 = new Product(1, "kqly1");
    Product product2 = new Product(2, "kqly2");
    Product product3 = new Product(3, "kqly3");
    Product product4 = new Product(4, "kqly4");
    List<Product> productArrayList1 = Arrays.asList(product1, product2);
    List<Product> productArrayList2 = Arrays.asList(product3, product4);
    Category category1 = new Category("venstre",productArrayList1);
    Category category2 = new Category("hoejre", productArrayList2);
    List<Category> categories = Arrays.asList(category1, category2);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void selectCategories() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);

        scrollPane.setContent(grid);
        int counter = 0;
        int rowCounter = 0;
        for (Category category : categories) {
            counter++;
            Button categoryButton = new Button(category.getName());
            categoryButton.setOnAction(event -> choosenCategory(category));
            categoryButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
            categoryButton.setMaxSize(300,80);
            categoryButton.setMinSize(300,80);
            if (counter == 2) {
                rowCounter++;
                grid.add(categoryButton, rowCounter, 2);
            }
            else
                grid.add(categoryButton, rowCounter, 2);
        }
    }

    public void choosenCategory (Category category) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);

        Label label2 = new Label("" + category.getName());
        label2.setFont(Font.font("San Francisco", 30));
        label2.setAlignment(Pos.TOP_RIGHT);
        scrollPane.setContent(grid);
        grid.add(label2, 1 , 1);

        int counter = 0;
        int rowCounter = 0;
        for (Product product : category.getProductArrayList()) {
            counter++;

            Button productButton = new Button(product.getName());

            productButton.setOnAction(event -> scrollPane.setContent(new Button()));

            productButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
            productButton.setMaxSize(350,80);
            productButton.setMinSize(350,80);

            Button returnButton = new Button("back to 80's");

            returnButton.setOnAction(event -> selectCategories());

            returnButton.setStyle("-fx-font: 10 arial; -fx-base: #f08080;");
            returnButton.setMaxSize(150,30);
            returnButton.setMinSize(150,30);
            grid.add(returnButton, 0,0);

            productButton.setOnAction(event -> addToProductList(product));

            if (counter == 2) {
                rowCounter++;
                grid.add(productButton, rowCounter, 2);
            }
            else
                grid.add(productButton, rowCounter, 2);
        }
    }

    public void addToProductList(Product product) {

        ArrayList<String> productList = new ArrayList<String>();

        productList.add(product.getName());

        

        System.out.println("" + productList);

    }

}
