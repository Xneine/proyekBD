package com.example.proyek_bd.controllers;
import com.example.proyek_bd.mysqlconnector;
import com.example.proyek_bd.objects.Customer;
import com.example.proyek_bd.objects.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class addServiceController {
    @FXML
    private TableView<Service> table_service;
    @FXML
    private TableColumn<Service, Integer> service_id_tb;
    @FXML
    private TableColumn<Service, String> service_category_tb;
    @FXML
    private TextField idField;
    @FXML
    private TextField categoryField;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField categoryField2;
    @FXML
    private Button addButton;

    private Connection connection;

    public addServiceController() {
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
    public void addService() {
        String serviceCategory = categoryField.getText();
        try {
            String query = "INSERT INTO service (service_category) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, serviceCategory);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Service added successfully!");
                categoryField.clear();

            } else {
                System.out.println("Failed to add service!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void updateService() {
        int serviceId = Integer.parseInt(idField.getText());
        String serviceCategory = categoryField2.getText();
        try {
            String query = "UPDATE service SET service_category = ? WHERE service_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, serviceCategory);
            statement.setInt(2, serviceId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Service updated successfully!");
                idField.clear();
                categoryField2.clear();
            } else {
                System.out.println("Failed to update service!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteService() {
        int serviceId = Integer.parseInt(idField.getText());
        try {
            String query = "DELETE FROM service WHERE service_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, serviceId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Service deleted successfully!");
                idField.clear();
                categoryField2.clear();
            } else {
                System.out.println("Failed to delete service!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //////////////////
    public ObservableList<Service> getServiceList(){
        ObservableList<Service> list = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM service";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_category = resultSet.getString("service_category");

                Service service = new Service(service_id,service_category);
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @FXML
    private void showService() {
        ObservableList<Service> list = getServiceList();
        service_id_tb.setCellValueFactory(new PropertyValueFactory<>("service_id"));
        service_category_tb.setCellValueFactory(new PropertyValueFactory<>("service_category"));
        table_service.setItems(list);
    }
}

