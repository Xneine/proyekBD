package com.example.proyek_bd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class menuController {
    @FXML
    public MenuItem changeSceneMenuItem;
    @FXML
    public MenuItem changeSceneMenuItem2;
    @FXML
    public MenuItem changeSceneMenuItem3;
    @FXML
    public MenuItem changeSceneMenuItem4;
    @FXML
    public void changeSceneToAddCostumer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/addCostumer.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeSceneToCustomerTable(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/customerTable.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem4.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeSceneToAddOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/addOrder.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem2.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeSceneToAddDetailOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/addDetailOrder.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem3.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}