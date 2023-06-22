package com.example.proyek_bd.objects;

import javafx.collections.ObservableList;

public class Service {
    private int service_id;
    private String service_category;


    public Service(int service_id, String service_category) {
        this.service_id = service_id;
        this.service_category = service_category;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_category() {
        return service_category;
    }

    public void setService_category(String service_category) {
        this.service_category = service_category;
    }
}
