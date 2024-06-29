package sign;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Guest {

    private static ArrayList<sign.Products> Cart = new ArrayList<>();

    public static ArrayList<sign.Products> getCart() {
        return Cart;
    }

    public void setCart(ArrayList<sign.Products> cart) {
        Cart = cart;
    }

    public Guest(String User_Name, ArrayList<sign.Products> menu) {
        menu(User_Name, menu);
    }

    void menu(String User_Name, ArrayList<sign.Products> menu) {

        sign.DB_Sales sale = new sign.DB_Sales();
        sign.DB_Products product = new sign.DB_Products();
        sign.DB_User users = new sign.DB_User();

        JFrame frame = new JFrame("Store Management System");
        frame.getContentPane().setBackground(sign.Main.backgroundColor);
        frame.setSize(1500, 1000);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPanel panel = new JPanel(new GridLayout(8, 2, 3, 3)) {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new java.awt.Color(246, 167, 167), 100, getHeight(), new java.awt.Color(13, 68, 123));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }

        };

        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));

        JLabel checkout = new JLabel("0 item added");
        checkout.setFont(new Font("Helvetica", Font.BOLD, 18));
        checkout.setHorizontalAlignment(SwingConstants.CENTER);
        checkout.setBackground(sign.Main.foregroundColor);
        checkout.setOpaque(true);
        checkout.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        checkout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkout.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                if (Cart.size() != 0) {
                    String msg = "";
                    double sum = 0;
                    for (sign.Products i : Cart) {
                        sum = sum + i.getPrice();
                        msg = msg + i.getName() + " | " + i.getCategory() + " | " + i.getPrice() + " $\n";
                    }
                    JOptionPane.showConfirmDialog(frame, msg, "Card List", JOptionPane.DEFAULT_OPTION);

                    int d = JOptionPane.showConfirmDialog(frame, "Are you sure that " + "you want to buy these items?");
                    if (d == JOptionPane.YES_OPTION) {


                        Cart.clear();
                        checkout.setText("0 item added");
                        frame.dispose();
                        sign.Basket1 basket = new sign.Basket1(User_Name);

                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Cart is empty");
                }
            }
        });
        frame.add(checkout, BorderLayout.SOUTH);


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

            JButton add = sign.Main.button("Add");
            add.setFont(new Font("Helvetica", Font.BOLD, 13));
            add.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    Cart.add(item);
                    checkout.setText(Cart.size() + " items added. Click here to checkout");

                }
            });
            c.add(add);

            JButton removefromlist = sign.Main.button("Remove");
            removefromlist.setFont(new Font("Helvetica", Font.BOLD, 13));
            removefromlist.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    Cart.remove(item);
                    checkout.setText(Cart.size() + " items added. Click here to checkout");

                }
            });
            c.add(removefromlist);


            JButton addLike = sign.Main.button("Add Like");
            addLike.setFont(new Font("Helvetica", Font.BOLD, 13));
            addLike.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    product.edit_rating(item.getID(), product.find_product(item.getID()).getRating() + 1);
                    JOptionPane.showMessageDialog(frame, "Likes added successfully");
                    likes.setText(String.valueOf(product.find_product(item.getID()).getRating()) + " ★ ");


                }
            });
            c.add(addLike);

            p.add(c, BorderLayout.CENTER);
            panel.add(p);
        }


        frame.add(panel, BorderLayout.CENTER);

        JButton back = sign.Main.button("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Client client = new sign.Client(User_Name);
                client.setVisible(true);
            }
        });

        back.setBounds(20, 0, 80, 60);
        frame.add(back);


        JButton logOut = sign.Main.button("LogOut");
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Welcome welcome = new sign.Welcome();
                welcome.setVisible(true);
            }
        });

        logOut.setBounds(120, 0, 80, 60);
        frame.add(logOut);

        JButton Profile = sign.Main.button("Profile");
        Profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Client_Profile profile = new sign.Client_Profile(User_Name);
                profile.setVisible(true);
            }
        });

        Profile.setBounds(220, 0, 80, 60);
        frame.add(Profile);


        JButton Basket = sign.Main.button("Basket");
        Basket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Basket1 basket = new sign.Basket1(User_Name);
            }
        });

        Basket.setBounds(320, 0, 80, 60);
        frame.add(Basket);

        JButton SortByPrice = sign.Main.button("Sort Price");
        SortByPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Guest guest = new sign.Guest(User_Name, product.sort_by_price());

            }
        });
        SortByPrice.setBounds(420, 0, 100, 60);
        frame.add(SortByPrice);

        JButton SortByLikes = sign.Main.button("Sort Likes");
        SortByLikes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                sign.Guest guest = new sign.Guest(User_Name, product.sort_by_rating());

            }
        });
        SortByLikes.setBounds(540, 0, 100, 60);
        frame.add(SortByLikes);

        JTextField Search_Field = sign.Main.textField();
        Search_Field.setBounds(780, 10, 200, 40);
        Search_Field.setText("Search \uD83D\uDD0E");
        Search_Field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Search_Field.getText().equals("Search \uD83D\uDD0E")) {
                    Search_Field.setForeground(Color.black);
                    Search_Field.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Search_Field.getText().equals("")) {
                    Search_Field.setForeground(Color.gray);
                    Search_Field.setText("Search \uD83D\uDD0E");
                }
            }
        });
        frame.add(Search_Field);


        JButton Search = sign.Main.button("Search");
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Search_Field.getText().isEmpty())
                    new sign.Guest(User_Name, product.getList_of_products());
                else {

                    int a = JOptionPane.showConfirmDialog(frame, "Do you Want to Search By Name ?", "Search", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (a == JOptionPane.YES_OPTION) {

                        new Guest(User_Name, product.search_name(Search_Field.getText()));
                        frame.dispose();
                    } else if (a == JOptionPane.NO_OPTION) {

                        new Guest(User_Name, product.search_category(Search_Field.getText()));
                        frame.dispose();

                    }

                }


                frame.dispose();
            }
        });
        Search.setBounds(660, 0, 100, 60);
        frame.add(Search);


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
