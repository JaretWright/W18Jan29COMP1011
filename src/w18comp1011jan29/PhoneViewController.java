package w18comp1011jan29;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author JWright
 */
public class PhoneViewController implements Initializable {

    @FXML    private TextField resTextField;
    @FXML    private ComboBox<String> brandComboBox;
    @FXML    private TextField modelTextField;
    @FXML    private TextField osTextField;

    
    public void createPhoneButtonPushed()
    {
        Phone newPhone = new Phone(this.resTextField.getText(), 
                                    this.brandComboBox.getValue(), 
                                    this.modelTextField.getText(), 
                                    this.osTextField.getText());
                                    
        System.out.println(newPhone.toString());
    }

    /**
     * This method will automatically be called when the scene
     * is launched
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        brandComboBox.getItems().addAll(Phone.getManufacturers());
        brandComboBox.getSelectionModel().selectFirst();
        
    }
    
}
