package com.example.proyek_bd.objects;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int order_id;
    private LocalDate orderDate;
    private int customer_id;
    private String conditions;
    private int delivery_id;

    public Order(int order_id, LocalDate orderDate, int customer_id, String conditions, int delivery_id) {
        this.order_id = order_id;
        this.orderDate = orderDate;
        this.customer_id = customer_id;
        this.conditions = conditions;
        this.delivery_id = delivery_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }
}
