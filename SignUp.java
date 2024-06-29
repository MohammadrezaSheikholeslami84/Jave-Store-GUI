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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mehrzad @author Iliya @author mohammadreza
 */
public class SignUp extends javax.swing.JFrame implements ActionListener {

    public SignUp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        kGradientPanel1 = new sign.KGradientPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(13, 68, 123));
        kGradientPanel1.setkStartColor(new java.awt.Color(246, 167, 167));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1250, 710));

        kGradientPanel1.setkEndColor(new java.awt.Color(13, 68, 123));
        kGradientPanel1.setkStartColor(new java.awt.Color(246, 167, 167));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1250, 710));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setForeground(Color.gray);
        jTextField3.setText("First Name");
        jTextField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField3.getText().equals("First Name")) {
                    jTextField3.setForeground(Color.black);
                    jTextField3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField3.getText().equals("")) {
                    jTextField3.setForeground(Color.gray);
                    jTextField3.setText("First Name");
                }
            }
        });


        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(Color.gray);
        jTextField1.setText("Family Name");
        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField1.getText().equals("Family Name")) {
                    jTextField1.setForeground(Color.black);
                    jTextField1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField1.getText().equals("")) {
                    jTextField1.setForeground(Color.gray);
                    jTextField1.setText("Family Name");
                }
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.setForeground(Color.gray);
        jTextField4.setText("User Name");
        jTextField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField4.getText().equals("User Name")) {
                    jTextField4.setForeground(Color.black);
                    jTextField4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField4.getText().equals("")) {
                    jTextField4.setForeground(Color.gray);
                    jTextField4.setText("User Name");
                }
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.setForeground(Color.gray);
        jTextField5.setText("Password");
        jTextField5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField5.getText().equals("Password")) {
                    jTextField5.setForeground(Color.black);
                    jTextField5.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField5.getText().equals("")) {
                    jTextField5.setForeground(Color.gray);
                    jTextField5.setText("Password");
                }
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField6.setForeground(Color.gray);
        jTextField6.setText("Phone Number");
        jTextField6.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField6.getText().equals("Phone Number")) {
                    jTextField6.setForeground(Color.black);
                    jTextField6.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField6.getText().equals("")) {
                    jTextField6.setForeground(Color.gray);
                    jTextField6.setText("Phone Number");
                }
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setForeground(Color.gray);
        jTextField2.setText("Address");
        jTextField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField2.getText().equals("Address")) {
                    jTextField2.setForeground(Color.black);
                    jTextField2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField2.getText().equals("")) {
                    jTextField2.setForeground(Color.gray);
                    jTextField2.setText("Address");
                }
            }
        });


        jButton1.setText("Submit");
        jButton1.addActionListener(this);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(this);

        jRadioButton1.setText("Maneger");
        jRadioButton2.setText("Client");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField2)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addGap(180, 180, 180)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(393, 393, 393))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3))
        );
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        //     .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        //.addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                                .addComponent(jButton3))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton2)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private sign.KGradientPanel kGradientPanel1;

    @Override
    public void actionPerformed(ActionEvent e) {

        sign.DB_User userdb = new sign.DB_User();

        if (e.getSource() == jButton3) {
            this.dispose();
            sign.Welcome welcome = new sign.Welcome();
            welcome.setVisible(true);

        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected())
            JOptionPane.showMessageDialog(this, "Choose your Account Type");

        else if (e.getSource() == jButton1 && jRadioButton2.isSelected()) {
            if (check_password_length(jTextField5.getText()) && check_password_characters(jTextField5.getText()) && check_phone_number(jTextField6.getText())) {
                userdb.create_Account(jTextField4.getText(), jTextField3.getText(), jTextField1.getText(), jTextField6.getText(), jTextField5.getText(), jTextField2.getText(), 0, "Guest");
                JOptionPane.showMessageDialog(this, "Account is Created");
                this.dispose();
                sign.Client client = new sign.Client(jTextField4.getText());
                client.setVisible(true);
            }
        } else if (e.getSource() == jButton1 && jRadioButton1.isSelected()) {
            if (check_password_length(jTextField5.getText()) && check_password_characters(jTextField5.getText()) && check_phone_number(jTextField6.getText())) {
                userdb.create_Account(jTextField4.getText(), jTextField3.getText(), jTextField1.getText(), jTextField6.getText(), jTextField5.getText(), jTextField2.getText(), 0, "Admin");
                JOptionPane.showMessageDialog(this, "Account is Created");
                this.dispose();
                sign.Maneger maneger = new sign.Maneger(jTextField4.getText());
                maneger.setVisible(true);
            }
        }

    }

    public boolean check_password_length(String entered_password) {    // RETURN TRUE IF THE LENGTH IS GREATER THAN 8

        if (entered_password.length() <= 8 && entered_password.length() >= 12) {
            JOptionPane.showMessageDialog(this, "Password length most be at least 9 and uttermost 11");
            return false;
        } else {
            return true;
        }
    }

    public boolean check_password_characters(String entered_password) {

        // FIRST CHECK THAT DOES THE PASSWORD INCLUDE NUMBERS OR NO USING " REGEX "
        int number_flag = 0;
        Pattern numbber_pattern = Pattern.compile(".*\\d.*");
        Matcher matcher_number = numbber_pattern.matcher(entered_password);
        if (matcher_number.matches()) {
            number_flag = 1;
        }
        if (number_flag == 0) {
            JOptionPane.showMessageDialog(this, "Password MUST include numbers");
            return false;
        }

        //NOW CHECK THAT DOES THE PASSWORD INCLUDE BOTH LOWERCASE AND UPPERCASE CHARACTERS
        int lower_flag = 0;
        int upper_flag = 0;
        char temp_char;
        for (int i = 0; i < entered_password.length(); ++i) {
            temp_char = entered_password.charAt(i);
            if (Character.isLowerCase(temp_char)) {
                lower_flag = 1;
            }
            if (Character.isUpperCase(temp_char)) {
                upper_flag = 1;
            }
        }

        if (lower_flag == 1 && upper_flag == 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Password MUST include BOTH upper and lower characters");
            return false;
        }
    }

    public boolean check_phone_number(String entered_phone_number) {

        // FIRST CHECK THE LENGTH OF PHONE NUMBER
        if (entered_phone_number.length() != 11) {
            JOptionPane.showMessageDialog(this, "Phone number length must have 11 digits");
            return false;
        }

        //CHECK THE FIRST PART OF PHONE NUMBER
        String starting_part = entered_phone_number.substring(0, 2);
        if (!(starting_part.equals("09"))) {
            JOptionPane.showMessageDialog(this, "Phone number length must be started with \"09\" ");
            return false;
        }

        return true;
    }

}