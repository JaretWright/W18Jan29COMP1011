package w18comp1011jan29;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class PhoneTableViewController implements Initializable
{
    @FXML    private TableView<Phone> tableView;
    @FXML    private TableColumn<Phone, String> makeColumn;
    @FXML    private TableColumn<Phone, String> modelColumn;
    @FXML    private TableColumn<Phone, String> osColumn;
    @FXML    private TableColumn<Phone, Double> resolutionColumn;
    @FXML    private TableColumn<Phone, Integer> memoryColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //configure the columns to connect with the Phone class
        //instance variables
        this.makeColumn.setCellValueFactory(
                new PropertyValueFactory<Phone, String>("brand"));
        this.memoryColumn.setCellValueFactory(
                new PropertyValueFactory<Phone, Integer>("memory"));
        this.modelColumn.setCellValueFactory(
                new PropertyValueFactory<Phone, String>("model"));
        this.osColumn.setCellValueFactory(
                new PropertyValueFactory<Phone, String>("os"));
        this.resolutionColumn.setCellValueFactory(
                new PropertyValueFactory<Phone, Double>("res"));
        loadData();
    }    
    
    /**
     * This method will populate the table with Phone objects
     */
    public void loadData()
    {
        //create a temp Phone to show in the table
        Phone phone = new Phone(14.2, "Apple", "iPhone X", "iOS",
                                64, "./src/Images/defaultPhone.png");
        Phone phone2 = new Phone(14.2, "Samsung", "Galaxy 9", "android",
                                64, "./src/Images/defaultPhone.png");
        
        //create an ObservableList to add to the Table
        ObservableList<Phone> phones = FXCollections.observableArrayList();
        
        //add the phones to the list
        phones.add(phone);
        phones.add(phone2);
        
        //add the phones list to the Table's existing list
        tableView.getItems().addAll(phones);
        
    }
}

