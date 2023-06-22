module com.example.proyek_bd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyek_bd to javafx.fxml;
    exports com.example.proyek_bd;
}