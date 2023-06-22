package com.example.proyek_bd.objects;

public class Customer {
    private String nama, alamat;
    private int customer_id, telepon;

    public Customer(){

    }

    public Customer(int customer_id, String nama, String alamat, int telepon){
        this.customer_id = customer_id;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTelepon() {
        return telepon;
    }

    public void setTelepon(int telepon) {
        this.telepon = telepon;
    }
}
