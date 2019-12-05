
public class CoffeePowder extends CoffeeProduct {

    private int weight;

    public CoffeePowder(int productID, String name, int weight) {
        super(productID, name);
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + "\t\t" + getWeight() + "g ";
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String stringDetails() {
        return super.stringDetails() + "\nWeight: " + getWeight();
    }

    public CoffeeProduct clone() {
        CoffeeProduct temp = new CoffeePowder(this.getProductID(), this.getName(), this.getWeight());
        temp.setQty(this.getQty());
        return temp;
    }
}
