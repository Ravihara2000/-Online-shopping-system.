import java.io.Serializable;

public abstract class Products implements Serializable {
    private String productId;
    private String productName;
    private int numOfItems;
    private int price;

    @Override
    public String toString() {
        return "Products{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", numOfItems=" + numOfItems +
                ", price=" + price +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }


    public int getNumOfItems() {
        return numOfItems;
    }

    public int getPrice() {
        return price;
    }

    public Products() {
    }

    public Products(String productId, String productName, int numOfItems, int price) {
        this.productId = productId;
        this.productName = productName;
        this.numOfItems = numOfItems;
        this.price = price;
    }
}
