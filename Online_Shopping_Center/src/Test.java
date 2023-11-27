public class Test {
    public static void main(String[] args) {
        ShoppingManager manager = new WestminsterShoppingManager();
        Electronics e1 = new Electronics("w1","dphone",10,100,"apple",20);
        Electronics e2 = new Electronics("w2","atab",1,100,"samsung",20);
        Clothing c1 = new Clothing("q1","cshirt",2,30,"small","black");
        Clothing c2 = new Clothing("q2","bshort",15,34,"xl","yellow");

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
        //TestGui g2 = new TestGui((WestminsterShoppingManager)manager);
        //desc d1 = new desc((WestminsterShoppingManager) manager);
    }
}
