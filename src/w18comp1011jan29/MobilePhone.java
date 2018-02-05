
package w18comp1011jan29;

/**
 *
 * @author JWright
 */
public class MobilePhone {
    private String manufacturer, model, bands;
    private double rearCameraRes;

    public MobilePhone(String manufacturer, String model, String bands, double rearCameraRes) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.bands = bands;
        this.rearCameraRes = rearCameraRes;
    }

    public MobilePhone(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.bands = "4G";
        this.rearCameraRes = 0;
    }
    
    
    


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBands() {
        return bands;
    }

    public void setBands(String bands) {
        this.bands = bands;
    }

    public double getRearCameraRes() {
        return rearCameraRes;
    }

    public void setRearCameraRes(double rearCameraRes) {
        this.rearCameraRes = rearCameraRes;
    }
    
    
}
