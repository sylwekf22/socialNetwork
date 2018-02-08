package sample;

import com.google.common.graph.MutableValueGraph;
import graph.GraphConnectedComponents;
import graph.GraphOperation;
import graphcreator.GuavaGraphCreator;
import javafx.fxml.FXML;

import java.util.List;
import java.util.Map;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        GraphOperation graphOperation = new GraphOperation();
        GuavaGraphCreator guavaGraphCreator = new GuavaGraphCreator("data.csv");
        MutableValueGraph<String, String> graph = guavaGraphCreator.createGraphFromFile();

        GraphConnectedComponents graphConnectedComponents = new GraphConnectedComponents();
        graphConnectedComponents.countConnectedComponents(graph);
        graphConnectedComponents.computeListOfConnectedComponents();
        Map<Integer, List<Integer>> mapOfIdenticalComponentsLength = graphConnectedComponents.getMapOfIdenticalComponentsLength();

        for (Map.Entry<Integer, List<Integer>> map : mapOfIdenticalComponentsLength.entrySet()) {
            System.out.println(map.getKey() +" " + map.getValue().toString());
        }
    }

    private Main main;
}