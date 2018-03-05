package w18comp1011jan29;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JWright
 */
public class SceneChanger
{
    /**
     * This method will allow the application to change scenes without
     * passing any data to the new scene
     */
    public static void changeScene(ActionEvent event, String fxmlFileName, String title) throws IOException
    {
        //get the Stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(fxmlFileName));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
       
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * This method will change scenes and allow a Phone object to be passed
     * between scenes
     */
    public static void changeScene(ActionEvent event, String fxmlFileName, String title, 
                                        PhoneLoadInterface controller, Phone phone) throws IOException
    {       
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(fxmlFileName));
        Parent root = loader.load();
        
        //access the controller class to preload the phone
        controller = loader.getController();
        controller.preloadPhone(phone);
        
        Scene scene = new Scene(root);
        
        //get the Stage from the event
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        stage.setTitle("Edit Phone");
        stage.setScene(scene);
        stage.show();        
        
    }
}
