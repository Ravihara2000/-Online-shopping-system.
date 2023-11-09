public class Test {
    public static void main(String[] args) {
        ShoppingManager manager = new WestminsterShoppingManager();
        Electronics e1 = new Electronics("w1","phone",10,100,"apple",20);
        Electronics e2 = new Electronics("w2","tab",15,100,"samsung",20);
        Clothing c1 = new Clothing("q1","shirt",5,30,"small","black");
        Clothing c2 = new Clothing("q2","short",15,34,"xl","yellow");
        manager.addProduct(e1);
        manager.addProduct(e2);
        manager.addProduct(c1);
        manager.addProduct(c2);
        //manager.printProduct();
        //manager.deleteProduct("w11");
        //manager.printProduct();
        //manager.saveDataToFile("shopping_data.txt");
/*        manager.loadDataFromFile("shopping_data.txt");
        manager.printProduct();*/
        ShoppingGUI g1 = new ShoppingGUI((WestminsterShoppingManager) manager);
    }
}
