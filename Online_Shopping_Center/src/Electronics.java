import java.io.Serializable;

public class Electronics extends Products implements Serializable {
    private String brand;
    private int warrantyPeriod;

    private String name;//for demo
    public Electronics(String brand, int warrantyPeriod, String name) {
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
        this.name = name;
    }

    public Electronics(String brand, int warrantyPeriod) {
    }

    public String getBrand() {
        return brand;
    }


    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics{"+super.toString() +
                "brand='" + brand + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                '}';
    }
    public String toStringGui() {
        return brand + ',' + warrantyPeriod;
    }

    public Electronics(String productId, String productName, int numOfItems, int price, String brand, int warrantyPeriod) {
        super(productId, productName, numOfItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }
    public String getCategory() {
        return "Electronics";
    }
    public String getInfo() {
        return toStringGui();
    }



}
