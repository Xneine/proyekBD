package com.example.proyek_bd.controllers;

import com.example.proyek_bd.objects.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.example.proyek_bd.mysqlconnector;
import javafx.scene.control.cell.PropertyValueFactory;

public class addCustomerController implements Initializable {
    @FXML
    private TableColumn<Customer,Integer> customerId_column;
    @FXML
    private TableColumn<Customer, String> alamat_column;

    @FXML
    private TableColumn<Customer, String> name_column;

    @FXML
    private TableColumn<Customer, Integer> telepon_column;

    @FXML
    private TableView<Customer> table_service;

    @FXML
    private TextField namaField;

    @FXML
    private TextField alamatField;

    @FXML
    private TextField teleponField;

    @FXML
    private Button addButton;

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addCostumer(){
        insertCustomer();
    }

    @FXML
    private void tableView(){
        showCustomer();
    }

    public void insertCustomer(){
        if(namaField.getText().equals("") || teleponField.getText().equals("") || alamatField.getText().equals("")){
            Alert alert =  new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error");
            alert.setHeight(100);
            alert.setContentText("Data belum terisi, harap isi data kembali");
            alert.setTitle("Error");
            alert.showAndWait();
            doNothing();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Save");
            alert.setContentText("Are You Sure Want to Save?");
            alert.showAndWait();
            ButtonType buttonType = alert.getResult();
            if (buttonType == ButtonType.OK){
                String addQuery = "insert into customer(customer_name,customer_address,customer_phone_number) values ('"+ namaField.getText() +  "','" + alamatField.getText()
                        + "','" + Integer.parseInt(teleponField.getText()) +"')";
                try {
                    executeQuery(addQuery);
                    clearField();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                alert.close();
            }
        }
    }

    public ObservableList<Customer> getCustomerList(){
        ObservableList<Customer> list = FXCollections.observableArrayList();

        try {
            String query = "SELECT * FROM customer";
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String address = resultSet.getString("customer_address");
                int phoneNumber = resultSet.getInt("customer_phone_number");

                Customer customer = new Customer(customerId, name, address, phoneNumber);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void showCustomer(){
        ObservableList<Customer> list = getCustomerList();
        customerId_column.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("nama"));
        alamat_column.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        telepon_column.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        table_service.setItems(list);
    }

    private void executeQuery(String query) {
        Connection connection = getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Connection getConnection(){
        Connection conn = mysqlconnector.connectDB();
        String url = "jdbc:mysql://localhost/" + mysqlconnector.getDbName();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, mysqlconnector.getDbUser(), mysqlconnector.getDbPass());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    private void doNothing(){
        namaField.setText(namaField.getText());
        alamatField.setText(alamatField.getText());
        teleponField.setText(teleponField.getText());
    }

    public void clearField(){
        namaField.setText("");
        alamatField.setText("");
        teleponField.setText("");
    }

}
