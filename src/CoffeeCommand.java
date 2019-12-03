import java.util.*;

public interface CoffeeCommand {
    public abstract void excute(Scanner sc);    
}

class CommandAddProduct implements CoffeeCommand{

    @Override
    public void excute(Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
