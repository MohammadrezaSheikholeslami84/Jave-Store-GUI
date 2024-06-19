import java.lang.classfile.attribute.StackMapTableAttribute;
import java.sql.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Products{
    private String category ;
    private String name  ;
    private int ID ;
    private double price ;
    private int inventory ;
    private double rating ;
    public Products(String category , String name , int ID , double price , int inventory , double rating){
        this.category = category ;
        this.name = name ;
        this.ID = ID ;
        this.price = price ;
        this.inventory = inventory ;
        this.rating = rating ;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.name ;
    }

    public static void main(String[] args) {

        try {
            Products product1;
            ArrayList<Products> list_of_products = new ArrayList<>() ;
            String category = null;
            String name = null ;
            int id = -1  , inventory = -1 ;
            double price = -1 , rating = -1 ;

            Connection con = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sys", "root", "1284iliya");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE) ;
            String SQL_query = "SELECT * FROM Products LIMIT 0,1" ;
            ResultSet rs = stmt.executeQuery(SQL_query) ;
            while(rs.next()) {
                 category = rs.getString("category");
                 name = rs.getString("name");
                 id = rs.getInt("ID");
                 price = rs.getDouble("price");
                 inventory = rs.getInt("inventory");
                 rating = rs.getDouble("rating");
            }
            product1 = new Products(category , name , id , price , inventory , rating) ;
            list_of_products.add(product1) ;
            System.out.println(product1.category + " " + product1.name + " " + product1.ID + " " + product1.price + " " + product1.inventory + " " + product1.rating);
            System.out.println(list_of_products);


        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}