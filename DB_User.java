package sign;

import java.sql.*;
import java.util.*;

public class DB_User {

    String db_address = "jdbc:mysql://localhost:3306/store_project";
    String username = "root";
    String password = "Ok@4!04569";

    private ArrayList<sign.Account> account = new ArrayList<>();

    public DB_User() {
        initializeArray();
    }

    public ArrayList<sign.Account> getAccount() {
        return account;
    }

    public void initializeArray() {

        try {

            Connection connection = DriverManager.getConnection(db_address, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {

                String user_name = rs.getString("UserName");
                String name = rs.getString("Name");
                String familyname = rs.getString("FamilyName");
                String phonenumber = rs.getString("PhoneNumber");
                String password = rs.getString("Password");
                String address = rs.getString("Address");
                Long cash = rs.getLong("Cash");
                String UserType = rs.getString("UserType");

                account.add(new sign.Account(user_name, name, familyname, phonenumber, password, address, cash, UserType));

            }

            rs.beforeFirst();
        } catch (SQLException e) {

        }

    }

    public boolean create_Account(String user_name_input, String name_input, String familyname_input, String phonenumber_input,
                                  String password_input, String address_input, long cash_input, String UserType) {

        boolean is_new = false;

        try {

            if (new_user_check(user_name_input, UserType)) {
                account.add(new sign.Account(user_name_input, name_input, familyname_input, phonenumber_input, password_input, address_input, cash_input, UserType));
                addrecord();
                is_new = true;

            }


        } catch (SQLException e) {

        }

        return is_new;
    }

    public boolean login(String user_name_input, String UserType) {

        return !new_user_check(user_name_input, UserType);

    }

    public sign.Account search_account(String user_name_search, String UserType) {

        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).getUser_name().equals(user_name_search) && account.get(i).getUserType().equals(UserType))
                return account.get(i);
        }

        return null;
    }


    public String get_account_pass(String user_name_search, String UserType) {

        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).getUser_name().equals(user_name_search) && account.get(i).getUserType().equals(UserType))
                return account.get(i).getPassword();
        }

        return null;
    }


    public void addrecord() throws SQLException {
        sign.Account added_account = account.getLast();

        Connection connection = DriverManager.getConnection(db_address, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = statement.executeQuery("SELECT * FROM users");

        rs.moveToInsertRow();
        rs.updateString("UserName", added_account.getUser_name());
        rs.updateString("Name", added_account.getName());
        rs.updateString("FamilyName", added_account.getFamilyname());
        rs.updateString("PhoneNumber", added_account.getPhonenumber());
        rs.updateString("Password", added_account.getPassword());
        rs.updateString("Address", added_account.getAddress());
        rs.updateLong("Cash", added_account.getCash());
        rs.updateString("UserType", added_account.getUserType());

        rs.insertRow();
        rs.close();
    }

    public void adddata(String user_name, String name, String familyname, String phonenumber, String password, String address, long cash, String UserType) {
        account.add(new sign.Account(user_name, name, familyname, phonenumber, password, address, cash, UserType));
    }


    public boolean new_user_check(String user_name, String UserType) {
        boolean is_new_user = true;
        for (sign.Account accounts : account) {

            if (accounts.getUser_name().equals(user_name) && accounts.getUserType().equals(UserType)) {

                is_new_user = false;
            }
        }
        return is_new_user;
    }

    public void edit_Password(String user_name, String newPassword, String UserType) {

        try {

            Connection connection = DriverManager.getConnection(db_address, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                String current_user_name = resultSet.getString("UserName");
                String current_UserType = resultSet.getString("UserType");

                if (current_user_name.equals(user_name) && current_UserType.equals(UserType)) {
                    resultSet.updateString("Password", newPassword);
                    resultSet.updateRow();
                }


            }

            resultSet.close();
        } catch (SQLException E) {

        }

        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).getUser_name().equals(user_name) && account.get(i).getUserType().equals(UserType))
                account.get(i).setPassword(newPassword);
        }


    }

    public void edit_Cash(String user_name, long newCash, String UserType) {

        try {

            Connection connection = DriverManager.getConnection(db_address, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                String current_user_name = resultSet.getString("UserName");
                String current_UserType = resultSet.getString("UserType");

                if (current_user_name.equals(user_name) && current_UserType.equals(UserType)) {
                    resultSet.updateLong("Cash", newCash);
                    resultSet.updateRow();
                }


            }

            resultSet.close();
        } catch (SQLException e) {

        }

        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).getUser_name().equals(user_name) && account.get(i).getUserType().equals(UserType))
                account.get(i).setCash(newCash);
        }


    }


    public void edit_cash_for_admin(long newCash){

        // UPDATE DATABASE
        try {
            Connection con = DriverManager.getConnection(db_address , username , password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL_query = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(SQL_query);

            while(rs.next()){
                if(rs.getString("UserType").equals("Admin")){
                    rs.updateLong("Cash" , newCash);
                    rs.updateRow();

                }
            }

            rs.close();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        // ARRAYLIST UPDATED
        for(int i = 0 ; i <account.size() ; ++i){
            if(account.get(i).getUserType().equals("Admin")){
                account.get(i).setCash(newCash);
            }

        }
    }

    public Object[][] AccountTableData_ArrayList() {
        int columns = 5, rows = 0, aux = 0;

        List<Object> AccountList = new ArrayList<>();

        for (int i = 0; i < account.size(); i++) {

            if (account.get(i).getUserType().equals("Guest")) {
                AccountList.add(account.get(i).getUser_name());
                AccountList.add(account.get(i).getName());
                AccountList.add(account.get(i).getFamilyname());
                AccountList.add(account.get(i).getPhonenumber());
                AccountList.add(new sign.DB_Sales().total_purchased(account.get(i).getUser_name()));
                rows++;
            }


        }

        Object[][] Accounts = new Object[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Accounts[i][j] = AccountList.get(aux++);
            }
        }
        return Accounts;
    }


}

