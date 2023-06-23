package com.example.proyek_bd.objects;

import javafx.collections.ObservableList;

import java.util.Date;

public class Order {
    private int order_id;
    private Customer customer;
    private ObservableList<Service> listService;
    private Date orderDate;

    public Order(int order_id, Customer customer, ObservableList<Service> listService, Date orderDate) {
        this.order_id = order_id;
        this.customer = customer;
        this.listService = listService;
        this.orderDate = orderDate;
    }
}
