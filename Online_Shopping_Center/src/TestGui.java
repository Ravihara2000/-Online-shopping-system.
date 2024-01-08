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
        f1.setSize(1000, 600);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(new BorderLayout());
        f1.setTitle("Westminster Shopping Center");
        //f1.getContentPane().setBackground(new Color(255,100,55));
        f1.setLocationRelativeTo(null); // GUI comes to the middle of the screen

        JLabel titleLabel = new JLabel("Westminster Shopping Center");
        titleLabel.setFont(new Font("Calibre", Font.BOLD, 29));
        JPanel titlePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePane.add(titleLabel);
        f1.add("North", titlePane);

        //btn area panel
        JPanel btnPanel = new JPanel();

        //sort btn
        JButton sort = new JButton("Sort");
        btnPanel.add(sort);

        JButton addCart = new JButton("Add Cart");
        btnPanel.add(addCart);

        JLabel ddText = new JLabel("Select product category:");
        btnPanel.add(ddText);

        // Create an array of items for the dropdown list
        String[] items = {"All", "Electronics", "Clothes"};

        // Create a JComboBox with the array of items
        JComboBox<String> dropdown = new JComboBox<>(items);
        // Add an ActionListener to the JComboBox
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = dropdown.getSelectedItem().toString();
                //updateTable(selectedCategory, tableModel, manager);
            }
        });

        btnPanel.add(dropdown);
        f1.add(btnPanel);

        JPanel tablePanel = new JPanel();

        String[] columnNames = {"Product ID", "Name", "Category", "Price","Number of Items", "Info"};
// Remove the DefaultTableModel type declaration before tableModel
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable productListTable = new JTable(tableModel);

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
        //pane.setPreferredSize(new Dimension(1000, 500));
        tablePanel.add(productListTable);
        f1.add("South",pane);






        f1.setVisible(true);
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

}