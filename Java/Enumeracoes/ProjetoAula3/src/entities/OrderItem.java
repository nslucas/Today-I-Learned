package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(){}

    public OrderItem(Integer quantity, Double price, Product p){
        this.quantity = quantity;
        this.price = price;
        this.product = p;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){this.quantity = quantity;}

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(){
        this.price = price;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public Double subTotal(){
        return quantity * price;
    }

    @Override
    public String toString() {
        return  getProduct().getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}
