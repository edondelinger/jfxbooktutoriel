package com.example.bookapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField monID;
    @FXML
    private TextField monMDP;
    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        String id, mdp;

        id = monID.getText();
        mdp = monMDP.getText();

        if (id.equals("admin") && mdp.equals("admin")) {

            Stage newWindow = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accueil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            newWindow.setScene(scene);
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText("Connexion");
            alert.setContentText("utilisateur non reconnu. Réessayez !");
            alert.showAndWait();
        }

    }
}