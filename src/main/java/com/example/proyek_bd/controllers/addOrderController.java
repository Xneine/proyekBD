package com.example.proyek_bd.controllers;
import com.example.proyek_bd.mysqlconnector;
import com.example.proyek_bd.objects.Order;
import com.example.proyek_bd.objects.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.sql.Date;
import java.time.LocalDate;

import java.sql.*;

import java.time.LocalDate;

public class addOrderController {
    @FXML
    private VBox vbox;

    @FXML
    private DatePicker tanggalPicker;
    @FXML
    private ChoiceBox<String> idOrders;

    @FXML
    private ChoiceBox<String> costumerChoiceBox;


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
        populateDistanceChoiceBox();
        populateIdOrderChoiceBox();
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


    private void populateDistanceChoiceBox() {
        try {
            String query = "SELECT delivery_id, delivery_radius, delivery_price FROM delivery";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int deliveryRadius = resultSet.getInt("delivery_radius");
                int deliveryId = resultSet.getInt("delivery_id");
                int deliveryPrice = resultSet.getInt("delivery_price");
                distanceChoiceBox.getItems().add(( deliveryId+ " - " + deliveryRadius+ " - " + deliveryPrice));
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
        String delivery = distanceChoiceBox.getValue();
        Date date = Date.valueOf(tanggalPicker.getValue());
        String keterangan = keteranganTextArea.getText();

        try {
            String query = "INSERT INTO orders (customer_id, delivery_id, order_date, conditions) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            String[] costumerData = costumerChoice.split(" - ");
            int costumerId = Integer.parseInt(costumerData[0]);

            String[] bebas = delivery.split(" - ");
            int delId = Integer.parseInt(bebas[0]);

            statement.setInt(1, costumerId);
            statement.setInt(2, delId);
            statement.setDate(3, date);
            statement.setString(4, keterangan);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                costumerChoiceBox.setValue(null);
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
    public void updateOrder() {
        int orderId = Integer.parseInt(idOrders.getValue());
        String[] costumerData = idOrders.getValue().split(" - ");
        int customId= Integer.parseInt(costumerData[0]);
        String[] deliveryData = idOrders.getValue().split(" - ");
        int deliveryId= Integer.parseInt(deliveryData[0]);
        Date date = Date.valueOf(tanggalPicker.getValue());
        String conditions = keteranganTextArea.getText();
        try {
            String query = "UPDATE orders SET customer_id = ?, delivery_id = ?, order_date = ?, conditions = ? WHERE order_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, customId);
            statement.setInt(2, deliveryId);
            statement.setDate(3, date);
            statement.setString(4, conditions);
            statement.setInt(5, orderId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Service updated successfully!");
            } else {
                System.out.println("Failed to update service!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteOrder() {
        int orderId = Integer.parseInt(idOrders.getValue());
        try {
            String query = "DELETE FROM order WHERE order_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, orderId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Service deleted successfully!");
            } else {
                System.out.println("Failed to delete service!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateIdOrderChoiceBox() {
        try {
            String query = "SELECT order_id FROM order";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                idOrders.getItems().add(String.valueOf(orderId));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

