package sample;

import com.google.common.graph.MutableValueGraph;
import graph.*;
import javafx.fxml.FXML;

import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        GraphCreator graphCreator = new GraphCreator("data.csv");

        GraphOperation graphOperation = new GraphOperation();

        MutableValueGraph<String, String> graph = graphCreator.createGraphFromFile();
        MutableValueGraph<String, String> valueGraph = graphOperation.removeIsolatedNodes(graph);

        GraphConnectedComponents graphConnectedComponents = new GraphConnectedComponents(valueGraph);
        graphConnectedComponents.countConnectedComponents(valueGraph);
        graphConnectedComponents.computeListOfConnectedComponents();
        graphConnectedComponents.printListOfConnectedComponents();
        
        int theSmallestConnectedComponents = graphConnectedComponents.findTheSmallestConnectedComponents();
        int theBiggestConnectedComponents = graphConnectedComponents.findTheBiggestConnectedComponents();
        System.out.println(theSmallestConnectedComponents + " " + theBiggestConnectedComponents);
    }

    private Main main;
}