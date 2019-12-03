
import java.util.*;

public class Assignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector CoffeeProduct = new Vector();
        CoffeeProductFactory cf[] = {new CoffeePowderFactory(), new CoffeeCandyFactory()};
        while (true) {
            System.out.println("Coffee Inventory Management System");
            System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
            System.out.println("a = add product, v = view product, c = collect product, s = ship product, "
                    + "u = undo, r = redo, sl = show list undo/redo, x = exit system ");
            String command = sc.next();
            if (command.equals("a")) {
                System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder): ");
                command = sc.next();
                if (command.equals("cp")) {
                    cf[0].createCoffeeProduct(sc);
                } else if (command.equals("cc")) {
                    cf[1].createCoffeeProduct(sc);
                }
            } else if (command.equals("v")) {

            } else if (command.equals("c")) {

            } else if (command.equals("s")) {

            } else if (command.equals("u")) {

            } else if (command.equals("r")) {

            } else if (command.equals("sl")) {

            } else if (command.equals("x")) {
                System.out.println("Thanks for using Coffee Inventory Management System!!");
                break;
            } else {
                System.out.println("Invalid command, please input again!");
            }
        }
    }
}
