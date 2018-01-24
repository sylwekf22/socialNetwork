package databasequeries;

import com.google.common.graph.MutableValueGraph;
import csv.CSVReader;

import java.util.HashMap;
import java.util.Map;

public class GraphOperation {
    private final CSVReader csvReader;
    private final GraphConverter graphConverter;
    private MutableValueGraph<String, String> graph;

    public GraphOperation() {
        this.csvReader = new CSVReader("data.csv");
        this.graphConverter = new GraphConverter(csvReader);
        this.graph = graphConverter.convertCSVToGraph();
    }

    public GraphOperation(String fileName) {
        this.csvReader = new CSVReader(fileName);
        this.graphConverter = new GraphConverter(csvReader);
        this.graph = graphConverter.convertCSVToGraph();
    }

    public int getAmountOfNodes(){
        return graph.nodes().size();
    }

    public int getAmountOfEdges(){
        return graph.edges().size();
    }

    public int getAmountOfDegrees(){
        int sum = 0;

        for (String node : graph.nodes()) {
            sum+=graph.degree(node);
        }
        return sum;
    }

    public Map<String, Integer> getListOfDegrees(){
        Map<String, Integer> mapOfDegrees = new HashMap<>();

        for (String node : graph.nodes()) {
            mapOfDegrees.put(node, graph.degree(node));
        }
        return mapOfDegrees;
    }

    public Map<String, Double> getListOfAverageDegrees(){
        Map<String, Double> mapOfAverageDegrees = new HashMap<>();

        double sumOfDegrees = (double) getAmountOfDegrees();

        for (String node : graph.nodes()) {
            mapOfAverageDegrees.put(node, graph.degree(node)/sumOfDegrees);
        }
        return mapOfAverageDegrees;
    }
}