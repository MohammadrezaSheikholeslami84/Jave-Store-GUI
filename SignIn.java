/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author mehrzad
 */
public class SignIn extends javax.swing.JFrame implements ActionListener {

    public static sign.Account account;

    public SignIn() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        kGradientPanel1 = new sign.KGradientPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(13, 68, 123));
        kGradientPanel1.setkStartColor(new java.awt.Color(246, 167, 167));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(Color.gray);
        jTextField1.setText("UserName");
        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField1.getText().equals("UserName")) {
                    jTextField1.setForeground(Color.black);
                    jTextField1.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField1.getText().equals("")) {
                    jTextField1.setForeground(Color.gray);
                    jTextField1.setText("UserName");
                }

            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setForeground(Color.gray);
        jTextField2.setText("Password");
        jTextField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField2.getText().equals("Password")) {
                    jTextField2.setForeground(Color.black);
                    jTextField2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField2.getText().equals("")) {
                    jTextField2.setForeground(Color.gray);
                    jTextField2.setText("Password");
                }
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(this);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(this);

        jRadioButton2.setText("Client");

        jRadioButton1.setText("Maneger");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(568, 568, 568))
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(507, 507, 507)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(396, 487, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addComponent(jButton4))
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
                new SignIn().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private sign.KGradientPanel kGradientPanel1;


    @Override
    public void actionPerformed(ActionEvent e) {

        sign.DB_User userdb = new sign.DB_User();


        if (e.getSource() == jButton4) {
            this.dispose();
            sign.Welcome welcome = new sign.Welcome();
            welcome.setVisible(true);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected())
            JOptionPane.showMessageDialog(null, "Choose your Account Type");
        else if (e.getSource() == jButton1 && jRadioButton2.isSelected()) {

            if (userdb.login(jTextField1.getText(), "Guest")) {

                if (userdb.get_account_pass(jTextField1.getText(), "Guest").equals(jTextField2.getText())) {

                    account = new sign.DB_User().search_account(jTextField1.getText(), "Guest");
                    this.dispose();
                    sign.Client client = new sign.Client(jTextField1.getText());
                    client.setVisible(true);

                } else
                    JOptionPane.showMessageDialog(this, "Password is Wrong");

            } else {
                int a = JOptionPane.showConfirmDialog(this, "Do you Want to Create Account ?", "Create Account", JOptionPane.YES_NO_CANCEL_OPTION);

                if (a == JOptionPane.YES_OPTION) {
                    this.dispose();
                    sign.SignUp F = new sign.SignUp();
                    F.setVisible(true);

                }
            }

        } else if (e.getSource() == jButton1 && jRadioButton1.isSelected()) {

            if (userdb.login(jTextField1.getText(), "Admin")) {

                if (userdb.get_account_pass(jTextField1.getText(), "Admin").equals(jTextField2.getText())) {

                    account = new sign.DB_User().search_account(jTextField1.getText(), "Admin");
                    this.dispose();
                    sign.Maneger maneger = new sign.Maneger(jTextField1.getText());
                    maneger.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Password is Wrong");
                }

            } else {

                int a = JOptionPane.showConfirmDialog(this, "Do you Want to Create Account ?", "Create Account", JOptionPane.YES_NO_CANCEL_OPTION);

                if (a == JOptionPane.YES_OPTION) {
                    this.dispose();
                    sign.SignUp F = new sign.SignUp();
                    F.setVisible(true);

                }


            }
        }


    }
    // End of variables declaration

    public boolean check_inputs(String username, String Password) {

        boolean is_fine = true;
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "User Name is Empty");
            is_fine = false;
        } else if (Password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password is Empty");
            is_fine = false;
        }

        return is_fine;


    }
}
