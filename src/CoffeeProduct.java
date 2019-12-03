public class CoffeeProduct {

    private String name;
    private int productID;
    private int qty;

    public CoffeeProduct(String name, int productID) {
        this.name = name;
        this.productID = productID;
    }

    public String toString() {
        return "";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
}