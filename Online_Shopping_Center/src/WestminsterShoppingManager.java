import java.util.ArrayList;

public class WestminsterShoppingManager implements ShoppingManager {
    public final static int maxProducts=50;
    public ArrayList <Electronics> electList = new ArrayList<>();
    public ArrayList <Clothing> clothList = new ArrayList<>();

    public ArrayList<Electronics> getElectList() {
        return electList;
    }

    public ArrayList<Clothing> getClothList() {
        return clothList;
    }


    public void addProduct(Products products) {
        if (getClothList().size() + getElectList().size() > maxProducts) {
            System.out.println("Maximum limit reached");
        } else {
            if (products instanceof Electronics) {
                getElectList().add((Electronics) products);
                System.out.println("Electronics item added");
            } else if (products instanceof Clothing) {
                getClothList().add((Clothing) products);
                System.out.println("Clothing item added");
            } else {
                System.out.println("Unknown product type");
            }
        }
    }

}
