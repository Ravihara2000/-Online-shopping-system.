import java.io.*;
import java.util.*;

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
    public void saveDataToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Save Electronics data
            writer.write("Electronics Data:");
            writer.newLine();
            for (Electronics electronics : electList) {
                writer.write(electronics.toString()); // You should implement a toString method in Electronics
                writer.newLine();
            }

            // Save Clothing data
            writer.write("Clothing Data:");
            writer.newLine();
            for (Clothing clothing : clothList) {
                writer.write(clothing.toString()); // You should implement a toString method in Clothing
                writer.newLine();
            }

            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error while saving data to file: " + e.getMessage());
        }
    }

    public void loadDataFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentCategory = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Electronics Data:")) {
                    currentCategory = "Electronics";
                } else if (line.startsWith("Clothing Data:")) {
                    currentCategory = "Clothing";
                } else if (currentCategory != null) {
                    // Parse and create objects based on the category
                    if (currentCategory.equals("Electronics")) {
                        Electronics electronics = Electronics.fromString(line);
                        if (electronics != null) {
                            electList.add(electronics);
                        }
                    } else if (currentCategory.equals("Clothing")) {
                        Clothing clothing = Clothing.fromString(line);
                        if (clothing != null) {
                            clothList.add(clothing);
                        }
                    }
                }
            }

            System.out.println("Data loaded from " + filename);
        } catch (IOException e) {
            System.err.println("Error while loading data from file: " + e.getMessage());
        }
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

    public void printProduct(){


        if(getElectList().isEmpty() && getClothList().isEmpty()){
            System.out.println("No products have added");
        }else{

            Collections.sort(electList, new Comparator<Electronics>() {
                @Override
                public int compare(Electronics e1, Electronics e2) {
                    return e1.getProductId().compareTo(e2.getProductId());
                }
            });

            Collections.sort(clothList, new Comparator<Clothing>() {
                @Override
                public int compare(Clothing c1, Clothing c2) {
                    return c1.getProductId().compareTo(c2.getProductId());
                }
            });
            System.out.println("\n*** List of all items ***");
            for (Electronics electronics:electList) {
                System.out.println("\nProduct Id :"+electronics.getProductId());
                System.out.println("Product Name :"+electronics.getProductName());
                System.out.println("Number of Items :"+electronics.getNumOfItems());
                System.out.println("Price :"+electronics.getPrice());
                System.out.println("Brand :"+electronics.getBrand());
                System.out.println("Warranty period :"+electronics.getWarrantyPeriod());
            }

            for (Clothing clothing:clothList) {
                System.out.println("\nProduct Id :"+clothing.getProductId());
                System.out.println("Product Name :"+clothing.getProductName());
                System.out.println("Number of Items :"+clothing.getNumOfItems());
                System.out.println("Price :"+clothing.getPrice());
                System.out.println("Size :"+clothing.getSize());
                System.out.println("Color :"+clothing.getColor());
            }
        }
    }

    public void deleteProduct(String productId) {
        boolean found = false;

        // Using Iterator for safe removal
        Iterator<Electronics> electronicsIterator = electList.iterator();
        while (electronicsIterator.hasNext()) {
            Electronics electronics = electronicsIterator.next();
            if (electronics.getProductId().equals(productId)) {
                found = true;
                electronicsIterator.remove();
                System.out.println("\nRemoved electronic item");
                break;
            }
        }

        // Using Iterator for safe removal
        Iterator<Clothing> clothingIterator = getClothList().iterator();
        while (clothingIterator.hasNext()) {
            Clothing clothing = clothingIterator.next();
            if (clothing.getProductId().equals(productId)) {
                found = true;
                clothingIterator.remove();
                System.out.println("\nRemoved clothing item");
                break;
            }
        }

        if (!found) {
            System.out.println("\nInvalid product id");
        }
    }


}
