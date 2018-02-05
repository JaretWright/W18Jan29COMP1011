package w18comp1011jan29;

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
        this.brand = brand;
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
    
}
