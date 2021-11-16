package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class InventoryManagementApplication extends javafx.application.Application {
    public static Stage stage;

    @Override
    public void start(Stage stagein) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InventoryManagementApplication.fxml")));

        this.stage = stagein;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet1.css").toExternalForm());
        stage.setTitle("Inventory Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
