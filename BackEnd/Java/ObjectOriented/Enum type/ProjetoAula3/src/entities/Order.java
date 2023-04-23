package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;

    private Client client;
    static List<OrderItem> items = new ArrayList<>();

    public Order(){
    }

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment(){
        return this.moment;
    }

    public void setMoment(Date moment){
        this.moment = moment;
    }

    public OrderStatus getStatus(){
        return this.status;
    }

    public void setStatus(Date moment){
        this.moment = moment;
    }

    public static void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total() {
        double valor;
        int quantidade;
        double sum = 0;
        for (OrderItem item : items) {
            valor = item.getPrice();
            quantidade = item.getQuantity();
            sum += valor * quantidade;
        } return sum;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
