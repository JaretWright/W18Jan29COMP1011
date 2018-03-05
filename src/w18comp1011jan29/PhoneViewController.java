package w18comp1011jan29;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


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
    @FXML    private Spinner<Integer> memorySpinner;
    @FXML    private ImageView imageView;
             private ToggleGroup osToggleGroup;
             private String imageLocation;
             private Phone phone;
    
             
    /**
     * This method will be used to preload a Phone object in the scene
     * @return 
     */
    public void preloadPhone(Phone newPhone)
    {
        this.phone = newPhone;
        System.out.printf("Phone: '%s' was loaded %n", phone);
    }
             
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
                                        os,
                                        memorySpinner.getValue(),
                                        this.imageLocation);

            System.out.println(newPhone.toString());
            errorMsg.setText("");
            newPhone.insertIntoDB();
        }
        catch (IllegalArgumentException e)
        {
            errorMsg.setText(e.getMessage());
            
        } catch (SQLException ex)
        {
            Logger.getLogger(PhoneViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method will automatically be called when the scene
     * is launched
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //setup Spinner object (min value, max value, default value)
        SpinnerValueFactory<Integer> memoryValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(16,256,64);
        memorySpinner.setValueFactory(memoryValueFactory);
        memorySpinner.setEditable(true);
        
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
        
        //load the default image
        imageView.setImage(new Image("file:./src/Images/defaultPhone.png"));
        imageLocation = "./src/Images/defaultPhone.png";
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
 
    /**
     * This method will launch a FileChooser and return the file selected or null
     */
    public void getNewImage(ActionEvent event)
    {
        //get the stage to open the new window
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //Instantiate a FileChooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        
        //create filters
        FileChooser.ExtensionFilter imgFilter = 
                   new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png");
        fileChooser.getExtensionFilters().add(imgFilter);
                
        //configure the FileChooser to start in the users' home directory
        String userDirectoryString = System.getProperty("user.home")+"\\Pictures";
        File userDirectory = new File(userDirectoryString);
        
        //check if the userDirectory/pictures exists
        if (!userDirectory.canRead())
            userDirectory = new File(System.getProperty("user.home"));
        
        //configure the FileChooser to use the starting directory
        fileChooser.setInitialDirectory(userDirectory);
  
        
        //Open the file dialog window
        File tmpImageFile = fileChooser.showOpenDialog(stage);
        
        //check that we got a file
        if (tmpImageFile != null)
        {
            //update the ImageView with the new image
            if (tmpImageFile.isFile())
            {
                imageView.setImage(new Image("file:"+tmpImageFile.getPath()));
                imageLocation = tmpImageFile.getPath();
            }
        }
    }
    
    /**
     * This will take the user back to the table view of all phones
     */
    public void changeToTableView(ActionEvent event) throws IOException
    {
        SceneChanger.changeScene(event, "PhoneTableView.fxml", "List of Phones");
    }
}
