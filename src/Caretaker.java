
import java.util.*;

public class Caretaker {

    private Stack<Memento> undoList;
    private Stack<Memento> redoList;

    public Caretaker() {
        undoList = new Stack<Memento>();
        redoList = new Stack<Memento>();
    }

    public void saveHistory(CoffeeHouse ch, String des) {
        Memento amemento = new Memento(ch, des);
        if (!redoList.empty()) {
            if (!amemento.equals(redoList.get(redoList.size() - 1))) {
                redoList.clear();
            }
        }
        undoList.push(amemento);
    }

    public boolean undo() {
        if (undoList.size() > 1) {
            Memento temp = undoList.pop();
            redoList.push(temp);
            Memento m = undoList.get(undoList.size() - 1);
            m.restore();
            return true;
        } else {
            return false;
        }
    }

    public boolean redo() {
        if (!redoList.isEmpty()) {
            Memento m = redoList.pop();
            undoList.push(m);
            m.restore();
            return true;
        } else {
            return false;
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
        if (undoList.size() <= 1) {
            s += "Empty";
        } else {
            for (int i = 1; i < undoList.size(); i++) {
                s += undoList.get(i).getDes() + "\n";
            }
        }
        if (redoList.size() == 0) {
            s += "Empty";
        } else {
            s += "\nRedo List: \n";
            for (int i = 0; i < redoList.size(); i++) {
                s += redoList.get(i).getDes() + "\n";
            }
        }
        return s;
    }
}
