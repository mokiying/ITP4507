
import java.util.*;

public class CoffeeHouse {

    private List<CoffeeProduct> products;//data

    public CoffeeHouse() {
    }

    public CoffeeHouse(List<CoffeeProduct> prods) {
        this.products = prods;
    }

    public List<CoffeeProduct> getProducts() {
        return this.products;
    }

    public void setProducts(List<CoffeeProduct> prod) {
        this.products = prod;
    }

}

class Memento {

    private CoffeeHouse coffeeHouse;// Target (not data)
    private List<CoffeeProduct> data;// Record Data
    private String desc;

    public Memento(CoffeeHouse ch, String des) {
        this.coffeeHouse = new CoffeeHouse(ch.getProducts()); // Obj Ref
        this.desc = des;
        List<CoffeeProduct> temp = new Vector(); // clone the data without obj ref 0v0/
        for (CoffeeProduct cp : ch.getProducts()) {
            temp.add(cp); 
        }
        this.data = temp; //its stored a new obj not obj ref :>
    }

    public String getDes() {
        return desc;
    }

    public void restore() {
        this.coffeeHouse.setProducts(data);
    }
}
