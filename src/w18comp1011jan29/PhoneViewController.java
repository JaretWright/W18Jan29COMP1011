package w18comp1011jan29;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import w18comp1011jan29.Phone;


/**
 * FXML Controller class
 *
 * @author JWright
 */
public class PhoneViewController implements Initializable {

    @FXML    private TextField resTextField;
    @FXML    private TextField brandTextField;
    @FXML    private TextField modelTextField;
    @FXML    private TextField osTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void createPhoneButtonPushed()
    {
        Phone newPhone = new Phone(this.resTextField.getText(), 
                                    this.brandTextField.getText(), 
                                    this.modelTextField.getText(), 
                                    this.osTextField.getText());
                                    
        System.out.println(newPhone.toString());
    }
    
}
