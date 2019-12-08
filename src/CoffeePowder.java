
public class CoffeePowder extends CoffeeProduct {

    private double weight;

    public CoffeePowder(int productID, String name, double weight) {
        super(productID, name);
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + "\nWeight: " + getWeight() + "g";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
