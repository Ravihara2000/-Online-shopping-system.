import java.io.IOException;
import java.util.Scanner;

public class ConsoleMenu {

    private WestminsterShoppingManager shoppingManager;

    static ShoppingManager manager = new WestminsterShoppingManager();
    final static Scanner scn =new Scanner(System.in);
    //static SkinConsultationManager manager = new WestminsterSkinConsultationManager();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        menuloop:
        while (true){
            displayMenu();
            int choice =scn.nextInt();
            //TODO: Validate the user input for integer

            switch (choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    manager.printProduct();
                    break;
                case 4:
                    //manager.printStatistics();
                    manager.saveDataToFile("shopping_data.txt");

                    //System.out.println("data saved successfully");
                    break;
                case 5:
                    manager.loadDataFromFile("shopping_data.txt");
                    break;
                case 6:
                    ShoppingGUI g1 = new ShoppingGUI((WestminsterShoppingManager) manager);
                    break;
                case 7:
                    System.out.println("Thank you for using the system");
                    break menuloop;
                default:
                    System.out.println("invalid option");
            }
        }

    }
    public static void displayMenu(){
        System.out.println("\n ----WELCOME TO WESTMINSTER ONLINE SHOPPING  CENTER-----");
        System.out.println("1: Add a new product");
        System.out.println("2: Delete a product");
        System.out.println("3: Display all products");//alphabetically according to the
        System.out.println("4: Save Data");
        System.out.println("5: Load Data");
        System.out.println("6: Display GUI");
        System.out.println("7: Quite application");
    }

    public static void addProduct(){

        try{
        System.out.println("what do you want to add?");
        System.out.println("1.Electronics\n 2.Clothing");
        //Scanner sc = new Scanner(System.in);
        int x= scn.nextInt();
            if(x==1){


            System.out.println("Enter product ID");
            String pId = scn.next();

            System.out.println("Enter product Name");
            String pName = scn.next();

            System.out.println("Enter number of products");
            int pAmount = scn.nextInt();

            System.out.println("Enter product price");
            int pPrice = scn.nextInt();


            System.out.println("Enter product brand");
            String pBrand = scn.next();

            System.out.println("Enter product warranty period");
            int pWarranty = scn.nextInt();

             Electronics electronics = new Electronics(pId,pName,pAmount,pPrice,pBrand,pWarranty);

            manager.addProduct(electronics);

        } else if (x==2) {

                System.out.println("Enter product ID");
                String pId = scn.next();

                System.out.println("Enter product Name");
                String pName = scn.next();

                System.out.println("Enter number of products");
                int pAmount = scn.nextInt();

                System.out.println("Enter product price");
                int pPrice = scn.nextInt();
                System.out.println("Enter product Size");
                String pSize = scn.next();

                System.out.println("Enter product color");
                String pColor = scn.next();

                Clothing clothing = new Clothing(pId,pName,pAmount,pPrice,pSize,pColor);
                manager.addProduct(clothing);

        }else {
            System.out.println("Invalid input");
        }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteProduct(){
        System.out.println("what do you want to delete?");
        System.out.println("1.Electronics\n 2.Clothing");
        //Scanner sc = new Scanner(System.in);
        int x= scn.nextInt();

        if(x==1){
            System.out.println("Enter product Id");
            String pId = scn.next();

            manager.deleteProduct(pId);
        }
    }


}
