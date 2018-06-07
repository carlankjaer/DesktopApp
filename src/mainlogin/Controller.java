package mainlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public void loginFunction (ActionEvent event)
    {

        Parent root;
        try
        {

            root = FXMLLoader.load(getClass().getClassLoader().getResource("creditguiadmin/creditGUI.fxml"));
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
}
