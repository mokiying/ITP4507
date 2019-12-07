
import java.util.Scanner;
import java.util.Vector;

interface CommandFactory {

    public CoffeeCommand create();
}

class AddProductFactory implements CommandFactory {

    private Scanner sc;
    private CoffeeProduct coffeeProduct;
    private Caretaker ct;
    private CoffeeHouse ch;

    public AddProductFactory(Scanner sc, Caretaker ct, CoffeeHouse ch) {
        this.sc = sc;
        this.ct = ct;
        this.ch = ch;
    }

    @Override
    public CoffeeCommand create() {
        return new AddProductCommand(coffeeProduct, sc, ct, ch);
    }

}

class ViewProductFactory implements CommandFactory {

    private Scanner sc;
    private CoffeeHouse ch;

    public ViewProductFactory(Scanner sc, CoffeeHouse ch) {
        this.sc = sc;
        this.ch = ch;
    }

    @Override
    public CoffeeCommand create() {
        return new ViewProductCommand(sc, ch);
    }

}

class CollectProductFactory implements CommandFactory {

    private Scanner sc;
    private Caretaker ct;
    private CoffeeHouse ch;

    public CollectProductFactory(Scanner sc, Caretaker ct, CoffeeHouse ch) {
        this.sc = sc;
        this.ct = ct;
        this.ch = ch;
    }

    @Override
    public CoffeeCommand create() {
        return new CollectProductCommand(sc, ct, ch);
    }

}

class ShipProductFactory implements CommandFactory {

    private Scanner sc;
    private Caretaker ct;
    private CoffeeHouse ch;

    public ShipProductFactory(Scanner sc, Caretaker ct, CoffeeHouse ch) {
        this.sc = sc;
        this.ct = ct;
        this.ch = ch;
    }

    @Override
    public CoffeeCommand create() {
        return new ShipProductCommand(sc, ct, ch);
    }

}

class UndoFactory implements CommandFactory {

    private Scanner sc;
    private Caretaker ct;

    public UndoFactory(Scanner sc, Caretaker ct) {
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new UndoCommand(ct);
    }

}

class RedoFactory implements CommandFactory {

    private Scanner sc;
    private Caretaker ct;

    public RedoFactory(Scanner sc, Caretaker ct) {
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public CoffeeCommand create() {
        return new RedoCommand(ct);
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
