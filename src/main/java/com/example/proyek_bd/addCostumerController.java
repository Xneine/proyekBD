package com.example.proyek_bd;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
public class addCostumerController {
    @FXML
    private TextField namaField;

    @FXML
    private TextField alamatField;

    @FXML
    private TextField teleponField;

    @FXML
    private Button addButton;

    @FXML
    private void addCustomer() {
        // Mendapatkan nilai dari field nama, alamat, dan telepon
        String nama = namaField.getText();
        String alamat = alamatField.getText();
        String telepon = teleponField.getText();

        // Lakukan operasi tambahan sesuai kebutuhan
        // ...

        // Contoh tampilan pesan konfirmasi
        System.out.println("Data Costumer ditambahkan:");
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Telepon: " + telepon);
    }
}
