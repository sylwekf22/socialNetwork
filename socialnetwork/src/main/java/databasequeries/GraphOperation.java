package databasequeries;

import com.google.common.graph.MutableValueGraph;
import csv.CSVReader;

public class GraphOperation {
    private final CSVReader csvReader;
    private final GraphConverter graphConverter;
    private MutableValueGraph<String, String> graph;

    public GraphOperation() {
        this.csvReader = new CSVReader("data.csv");
        this.graphConverter = new GraphConverter(csvReader);
        this.graph = graphConverter.convertCSVToGraph();
    }

    public int getAmountOfNodes(){
        return graph.nodes().size();
    }

    public int getAmountOfEdges(){
        return graph.edges().size();
    }
}