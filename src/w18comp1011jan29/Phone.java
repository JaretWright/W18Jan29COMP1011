package w18comp1011jan29;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JWright
 */
public class Phone {
    private String res, brand, model, os;

    public Phone(String res, String brand, String model, String os) {
        this.res = res;
        this.brand = brand;
        this.model = model;
        this.os = os;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
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
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
    
    /**
     * This method will return a List of a valid phone manufacturers
     */
    public static List<String> getManufacturers()
    {
      String[] manufacturers = {"Apple","Samsung","Sony","Nokia","HTC","Blackberry"};
      return Arrays.asList(manufacturers);
    }
}
