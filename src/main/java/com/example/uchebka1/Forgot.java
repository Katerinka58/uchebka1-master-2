package com.example.uchebka1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Forgot {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button examination_button;

    @FXML
    private TextField loginText_forgot;

    @FXML
    private TextField paswordText_forgot;
    User user = new User();
    @FXML
    void back(MouseEvent event) {
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
    @FXML
    void initialize() {
        examination_button.setOnMouseClicked(e -> {
            String login = loginText_forgot.getText();
            String password = paswordText_forgot.getText();
            if (checkCredentials(login, password)) {
                openNewWindow();
            }
            else {
            }
        });
    }


    private boolean checkCredentials(String login, String phone) {
        DataHelper dbHandler = new DataHelper();

        user.setLogin(login);
        user.setPhone(phone);
        ResultSet result = dbHandler.getUserF(user);
        try {
            if (result.next()) {
                user.setPhone(result.getString("phone"));
                user.setLogin(result.getString("login"));
                openNewWindow();
            } else {
                showAlert("Пользователь не найден.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void openNewWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Password_recovery2.fxml"));
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
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

