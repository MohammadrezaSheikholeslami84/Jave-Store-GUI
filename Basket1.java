package sign;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Basket1 {
    public Basket1(String username) {



        sign.DB_Sales sale = new sign.DB_Sales();
        sign.DB_Products product = new sign.DB_Products();
        sign.DB_User users = new sign.DB_User();

        ArrayList<sign.Products> menu = sign.Guest.getCart();

        JFrame frame = new JFrame("Backet");
        frame.getContentPane().setBackground(sign.Main.backgroundColor);
        frame.setSize(1500, 1000);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPanel panel = new JPanel(new GridLayout(8, 2, 3, 3));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));

        for (int i = 0; i < menu.size(); i++) {
            sign.Products item = menu.get(i);
            JPanel p = new JPanel(new BorderLayout());
            p.setBackground(sign.Main.foregroundColor);

            if (item.getFilePath() != null) {
                JLabel label = new JLabel();
                try {

                    BufferedImage img = ImageIO.read(new File(item.getFilePath()));
                    Image im = img.getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING);
                    label.setIcon(new ImageIcon(im));
                } catch (Exception y) {
                }
                p.add(label, BorderLayout.WEST);
            }

            JPanel c = new JPanel(new GridLayout(2, 4, 10, 2));
            c.setBackground(null);
            c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel title = new JLabel(item.getName());
            title.setFont(new Font("Helvetica", Font.BOLD, 19));
            c.add(title);

            JLabel category = new JLabel(String.valueOf(item.getCategory()));
            category.setFont(new Font("Helvetica", Font.BOLD, 17));
            category.setForeground(Color.BLUE);
            c.add(category);

            JLabel likes = new JLabel(String.valueOf(item.getRating()) + " ★ ");
            likes.setFont(new Font("Helvetica", Font.BOLD, 17));
            likes.setForeground(new Color(5, 136, 92));
            c.add(likes);

            JLabel price = new JLabel(String.valueOf(item.getPrice()) + " $");
            price.setFont(new Font("Helvetica", Font.BOLD, 17));
            price.setForeground(Color.RED);
            c.add(price);

            JButton removefromlist = sign.Main.button("Remove from Cart");
            removefromlist.setFont(new Font("Helvetica", Font.BOLD, 13));
            removefromlist.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    menu.remove(item);
                    sign.Basket1 basket = new sign.Basket1(username);
                    frame.dispose();

                }
            });
            c.add(removefromlist);

            p.add(c, BorderLayout.CENTER);
            panel.add(p);
        }

        frame.add(panel, BorderLayout.CENTER);

        JButton Back = sign.Main.button("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                sign.Guest guest = new sign.Guest(username,new sign.DB_Products().getList_of_products());

            }
        });

        Back.setBounds(20, 0, 80, 60);
        frame.add(Back);

        JButton LogOut = sign.Main.button("LogOut");
        LogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Welcome welcome= new sign.Welcome();
                welcome.setVisible(true);
            }
        });

        LogOut.setBounds(120, 0, 80, 60);
        frame.add(LogOut);


        JButton Submit = sign.Main.button("Submit");
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (menu.size() != 0) {

                    String msg = "";
                    double sum = 0;
                    for (sign.Products i : menu) {

                        if (i.getInventory() >= 1) {
                            sum = sum + i.getPrice();
                            msg = msg + i.getName() + " | " + i.getCategory() + " | " + i.getPrice() + " $\n";
                        }
                    }
                    JOptionPane.showConfirmDialog(frame, msg, "Card List", JOptionPane.DEFAULT_OPTION);

                    int d = JOptionPane.showConfirmDialog(frame, "Are you sure that " + "you want to buy these items?");
                    if (d == JOptionPane.YES_OPTION) {

                        sign.DB_Sales sale = new sign.DB_Sales();
                        sign.DB_Products product = new sign.DB_Products();

                        long sum_buy_products = 0;

                        long cash_user = users.search_account(username, "Guest").getCash();
                        long cash_admin = users.search_account("mehrzadsameni", "Admin").getCash();


                        if (cash_user >= sum) {

                            for (int i = 0; i < menu.size(); i++) {

                                String Sale_Id = username + menu.get(i).getID();
                                int inventory = product.find_product(menu.get(i).getID()).getInventory();
                                System.out.println(Sale_Id);

                                if (inventory > 0) {

                                    product.edit_inventory(menu.get(i).getID(), product.find_product(menu.get(i).getID()).getInventory() - 1);
                                    sum_buy_products += menu.get(i).getPrice();

                                    if (sale.check_saleID(Sale_Id))
                                       sale.add_sold_product(Sale_Id, username, menu.get(i).getID(), sale.find_sold_product(Sale_Id).getNumbers()+1, sale.find_sold_product(Sale_Id).getPrice() + menu.get(i).getPrice());

                                    else
                                        sale.add_sold_product(Sale_Id, username, menu.get(i).getID(), 1,  menu.get(i).getPrice());


                                } else {
                                    JOptionPane.showMessageDialog(frame, "Inventory " + product.find_product(menu.get(i).getID()).getName() + " is not enough");
                                    break;
                                }


                            }

                            users.edit_Cash(username, (long) (cash_user - sum), "Guest");
                            users.edit_cash_for_admin(cash_admin + sum_buy_products);

                            menu.clear();
                            frame.dispose();
                            sign.Basket1 basket = new sign.Basket1(username);
                            frame.dispose();

                        } else {
                            JOptionPane.showMessageDialog(frame, "Balance is not enough");

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Cart is empty");
                }
           }


        });

        Submit.setBounds(220, 0, 80, 60);
        frame.add(Submit);

        frame.add(panel, BorderLayout.CENTER);
        JLabel title = new JLabel("");
        title.setFont(new Font("Helvetica", Font.BOLD, 17));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(sign.Main.foregroundColor);
        title.setOpaque(true);
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));
        frame.add(title, BorderLayout.NORTH);
        frame.setVisible(true);

    }
}

