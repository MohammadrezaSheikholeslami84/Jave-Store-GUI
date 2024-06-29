/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mehrzad @author Iliya @author mohammadreza
 */
public class Maneger extends javax.swing.JFrame implements ActionListener {

    static String username;

    public Maneger(String username) {
        this.username = username;
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        kGradientPanel1 = new sign.KGradientPanel();
        jButton3 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(13, 68, 123));
        kGradientPanel1.setkStartColor(new java.awt.Color(246, 167, 167));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1250, 710));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Sign out");
        jButton3.addActionListener(this);

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("Product");
        jToggleButton1.addActionListener(this);

        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(5, 5, 5));
        jToggleButton2.setText("Income");
        jToggleButton2.addActionListener(this);

        jToggleButton3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(10, 10, 10));
        jToggleButton3.setText("Client's list");
        jToggleButton3.addActionListener(this);

        jToggleButton4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton4.setText("Sold Products");
        jToggleButton4.addActionListener(this);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap(492, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)) // New Previous Orders button
                                .addGap(474, 474, 474))
        );
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap(173, Short.MAX_VALUE)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27) // Adjusted gap for new button
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE) // New Previous Orders button
                                .addGap(27, 27, 27)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(jButton3))
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maneger(username).setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private sign.KGradientPanel kGradientPanel1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton3) {
            this.dispose();
            sign.Welcome welcome = new sign.Welcome();
            welcome.setVisible(true);
        }
        else if (e.getSource() == jToggleButton1) {
            this.dispose();
            sign.Product_manager product_manager = new sign.Product_manager(username);
            product_manager.setVisible(true);
        }
        else if (e.getSource() == jToggleButton2) {
            this.dispose();
            sign.Income income = new sign.Income(username);
            income.setVisible(true);
        }
        else if (e.getSource() == jToggleButton3) {
            this.dispose();
            sign.Client_List client = new sign.Client_List(username);
            client.setVisible(true);
        }
        else if (e.getSource() == jToggleButton4) {
            this.dispose();
            sign.Sold_Products soldproducts = new sign.Sold_Products(username);
            soldproducts.setVisible(true);
        }
    }
    // End of variables declaration
}
