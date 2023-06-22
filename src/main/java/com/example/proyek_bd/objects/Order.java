package com.example.proyek_bd.objects;

import javafx.collections.ObservableList;

import java.util.Date;

public class Order {
    private int order_id;
    private Customer customer;
    private ObservableList<Service> listService;
    private Date orderDate;


}
