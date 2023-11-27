import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Color;

public class TestGui extends JFrame {
    private DefaultTableModel tableModel;
    private JPanel productDetailsPanel;
    public TestGui(WestminsterShoppingManager manager) {
        JFrame f1 = new JFrame();
        f1.setSize(700, 400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(new BorderLayout());
        f1.setTitle("Westminster Shopping Center");
        f1.getContentPane().setBackground(new Color(255,100,55));
        f1.setLocationRelativeTo(null); // GUI comes to the middle of the screen

        JLabel titleLabel = new JLabel("Westminster Shopping Center");
        titleLabel.setFont(new Font("Calibre", Font.BOLD, 29));
        JPanel titlePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePane.add(titleLabel);
        f1.add("North", titlePane);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create an array of items for the dropdown list
        String[] items = {"All", "Electronics", "Clothes"};

        // Create a JComboBox with the array of items
        JComboBox<String> dropdown = new JComboBox<>(items);
        // Add an ActionListener to the JComboBox
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = dropdown.getSelectedItem().toString();
                updateTable(selectedCategory, tableModel, manager);
            }
        });

        // Create a JLabel with the desired text
        JLabel label = new JLabel("Select product category:");
        label.setFont(new Font("Calibre", Font.PLAIN, 16));

        JButton sortBtn = new JButton("Sort List");
        sortBtn.setBounds(130,50,50,50);
        panel.add(sortBtn);

        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortTable();
            }
        });

        JButton cartBtn = new JButton("Shopping Cart");
        cartBtn.setBounds(130,50,50,50);
        panel.add(cartBtn);
        //f1.add("South",titlePane);

        // Add the JLabel and JComboBox to the panel
        panel.add(label);
        panel.add(dropdown);

        // Add the panel to the frame's center
        f1.add("Center", panel);


        String[] columnNames = {"Product ID", "Name", "Category", "Price","Number of Items", "Info"};
// Remove the DefaultTableModel type declaration before tableModel
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable productListTable = new JTable(tableModel);

        // Create a panel for product details
        productDetailsPanel = new JPanel();
        productDetailsPanel.setLayout(new BoxLayout(productDetailsPanel, BoxLayout.Y_AXIS));
        f1.add("Center", productDetailsPanel);

        // Add a ListSelectionListener to the table
        productListTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = productListTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Get the selected product details
                String productId = tableModel.getValueAt(selectedRow, 0).toString();
                String productName = tableModel.getValueAt(selectedRow, 1).toString();
                String category = tableModel.getValueAt(selectedRow, 2).toString();
                String price = tableModel.getValueAt(selectedRow, 3).toString();
                String numOfItems = tableModel.getValueAt(selectedRow, 4).toString();
                String info = tableModel.getValueAt(selectedRow, 5).toString();

                // Display the product details in the details panel
                displayProductDetails(productId, productName, category, price, numOfItems, info);
            }
        });


        // Populate the table with data from the ArrayList
        ArrayList<Clothing> clothList = manager.getClothList();
        for (Clothing clothing : clothList) {
            Object[] rowData = {clothing.getProductId(), clothing.getProductName(),clothing.getCategory(), clothing.getPrice(),clothing.getNumOfItems(),clothing.getInfo()};
            tableModel.addRow(rowData);
        }
        ArrayList<Electronics> electList = manager.getElectList();
        for (Electronics electronics : electList) {
            Object[] rowData = {electronics.getProductId(), electronics.getProductName(),electronics.getCategory(), electronics.getPrice(),electronics.getNumOfItems(),electronics.getInfo()};
            tableModel.addRow(rowData);
        }
        productListTable.setDefaultEditor(Object.class, null); // get an uneditable table
        JScrollPane pane = new JScrollPane(productListTable);
        pane.setPreferredSize(new Dimension(300, 150));
        f1.add("South",pane);



        f1.setVisible(true);
    }

    // Method to sort the table alphabetically based on product name

    // Method to update the table based on the selected category
    private void updateTable(String selectedCategory, DefaultTableModel tableModel, WestminsterShoppingManager manager) {
        // Check if tableModel is null, and initialize it if needed
        if (tableModel == null) {
            String[] columnNames = {"Product ID", "Name", "Category", "Price", "Number of Items","Info"};
            tableModel = new DefaultTableModel(columnNames, 0);
        }
        // Clear the table
        tableModel.setRowCount(0);

        // Populate the table with data based on the selected category
        if (selectedCategory.equals("All")) {
            populateTable(manager.getClothList(), manager.getElectList(), tableModel);
        } else if (selectedCategory.equals("Clothes")) {
            populateTable(manager.getClothList(), new ArrayList<>(), tableModel);
        } else if (selectedCategory.equals("Electronics")) {
            populateTable(new ArrayList<>(), manager.getElectList(), tableModel);
        }
    }

    // Method to populate the table with data from the ArrayLists
    private void populateTable(ArrayList<Clothing> clothList, ArrayList<Electronics> electList, DefaultTableModel tableModel) {
        for (Clothing clothing : clothList) {
            Object[] rowData = {clothing.getProductId(), clothing.getProductName(), clothing.getCategory(), clothing.getPrice(),clothing.getNumOfItems(), clothing.getInfo()};
            if (clothing.getNumOfItems() < 3) {
                // Set the background color of the entire row to red
                Arrays.fill(rowData, Color.RED);
            }
            tableModel.addRow(rowData);


        }
        for (Electronics electronics : electList) {
            Object[] rowData = {electronics.getProductId(), electronics.getProductName(), electronics.getCategory(), electronics.getPrice(),electronics.getNumOfItems(), electronics.getInfo()};
            tableModel.addRow(rowData);
        }
    }
    private void sortTable() {
        ArrayList<Object[]> data = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Object[] rowData = new Object[tableModel.getColumnCount()];
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                rowData[j] = tableModel.getValueAt(i, j);
            }
            data.add(rowData);
        }
        data.sort(Comparator.comparing(o -> o[1].toString())); // Sorting based on product name

        tableModel.setRowCount(0); // Clear the table

        for (Object[] rowData : data) {
            tableModel.addRow(rowData);
        }
    }
    // Add a method to display product details in the details panel
    private void displayProductDetails(String productId, String productName, String category, String price, String numOfItems, String info) {
        // Clear the existing content in the details panel
        productDetailsPanel.removeAll();

        // Create labels to display product details
        JLabel productIdLabel = new JLabel("Product ID: " + productId);
        JLabel productNameLabel = new JLabel("Name: " + productName);
        JLabel categoryLabel = new JLabel("Category: " + category);
        JLabel priceLabel = new JLabel("Price: " + price);
        JLabel numOfItemsLabel = new JLabel("Number of Items: " + numOfItems);
        JLabel infoLabel = new JLabel("Info: " + info);

        // Add labels to the details panel
        productDetailsPanel.add(productIdLabel);
        productDetailsPanel.add(productNameLabel);
        productDetailsPanel.add(categoryLabel);
        productDetailsPanel.add(priceLabel);
        productDetailsPanel.add(numOfItemsLabel);
        productDetailsPanel.add(infoLabel);

        // Repaint the details panel
        productDetailsPanel.revalidate();
        productDetailsPanel.repaint();


    }
}
