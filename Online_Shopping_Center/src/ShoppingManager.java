import java.io.IOException;

public interface ShoppingManager {

    void addProduct(Products products);
    void printProduct();
    void deleteProduct(String productId);

    void saveData() throws IOException;

    void loadData() throws IOException;
}
