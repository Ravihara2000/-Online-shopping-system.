public class Electronics extends Products{
    private String brand;
    private int warrantyPeriod;

    public Electronics(String brand, int warrantyPeriod) {
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                '}';
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronics(String productId, String productName, int numOfItems, int price, String brand, int warrantyPeriod) {
        super(productId, productName, numOfItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }
}
