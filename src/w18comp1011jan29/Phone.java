package w18comp1011jan29;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JWright
 */
public class Phone {
    private String brand, model, os;
    private double res;
    private int memory;

    public Phone(double res, String brand, String model, String os, int memory) {
        setRes(res);
        setBrand(brand);
        setModel(model);
        setOs(os);
        setMemory(memory);
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
}
