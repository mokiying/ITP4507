
import java.util.*;

public class CoffeeHouse {

    private Vector<CoffeeProduct> vtcp;
    private CoffeeProduct product;
    private String des;

    public CoffeeHouse() {
        this.vtcp = new Vector<CoffeeProduct>();
    }

    public CoffeeHouse(CoffeeProduct prods, String des) {
        this.product = prods;
        this.des = des;
    }

    public CoffeeHouse(Vector<CoffeeProduct> vtcp, CoffeeProduct prods, String des) {
        this.vtcp = vtcp;
        this.product = prods;
        this.des = des;
    }

    public Vector<CoffeeProduct> getVtcp() {
        return this.vtcp;
    }

    public CoffeeProduct getProducts() {
        return this.product;
    }

    public String getDes() {
        return this.des;
    }

    public void setVtcp(Vector<CoffeeProduct> vtcp1) {
        this.vtcp = vtcp1;
    }

    public void setProducts(CoffeeProduct prod1) {
        this.product = prod1;
    }

    public void setDes(String des1) {
        this.des = des1;
    }

    public void addProductToVcpt(CoffeeProduct cp) {
        vtcp.add(cp);
    }

//    public Memento saveToMemento(CoffeeProduct nProduct, String nDes) {
//        return new Memento(nProduct, nDes);
//    }
//    public void delVtcp() {
//        vtcp.remove(vtcp.size() - 1);
//    }
//
//    public void rm(Memento m) {
//        this.vtcp.remove(m.getCoffeeProduct());
//    }

}

class Memento {

    private CoffeeProduct data;
    private int qty;
    private String desc;
    CoffeeHouse ch;

    public Memento() {

    }

    public Memento(CoffeeProduct cp, String des) {
        this.data = cp;
        this.desc = des;
        this.qty = cp.getQty();
    }

    public String getDes() {
        return this.desc;
    }

    public CoffeeProduct getCoffeeProduct() {
        return this.data;
    }

    public int getQty() {
        return this.qty;
    }

    public void restore() {
            data.setQty(this.qty);
    }

}
