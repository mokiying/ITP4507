
import java.util.*;

public class Assignment {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Stack<CoffeeCommand> commands = new Stack<CoffeeCommand>();
        Caretaker ct = new Caretaker();
        CoffeeHouse ch = new CoffeeHouse();
        String command;
        ct.saveHistory(ch, "FirstSave");
        while (true) {
            System.out.println("Coffee Inventory Management System");
            System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
            System.out.println("a = add product,  v = view products,  c = collect product,  s = ship product, \n"
                    + "u = undo,  r = redo,  sl = show list undo/redo,  x = exit system\n");
            command = sc.nextLine();

            CoffeeCommand com = createCommand(command, commands, ch.getProducts(), ct);
            com.excute();
        }
    }

    public static CoffeeCommand createCommand(String command, Stack commands, Vector<CoffeeProduct> coffeeProduct, Caretaker ct) {
        CoffeeCommand com;
        CommandFactory[] factory = {new AddProductFactory(coffeeProduct, sc, ct), 
            new ViewProductFactory(coffeeProduct, sc), 
            new CollectProductFactory(coffeeProduct, sc, ct),
            new ShipProductFactory(coffeeProduct, sc, ct),
            new UndoFactory(coffeeProduct, sc, ct), 
            new RedoFactory(coffeeProduct, sc, ct), 
            new ShowListUnRedoFactory(sc, ct), 
            new ExitSystemFactory()};
        if (command.equals("a")) {
            com = factory[0].create();
        } else if (command.equals("v")) {
            com = factory[1].create();
        } else if (command.equals("c")) {
            com = factory[2].create();
        } else if (command.equals("s")) {
            com = factory[3].create();
        } else if (command.equals("u")) {
            com = factory[4].create();
        } else if (command.equals("r")) {
            com = factory[5].create();
        } else if (command.equals("sl")) {
            com = factory[6].create();
        } else if (command.equals("x")) {
            com = factory[7].create();
        } else {
            com = null;
        }

        return com;
    }

}
