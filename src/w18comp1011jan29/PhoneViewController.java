package w18comp1011jan29;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


/**
 * FXML Controller class
 *
 * @author JWright
 */
public class PhoneViewController implements Initializable {

    @FXML    private ComboBox<String> brandComboBox;
    @FXML    private TextField modelTextField;
    @FXML    private Slider resolutionSlider;
    @FXML    private Label resolutionLabel;
    @FXML    private Label errorMsg;
    @FXML    private RadioButton androidRadioButton;
    @FXML    private RadioButton iOSRadioButton;
    @FXML    private RadioButton windowsRadioButton;
    @FXML    private RadioButton blackberryRadioButton;
             private ToggleGroup osToggleGroup;
    
    public String getOSFromRadioButtons()
    {
        if (osToggleGroup.getSelectedToggle().equals(iOSRadioButton))
            return "iOS";
        
        if (osToggleGroup.getSelectedToggle().equals(androidRadioButton))
            return "Android";
        
        if (osToggleGroup.getSelectedToggle().equals(windowsRadioButton))
            return "Windows";
        
        else return "Blackberry";
        
    }
    public void createPhoneButtonPushed()
    {
        String os = getOSFromRadioButtons();
        try{
            Phone newPhone = new Phone(resolutionSlider.getValue(), 
                                        this.brandComboBox.getValue(), 
                                        this.modelTextField.getText(), 
                                        os);

            System.out.println(newPhone.toString());
            errorMsg.setText("");
        }
        catch (IllegalArgumentException e)
        {
            errorMsg.setText(e.getMessage());
            
        }
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
        
        errorMsg.setText("");
        
        //configure the RadioButtons and add a ToggleGroup to ensure
        //only 1 RadioButton at a time is selected
        osToggleGroup = new ToggleGroup();
        iOSRadioButton.setToggleGroup(osToggleGroup);
        androidRadioButton.setToggleGroup(osToggleGroup);
        windowsRadioButton.setToggleGroup(osToggleGroup);
        blackberryRadioButton.setToggleGroup(osToggleGroup);
        androidRadioButton.setSelected(true);
        
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
