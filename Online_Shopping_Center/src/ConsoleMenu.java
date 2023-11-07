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
                    //addDoctor();
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


}
