package com.example.uchebka1;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Contacts {
        @FXML private ResourceBundle resources;
        @FXML private URL location;
        @FXML private Button back;
        @FXML private ImageView gmail_image;
        @FXML private ImageView instagram_image;
        @FXML private ImageView telegram_image;
        @FXML private ImageView vk_image;
        @FXML
        void back(MouseEvent event) {
        }
        @FXML
        void initialize() {
                gmail_image.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> openWebPage("https://mail.ru/"));
                instagram_image.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> openWebPage("https://www.instagram.com"));
                telegram_image.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> openWebPage("https://web.telegram.org"));
                vk_image.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> openWebPage("https://vk.com/id412335172"));
        }

        private void openWebPage(String url) {
                try {
                        Desktop.getDesktop().browse(new URL(url).toURI());
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }
        public void setBack (MouseEvent mouseEvent) {
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
}



