public class Clothing extends Products{
    private String size;
    private String color;

    public Clothing(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Clothing(String productId, String productName, int numOfItems, int price, String size, String color) {
        super(productId, productName, numOfItems, price);
        this.size = size;
        this.color = color;
    }
}
