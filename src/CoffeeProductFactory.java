
import java.util.*;

public interface CoffeeProductFactory {

    public abstract CoffeeProduct createCoffeeProduct(Scanner sc);
}

class CoffeePowderFactory implements CoffeeProductFactory {

    @Override
    public CoffeeProduct createCoffeeProduct(Scanner sc) {
        System.out.println("Enter product id, name and weight(g):");
        String[] data = sc.nextLine().split(", ");
        try {
            int productID = Integer.parseInt(data[0]);
            String name = data[1];
            Double weight = Double.parseDouble(data[2]);
            CoffeePowder powder = new CoffeePowder(productID, name, weight);
            System.out.println("New product record created.\n");
            return powder;
        } catch (Exception e) {
            System.out.println(data);
            System.out.println(e);
            System.out.println("Please input a valid values !");
        }
        return null;
    }
}

class CoffeeCandyFactory implements CoffeeProductFactory {

    @Override
    public CoffeeProduct createCoffeeProduct(Scanner sc) {
        System.out.println("Enter product id, name, number of candy and calories per candy: ");
        String[] data = sc.nextLine().split(", ");
        try {
            int productID = Integer.parseInt(data[0]);
            String name = data[1];
            int noOfCandy = Integer.parseInt(data[2]);
            int caloriesPerCandy = Integer.parseInt(data[3]);
            System.out.println("New product record created.\n");
            return new CoffeeCandy(productID, name, noOfCandy, caloriesPerCandy);
        } catch (Exception e) {
            System.out.println("Please input a valid values !");
        }

        return null;
    }
}
