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
import rest.DTO.*;
import rest.implementations.CategoryClientImpl;
import rest.implementations.ProductClientImpl;
import rest.interfaces.CategoryClient;
import rest.interfaces.ProductClient;

import javax.swing.*;
import javax.ws.rs.NotAuthorizedException;
import java.net.URL;
import java.util.*;

public class UIController implements Initializable {

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
    public TextField deleteCustomerID;
    public TextField deleteCustomerName;
    public TableColumn productIdInPrductTable;
    public TableColumn productCategoryInTable;
    public TableColumn productNameInTable;
    public TableColumn productPriseInTable;
    public TextField searchForProduct;
    public TableView productListTable;
    public ChoiceBox choosePrduct;
    public Button cancleList;
    public TableView customerListTable;
    public TableColumn customerListTablePhone;
    public TextField searchCustomer;
    public ChoiceBox chooseSearchCustomer;
    public TableColumn customerListTableFirstname;
    public TableColumn customerListTableLastname;
    public TableColumn customerListTableAddress;
    public TableColumn customerListTableUserID;

    Product product1 = new Product("Bananer", 100, new Company(1, "PF"));
    Product product2 = new Product("Æbler", 100, new Company(1,"PF"));
    Product product3 = new Product("Citroner", 100, new Company(1,"PF"));
    List<Product> productArrayList1 = Arrays.asList(product1, product2);
    List<Product> productArrayList2 = Arrays.asList(product3);
    Category category1 = new Category(1,"Venstre",productArrayList1, new Company(1,"PF"));
    Category category2 = new Category(2,"Højre", productArrayList2, new Company(2, "PF"));
    List<Category> categories = Arrays.asList(category1, category2);
    ObservableList<Product> obsTableList = FXCollections.observableArrayList(productList);
    private List<Product> allProducts = new ArrayList<>();

    Customer customer = new Customer("27831230", "carlankjaer@gmail.com", "Teglgårdsvej 905, 2.tv");

    private CategoryClient categoryClient = new CategoryClientImpl();
    private ProductClient productClient = new ProductClientImpl();
    /*List<Category> categories = categoryClient.getAll();
    ObservableList<Product> obsTableList = FXCollections.observableArrayList(productList);
    private List<Product> allProducts = new ArrayList<>();*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Category cat : categories) {
            for (Product p : cat.getProducts()) {
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
                new PropertyValueFactory<Product, Double>("price"));

        productCategoryInTable.setCellValueFactory(
                new PropertyValueFactory<Product, String>("company"));



        choosePrduct.getItems().addAll("Navn", "ID");
        choosePrduct.setValue("Navn");

        searchForProduct.setPromptText("Søg");
        searchForProduct.setOnKeyReleased(keyEvent -> {
            obsTableList.setAll(allProducts);
            if (choosePrduct.getValue().equals("Navn")) {
                obsTableList.removeIf(p -> !p.getName().toLowerCase().contains(searchForProduct.getText().toLowerCase().trim()));
            }
            else if (choosePrduct.getValue().equals("ID"))
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

        chooseSearchCustomer.getItems().addAll("ID", "Telefon nummer", "Fornavn", "Efternavn", "Addresse");
        chooseSearchCustomer.setValue("ID");

        searchCustomer.setOnKeyReleased(keyEvent -> {

            if (chooseSearchCustomer.getValue().equals("ID")) {

            }
            else if (chooseSearchCustomer.getValue().equals("Telefon nummer")) {

            }
            else if (chooseSearchCustomer.getValue().equals("Fornavn")) {

            }
            else if (chooseSearchCustomer.getValue().equals("Efternavn")) {

            }
            else if (chooseSearchCustomer.getValue().equals("Adresse")) {

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
        try {
            List<Category> newcategories = categoryClient.getAll();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);

        Label label2 = new Label("" + category.getName());
        label2.setFont(Font.font("San Francisco", 30));
        label2.setAlignment(Pos.TOP_RIGHT);
        scrollPane.setContent(grid);
        grid.add(label2, 1 , 0);

        int counter = 0;
        int rowCounter = 0;
        for (Product product : category.getProducts()) {
            counter++;

            Button productButton = new Button(product.getName());

            productButton.setOnAction(event -> scrollPane.setContent(new Button()));

            productButton.setStyle("-fx-font: 22 arial;");
            productButton.setMaxSize(300,80);
            productButton.setMinSize(300,80);

            Button returnButton = new Button("< back");

            returnButton.setOnAction(event -> selectCategories());

            returnButton.setStyle("-fx-font: 15 arial;");
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

    public void itemToList(MouseEvent mouseEvent) {

        ObservableList<Product> obsProductList = FXCollections.observableArrayList(productList);

        productColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        productTable.setItems(obsProductList);

    }

    public void customerList(User user) {

    }
}