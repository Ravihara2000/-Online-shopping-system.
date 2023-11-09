import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingGUI extends JFrame {
    public ShoppingGUI(WestminsterShoppingManager manager) {
        JFrame f1 = new JFrame();
        f1.setSize(1000, 700);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(new BorderLayout());
        f1.setTitle("Westminster Shopping Center");
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

        // Create a JLabel with the desired text
        JLabel label = new JLabel("Select product category:");
        label.setFont(new Font("Calibre", Font.PLAIN, 16));

        JButton cartBtn = new JButton("Shopping Cart");
        cartBtn.setBounds(130,50,50,50);
        panel.add(cartBtn);
        //f1.add("South",titlePane);

        // Add the JLabel and JComboBox to the panel
        panel.add(label);
        panel.add(dropdown);

        // Add the panel to the frame's center
        f1.add("Center", panel);


        String[] columnNames = {"Product ID", "Name", "Category", "Price", "Info"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable productListTable = new JTable(tableModel);
        

        // Populate the table with data from the ArrayList
        ArrayList<Clothing> clothList = manager.getClothList();
        for (Clothing clothing : clothList) {
            Object[] rowData = {clothing.getProductId(), clothing.getProductName(),clothing.getCategory(), clothing.getPrice(),clothing.getInfo()};
            tableModel.addRow(rowData);
        }
        ArrayList<Electronics> electList = manager.getElectList();
        for (Electronics electronics : electList) {
            Object[] rowData = {electronics.getProductId(), electronics.getProductName(),electronics.getCategory(), electronics.getPrice(),electronics.getInfo()};
            tableModel.addRow(rowData);
        }
        productListTable.setDefaultEditor(Object.class, null); // get an uneditable table
        JScrollPane pane = new JScrollPane(productListTable);
        pane.setPreferredSize(new Dimension(300, 150));
        f1.add("South",pane);

        f1.setVisible(true);
    }
}
