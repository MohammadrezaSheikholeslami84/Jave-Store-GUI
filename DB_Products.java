package sign;
import sign.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class DB_Products {
    private ArrayList<sign.Products> list_of_products = new ArrayList<>() ;
    private final String url = "jdbc:mysql://localhost:3306/Store_Project" ;
    private final String username = "root" ;
    private final String password = "1284iliya" ;

    public ArrayList<sign.Products> getList_of_products() {
        return list_of_products;
    }

    public void setList_of_products(ArrayList<sign.Products> list_of_products) {
        this.list_of_products = list_of_products;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public DB_Products() {
        intialize_arraylist() ;
    }
    public void intialize_arraylist(){

        try {
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL_query = "SELECT * FROM Products";
            ResultSet rs = stmt.executeQuery(SQL_query);

            while(rs.next()){
                int id = rs.getInt("ID") ;
                String category = rs.getString("category") ;
                String name = rs.getString("name") ;
                long price = rs.getLong("price") ;
                int inventory = rs.getInt("inventory") ;
                int rating = rs.getInt("rating") ;
                String filePath = rs.getString("filePath") ;
                list_of_products.add(new sign.Products(id , category , name , price , inventory , rating , filePath)) ;
            }
            rs.beforeFirst();
            rs.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void add_product(int new_id , String new_category , String new_name , long new_price , int new_inventory , int new_rating , String new_filePath){
        boolean id_does_not_exist = checkID(new_id) ;
        if( id_does_not_exist){
            add_to_database(new_id , new_category , new_name , new_price , new_inventory , new_rating , new_filePath); //ADD TO DATABASE
            getList_of_products().add(new sign.Products(new_id , new_category , new_name , new_price , new_inventory , new_rating , new_filePath)) ; // ADD TO ARRAYLIST
        }
        else{
            System.out.println("This ID already exists!");
        }
    }
    public boolean checkID(int id){    //IT RETURNS TRUE IF IT DOESN'T FIND THE GIVEN ID
        for(int i = 0 ; i <getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == id){
                return false ;
            }
        }
        return true ;
    }
    public boolean check_inventory(int id){

        for(int i = 0 ; i<getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getInventory() >= 1){
                return true ;
            }
        }
        return false ;
    }

    public void add_to_database(int new_id , String new_category , String new_name , long new_price , int new_inventory , int new_rating , String new_filePath){

        try{
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL_query = "SELECT * FROM Products";
            ResultSet rs = stmt.executeQuery(SQL_query);
            rs.moveToInsertRow();
            rs.updateInt("ID" , new_id);
            rs.updateString("category" , new_category);
            rs.updateString("name" , new_name);
            rs.updateLong("price" , new_price);
            rs.updateInt("inventory" , new_inventory);
            rs.updateInt("rating" , new_rating);
            rs.updateString("filePath" , new_filePath);
            rs.insertRow();
            rs.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void remove_product(int id_to_remove){

        boolean does_exist = checkID(id_to_remove) ; // IF ID WAS FOUND , DOES_EXIST WILL BE FALSE
        if( !(does_exist) ){

            remove_from_database(id_to_remove);
            for(int i = 0 ; i < getList_of_products().size() ; ++i){
                if(getList_of_products().get(i).getID() == id_to_remove){
                    getList_of_products().remove(i) ;
                    break;
                }
            }

        }
        else{
            System.out.println("This ID doesn't exist");
        }
    }

    public void remove_from_database(int id_for_remove){

        try{
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL_query = "SELECT * FROM Products";
            ResultSet rs = stmt.executeQuery(SQL_query);

            while(rs.next()){
                if(rs.getInt("ID") == id_for_remove){
                    rs.deleteRow();
                    rs.close();
                    break;
                }
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void general_edit(int wanted_id , String want_to_change_category , String want_to_change_name , long want_to_change_price , int want_to_change_inventory){

        boolean is_find_for_edit = false ;
        for(int i = 0 ;  i <getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == wanted_id){
                is_find_for_edit = true ;
            }
        }
        if(is_find_for_edit){

            //FIRST WE SHOULD EDIT ALL ITEMS IN DATABASE
            try{
                Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String SQL_query = "SELECT * FROM Products";
                ResultSet rs = stmt.executeQuery(SQL_query);

                while(rs.next()){
                    if(rs.getInt("ID") == wanted_id){
                        rs.updateString("category" , want_to_change_category );
                        rs.updateString("name" , want_to_change_name);
                        rs.updateLong("price" , want_to_change_price);
                        rs.updateInt("inventory" , want_to_change_inventory);
                        rs.updateRow();
                        break;
                    }
                }
                rs.close();

            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            //NOW WE SHOULD EDIT THE ARRAYLIST
            for(int i = 0 ;  i < getList_of_products().size() ; ++i){
                if (getList_of_products().get(i).getID() == wanted_id){
                    getList_of_products().get(i).setCategory(want_to_change_category); ;
                    getList_of_products().get(i).setName(want_to_change_name);
                    getList_of_products().get(i).setPrice(want_to_change_price);
                    getList_of_products().get(i).setInventory(want_to_change_inventory);
                    break;
                }
            }

        }
        else{
            System.out.println("This ID doesn't exist");
        }
    }

    public void edit_price(int wanted_id , long new_price){

        boolean is_find_for_edit = false ;
        for(int i = 0 ;  i <getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == wanted_id){
                is_find_for_edit = true ;
            }
        }
        if(is_find_for_edit){
            //FIRST WE SHOULD EDIT PRICE IN DATABASE
            try{
                Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String SQL_query = "SELECT * FROM Products";
                ResultSet rs = stmt.executeQuery(SQL_query);

                while(rs.next()){
                    if(rs.getInt("ID") == wanted_id){
                        rs.updateLong("price" , new_price);
                        rs.updateRow();
                        break;
                    }
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            //NOW WE SHOULD EDIT THE ARRAYLIST
            for(int i = 0 ;  i < getList_of_products().size() ; ++i){
                if (getList_of_products().get(i).getID() == wanted_id){
                    getList_of_products().get(i).setPrice(new_price) ;
                    break;
                }
            }

        }
        else{
            System.out.println("This ID doesn't exist");
        }
    }

    public void edit_inventory(int wanted_id , int new_inventory){

        boolean is_find_for_edit = false ;
        for(int i = 0 ;  i <getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == wanted_id){
                is_find_for_edit = true ;
            }
        }
        if(is_find_for_edit){
            //FIRST WE SHOULD EDIT PRICE IN DATABASE
            try{
                Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
                String SQL_query = "SELECT * FROM Products";
                ResultSet rs = stmt.executeQuery(SQL_query);

                while(rs.next()){
                    if(rs.getInt("ID") == wanted_id){
                        rs.updateInt("inventory" , new_inventory);
                        rs.updateRow();
                        break;
                    }
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            //NOW WE SHOULD EDIT THE ARRAYLIST
            for(int i = 0 ;  i < getList_of_products().size() ; ++i){
                if (getList_of_products().get(i).getID() == wanted_id){
                    getList_of_products().get(i).setInventory(new_inventory); ;
                    break;
                }
            }

        }
        else{
            System.out.println("This ID doesn't exist");
        }
    }
    public void edit_rating(int wanted_id , int new_rating){
        boolean is_find_for_edit = false ;
        for(int i = 0 ;  i <getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == wanted_id){
                is_find_for_edit = true ;
            }
        }
        if(is_find_for_edit){
            //FIRST WE SHOULD EDIT PRICE IN DATABASE
            try{
                Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String SQL_query = "SELECT * FROM Products";
                ResultSet rs = stmt.executeQuery(SQL_query);

                while(rs.next()){
                    if(rs.getInt("ID") == wanted_id){
                        rs.updateInt("rating" , new_rating);
                        rs.updateRow();
                        break;
                    }
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            //NOW WE SHOULD EDIT THE ARRAYLIST
            for(int i = 0 ;  i < getList_of_products().size() ; ++i){
                if (getList_of_products().get(i).getID() == wanted_id){
                    getList_of_products().get(i).setRating(new_rating); ;
                    break;
                }
            }

        }
        else{
            System.out.println("This ID doesn't exist");
        }
    }
    public void edit_file_path(int wanted_id , String new_file_path){
        boolean is_find_for_edit = false ;
        for(int i = 0 ;  i <getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == wanted_id){
                is_find_for_edit = true ;
            }
        }
        if(is_find_for_edit){
            //FIRST WE SHOULD EDIT PRICE IN DATABASE
            try{
                Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String SQL_query = "SELECT * FROM Products";
                ResultSet rs = stmt.executeQuery(SQL_query);

                while(rs.next()){
                    if(rs.getInt("ID") == wanted_id){
                        rs.updateString("filePath" , new_file_path);
                        rs.updateRow();
                        break;
                    }
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            //NOW WE SHOULD EDIT THE ARRAYLIST
            for(int i = 0 ;  i < getList_of_products().size() ; ++i){
                if (getList_of_products().get(i).getID() == wanted_id){
                    getList_of_products().get(i).setFilePath(new_file_path); ;
                    break;
                }
            }

        }
        else{
            System.out.println("This ID doesn't exist");
        }
    }
    public sign.Products find_product(int wanted_id){
        for(int i = 0 ; i < getList_of_products().size() ; ++i){
            if(getList_of_products().get(i).getID() == wanted_id){
                return getList_of_products().get(i) ;
            }
        }
        return null ;
    }
    public ArrayList<sign.Products> search_name(String text_in_search_field ){

        Pattern search_pattern = Pattern.compile("\\b\\w*" + text_in_search_field + "\\w*\\b" , Pattern.CASE_INSENSITIVE) ;
        ArrayList<sign.Products> found_products = new ArrayList<>() ;

        for(int i = 0 ; i < getList_of_products().size() ; ++i){
            Matcher matcher_name = search_pattern.matcher(getList_of_products().get(i).getName()) ;
            while (matcher_name.find()) {
                found_products.add(getList_of_products().get(i)) ;
                //  System.out.println(STR."Match found: \{matcher_name.group()}");
            }
        }
        return found_products ;
    }
    public ArrayList<sign.Products> search_category(String text_in_search_field ){

        Pattern search_pattern = Pattern.compile("\\b\\w*" + text_in_search_field + "\\w*\\b" , Pattern.CASE_INSENSITIVE) ;
        ArrayList<sign.Products> found_products = new ArrayList<>() ;

        for(int i = 0 ; i < getList_of_products().size() ; ++i){
            Matcher matcher_category = search_pattern.matcher(getList_of_products().get(i).getCategory()) ;
            while (matcher_category.find()) {
                found_products.add(getList_of_products().get(i)) ;
                //  System.out.println(STR."Match found: \{matcher_category.group()}");
            }
        }
        return found_products ;
    }

    public ArrayList<sign.Products> sort_by_price(){

        try{
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL_query = "SELECT * FROM Products order by price desc";
            ResultSet rs = stmt.executeQuery(SQL_query);

            ArrayList<sign.Products> sorted_products_by_price = new ArrayList<>() ;

            while (rs.next()){
                int id =rs.getInt("ID") ;
                String category = rs.getString("category") ;
                String name = rs.getString("name") ;
                long price = rs.getLong("price") ;
                int inventory = rs.getInt("inventory") ;
                int rating = rs.getInt("rating") ;
                String filePath = rs.getString("filePath") ;
                sorted_products_by_price.add(new sign.Products(id , category , name , price , inventory , rating , filePath)) ;
            }

            rs.beforeFirst();
            rs.close();
            return sorted_products_by_price ;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null ;
        }
    }
    public ArrayList<sign.Products> sort_by_rating(){

        try{
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword());
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL_query = "SELECT * FROM Products order by rating desc";
            ResultSet rs = stmt.executeQuery(SQL_query);

            ArrayList<sign.Products> sorted_products_by_rating = new ArrayList<>() ;

            while(rs.next()){
                int id = rs.getInt("ID") ;
                String category  =rs.getString("category") ;
                String name = rs.getString("name") ;
                long price = rs.getLong("price") ;
                int inventory = rs.getInt("inventory") ;
                int rating = rs.getInt("rating") ;
                String filePath = rs.getString("filePath") ;
                sorted_products_by_rating.add(new sign.Products(id , category , name , price , inventory , rating , filePath)) ;
            }

            rs.beforeFirst();
            rs.close();
            return sorted_products_by_rating ;

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null ;
        }
    }

    public Object[][] show_products_for_manager(){

        Object[][] all_products_for_table = new Object[getList_of_products().size()][7] ;

        for(int i = 0 ; i <getList_of_products().size() ; ++i){
            all_products_for_table[i][0] = getList_of_products().get(i).getID() ;
            all_products_for_table[i][1] = getList_of_products().get(i).getCategory() ;
            all_products_for_table[i][2] = getList_of_products().get(i).getName() ;
            all_products_for_table[i][3] = getList_of_products().get(i).getPrice() ;
            all_products_for_table[i][4] = getList_of_products().get(i).getInventory() ;
            all_products_for_table[i][5] = getList_of_products().get(i).getRating() ;
            all_products_for_table[i][6] = getList_of_products().get(i).getFilePath() ;
        }
        return all_products_for_table ;

    }

}
