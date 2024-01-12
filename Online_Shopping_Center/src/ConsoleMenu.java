import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    static ShoppingManager manager = new WestminsterShoppingManager();
    final static Scanner scn =new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        menuloop:
        while (true){
            try {
                displayMenu();
                int choice = scn.nextInt();
                //TODO: Validate the user input for integer

                switch (choice) {
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
                        manager.saveData();

                        break;
                    case 5:
                        manager.loadData();
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
            }catch (InputMismatchException e){
                System.out.println("invalid input type");
                scn.next();  // Clear the scanner buffer

            }
        }

    }
    public static void displayMenu(){
        System.out.println("\n ----WELCOME TO WESTMINSTER ONLINE SHOPPING  CENTER-----");
        System.out.println("1: Add a new product");
        System.out.println("2: Delete a product");
        System.out.println("3: Display all products");
        System.out.println("4: Save Data");
        System.out.println("5: Load Data");
        System.out.println("6: Display GUI");
        System.out.println("7: Quite application");
    }

    //add product method
    public static void addProduct(){

        try{
        System.out.println("what do you want to add?");
        System.out.println("1.Electronics\n2.Clothing");
        String x= scn.next();

        if(x.equals("1")||x.equals("2")) {

            System.out.println("Enter product ID");
            String pId;
            do {
                pId = scn.next();
                if (pId.trim().isEmpty()) {
                    System.out.println("Product ID cannot be empty. Please enter again:");
                }
            } while (pId.trim().isEmpty());

            System.out.println("Enter product Name");
            String pName;
            do {
                pName = scn.next();
                if (pName.trim().isEmpty()) {
                    System.out.println("Product Name cannot be empty. Please enter again:");
                }
            } while (pName.trim().isEmpty());

            System.out.println("Enter number of products");
            int pAmount;
            do {
                while (!scn.hasNextInt()) {
                    System.out.println("Invalid input. Please reenter number of products");
                    scn.next();  // Consume the invalid input
                }
                pAmount = scn.nextInt();
                if (pAmount <= 0) {
                    System.out.println("Number of products must be positive. Please enter again:");
                }
            } while (pAmount <= 0);

            System.out.println("Enter product price");
            int pPrice;
            do {
                while (!scn.hasNextInt()) {
                    System.out.println("Invalid input. Please reenter product price");
                    scn.next();  // Consume the invalid input
                }
                pPrice = scn.nextInt();
                if (pPrice <= 0) {
                    System.out.println("Product price must be positive. Please enter again:");
                }
            } while (pPrice <= 0);

            if (x.equals("1")) {
                System.out.println("Enter product brand");
                String pBrand;
                do {
                    pBrand = scn.next();
                    if (pBrand.trim().isEmpty()) {
                        System.out.println("Product brand cannot be empty. Please enter again:");
                    }
                } while (pBrand.trim().isEmpty());

                System.out.println("Enter product warranty period");
                int pWarranty;
                do {
                    while (!scn.hasNextInt()) {
                        System.out.println("Invalid input. Please reenter product warranty period");
                        scn.next();
                    }
                    pWarranty = scn.nextInt();
                    if (pWarranty <= 0) {
                        System.out.println("Product warranty period must be positive. Please enter again:");
                    }
                } while (pWarranty <= 0);

                Electronics electronics = new Electronics(pId, pName, pAmount, pPrice, pBrand, pWarranty);
                manager.addProduct(electronics);

            } else if (x.equals("2")) {
                System.out.println("Enter product Size");
                String pSize;
                do {
                    pSize = scn.next();
                    if (pSize.trim().isEmpty()) {
                        System.out.println("Product size cannot be empty. Please enter again:");
                    }
                } while (pSize.trim().isEmpty());

                System.out.println("Enter product color");
                String pColor;
                do {
                    pColor = scn.next();
                    if (pColor.trim().isEmpty()) {
                        System.out.println("Product color cannot be empty. Please enter again:");
                    }
                } while (pColor.trim().isEmpty());

                Clothing clothing = new Clothing(pId, pName, pAmount, pPrice, pSize, pColor);
                manager.addProduct(clothing);
            }

        }else {
            System.out.println("Invalid input");
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
//delete product id
    public static void deleteProduct(){
        System.out.println("Enter product ID to delete");
        String pId;
        boolean isValidId = false;

        do {
            pId = scn.next();

            // Check if the ID is empty
            if (pId.trim().isEmpty()) {
                System.out.println("Product ID cannot be empty. Please enter again:");
                continue; // Continue to the next iteration of the loop
            }


            isValidId = true; // Set the flag to true if a valid ID is entered

        } while (!isValidId);

        manager.deleteProduct(pId);


    }

}
