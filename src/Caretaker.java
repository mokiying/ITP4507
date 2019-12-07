
import java.util.*;

public class Caretaker {

    private Stack<Memento> undoList;
    private Stack<Memento> redoList;
    CoffeeHouse ch;

    public Caretaker() {
        undoList = new Stack<Memento>();
        redoList = new Stack<Memento>();
    }

    public void saveHistory(CoffeeProduct cp, String des) {
        redoList.clear();
        Memento amemento = new Memento(cp, des);
        undoList.push(amemento);
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            System.out.println("undo completed.");
            Memento m = undoList.pop();
            Memento redomemento = new Memento(m.getCoffeeProduct(), m.getDes());
            redoList.push(redomemento);
            m.restore();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("redo completed.");
            Memento m = redoList.pop();
            Memento undomemento = new Memento(m.getCoffeeProduct(), m.getDes());
            undoList.push(undomemento);
            m.restore();
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public Stack<Memento> getUndoList() {
        return undoList;
    }

    public Stack<Memento> getRedoList() {
        return redoList;
    }

    public String toString() {
        String s = "Undo List: \n";
        if (undoList.size() == 0) {
            s += "Empty\n";
        } else {
            for (int i = 0; i < undoList.size(); i++) {
                s += undoList.get(i).getDes() + "\n";
            }
        }
        s += "\nRedo List: \n";
        if (redoList.size() == 0) {
            s += "Empty\n";
        } else {
            for (int i = 0; i < redoList.size(); i++) {
                s += redoList.get(i).getDes() + "\n";
            }
        }
        return s;
    }
}
