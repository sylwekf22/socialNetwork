package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Klasa uruchomieniowa okna wyników co 5 lat
public class FiveYearPeriodStatistics extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/views/FiveYearPeriodStatisticsView.fxml"));

            Parent parent = fxmlLoader.load();

            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("RSDS Five-year period statistics");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
