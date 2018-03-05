package w18comp1011jan29;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    @FXML    private Button editButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        this.editButton.setDisable(true);
        
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
        
        resolutionColumn.setStyle("-fx-alignment: CENTER;");
        
        try
        {
            loadData();
        } catch (SQLException ex)
        {
            System.err.println(ex);
        }
    }    
    
    /**
     * This method will populate the table with Phone objects
     */
    public void loadData() throws SQLException
    {
        
        //get the Phone data from the database
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            //1. connect to the DB with the URL to the db, user name and password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "comp1011Assign1?useSSL=false", "student", "student");
            
            //2.create a statement object to execute on the DB
            statement = conn.createStatement();
            
            //3. create & execute the SQL query
            resultSet = statement.executeQuery("SELECT * FROM phones");
            
            //4. Optionally display meta data (header information)
//            ResultSetMetaData md = resultSet.getMetaData();
//            int numOfCol = md.getColumnCount();
            
//            for (int i=1; i<=numOfCol ; i++)
//            {
//                System.out.printf("%-15s", md.getColumnName(i));
//            }
//            System.out.println();
            
            //5.  Loop over the result set and display to the screen
            while (resultSet.next())
            {
                Phone newPhone = new Phone(
                                        resultSet.getDouble("res"),
                                        resultSet.getString("brand"),
                                        resultSet.getString("model"),
                                        resultSet.getString("os"),
                                        resultSet.getInt("memory"),
                                        resultSet.getString("imageLocation"));
                tableView.getItems().add(newPhone);
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        finally
        {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }
        
        
        //create a temp Phone to show in the table
//        Phone phone = new Phone(14.2, "Apple", "iPhone X", "iOS",
//                                64, "./src/Images/defaultPhone.png");
//        Phone phone2 = new Phone(14.2, "Samsung", "Galaxy 9", "android",
//                                64, "./src/Images/defaultPhone.png");
        
        //create an ObservableList to add to the Table
//        ObservableList<Phone> phones = FXCollections.observableArrayList();
//        
//        //add the phones to the list
//        phones.add(phone);
//        phones.add(phone2);
//        
//        //add the phones list to the Table's existing list
//        tableView.getItems().addAll(phones);
    }
    
    /**
     * This will transition the scene to the PhoneView.fxml scene
     * to create a new phone
     */
    public void createPhoneButtonPushed(ActionEvent event) throws IOException
    {
        SceneChanger.changeScene(event, "PhoneView.fxml", "Create Phone");
    }
    
    /**
     * This method will load a phone object and pass the data into the 
     * edit scene
     */
    public void editPhoneButtonPushed(ActionEvent event) throws IOException
    {
        //Get the selected Phone from the table
        Phone phone = this.tableView.getSelectionModel().getSelectedItem();
       
        SceneChanger.changeScene(event, "PhoneView.fxml", "Edit Phone", 
                                    new PhoneViewController(), phone);
    }
    
    /**
     * This method will enable the edit button when a Phone object is
     * selected
     */
    public void enableEdit()
    {
        if (tableView.getSelectionModel().getSelectedItem() != null)
            this.editButton.setDisable(false);
    }
}

