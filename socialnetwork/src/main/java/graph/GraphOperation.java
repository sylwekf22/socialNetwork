package graph;

import com.google.common.graph.*;
import csv.CSVReader;

import java.util.*;
import java.util.stream.Collectors;

public class GraphOperation {
    private final GraphCreator graphCreator;

    public GraphOperation() {
        graphCreator = new GraphCreator("data.csv");
    }

    public int getNumberOfNodes(MutableValueGraph<String, String> graph){
        return graph.nodes().size();
    }

    public int getNumberOfEdges(MutableValueGraph<String, String> graph){
        return graph.edges().size();
    }

    public int getNumberOfDegrees(MutableValueGraph<String, String> graph){
        int sum = 0;

        for (String node : graph.nodes()) {
            sum+=graph.degree(node);
        }
        return sum;
    }

    public double getNumberOfAverageDegree(MutableValueGraph<String, String> graph){
        return getNumberOfDegrees(graph) / getNumberOfNodes(graph);
    }

    public Map<String, Integer> getListOfDegrees(MutableValueGraph<String, String> graph){
        Map<String, Integer> mapOfDegrees = new HashMap<>();

        for (String node : graph.nodes()) {
            mapOfDegrees.put(node, graph.degree(node));
        }
        return mapOfDegrees;
    }

    public Map<String, Double> getListOfAverageDegrees(MutableValueGraph<String, String> graph){
        Map<String, Double> mapOfAverageDegrees = new HashMap<>();

        double sumOfDegrees = (double) getNumberOfDegrees(graph);

        for (String node : graph.nodes()) {
            mapOfAverageDegrees.put(node, graph.degree(node)/sumOfDegrees);
        }
        return mapOfAverageDegrees;
    }

    public List<List<String>> getAdjacencyMatrix(MutableValueGraph<String, String> graph){
        return null;
    }

    public Map<String, Set<String>> getAdjacencyList(MutableValueGraph<String, String> graph){
        Map<String, Set<String>> adjacencyList = new HashMap<>();

        for(String node : graph.nodes()){
            adjacencyList.put(node, graph.adjacentNodes(node));
        }
        return adjacencyList;
    }

    public List<String> getListOfSortedNodes(MutableValueGraph<String, String> graph){
        return graph.nodes()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getListOfIsolatedNodes(MutableValueGraph<String, String> graph){
        List<String> isolatedNodes = new LinkedList<>();
        for (String node : graph.nodes()){
            if (graph.hasEdgeConnecting(node, node) && graph.degree(node) == 2){
                isolatedNodes.add(node);
            }
        }
        return isolatedNodes;
    }

    public MutableValueGraph<String, String> removeIsolatedNodes(MutableValueGraph<String, String> graph){
        List<String> listOfIsolatedNodes = getListOfIsolatedNodes(graph);
        MutableValueGraph<String, String> graphWithoutIsolatedNodes = graphCreator.createGraphFromFile();

        listOfIsolatedNodes.forEach(graphWithoutIsolatedNodes::removeNode);

        return graphWithoutIsolatedNodes;
    }
}