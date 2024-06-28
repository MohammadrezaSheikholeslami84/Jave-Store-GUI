package sign;

import java.util.ArrayList;

public class Account {
    private String user_name;
    private String name;
    private String familyname;
    private String phonenumber;
    private String address;
    private String password;
    private long cash;
    private String UserType;

    public Account(String user_name, String name, String familyname, String phonenumber, String password, String address, long cash, String UserType) {
        this.user_name = user_name;
        this.name = name;
        this.familyname = familyname;
        this.phonenumber = phonenumber;
        this.password = password;
        this.address = address;
        this.cash = cash;
        this.UserType = UserType;
    }

    public String getUserType() { return UserType;}

    public void setUserType(String userType) { UserType = userType;}

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCash() {
        return cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user_name='" + user_name + '\'' +
                ", name='" + name + '\'' +
                ", familyname='" + familyname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", cash=" + cash +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}
