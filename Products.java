package sign;

import java.lang.classfile.attribute.StackMapTableAttribute;
import java.sql.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Products{
    private int ID ;
    private String category ;
    private String name  ;
    private long price ;
    private int inventory ;
    private int rating ;
    private String filePath ;
    public Products( int ID , String category , String name  , long price , int inventory , int rating , String filePath){
        this.ID = ID ;
        this.category = category ;
        this.name = name ;
        this.price = price ;
        this.inventory = inventory ;
        this.rating = rating ;
        this.filePath = filePath ;
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

    public long getPrice() {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", rating=" + rating +
                ", filePath='" + filePath + '\'' + '\n';
    }
}
