
import java.util.*;

public interface CoffeeCommand {

    public abstract void excute();
}

class AddProductCommand implements CoffeeCommand {

    private Scanner sc;
    private String command;
    private CoffeeProduct coffeeProduct;
    private Caretaker ct;
    private CoffeeHouse ch;
    CoffeeProductFactory[] cf = {new CoffeePowderFactory(), new CoffeeCandyFactory()};

    public AddProductCommand(CoffeeProduct coffeeProduct, Scanner sc, Caretaker ct, CoffeeHouse ch) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
        this.ch = ch;
    }

    @Override
    public void excute() {
        System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder): ");
        command = sc.nextLine();
        CoffeeProduct temp = null;
        if (command.equals("cp")) {
            temp = cf[0].createCoffeeProduct(sc);
            System.out.println();
            // coffeeProduct.addProduct(temp);
            ch.addProductToVcpt(temp);
            String des = "Add " + temp.getProductID() + " " + temp.getName();
            ct.saveHistory(temp, des);
        } else if (command.equals("cc")) {
            temp = cf[1].createCoffeeProduct(sc);
            // coffeeProduct.addProduct(temp);
            ch.addProductToVcpt(temp);
            String des = "Add " + temp.getProductID() + " " + temp.getName();
            ct.saveHistory(temp, des);
        }
    }
}

class ViewProductCommand implements CoffeeCommand {

    private Scanner sc;
    private String command;
    private CoffeeHouse ch;

    public ViewProductCommand(Scanner sc, CoffeeHouse ch) {
        this.sc = sc;
        this.ch = ch;
    }

    @Override
    public void excute() {
        System.out.println("Enter product id (* to show all):");
        command = sc.nextLine();
        if (command.equals("*")) {
            System.out.println("\nCoffee Product information");
            System.out.println("ID\tName\t\t\tQuantity\tOther Info");
            for (int i = 0; i < ch.getVtcp().size(); i++) {
                System.out.println(ch.getVtcp().get(i));
            }
        } else {
            for (int i = 0; i < ch.getVtcp().size(); i++) {
                if (ch.getVtcp().get(i).getProductID() == Integer.valueOf(command)) {
                    System.out.println("\nProduct information");
                    System.out.println(ch.getVtcp().get(i).stringDetails());
                }
            }
        }
    }
}

class CollectProductCommand implements CoffeeCommand {

    private Scanner sc;
    private int command;
    private Caretaker ct;
    private CoffeeHouse ch;

    public CollectProductCommand(Scanner sc, Caretaker ct, CoffeeHouse ch) {
        this.sc = sc;
        this.ct = ct;
        this.ch = ch;
    }

    @Override
    public void excute() {
        System.out.println("Enter product id:");
        command = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < ch.getVtcp().size(); i++) {
            if (command == ch.getVtcp().get(i).getProductID()) {
                System.out.println("Quantity to receive:");
                CoffeeProduct cofp = ch.getVtcp().get(i);
                int addQty = Integer.parseInt(sc.nextLine());
                String des = "Received " + addQty + " " + cofp.getName() + " (" + cofp.getProductID() + ")";
                ct.saveHistory(cofp, des);
                cofp.setQty(cofp.getQty() + addQty);

                System.out.println("Received " + addQty + " packs of " + cofp.getName()
                        + ". Current quantity is " + cofp.getQty() + ".\n");
            }
        }
    }
}

class ShipProductCommand implements CoffeeCommand {

    private Scanner sc;
    private int command;
    private Caretaker ct;
    private CoffeeHouse ch;

    public ShipProductCommand(Scanner sc, Caretaker ct, CoffeeHouse ch) {
        this.sc = sc;
        this.ct = ct;
        this.ch = ch;
    }

    @Override
    public void excute() {
        System.out.println("Enter product id:");
        command = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < ch.getVtcp().size(); i++) {
            if (command == ch.getVtcp().get(i).getProductID()) {
                System.out.println("Quantity to ship:");
                CoffeeProduct cofp = ch.getVtcp().get(i);
                int deQty = Integer.parseInt(sc.nextLine());
                if (cofp.getQty() < deQty) {
                    System.out.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
                } else {
                    String des = "Shipped " + deQty + " " + cofp.getName() + " (" + cofp.getProductID() + ")";
                    ct.saveHistory(cofp, des);
                    cofp.setQty(cofp.getQty() - deQty);

                    System.out.println("Shipped " + deQty + " packs of " + cofp.getName()
                            + ". Current quantity is " + cofp.getQty() + ".\n");
                }
            }
        }
    }
}

class UndoCommand implements CoffeeCommand {

    private Caretaker ct;

    public UndoCommand(Caretaker ct) {
        this.ct = ct;
    }

    @Override
    public void excute() {
        ct.undo();
    }
}

class RedoCommand implements CoffeeCommand {

    private Caretaker ct;

    public RedoCommand(Caretaker ct) {
        this.ct = ct;
    }

    @Override
    public void excute() {
        ct.redo();
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
