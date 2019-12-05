
import java.util.*;

public interface CoffeeCommand {

    public abstract void excute();
}

class AddProductCommand implements CoffeeCommand {

    private Scanner sc;
    private String command;
    private CoffeeHouse coffeeProduct;
    private Caretaker ct;
    CoffeeProductFactory[] cf = {new CoffeePowderFactory(), new CoffeeCandyFactory()};

    public AddProductCommand(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder): ");
        command = sc.nextLine();
        CoffeeProduct temp = null;
        if (command.equals("cp")) {
            temp = cf[0].createCoffeeProduct(sc);
            coffeeProduct.addProduct(temp);
            String des = "Add " + temp.getProductID() + " " + temp.getName();
            ct.saveHistory(coffeeProduct, des);
        } else if (command.equals("cc")) {
            temp = cf[1].createCoffeeProduct(sc);
            coffeeProduct.addProduct(temp);
            String des = "Add " + temp.getProductID() + " " + temp.getName();
            ct.saveHistory(coffeeProduct, des);          
        }
    }
}

class ViewProductCommand implements CoffeeCommand {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private String command;

    public ViewProductCommand(CoffeeHouse coffeeProduct, Scanner sc) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
    }

    @Override
    public void excute() {
        System.out.println("Enter product id (* to show all):");
        command = sc.nextLine();
        if (command.equals("*")) {
            System.out.println("\nCoffee Product information");
            System.out.println("ID\tName\t\t\tQuantity\tOther Info");
            for (int i = 0; i < coffeeProduct.getProducts().size(); i++) {
                System.out.println(coffeeProduct.getProducts().get(i));
            }
        } else {
            for (int i = 0; i < coffeeProduct.getProducts().size(); i++) {
                if (coffeeProduct.getProducts().get(i).getProductID()==Integer.valueOf(command)) { 
                    System.out.println("\nProduct information");
                    System.out.println(coffeeProduct.getProducts().get(i).stringDetails());
                }
            }
        }
    }
}

class CollectProductCommand implements CoffeeCommand {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private int command;
    private Caretaker ct;

    public CollectProductCommand(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println("Enter product id:");
        command = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < coffeeProduct.getProducts().size(); i++) {
            if (command == coffeeProduct.getProducts().get(i).getProductID()) {
                System.out.println("Quantity to receive:");
                CoffeeProduct cofp = coffeeProduct.getProducts().get(i);
                int addQty = Integer.parseInt(sc.nextLine());
                String des = "Received " + addQty + " " + cofp.getName() + " (" + cofp.getProductID() + ")";
                
                cofp.setQty(cofp.getQty() + addQty);
                ct.saveHistory(coffeeProduct, des);
                System.out.println("Received " + addQty + " packs of " + cofp.getName()
                        + ". Current quantity is " + cofp.getQty() + ".\n");
            }
        }
    }
}

class ShipProductCommand implements CoffeeCommand {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private int command;
    private Caretaker ct;

    public ShipProductCommand(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public void excute() {
        System.out.println("Enter product id:");
        command = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < coffeeProduct.getProducts().size(); i++) {
            if (command == coffeeProduct.getProducts().get(i).getProductID()) {
                System.out.println("Quantity to ship:");
                CoffeeProduct cofp = coffeeProduct.getProducts().get(i);
                int deQty = Integer.parseInt(sc.nextLine());
                if (cofp.getQty() < deQty) {
                    System.out.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
                } else {
                    String des = "Shipped " + deQty + " " + cofp.getName() + " (" + cofp.getProductID() + ")";
                    
                    cofp.setQty(cofp.getQty() - deQty);
                    ct.saveHistory(coffeeProduct, des);
                    System.out.println("Shipped " + deQty + " packs of " + cofp.getName()
                            + ". Current quantity is " + cofp.getQty() + ".\n");
                }
            }
        }
    }
}

class UndoCommand implements CoffeeCommand {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public UndoCommand(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
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

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public RedoCommand(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
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
