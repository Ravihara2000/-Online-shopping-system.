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
        return "Electronics{"+super.toString() +
                "brand='" + brand + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                '}';
    }
    public String toStringGui() {
        return brand + ',' + warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronics(String productId, String productName, int numOfItems, int price, String brand, int warrantyPeriod) {
        super(productId, productName, numOfItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }
    public static Electronics fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length != 2) {
            return null; // Invalid data
        }

        String brand = parts[0].substring(parts[0].indexOf('=') + 1).trim();
        int warrantyPeriod = Integer.parseInt(parts[1].substring(parts[1].indexOf('=') + 1).replace("}", "").trim());

        return new Electronics(brand, warrantyPeriod);
    }
    public String getCategory() {
        return "Electronics";
    }
    public String getInfo() {
        return toStringGui();
    }

}
