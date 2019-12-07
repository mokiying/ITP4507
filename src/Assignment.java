
import java.util.*;

public class Assignment {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Caretaker ct = new Caretaker();
        CoffeeHouse ch = new CoffeeHouse();
        
        String command;
        while (true) {
            System.out.println("Coffee Inventory Management System");
            System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
            System.out.println("a = add product,  v = view products,  c = collect product,  s = ship product, \n"
                    + "u = undo,  r = redo,  sl = show list undo/redo,  x = exit system\n");
            command = sc.nextLine();

            CoffeeCommand com = createCommand(command, ct, ch);
            com.excute();
        }
    }

    public static CoffeeCommand createCommand(String command, Caretaker ct, CoffeeHouse ch) {
        CoffeeCommand com;
        CommandFactory[] factory = {new AddProductFactory(sc, ct, ch), 
            new ViewProductFactory(sc, ch), 
            new CollectProductFactory(sc, ct, ch),
            new ShipProductFactory(sc, ct, ch),
            new UndoFactory(sc, ct), 
            new RedoFactory(sc, ct), 
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
