package com.example.uchebka1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Klient {

    @FXML private Button back;
    @FXML private MenuItem conference;
    @FXML private Button contacts;
    @FXML private MenuItem del_mer;
    @FXML private MenuItem festival;
    @FXML private MenuItem korporetion;
    @FXML private MenuItem marriage;
    @FXML private MenuItem online_mer;
    @FXML private Button portfolio;
    @FXML private Button prices;
    @FXML private MenuButton services;
    @FXML
    public void initialize() {
        marriage.setOnAction(even -> services.setText(marriage.getText()));
        festival.setOnAction(even -> services.setText(festival.getText()));

    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void back(MouseEvent mouseEvent) {
        back.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Avtiriz.xml.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
     public void setContacts(){
        contacts.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Avtiriz.xml.fxml"));
         try {
             loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         Parent root = loader.getRoot();
         Stage stage = new Stage();
         stage.setScene(new Scene(root));
         stage.show();     }
}
