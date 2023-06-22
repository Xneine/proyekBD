package com.example.proyek_bd.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class addOrderController {
    @FXML
    private VBox vbox;

    @FXML
    private DatePicker tanggalPicker;

    @FXML
    private ChoiceBox<String> costumerChoiceBox;

    @FXML
    private ChoiceBox<String> serviceChoiceBox;

    @FXML
    private ChoiceBox<String> distanceChoiceBox;

    @FXML
    private TextArea keteranganTextArea;

    @FXML
    private Button addButton;

    @FXML
    private void addData() {
        // Mendapatkan nilai tanggal yang dipilih
        LocalDate selectedDate = tanggalPicker.getValue();

        // Mendapatkan nilai-nilai lainnya
        String costumer = costumerChoiceBox.getValue();
        String service = serviceChoiceBox.getValue();
        String distance = distanceChoiceBox.getValue();
        String keterangan = keteranganTextArea.getText();

    }
}
