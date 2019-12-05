
import java.util.*;

public interface CoffeeCommand {

    public abstract void excute();
}

class AddProductCommand implements CoffeeCommand {

    private Scanner sc;
    private String command;
    private Vector<CoffeeProduct> coffeeProduct;
    private Caretaker ct;
    CoffeeProductFactory[] cf = {new CoffeePowderFactory(), new CoffeeCandyFactory()};

    public AddProductCommand(Vector<CoffeeProduct> coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder): ");
        command = sc.next();
        CoffeeProduct temp = null;
        if (command.equals("cp")) {
            temp = cf[0].createCoffeeProduct(sc);
            String des = "Add " + temp.getProductID() + " " + temp.getName();
            ct.saveHistory(new CoffeeHouse(coffeeProduct), des);
            coffeeProduct.add(temp);
        } else if (command.equals("cc")) {
            temp = cf[1].createCoffeeProduct(sc);
            String des = "Add " + temp.getProductID() + " " + temp.getName();
            ct.saveHistory(new CoffeeHouse(coffeeProduct), des);
            coffeeProduct.add(temp);
        }
    }
}

class ViewProductCommand implements CoffeeCommand {

    private Vector<CoffeeProduct> coffeeProduct;
    private Scanner sc;
    private String command;

    public ViewProductCommand(Vector<CoffeeProduct> coffeeProduct, Scanner sc) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
    }

    @Override
    public void excute() {
        System.out.println("Enter product Id. (* to show all): ");
        command = sc.next();
        if (command.equals("*")) {
            System.out.println("CoffeeProduct information");
            System.out.println("ID\tName\t\t\tQuantity\tOther Info");
            for (int i = 0; i < coffeeProduct.size(); i++) {
                System.out.println(coffeeProduct.get(i));
            }
        } else {
            for (int i = 0; i < coffeeProduct.size(); i++) {
                if (command.equals(coffeeProduct.get(i).getProductID())) {
                    System.out.println("Product information");
                    System.out.println(coffeeProduct.get(i).stringDetails());
                }
            }
        }
    }
}

class CollectProductCommand implements CoffeeCommand {

    private Vector<CoffeeProduct> coffeeProduct;
    private Scanner sc;
    private int command;
    private Caretaker ct;

    public CollectProductCommand(Vector<CoffeeProduct> coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println("Enter code: ");
        command = Integer.parseInt(sc.next());
        for (int i = 0; i < coffeeProduct.size(); i++) {
            if (command == coffeeProduct.get(i).getProductID()) {
                System.out.println("Quantity to receive: ");
                CoffeeProduct cofp = coffeeProduct.get(i);
                int addQty = Integer.parseInt(sc.next());
                String des = "Received " + addQty + " " + cofp.getName() + " (" + cofp.getProductID() + ") ";
                ct.saveHistory(new CoffeeHouse(coffeeProduct), des);
                cofp.setQty(cofp.getQty() + addQty);
                System.out.println("Received " + addQty + " packs of " + cofp.getName()
                        + ". Current quantity is " + cofp.getQty() + ". ");
            }
        }
    }
}

class ShipProductCommand implements CoffeeCommand {

    private Vector<CoffeeProduct> coffeeProduct;
    private Scanner sc;
    private int command;
    private Caretaker ct;

    public ShipProductCommand(Vector<CoffeeProduct> coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println("Enter code: ");
        command = Integer.parseInt(sc.next());
        for (int i = 0; i < coffeeProduct.size(); i++) {
            if (command == coffeeProduct.get(i).getProductID()) {
                System.out.println("Quantity to ship: ");
                CoffeeProduct cofp = coffeeProduct.get(i);
                int deQty = Integer.parseInt(sc.next());
                if (cofp.getQty() < deQty) {
                    System.out.println("Invalid quantity (current balance is less than required quantity). Try again!!! ");
                } else {
                    String des = "Shipped " + deQty + " " + cofp.getName() + " (" + cofp.getProductID() + ") ";
                    ct.saveHistory(new CoffeeHouse(coffeeProduct), des);
                    cofp.setQty(cofp.getQty() - deQty);
                    System.out.println("Shipped " + deQty + " packs of " + cofp.getName()
                            + ". Current quantity is " + cofp.getQty() + ". ");
                }
            }
        }
    }
}

class UndoCommand implements CoffeeCommand {

    private Vector<CoffeeProduct> coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public UndoCommand(Vector<CoffeeProduct> coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        if (ct.undo()) {
            System.out.println("undo completed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}

class RedoCommand implements CoffeeCommand {

    private Vector<CoffeeProduct> coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public RedoCommand(Vector<CoffeeProduct> coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        if (ct.redo()) {
            System.out.println("redo completed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

}

class ShowListUnRedoCommand implements CoffeeCommand {

    private Scanner sc;
    private Caretaker ct;

    public ShowListUnRedoCommand(Scanner sc, Caretaker ct) {
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println(ct.toString());
    }

}

class ExitSystemCommand implements CoffeeCommand {

    @Override
    public void excute() {
        System.out.println("Thanks for using Coffee Inventory Management System!!");
        System.exit(0);
    }

}
