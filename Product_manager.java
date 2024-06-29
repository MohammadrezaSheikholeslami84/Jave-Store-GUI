/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sign;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author mehrzad @author Iliya @author mohammadreza
 */
public class Product_manager extends javax.swing.JFrame implements ActionListener {

    static String username;

    DefaultTableModel model ;
    TableRowSorter<DefaultTableModel> rowSorter ;
    public Product_manager(String username) {
        this.username = username;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        kGradientPanel1 = new sign.KGradientPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(13, 68, 123));
        kGradientPanel1.setkStartColor(new java.awt.Color(246, 167, 167));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1250, 710));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Sign out");
        jButton3.addActionListener(this);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText(" Add Item");
        jButton4.addActionListener(this);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Search Item");

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(this);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton6.setText("Add Image");
        jButton6.addActionListener(this);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(this);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton8.setText("Edit");
        jButton8.addActionListener(this);

        //  FILL THE TABLE AND ADD SORTING OPTION TO TABLE :

        Class[] all_types ;
        all_types = new Class[]{Integer.class , String.class , String.class , Long.class , Integer.class , Integer.class} ;

        model = new DefaultTableModel(new sign.DB_Products().show_products_for_manager() , new String[]{ "ID", "category",
                "name", "price" , "inventory" , "rating"}){

            @Override
            public Class getColumnClass(int index_of_column) {
                return all_types[index_of_column] ;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false ;
            }
        };

        jTable1.setModel(model);
        jTable1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTable1);

        String searched_item = jTextField1.getText() ;
        rowSorter = new TableRowSorter<>(model) ;
        jTable1.setRowSorter(rowSorter);

        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String searched_item = jTextField1.getText() ;
                search_field(searched_item);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String searched_item = jTextField1.getText() ;
                search_field(searched_item);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String searched_item = jTextField1.getText() ;
                search_field(searched_item);
            }
            public void search_field(String searched_item){

                if(searched_item.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searched_item));
                }
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(58, 58, 58)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton7)
                                                        .addComponent(jButton8)
                                                        .addComponent(jButton4)
                                                        .addComponent(jButton6))
                                                .addGap(0, 123, Short.MAX_VALUE))))
        );
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton5)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product_manager(username).setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private sign.KGradientPanel kGradientPanel1;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton3) {
            this.dispose();
            sign.Welcome welcome = new sign.Welcome();
            welcome.setVisible(true);
        }
        else if (e.getSource() == jButton5) {
            this.dispose();
            sign.Maneger maneger = new sign.Maneger(username);
            maneger.setVisible(true);
        }
        else if (e.getSource() == jButton6) {

            int selected_row = jTable1.getSelectedRow() ;

            if(selected_row != -1) {

                int selectedID = (int) jTable1.getValueAt(selected_row , 0) ;
                JFileChooser select_image_for_products = new JFileChooser("/Users/iliya/Downloads/Images_for_Store");
                int variable = select_image_for_products.showSaveDialog(null);

                select_image_for_products.setAcceptAllFileFilterUsed(false);
                String file_path = select_image_for_products.getSelectedFile().getAbsolutePath();
                select_image_for_products.setApproveButtonText(" Are you sure ?");

                if(variable == JFileChooser.APPROVE_OPTION ) {
                    new sign.DB_Products().edit_file_path(selectedID, file_path);
                }
            }
            else{
                JOptionPane.showMessageDialog(this , "Please select a Product to Add it's Image");
            }

        }

        else if (e.getSource() == jButton7) {

            int selected_row = jTable1.getSelectedRow() ;

            if(selected_row != -1){
                int selected_id = (int) jTable1.getValueAt(selected_row , 0) ;
                int make_sure =  JOptionPane.showConfirmDialog(this , "Are you sure? ") ;

                if(make_sure == JOptionPane.YES_OPTION){
                    JOptionPane.getRootFrame().dispose();
                    model.removeRow(selected_row);
                    new sign.DB_Products().remove_product(selected_id);
                }
                else{
                    JOptionPane.getRootFrame().dispose();
                }
            }
            else{
                JOptionPane.showMessageDialog(this , "please select a product to delete");
            }
        }
        else if (e.getSource() == jButton8) {

            int selected_row = jTable1.getSelectedRow() ;

            if(selected_row != -1){
                int selected_id = (int) jTable1.getValueAt(selected_row , 0) ;
                String selected_category = (String) jTable1.getValueAt(selected_row , 1) ;
                String selected_name = (String) jTable1.getValueAt(selected_row , 2) ;
                long selected_price = (long) jTable1.getValueAt(selected_row , 3) ;
                int selected_inventory = (int) jTable1.getValueAt(selected_row , 4) ;

                JDialog edit_item = new JDialog(this , "Edit Products") ;
                edit_item.setLayout(new GridLayout(6 , 2 , 5 , 5));
                edit_item.setSize(450 , 450);
                edit_item.setLocation(450 , 450);
                edit_item.setVisible(true);

                JLabel productID = new JLabel("ProductID: ") ;
                productID.setFont(new Font(Font.SERIF , Font.BOLD , 20));
                JTextField fix_productID = new JTextField() ;
                fix_productID.setText(String.valueOf(selected_id));
                fix_productID.setEditable(false);
                fix_productID.setBackground(Color.lightGray);

                JLabel category = new JLabel("Category: ") ;
                category.setFont(new Font(Font.SERIF , Font.BOLD , 20));
                JTextField edit_category = new JTextField() ;
                edit_category.setText(selected_category);

                JLabel name = new JLabel("Name: ") ;
                name.setFont(new Font(Font.SERIF , Font.BOLD , 20));
                JTextField edit_name = new JTextField() ;
                edit_name.setText(selected_name);

                JLabel price = new JLabel("Price: ") ;
                price.setFont(new Font(Font.SERIF , Font.BOLD , 20));
                JTextField edit_price = new JTextField() ;
                edit_price.setText(String.valueOf(selected_price));

                JLabel inventory = new JLabel("Inventory: ") ;
                inventory.setFont(new Font(Font.SERIF , Font.BOLD , 20));
                JTextField edit_inventory = new JTextField() ;
                edit_inventory.setText(String.valueOf(selected_inventory));

                JButton submit = new JButton() ;
                submit.setText("Submit");
                submit.setFont(new Font(Font.SERIF , Font.BOLD , 20));

                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String edited_category = edit_category.getText() ;
                        String edited_name = edit_name.getText() ;
                        long edited_price = Long.parseLong(edit_price.getText()) ;
                        int edited_inventory = Integer.parseInt(edit_inventory.getText()) ;

                        new sign.DB_Products().general_edit( selected_id , edited_category , edited_name , edited_price , edited_inventory);

                        model.setValueAt(edited_category , selected_row , 1);
                        model.setValueAt(edited_name , selected_row , 2);
                        model.setValueAt(edited_price , selected_row , 3);
                        model.setValueAt(edited_inventory , selected_row , 4);

                        edit_item.dispose();
                    }
                });

                edit_item.add(productID) ;
                edit_item.add(fix_productID) ;
                edit_item.add(category) ;
                edit_item.add(edit_category) ;
                edit_item.add(name) ;
                edit_item.add(edit_name) ;
                edit_item.add(price) ;
                edit_item.add(edit_price) ;
                edit_item.add(inventory) ;
                edit_item.add(edit_inventory) ;
                edit_item.add(submit) ;

            }
            else{
                JOptionPane.showMessageDialog(this ,"Please select a product to Edit");
            }
        }
        else if (e.getSource() == jButton4) {

            JDialog add_item = new JDialog(this , "Add Product") ;
            add_item.setLayout(new GridLayout(7 , 2 , 5 , 5));
            add_item.setSize(500 , 500);
            add_item.setLocation(450 , 300);
            add_item.setVisible(true);

            JLabel productID = new JLabel("ProductID: ") ;
            productID.setFont(new Font(Font.SERIF , Font.BOLD , 20));
            JTextField get_productID = new JTextField() ;

            JLabel category = new JLabel("Category: ") ;
            category.setFont(new Font(Font.SERIF , Font.BOLD , 20));
            JTextField get_category = new JTextField() ;

            JLabel name = new JLabel("Name: ") ;
            name.setFont(new Font(Font.SERIF , Font.BOLD , 20));
            JTextField get_name = new JTextField() ;

            JLabel price = new JLabel("Price: ") ;
            price.setFont(new Font(Font.SERIF , Font.BOLD , 20));
            JTextField get_price = new JTextField() ;

            JLabel inventory = new JLabel("Inventory: ") ;
            inventory.setFont(new Font(Font.SERIF , Font.BOLD , 20));
            JTextField get_inventory = new JTextField() ;


            JLabel file_path = new JLabel("File Path: ") ;
            file_path.setFont(new Font(Font.SERIF , Font.BOLD , 20));
            JTextField get_file_path = new JTextField() ;


            JButton submit_button = new JButton() ;
            submit_button.setText("Submit");
            submit_button.setFont(new Font(Font.SERIF , Font.BOLD , 20));

            submit_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int new_id = Integer.parseInt(get_productID.getText()) ;
                    String new_category = get_category.getText() ;
                    String new_name = get_name.getText() ;
                    long new_price = Long.parseLong(get_price.getText());
                    int new_inventory = Integer.parseInt(get_inventory.getText()) ;
                    String new_filePath = get_file_path.getText() ;

                    new sign.DB_Products().add_product(new_id , new_category , new_name , new_price , new_inventory , 0 , new_filePath);

                    model.insertRow(jTable1.getRowCount() , new Object[]{ new_id , new_category , new_name , new_price , new_inventory , 0 , new_filePath});

                    add_item.dispose();
                }
            });


            productID.setVisible(true);
            add_item.add(productID) ;
            get_productID.setVisible(true);
            add_item.add(get_productID) ;
            category.setVisible(true);
            add_item.add(category) ;
            get_category.setVisible(true);
            add_item.add(get_category) ;
            name.setVisible(true);
            add_item.add(name) ;
            get_name.setVisible(true);
            add_item.add(get_name) ;
            price.setVisible(true);
            add_item.add(price) ;
            get_price.setVisible(true);
            add_item.add(get_price) ;
            inventory.setVisible(true);
            add_item.add(inventory) ;
            get_inventory.setVisible(true);
            add_item.add(get_inventory) ;
            file_path.setVisible(true);
            add_item.add(file_path) ;
            get_file_path.setVisible(true);
            add_item.add(get_file_path) ;
            submit_button.setVisible(true);
            add_item.add(submit_button) ;

        }

    }
    // End of variables declaration
}
