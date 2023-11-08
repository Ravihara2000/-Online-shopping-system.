import java.io.FileNotFoundException;

public interface ShoppingManager {

    void addProduct(Products products);
    void printProduct();
    void deleteProduct(String productId);

    //void saveDataToFile() ;

    void saveDataToFile(String s);
    void loadDataFromFile(String f);
}
