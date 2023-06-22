package com.example.proyek_bd.objects;

public class Delivery {
    private int delivery_id, delivery_radius, delivery_price;

    public Delivery(int delivery_id, int delivery_radius, int delivery_price) {
        this.delivery_id = delivery_id;
        this.delivery_radius = delivery_radius;
        this.delivery_price = delivery_price;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getDelivery_radius() {
        return delivery_radius;
    }

    public void setDelivery_radius(int delivery_radius) {
        this.delivery_radius = delivery_radius;
    }

    public int getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(int delivery_price) {
        this.delivery_price = delivery_price;
    }
}
