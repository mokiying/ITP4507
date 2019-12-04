
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

    public void setProducts(List<CoffeeProduct> p) {
        this.products = p;
    }

    public void addProduct(CoffeeProduct coffeeProduct) {
        boolean haveOrNot = false;
        for (int i = 0; i < products.size(); i++) {
            if (this.getProducts().get(i).getProductID() == coffeeProduct.getProductID()) {
                haveOrNot = true;
            }
        }
        if (haveOrNot) {
            System.out.println("ProductID " + coffeeProduct.getProductID() + " is exist already.");
        } else {
            this.products.add(coffeeProduct);
        }
    }

    @Override
    public CoffeeHouse clone() {
        CoffeeHouse temp = new CoffeeHouse(this.products);
//        CoffeeProduct coffeeProduct;
//        for (int i = 0; i < this.products.size(); i++) {
//            temp.addProduct(coffeeProduct.clone());
//        }
        for(CoffeeProduct p : this.products){
            temp.addProduct(p.clone());
        }
        return temp;
    }
}

class Memento {

    private CoffeeHouse coffeeHouse;// Target (not data)
    private List<CoffeeProduct> data;// Record Data
    private String desc;

    public Memento(CoffeeHouse ch, String des) {
        this.coffeeHouse = ch; // Obj Ref
        this.desc = des;
        List<CoffeeProduct> temp = new Vector(); // clone the data without obj ref 0v0/
        for (CoffeeProduct cp : ch.getProducts()) {
            temp.add(cp.clone());
        }
        this.data = temp; //its stored a new obj not obj ref :>
    }

    public String getDes() {
        return desc;
    }

    public void restore() {
        coffeeHouse.setProducts(data);
    }
}
