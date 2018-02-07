package sample;


import csv.CSVReader;
import graph.GraphCreator;
import graph.GraphCreatorToCalculation;
import graph.GraphOperation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.GraphMeasurer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        GraphOperation graphopeation = new GraphOperation();
        //GraphCreator graphCreator = new GraphCreator("data.csv");
       // MutableValueGraph<String,String> graph = graphCreator.createGraphFromFile();
        GraphCreatorToCalculation graphCreatorToCalculation = new GraphCreatorToCalculation(new CSVReader("data.csv"));
        Graph<String, String> graph = graphCreatorToCalculation.createGraphFromFile();
        graphopeation.getGraphDiameter(graph);
        launch(args);
    }
}