package creditguiadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
//import rest.DTO.Category;
//import rest.DTO.Product;

import javax.swing.*;
import java.net.URL;
import java.util.*;


public class ScrollPaneController implements Initializable {

    private static final double BUTTON_PADDING = 10;
    public ScrollPane scrollPane;
    public Button categoriesButton;
    public TableView productTable;
    public TableColumn productColumn;
    public List<Product> productList = new ArrayList<>();
    public Button payForChosenProducts;
    public TextField createCustomerFirstName;
    public TextField createCustomerLastName;
    public TextField createCustomerAddress1;
    public TextField createCustomerAddress1createCustomerAddress2;
    public TextField createCustomerCity;
    public TextField createCustomerZipCode;
    public TextField createCustomerPhoneNumber;
    public TextField createCustomerEmail;
    public TextField createCustomerID;
    public Button createCustomerButton;
    public TextField createUserID;
    public TextField createUserPhoneNumber;
    public TextField createUserName;
    public CheckBox adminRights;
    public Button createUserButton;
    public TextField refundCustomerID;
    public TextField refundCustomerName;
    public TextField currentRefundableBalance;
    public Button refundLatestProduct;
    public Button refundAllProducts;
    public TextField deleteCustomerID;
    public TextField deleteCustomerName;
    public TableColumn productIdInPrductTable;
    public TableColumn productCategoryInTable;
    public TableColumn productNameInTable;
    public TableColumn productPriseInTable;
    public TextField searchForProduct;
    public TableView productListTable;
    public ChoiceBox choosePrduct;
    public Button getProductSearch;
    public Button cancleList;

    Product product1 = new Product(1, "Bananer");
    Product product2 = new Product(2, "Aebler");
    Product product3 = new Product(3, "Citroner");
    Product product4 = new Product(4, "Appelsiner");
    List<Product> productArrayList1 = Arrays.asList(product1, product2);
    List<Product> productArrayList2 = Arrays.asList(product3, product4);
    Category category1 = new Category("venstre",productArrayList1);
    Category category2 = new Category("hoejre", productArrayList2);
    List<Category> categories = Arrays.asList(category1, category2);
    ObservableList<Product> obsTableList = FXCollections.observableArrayList(productList);
    private List<Product> allProducts = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("test");



        for (Category cat : categories) {
            for (Product p : cat.getProductArrayList()) {
                allProducts.add(p);
                obsTableList.add(p);
            }
        }
        productListTable.setEditable(true);

    productListTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

            System.out.println(event.getClickCount());
            Node node = event.getPickResult().getIntersectedNode();
            Product product = null;
            try{
                product = (Product) ((TableCell) node).getTableRow().getItem();
            }catch (Exception e){
                product = (Product) ((TableCell)node.getParent()).getTableRow().getItem();
           }

           if(product != null)addToProductList(product);

        }
    });
        FilteredList<Product> flProducts = new FilteredList(obsTableList, p -> true);
        productListTable.setItems(flProducts);
        productListTable.getColumns().addAll(productNameInTable, productIdInPrductTable, productCategoryInTable);

        productListTable.getColumns();
        productListTable.setItems(obsTableList);
        productIdInPrductTable.setCellValueFactory(
                new PropertyValueFactory<Product, Integer>("id"));

        productNameInTable.setCellValueFactory(
                new PropertyValueFactory<Product, String>("name"));

        productCategoryInTable.setCellValueFactory(
                new PropertyValueFactory<Category, String>("name"));


        choosePrduct.getItems().addAll("name", "id");
        choosePrduct.setValue("name");

        searchForProduct.setPromptText("Soe nu!");
        searchForProduct.setOnKeyReleased(keyEvent -> {
            final String name = "name";
            obsTableList.setAll(allProducts);
            if (choosePrduct.getValue().equals(name)) {
                obsTableList.removeIf(p -> !p.getName().toLowerCase().contains(searchForProduct.getText().toLowerCase().trim()));
            }
            else if (choosePrduct.getValue().equals("id"))
            {
                obsTableList.removeIf(p -> !Integer.toString(p.getId()).contains(searchForProduct.getText().toLowerCase().trim()));
            }
        });

        choosePrduct.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {//reset table and textfield when new choice is selected
            if (newVal != null)
            {
                searchForProduct.setText("");
                flProducts.setPredicate(null);//This is same as saying flProduct.setPredicate(p->true);
            }
        });




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
            productButton.setMaxSize(300,80);
            productButton.setMinSize(300,80);

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

        productList.add(product);

        ObservableList<Product> obsProductList = FXCollections.observableArrayList(productList);

        productColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        productTable.setItems(obsProductList);

        cancleList.setOnAction(event -> {
            obsProductList.clear();
            productList.clear();
        });


    }

    public void removeItemsFromList(){



    }

    public void itemToList(MouseEvent mouseEvent) {



        ObservableList<Product> obsProductList = FXCollections.observableArrayList(productList);

        productColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        productTable.setItems(obsProductList);

    }
}