package com.example.proyek_bd.controllers;

import com.example.proyek_bd.mysqlconnector;
import com.example.proyek_bd.objects.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDate;

public class viewOrderController {

    @FXML
    private TableColumn<Order, Integer> category_id_tb;

    @FXML
    private TableColumn<Order, Integer> costumer_id_tb;

    @FXML
    private TableColumn<Order, Date> order_date_tb;

    @FXML
    private TableColumn<Order, Integer> order_id_tb;
    @FXML
    private TableColumn<Order, Integer> delivery_id_tb;

    @FXML
    private TableView<Order> table_order;

    @FXML
    private Button refreshButton;


    private Connection connection;

    public viewOrderController() {
        connection = mysqlconnector.connectDB();
        String url = "jdbc:mysql://localhost/" + mysqlconnector.getDbName();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, mysqlconnector.getDbUser(), mysqlconnector.getDbPass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Order> getOrderList(){
        ObservableList<Order> list = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM orders";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int order_id = resultSet.getInt("ORDER_ID");
                Date order_date = resultSet.getDate("ORDER_DATE");
                LocalDate localDate = order_date.toLocalDate();
                int customer_id = resultSet.getInt("CUSTOMER_ID");
                String conditions = resultSet.getString("CONDITIONS");
                int delivery_id = resultSet.getInt("DELIVERY_ID");

                Order order = new Order(order_id, localDate, customer_id, conditions, delivery_id);
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @FXML
    public void showOrder(){
        ObservableList<Order> list = getOrderList();
        order_id_tb.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        order_date_tb.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        costumer_id_tb.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        category_id_tb.setCellValueFactory(new PropertyValueFactory<>("conditions"));
        delivery_id_tb.setCellValueFactory(new PropertyValueFactory<>("delivery_id"));
        table_order.setItems(list);
    }

}
