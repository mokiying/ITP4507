
public class CoffeeCandy extends CoffeeProduct {

    private int noOfCandy;
    private int caloriesPerCandy;

    public CoffeeCandy(int productID, String name, int noOfCandy, int caloriesPerCandy) {
        super(productID, name);
        this.noOfCandy = noOfCandy;
        this.caloriesPerCandy = caloriesPerCandy;
    }

    public String toString() {
        return super.toString() + "\nNumber of candies per package: " + getNoOfCandy()
                + "\nCalories Per candy: " + getCaloriesPerCandy();
    }

    public int getNoOfCandy() {
        return noOfCandy;
    }

    public void setNoOfCandy(int noOfCandy) {
        this.noOfCandy = noOfCandy;
    }

    public int getCaloriesPerCandy() {
        return caloriesPerCandy;
    }

    public void setCaloriesPerCandy(int caloriesPerCandy) {
        this.caloriesPerCandy = caloriesPerCandy;
    }

}
