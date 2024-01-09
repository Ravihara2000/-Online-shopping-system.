import java.io.FileNotFoundException;
import java.io.IOException;

public interface ShoppingManager {

    void addProduct(Products products);
    void printProduct();
    void deleteProduct(String productId);

    //void saveDataToFile() ;

    void saveDataToFile(String s);
    void loadDataFromFile(String f);

    void saveData2() throws IOException;

    void loadData2() throws IOException;
}
