package practice13.TableView;


public class Product1 {

    private String name;
    private double price;
    private int quantity;

    public Product1(){
        this.name = "";
        this.price = 0;
        this.quantity = 0;
    }

    public Product1(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}