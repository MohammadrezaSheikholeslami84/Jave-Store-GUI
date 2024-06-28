package sign;

import java.sql.*;
import java.util.ArrayList;

public class DB_Sales {

    private ArrayList<sign.Sales> sold_products = new ArrayList<>() ;
    private final String url = "jdbc:mysql://root@localhost:3306/Store_Project" ;
    private final String username = "root" ;
    private final String password = "1284iliya" ;

    public ArrayList<sign.Sales> getSold_products(){
        return sold_products;
    }

    public void setSold_products(ArrayList<sign.Sales> sold_products) {
        this.sold_products = sold_products;
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

    public DB_Sales(){
        initialize_arraylist() ;
    }
    public void initialize_arraylist(){

        try{
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword()) ;
            Statement stmt=  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE) ;
            String SQL_query = "select * from sold" ;
            ResultSet rs = stmt.executeQuery(SQL_query) ;

            while(rs.next()){
                String saleID = rs.getString("saleID") ;
                String costumer_username = rs.getString("customer_username") ;
                int productID = rs.getInt("productID") ;
                String name = rs.getString("name") ;
                String category = rs.getString("category") ;
                int numbers = rs.getInt("numbers") ;
                long price = rs.getLong("price") ;
                getSold_products().add(new sign.Sales(saleID , costumer_username , productID , name , category ,  numbers , price)) ;
            }
            rs.beforeFirst();
            rs.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void add_sold_product(String saleID , String username_of_costumer , int sold_productID ){

        try {

            boolean does_saleID_exist = check_saleID(saleID);
            Connection con = DriverManager.getConnection(getUrl() , getUsername() , getPassword()) ;
            Statement stmt=  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE) ;
            String SQL_query = "select * from sold" ;
            ResultSet rs = stmt.executeQuery(SQL_query) ;

            if (does_saleID_exist) {
                while(rs.next()){
                    if(rs.getString("saleID").equals(saleID)){
                        rs.updateInt("numbers" , rs.getInt("numbers") + 1 );
                        rs.updateLong("price" , new sign.DB_Products().find_product(sold_productID).getPrice() + rs.getLong("price") );
                        rs.updateRow();
                        break;
                    }
                    rs.close();
                }
                //  NOW CHANGE THE ARRAYLIST
                for(int i = 0 ; i < getSold_products().size() ; ++i){
                    if ( getSold_products().get(i).getSaleID().equals(saleID) ){
                        getSold_products().get(i).setNumbers( getSold_products().get(i).getNumbers() + 1 );
                        getSold_products().get(i).setPrice( getSold_products().get(i).getPrice() + new sign.DB_Products().find_product(sold_productID).getPrice() );
                    }
                }

            }

            if( !(does_saleID_exist) ){
                rs.moveToInsertRow();
                rs.updateString("saleID" , saleID);
                rs.updateString("costumer_username" , username_of_costumer);
                rs.updateInt("productID" , sold_productID);
                rs.updateString("name" , new sign.DB_Products().find_product(sold_productID).getName() );
                rs.updateString("category" , new sign.DB_Products().find_product(sold_productID).getCategory());
                rs.updateInt("numbers" , 1);
                rs.updateLong("price" , new sign.DB_Products().find_product(sold_productID).getPrice());

                rs.insertRow();
                rs.close();

                // ADD TO ARRAYLIST
                String new_name_to_add = new sign.DB_Products().find_product(sold_productID).getName() ;
                String new_category_to_add = new sign.DB_Products().find_product(sold_productID).getCategory() ;
                long new_price_to_add = new sign.DB_Products().find_product(sold_productID).getPrice() ;
                getSold_products().add(new sign.Sales(saleID , username_of_costumer , sold_productID , new_name_to_add , new_category_to_add , 1 ,  new_price_to_add)) ;
            }

        }

        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public boolean check_saleID(String wanted_saleID){  //RETURNS TRUE IF THE WANTED SALE_ID EXIST

        for(int i = 0 ; i < getSold_products().size() ; ++i){
            if(getSold_products().get(i).getSaleID().equals(wanted_saleID)){
                return true ;
            }
        }
        return false ;
    }

    public ArrayList<sign.Sales> find_what_costumer_bought(String costumer_username){

        ArrayList<sign.Sales> purchased_products_by_specific_username = new ArrayList<>() ;
        for(int i = 0 ; i < getSold_products().size() ; ++i){
            if(getSold_products().get(i).getCustomer_userName().equals(costumer_username)){
                purchased_products_by_specific_username.add( getSold_products().get(i) ) ;
            }
        }
        return purchased_products_by_specific_username ;
    }

    public Object[][] show_for_client(ArrayList<sign.Sales> purchased_product_for_costumer){

        Object[][] show_purchased_for_client = new Object[purchased_product_for_costumer.size()][4] ;

        for(int i = 0 ; i < purchased_product_for_costumer.size() ; ++i){
            show_purchased_for_client[i][0] = purchased_product_for_costumer.get(i).getName() ;
            show_purchased_for_client[i][1] = purchased_product_for_costumer.get(i).getCategory() ;
            show_purchased_for_client[i][2] = purchased_product_for_costumer.get(i).getNumbers() ;
            show_purchased_for_client[i][3] = purchased_product_for_costumer.get(i).getPrice() ;
        }
        return show_purchased_for_client ;
    }
    public Object[][] show_for_manager(){

        Object[][] show_sold_products_for_manager = new Object[getSold_products().size()][4] ;

        for(int i = 0 ; i < getSold_products().size() ; ++i){
            show_sold_products_for_manager[i][0] = getSold_products().get(i).getName() ;
            show_sold_products_for_manager[i][1] = getSold_products().get(i).getCategory() ;
            show_sold_products_for_manager[i][2] = getSold_products().get(i).getNumbers() ;
            show_sold_products_for_manager[i][3] = getSold_products().get(i).getPrice() ;
        }
        return show_sold_products_for_manager ;
    }
}
