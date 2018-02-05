package w18comp1011jan29;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
    @FXML    private Slider resolutionSlider;
    @FXML    private Label resolutionLabel;
    
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
        //setup the combobox
        brandComboBox.getItems().addAll(Phone.getManufacturers());
        brandComboBox.getSelectionModel().selectFirst();
        
        resolutionSlider.setMin(4);
        resolutionSlider.setMax(20);
        resolutionSlider.setValue(12); //set the default value
        resolutionLabel.setText(Double.toString(resolutionSlider.getValue())
                                                +" MP");
    }
    
    /**
     * This method will update the resolution label and should be called
     * when the slider is dragged
     */
    public void resolutionSliderMoved()
    {
        String label = String.format("%.1f MP", resolutionSlider.getValue());
        resolutionLabel.setText(label);
    }
    
}
