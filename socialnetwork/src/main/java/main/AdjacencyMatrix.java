package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Klasa uruchomieniowa okna macierz sąsiedztwa
public class AdjacencyMatrix extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/views/AdjacencyMatrixView.fxml"));

            Parent parent = fxmlLoader.load();

            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("RSDS Adjacency Matrix");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
