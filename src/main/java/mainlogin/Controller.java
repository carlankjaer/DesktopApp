package mainlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rest.DTO.JWT;
import rest.DTO.LoginDetails;
import rest.DTO.Role;
import rest.implementations.AuthenticationClientImpl;
import rest.interfaces.AuthenticationClient;

import java.io.IOException;

public class Controller {

    public static String[] userAdmin = {"1", "1"};
    public static String[] userUser = {"2", "2"};
    public TextField userID;
    public PasswordField passwordID;
    private AuthenticationClient authenticationClient = new AuthenticationClientImpl();


    public void loginFunction (ActionEvent event)
    {

        try {
            String jwt = authenticationClient.login(new LoginDetails(userID.getText(), passwordID.getText()));
            JWT.getInstance().setToken(jwt);
            Role role = authenticationClient.getRole();

            if (role.equals(Role.ADMIN)) {
                Parent root;
                try
                {

                    root = FXMLLoader.load(getClass().getClassLoader().
                            getResource("fxml/creditGUI.fxml"));
                    Stage home = new Stage();
                    home.setTitle("Credit GUI");
                    home.setScene(new Scene(root, 1031.0, 800.0));
                    home.setMinHeight(800);
                    home.setMaxHeight(800);
                    home.setMinWidth(1031);
                    home.setMaxWidth(1031);
                    home.show();

                    ((Node)(event.getSource())).getScene().getWindow().hide();

                }

                catch (IOException e)
                {

                    System.out.println(e);

                }
            }

            else if (role.equals(Role.EMPLOYEE)) {
                Parent root;
                try
                {

                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/creditGUIuser.fxml"));
                    Stage home = new Stage();
                    home.setTitle("Credit GUI");
                    home.setScene(new Scene(root, 1031.0, 800.0));
                    home.setMinHeight(800);
                    home.setMaxHeight(800);
                    home.setMinWidth(1031);
                    home.setMaxWidth(1031);
                    home.show();

                    ((Node)(event.getSource())).getScene().getWindow().hide();

                }

                catch (IOException e)
                {

                    System.out.println(e);

                }
            }

            else if (role.equals(Role.CUSTOMER)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("NotAuthorized");
                alert.setHeaderText("Customers do not have access here");
                alert.setContentText("This application are only for admins and employees.");

                alert.showAndWait();
            }

            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("NotAuthorized");
                alert.setHeaderText("Error");
                alert.setContentText("Error.");

                alert.showAndWait();
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}