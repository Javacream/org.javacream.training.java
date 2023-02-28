package org.javacream.books.order.api;

import java.util.UUID;

public class Order {
    private long orderId;
    private String isbn;
    private int amount;
    private double totalPrice;
    private OrderStatus orderStatus;

    public long getOrderId() {
        return orderId;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Order(long orderId, String isbn, int amount, double totalPrice, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.isbn = isbn;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }
}
