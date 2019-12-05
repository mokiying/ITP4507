
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
    
    public void addProduct(CoffeeProduct coffeeProduct){
        this.products.add(coffeeProduct);
    }

}

class Memento {

    private CoffeeHouse coffeeHouse;// Target (not data)
    private List<CoffeeProduct> data;// Record Data
    private String desc;
    private CoffeeProduct coffeeProduct;

    public Memento() {

    }

    public Memento(CoffeeHouse ch, String des) {
        this.coffeeHouse = ch;
        this.desc = des;
        List<CoffeeProduct> temp = new Vector();
        for (CoffeeProduct cp : ch.getProducts()) {
            temp.add(cp);
        }
        this.data = temp; 
    }

    public String getDes() {
        return desc;
    }

    public CoffeeHouse getCoffeeHouse() {
        return this.coffeeHouse;
    }

    public void restore() {
        coffeeHouse.setProducts(data);
    }
}
