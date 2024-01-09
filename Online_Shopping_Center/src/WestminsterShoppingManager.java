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

/*    public void loadDataFromFile(String filename) {
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
    }*/



/*    public void addProduct(Products products) {
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
    }*/

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

    public void addProduct(Products products) {
        String productId = products.getProductId();

        // Check if the product ID already exists in either list
        if (productExists(productId)) {
            System.out.println("Product ID already exists. Cannot add duplicate.");
            return;
        }

        if (getClothList().size() + getElectList().size() >= maxProducts) {
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

    // Helper method to check if a product ID exists in either list
    private boolean productExists(String productId) {
        for (Electronics electronics : getElectList()) {
            if (electronics.getProductId().equals(productId)) {
                return true;
            }
        }
        for (Clothing clothing : getClothList()) {
            if (clothing.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    public void loadDataFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentCategory = null;
            StringBuilder productData = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Electronics Data:")) {
                    currentCategory = "Electronics";
                    productData.setLength(0); // Clear the StringBuilder for new data
                } else if (line.startsWith("Clothing Data:")) {
                    currentCategory = "Clothing";
                    productData.setLength(0); // Clear the StringBuilder for new data
                } else if (currentCategory != null) {
                    // Append the line to the product data
                    productData.append(line).append("\n");

                    // Check if the line ends with a '}' to determine if it's the end of product data
                    if (line.endsWith("}")) {
                        String productInfo = productData.toString().trim();
                        if (currentCategory.equals("Electronics")) {
                            Electronics electronics = Electronics.fromString(productInfo);
                            if (electronics != null) {
                                electList.add(electronics);
                            }
                        } else if (currentCategory.equals("Clothing")) {
                            Clothing clothing = Clothing.fromString(productInfo);
                            if (clothing != null) {
                                clothList.add(clothing);
                            }
                        }
                    }
                }
            }

            System.out.println("Data loaded from " + filename);
        } catch (IOException e) {
            System.err.println("Error while loading data from file: " + e.getMessage());
        }
    }

    public void saveData2() throws IOException {
        File file = new File("newText.txt");
        FileOutputStream fout = new FileOutputStream(file, true);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        Iterator it = electList.iterator();
        while(it.hasNext()){
            Electronics eleNew = (Electronics) it.next();
            objout.writeObject(eleNew);
            System.out.println("data saved successfully");
        }
    }

    public void loadData2() throws IOException {
        FileInputStream fin = new FileInputStream("newText.txt");
        ObjectInputStream objin = new ObjectInputStream(fin);

        while (true){
            try{
                Electronics electronics = (Electronics) objin.readObject();
                electList.add(electronics);
                System.out.println("Data loaded from text file");

            } catch (IOException|ClassNotFoundException e) {
                break;
            }
        }

    }




}
