
import java.util.Scanner;
import java.util.Vector;

interface CommandFactory {

    public CoffeeCommand create();
}

class AddProductFactory implements CommandFactory {

    private Scanner sc;
    private CoffeeHouse coffeeProduct;
    private Caretaker ct;

    public AddProductFactory(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new AddProductCommand(coffeeProduct, sc, ct);
    }

}

class ViewProductFactory implements CommandFactory {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;

    public ViewProductFactory(CoffeeHouse coffeeProduct, Scanner sc) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
    }

    @Override
    public CoffeeCommand create() {
        return new ViewProductCommand(coffeeProduct, sc);
    }

}

class CollectProductFactory implements CommandFactory {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public CollectProductFactory(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new CollectProductCommand(coffeeProduct, sc, ct);
    }

}

class ShipProductFactory implements CommandFactory {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public ShipProductFactory(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new ShipProductCommand(coffeeProduct, sc, ct);
    }

}

class UndoFactory implements CommandFactory {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public UndoFactory(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new UndoCommand(coffeeProduct, sc, ct);
    }

}

class RedoFactory implements CommandFactory {

    private CoffeeHouse coffeeProduct;
    private Scanner sc;
    private Caretaker ct;

    public RedoFactory(CoffeeHouse coffeeProduct, Scanner sc, Caretaker ct) {
        this.coffeeProduct = coffeeProduct;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new RedoCommand(coffeeProduct, sc, ct);
    }

}

class ShowListUnRedoFactory implements CommandFactory {

    private Scanner sc;
    private Caretaker ct;

    public ShowListUnRedoFactory(Scanner sc, Caretaker ct) {
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new ShowListUnRedoCommand(sc, ct);
    }

}

class ExitSystemFactory implements CommandFactory {

    @Override
    public CoffeeCommand create() {
        return new ExitSystemCommand();
    }

}
