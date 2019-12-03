public class CoffeePowder extends CoffeeProduct{
    private int weight;

    public CoffeePowder(int productID,String name,int weight) {
        super(name, productID);
        this.weight = weight;
    }

    public String toString() {
        return "";
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}