package mainlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public static String[] userAdmin = {"1", "1"};
    public static String[] userUser = {"2", "2"};
    public TextField userID;
    public PasswordField passwordID;


    public void loginFunction (ActionEvent event)
    {
        if (userID.getText().equals(userAdmin[0]) && passwordID.getText().equals(userAdmin[1])) {
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

        } else if(userID.getText().equals(userUser[0]) && passwordID.getText().equals(userUser[1])){
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
        else
            System.out.println("Unauthorized access");
    }
}