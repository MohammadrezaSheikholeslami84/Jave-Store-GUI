package sign;

public class Sales {

    private String saleID;
    private String customer_username;
    private int productID ;
    private String name ;
    private String category ;
    private int numbers;
    private long price ;

    public Sales(String saleID, String costumer_username, int productID, String name , String category , int numbers, long price) {
        this.saleID = saleID;
        this.customer_username = costumer_username ;
        this.productID = productID ;
        this.name = name ;
        this.category = category ;
        this.numbers = numbers ;
        this.price = price ;
    }

    public String getSaleID() {
        return saleID;
    }

    public void setSaleID(String saleID) {
        this.saleID = saleID;
    }

    public String getCustomer_userName() {
        return customer_username;
    }

    public void setCustomer_userName(String customer_userName) {
        this.customer_username = customer_userName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
