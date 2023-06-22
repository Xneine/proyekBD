module com.example.proyek_bd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyek_bd to javafx.fxml;
    exports com.example.proyek_bd;
    exports com.example.proyek_bd.controllers;
    opens com.example.proyek_bd.controllers to javafx.fxml;
    exports com.example.proyek_bd.objects;
    opens com.example.proyek_bd.objects to javafx.fxml;
}