public abstract class Products {
    private String productId;
    private String productName;
    private int numOfItems;
    private int price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
