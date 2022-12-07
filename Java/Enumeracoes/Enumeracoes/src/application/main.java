package application;

import entities.Order;
import entities.OrderStatus;

import java.util.Date;

public class main {

    public static void main(String[] args) {
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);
        OrderStatus os1 = OrderStatus.PENDING_PAYMENT;
        OrderStatus os2 = OrderStatus.valueOf("PENDING_PAYMENT");
        System.out.println(os1);
        System.out.println(os2);
    }
}

