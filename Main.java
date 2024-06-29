package sign;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class Main {

    public static Scanner s;

    public static Color backgroundColor = Color.decode("#D1E0E0");
    public static Color foregroundColor = Color.decode("#e7f9f9");
    public static Color highlightColor = Color.decode("#fe947f");

    public static JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Helvetica", Font.BOLD, 17));
        return label;
    }

    public static JTextField textField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Helvetica", Font.BOLD, 17));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        return textField;
    }

    public static JButton button(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", 1, 17));
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setBackground(highlightColor);
        btn.setBorder(null);
        btn.setFocusable(false);
        return btn;
    }

    public static JPasswordField passwordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Helvetica", Font.PLAIN, 12));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        return passwordField;
    }

}
