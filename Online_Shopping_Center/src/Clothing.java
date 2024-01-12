public class Clothing extends Products{
    private String size;
    private String color;

    public Clothing(String size, String color) {
        this.size = size;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Clothing{"+super.toString() +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String toStringGui() {
        return size + ',' +color;
    }

    public String getSize() {
        return size;
    }
    public String getCategory() {
        return "Clothing";
    }
    public String getInfo() {
        return toStringGui();
    }

    public String getColor() {
        return color;
    }


    public Clothing(String productId, String productName, int numOfItems, int price, String size, String color) {
        super(productId, productName, numOfItems, price);
        this.size = size;
        this.color = color;
    }
}
