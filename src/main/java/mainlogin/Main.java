package mainlogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rest.DTO.*;
import rest.implementations.AuthenticationClientImpl;
import rest.implementations.CustomerClientImpl;
import rest.implementations.OrderClientImpl;
import rest.implementations.ProductClientImpl;
import rest.interfaces.AuthenticationClient;
import rest.interfaces.CustomerClient;
import rest.interfaces.OrderClient;
import rest.interfaces.ProductClient;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application {
    static ProductClient productClient = new ProductClientImpl();
    static CustomerClient customerClient = new CustomerClientImpl();
    static AuthenticationClient authenticationClient = new AuthenticationClientImpl();
    static OrderClient orderClient = new OrderClientImpl();

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.setMaxHeight(450);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(600);
        primaryStage.show();
    }


    public static void main(String[] args) {launch(args);}}


