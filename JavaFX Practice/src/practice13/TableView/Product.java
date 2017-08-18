package practice13.TableView;

public class Product {

    private String nameg;
    private double price;
    private double quantity;

    public Product(){
        this.nameg = "";
        this.price = 0;
        this.quantity = 0;
    }

    public Product(String name, double price, int quantity){
        this.nameg = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getNameg() {
        return nameg;
    }

    public void setName(String name) {
        this.nameg = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}