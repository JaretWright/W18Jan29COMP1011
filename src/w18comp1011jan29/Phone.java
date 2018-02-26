package w18comp1011jan29;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JWright
 */
public class Phone {
    private String brand, model, os, imageLocation;
    private double res;
    private int memory;

    public Phone(double res, String brand, String model, String os, int memory, String imgLocation) {
        setRes(res);
        setBrand(brand);
        setModel(model);
        setOs(os);
        setMemory(memory);
        setImageLocation(imgLocation);
    }

    public String getImageLocation()
    {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation)
    {
        File img = new File(imageLocation);
        
        if (img.canRead())
            this.imageLocation = imageLocation;
        else
            throw new IllegalArgumentException("Image location is invalid");
    }

    public int getMemory()
    {
        return memory;
    }

    public void setMemory(int memory)
    {
        if (memory > 0)
            this.memory = memory;
        else throw new IllegalArgumentException("Memory must be greater than 0");
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        if (res<0 || res>45)
            throw new IllegalArgumentException("Resolution should be 0-45");
        else
            this.res = res;
    }
    
    /**
     * This overrides the toString() method from the object class
     * and will display a phone as "make model"
     * @return 
     */
    @Override
    public String toString(){
        return this.brand + " " + this.model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (getManufacturers().contains(brand))
            this.brand = brand;
        else
            throw new IllegalArgumentException("Valid brands are: "+ 
                                                    getManufacturers());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (!model.isEmpty())
            this.model = model;
        else
            throw new IllegalArgumentException("Model cannot be empty");
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        if (!os.isEmpty())
            this.os = os;
        else
           throw new IllegalArgumentException("OS cannot be empty");
    }
    
    /**
     * This method will return a List of a valid phone manufacturers
     */
    public static List<String> getManufacturers()
    {
      String[] manufacturers = {"Apple","Samsung","Sony","Nokia","HTC","Blackberry"};
      return Arrays.asList(manufacturers);
    }
    
    /**
     * This method will save the current instance of the phone into the database
     */
    public void insertIntoDB()
    {
        Connection conn=null;
        PreparedStatement ps = null;
        
        try
        {
            //1. Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "comp1011Assign1", "student", "student");
            
            //2. Create a String to hold the SQL statement.  ? will be our
            //place holders
            String sql = "INSERT INTO phones VALUES (?,?,?,?,?,?)";
            
            //3.  Prepare the query
            ps = conn.prepareStatement(sql);
            
            //4. Bind the parameters
            ps.setString(1, brand);
            ps.setString(2, this.model);
            ps.setString(3, this.os);
            ps.setString(4, this.imageLocation);
            ps.setDouble(5, res);
            ps.setInt(6, memory);
            
            //5. execute the sql statement
            ps.execute();
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        
    }
}
