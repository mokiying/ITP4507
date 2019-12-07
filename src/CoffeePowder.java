
public class CoffeePowder extends CoffeeProduct {

    private double weight;

    public CoffeePowder(int productID, String name, double weight) {
        super(productID, name);
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + "\t\t" + getWeight() + "g";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String stringDetails() {
        return super.stringDetails() + "\nWeight: " + getWeight() + "g";
    }

}
