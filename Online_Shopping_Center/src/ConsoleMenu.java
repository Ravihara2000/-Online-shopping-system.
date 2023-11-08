import java.io.IOException;
import java.util.Scanner;

public class ConsoleMenu {

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
                    //deleteDoctor();
                    break;
                case 3:
                    //manager.printDoctorList();
                    break;
                case 4:
                    //manager.printStatistics();
                    //manager.saveData();

                    System.out.println("data saved successfully");
                    break;
                case 5:
                    //manager.loadData();
                    break;
                case 6:
                    //SkinConsultGUI g1 = new SkinConsultGUI((WestminsterSkinConsultationManager) manager);
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

    private static void addProduct(){
        Clothing clothing;
        Electronics electronics;
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

        }else {
            System.out.println("Invalid input");
        }

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
