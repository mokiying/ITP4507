public class CoffeeProduct {

    private String name;
    private int productID;
    private int qty;

    public CoffeeProduct(int productID, String name) {
        this.productID = productID;
        this.name = name;
    }

    public String toString() {
        return getProductID() + "\t" + getName() + "\t\t\t" + getQty();
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
    public String stringDetails(){
        return "ID: " + getProductID() +"\nName: " + getName() + "\nQuantity: " + getQty();
    }
    
    public CoffeeProduct clone(){
        CoffeeProduct temp = new CoffeeProduct(this.productID, this.name);
        temp.setQty(this.qty);
        return temp;
    }
}