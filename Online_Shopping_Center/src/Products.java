public abstract class Products {
    private String productId;
    private String productName;
    private int numOfItems;
    private int price;

    public Products() {
    }

    public Products(String productId, String productName, int numOfItems, int price) {
        this.productId = productId;
        this.productName = productName;
        this.numOfItems = numOfItems;
        this.price = price;
    }
}
