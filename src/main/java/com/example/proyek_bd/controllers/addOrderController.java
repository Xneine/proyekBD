package com.example.proyek_bd.controllers;
import com.example.proyek_bd.mysqlconnector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.sql.*;

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

    private Connection connection;

    public addOrderController() {
        connection = mysqlconnector.connectDB();
        String url = "jdbc:mysql://localhost/" + mysqlconnector.getDbName();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, mysqlconnector.getDbUser(), mysqlconnector.getDbPass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        populateCostumerChoiceBox();
        populateServiceChoiceBox();
        populateDistanceChoiceBox();
    }

    private void populateCostumerChoiceBox() {
        try {
            String query = "SELECT customer_id, customer_name FROM customer";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int costumerId = resultSet.getInt("customer_id");
                String costumerName = resultSet.getString("customer_name");
                costumerChoiceBox.getItems().add(costumerId + " - " + costumerName);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateServiceChoiceBox() {
        try {
            String query = "SELECT service_id, service_category FROM service";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_category = resultSet.getString("service_category");
                serviceChoiceBox.getItems().add(service_id + " - " + service_category);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateDistanceChoiceBox() {
        try {
            String query = "SELECT delivery_id, delivery_radius, delivery_price FROM delivery";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int deliveryRadius = resultSet.getInt("delivery_radius");
                int deliveryId = resultSet.getInt("delivery_id");
                int deliveryPrice = resultSet.getInt("delivery_price");
                distanceChoiceBox.getItems().add(String.valueOf( deliveryRadius+ " - " + deliveryPrice));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addData() {
        String costumerChoice = costumerChoiceBox.getValue();
        String serviceChoice = serviceChoiceBox.getValue();
        Date date = Date.valueOf(tanggalPicker.getValue());
        String keterangan = keteranganTextArea.getText();

        try {
            String query = "INSERT INTO orders (customer_id, service_id, order_date, condition) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            String[] costumerData = costumerChoice.split(" - ");
            String[] serviceData = serviceChoice.split(" - ");
            int costumerId = Integer.parseInt(costumerData[0]);
            int service_Id= Integer.parseInt(serviceData[0]);

            statement.setInt(1, costumerId);
            statement.setInt(2, service_Id);
            statement.setDate(3, date);
            statement.setString(4, keterangan);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                costumerChoiceBox.setValue(null);
                serviceChoiceBox.setValue(null);
                distanceChoiceBox.setValue(null);
                tanggalPicker.setValue(null);
                keteranganTextArea.clear();

            } else {
                System.out.println("Failed to insert data!");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showOrder(){

    }
}

