
import java.util.*;

public class CoffeeHouse {

    private Vector<CoffeeProduct> products;//data

    public CoffeeHouse() {
        products = new Vector<CoffeeProduct>();
    }

    public CoffeeHouse(Vector<CoffeeProduct> prods) {
        this.products = prods;
    }

    public Vector<CoffeeProduct> getProducts() {
        return this.products;
    }
    
    public void setProducts(Vector<CoffeeProduct> prod) {
        this.products = prod;
    }

    public void addProduct(CoffeeProduct coffeeProduct) {
        this.products.add(coffeeProduct);
    }

    public CoffeeHouse clone() {
        CoffeeHouse temp = new CoffeeHouse();
        for (CoffeeProduct cp : this.getProducts()) {
            temp.addProduct(cp.clone());
        }
        return temp;
    }

}

class Memento {

    private CoffeeHouse coffeeHouse;// Target (not data)
    private Vector<CoffeeProduct> data;// Record Data
    private String desc;

    public Memento() {

    }

    public Memento(CoffeeHouse ch, String des) {
        this.coffeeHouse = ch;
        this.desc = des;
        this.data = ch.clone().getProducts();
    }

    public String getDes() {
        return desc;
    }

    public void restore() {
        coffeeHouse.setProducts(data);
    }
}
