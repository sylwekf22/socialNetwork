package sample;

import com.google.common.graph.MutableValueGraph;
import csv.CSVReader;
import graph.*;
import javafx.fxml.FXML;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        CSVReader csvReader = new CSVReader("data.csv");
        GraphCreator graphCreator = new GraphCreator(csvReader);
        MutableValueGraph<String, String> graph = graphCreator.createGraphFromFile();
        GraphConnectedComponents graphConnectedComponents = new GraphConnectedComponents(graph);
        int countConnectedComponents = graphConnectedComponents.countConnectedComponents(graph);
    }

    private Main main;
}