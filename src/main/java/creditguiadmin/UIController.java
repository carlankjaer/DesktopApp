package creditguiadmin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import rest.DTO.*;
import rest.implementations.*;
import rest.interfaces.*;

import java.net.URL;
import java.util.*;

public class UIController implements Initializable {

    private static final double BUTTON_PADDING = 10;
    public ScrollPane scrollPane;
    public Button categoriesButton;
    public TableView productTable;
    public TableColumn productColumn;
    private List<Product> productList = new ArrayList<>();
    public Button payForChosenProducts;
    public Button createCustomerButton;
    public TextField createUserID;
    public CheckBox adminRights;
    public Button createUserButton;
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
    public TextField createCustomerUsername;
    public TextField createCustomerPassword;
    public TextField createCustomerFirstname;
    public TextField createCustomerLastname;
    public TextField createCustomerPhonenumber;
    public TextField createCustomerAdress;
    public TextField createCustomerEmail;
    public Button deleteCustomerButton;
    public TextField deleteCustomerID;
    public Button refreachCustomerTableButton;
    public TextField orderCustomerTextfield;
    public TextField customerFundsAddTextfield;
    public Button customerFundsAddAmountButton;
    public TextField customerFundsAmountTextfield;
    public TextField creatNewProductName;
    public TextField deleteProductTextfield;
    public TextField creatNewProductPrice;
    public TextField createProduktCategoryName;
    public Button deleteProductButton;
    public Button createProductButton;
    public Button refreshProductsButton;
    public TextField createUserPassword;
    public TextField createUserLastname;
    public TextField createUserFirstname;

    private CategoryClient categoryClient = new CategoryClientImpl();
    private List<Category> categories = categoryClient.getAll();
    private ObservableList<Product> obsTableList = FXCollections.observableArrayList(productList);
    private List<Product> allProducts = new ArrayList<>();

    private CustomerClient customerClient = new CustomerClientImpl();
    private OrderClient orderClient = new OrderClientImpl();
    private List<User> users = new ArrayList<>();

    private ObservableList<User> obsUserTableList = FXCollections.observableArrayList(users);
    private EmployeeClient employeeClient = new EmployeeClientImpl();
    private ProductClient productClient = new ProductClientImpl();

    private void refreshView(){
        List<User> all = customerClient.getAll();
        obsUserTableList.setAll(all);
    }
    private void refreshViewProduct(){
        List<Product> all = productClient.getAll();
        obsTableList.setAll(all);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshView();
        refreshViewProduct();
        for (Category cat : categories) {
            for (Product p : cat.getProducts()) {
                allProducts.add(p);
                obsTableList.add(p);
            }
        }

        productListTable.setEditable(false);

    productListTable.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            Node node = event.getPickResult().getIntersectedNode();
            Product product;
            try{
                product = (Product) ((TableCell) node).getTableRow().getItem();
            }catch (Exception e){
                product = (Product) ((TableCell)node.getParent()).getTableRow().getItem();
           }

           if(product != null)addToProductList(product);

        }
    });

        //Creates filtered list with products
        FilteredList<Product> flProducts = new FilteredList(obsTableList, p -> true);

        productListTable.getColumns();
        productListTable.setItems(obsTableList);
        productIdInPrductTable.setCellValueFactory(
                new PropertyValueFactory<Product, Integer>("id"));

        productNameInTable.setCellValueFactory(
                new PropertyValueFactory<Product, String>("name"));

        productCategoryInTable.setCellValueFactory(
                new PropertyValueFactory<Category, String>("category"));

        productPriseInTable.setCellValueFactory(
                new PropertyValueFactory<Product, Double>("price"));

        //Sets values on choice box and adds "Navn" as standard search key
        choosePrduct.getItems().addAll("Navn", "ID","Pris");
        choosePrduct.setValue("Navn");

        //Filters search after search key (ex. "Navn")
        //Filters customers when typing starts so the only customers that are shown in the table are the people who matches the search
        searchForProduct.setPromptText("Søg");
        searchForProduct.setOnKeyReleased(keyEvent -> {
            obsTableList.setAll(allProducts);
            if (choosePrduct.getValue().equals("Navn")) {
                obsTableList.removeIf(p -> !p.getName().toLowerCase().contains(searchForProduct.getText().toLowerCase().trim()));
            }
            else if (choosePrduct.getValue().equals("Pris")) {
                obsTableList.removeIf(p -> !Double.toString(p.getPrice()).contains(searchForProduct.getText().toLowerCase().trim()));
            }
            else if (choosePrduct.getValue().equals("ID"))
            {
                obsTableList.removeIf(p -> !Integer.toString(p.getId()).contains(searchForProduct.getText().toLowerCase().trim()));
            }
        });

        createUserButton.setOnAction(event -> {
            if (adminRights.isSelected()){
                employeeClient.post(
                        new User(createUserID.getText(), createUserPassword.getText(),createUserFirstname.getText(),createUserLastname.getText(),true));
                }else{
                employeeClient.post(
                        new User(createUserID.getText(), createUserPassword.getText(),createUserFirstname.getText(),createUserLastname.getText(),false));
                }
            }
        );

        createCustomerButton.setOnAction(event -> customerClient.post(
                new User(createCustomerUsername.getText(), createCustomerPassword.getText(), createCustomerFirstname.getText(),
                        createCustomerLastname.getText(),
                        new Customer(createCustomerPhonenumber.getText(), createCustomerEmail.getText(),
                                createCustomerAdress.getText()
                        )
                )
        ));

        deleteCustomerButton.setOnAction
                (event -> customerClient.delete
                        (Integer.parseInt(deleteCustomerID.getText()
                        ))
                );

        payForChosenProducts.setOnAction
                (event -> orderClient.addOrder
                        (new OrderRequest(Integer.parseInt
                                (orderCustomerTextfield.getText()), 1, productList)
                        )
                );

        createProductButton.setOnAction
                (event -> {
                            String categoryID = createProduktCategoryName.getText();
                            boolean created = false;
                            for (Category c : categories) {
                                if (c.getId() == Integer.parseInt(categoryID)) {
                                    Product p = new Product(
                                            creatNewProductName.getText(),
                                            Double.parseDouble
                                                    (creatNewProductPrice.getText()));
                                    c.addProduct(p);
                                    created = true;
                                    productClient.post(p);
                                }
                            }
                            if (!created){
                                System.out.println("Category does not exist!");
                            }
                        }
                );

        choosePrduct.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {//reset table and textfield when new choice is selected
            if (newVal != null)
            {
                searchForProduct.setText("");
                flProducts.setPredicate(null);//This is same as saying flProduct.setPredicate(p->true);
            }
        });

        //Creates filtered list with customer
        FilteredList<User> flCustomer = new FilteredList(obsUserTableList, p -> true);

        customerListTable.getColumns();
        customerListTable.setItems(obsUserTableList);
        customerListTableUserID.setCellValueFactory(
                new PropertyValueFactory<User, Integer>("id"));

        customerListTablePhone.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
                    @Override
                    public ObservableValue call(TableColumn.CellDataFeatures param) {
                        User user = (User) param.getValue();
                        return new SimpleStringProperty(user.getCustomer().getPhonenumber());
                    }
                }
        );

        customerListTableFirstname.setCellValueFactory(
                new PropertyValueFactory<User, String>("firstname"));

        customerListTableLastname.setCellValueFactory(
                new PropertyValueFactory<User, String>("lastname"));

        customerListTableAddress.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
                    @Override
                    public ObservableValue call(TableColumn.CellDataFeatures param) {
                        User user = (User) param.getValue();
                        return new SimpleStringProperty(user.getCustomer().getAddress());
                    }
                }
        );
        refreshProductsButton.setOnAction(event -> refreshViewProduct());
        refreachCustomerTableButton.setOnAction(event -> refreshView());

        //Sets values on choice box and adds ID as standard search key
        chooseSearchCustomer.getItems().addAll("ID", "Fornavn", "Efternavn");
        chooseSearchCustomer.setValue("ID");

        //Filters search after search key (ex. ID)
        //Filters customers when typing starts so the only customers that are shown in the table are the people who matches the search
        searchCustomer.setOnKeyReleased(keyEvent -> {
            obsUserTableList.setAll(users);
            if (chooseSearchCustomer.getValue().equals("ID")) {
                obsUserTableList.removeIf(p -> !Integer.toString(p.getId()).contains(searchCustomer.getText().toLowerCase().trim()));
            }
            else if (chooseSearchCustomer.getValue().equals("Fornavn")) {
                obsUserTableList.removeIf(p -> !p.getFirstname().toLowerCase().contains(searchCustomer.getText().toLowerCase().trim()));
            }
            else if (chooseSearchCustomer.getValue().equals("Efternavn")) {
                obsUserTableList.removeIf(p -> !p.getLastname().toLowerCase().contains(searchCustomer.getText().toLowerCase().trim()));
            }
        });

        chooseSearchCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {//reset table and textfield when new choice is selected
            if (newVal != null)
            {
                searchCustomer.setText("");
                flCustomer.setPredicate(null);//This is same as saying flProduct.setPredicate(p->true);
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

    private void choosenCategory(Category category) {
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

    private void addToProductList(Product product) {

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
}