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
    public MenuItem changeSceneMenuItem5;
    @FXML
    public MenuItem changeSceneMenuItem6;
    @FXML
    public MenuItem changeSceneMenuItem7;
    @FXML
    public MenuItem changeSceneMenuItem8;
    @FXML
    public MenuItem changeSceneMenuItem9;
    @FXML
    public MenuItem changeSceneMenuItem10;
    @FXML
    public MenuItem changeSceneMenuItem11;
    @FXML
    public MenuItem changeSceneMenuItem12;
    @FXML
    public MenuItem changeSceneMenuItem13;
    @FXML
    public MenuItem changeSceneMenuItem14;
    @FXML
    public MenuItem changeSceneMenuItem15;
    @FXML
    public MenuItem changeSceneMenuItem16;
    @FXML
    public MenuItem changeSceneMenuItem17;
    @FXML
    public MenuItem changeSceneMenuItem18;
    @FXML
    public MenuItem changeSceneMenuItem19;
    @FXML
    public MenuItem changeSceneMenuItem20;

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
    public void changeSceneToUpdateDeleteCustomer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/updateDeleteCustomer.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem5.getParentPopup().getOwnerWindow().hide();
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
    public void changeSceneToViewOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/viewOrder.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem9.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeSceneToUpdateOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/updateDeleteOrder.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem10.getParentPopup().getOwnerWindow().hide();
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
    @FXML
    public void changeSceneToViewDetailOrder(ActionEvent actionEvent) {
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
    public void changeSceneToUpdateDetailOrder(ActionEvent actionEvent) {
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
    public void changeSceneToAddService(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/addService.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem6.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeSceneToUpdateDeleteService(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/updateDeleteService.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem8.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void changeSceneToServiceTable(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyek_bd/serviceTable.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            changeSceneMenuItem7.getParentPopup().getOwnerWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}