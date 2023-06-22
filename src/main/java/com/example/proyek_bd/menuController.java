package com.example.proyek_bd;

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
    public void changeSceneToAddCostumer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addCostumer.fxml"));
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
    public void changeSceneToAddOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addOrder.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addDetailOrder.fxml"));
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