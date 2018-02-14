package graphoperation;

import com.google.common.graph.*;
import creator.GuavaGraphCreator;
import writer.CSVWriter;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.GraphMeasurer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Klasa z operacjami na grafie
public class GraphOperation {

    public GraphOperation(){ }

    // Pobierz liczbę wierzchołków
    public int getNumberOfNodes(MutableValueGraph<String, String> graph){
        return graph.nodes().size();
    }

    // Pobierz liczbę krawędzi
    public int getNumberOfEdges(MutableValueGraph<String, String> graph){
        return graph.edges().size();
    }

    // Pobierz liczbę stopni wierzchołka
    public int getNumberOfDegrees(MutableValueGraph<String, String> graph){
        int sum = 0;

        for (String node : graph.nodes()) {
            sum+=graph.degree(node);
        }
        return sum;
    }

    // Pobierz liczbę średniej wartości stopni wierzchołka
    public double getNumberOfAverageDegree(MutableValueGraph<String, String> graph){
        return (double)getNumberOfDegrees(graph) / (double)getNumberOfNodes(graph);
    }

    // Pobierz listę sąsiedztwa
    public Map<String, Integer> getListOfDegrees(MutableValueGraph<String, String> graph){
        Map<String, Integer> mapOfDegrees = new HashMap<>();

        for (String node : graph.nodes()) {
            mapOfDegrees.put(node, graph.degree(node));
        }
        return mapOfDegrees;
    }

    // Pobierz listę średnich wartości stopni wierzchołka
    public Map<String, Double> getListOfAverageDegrees(MutableValueGraph<String, String> graph){
        Map<String, Double> mapOfAverageDegrees = new HashMap<>();

        double sumOfDegrees = (double) getNumberOfDegrees(graph);

        for (String node : graph.nodes()) {
            mapOfAverageDegrees.put(node, graph.degree(node)/sumOfDegrees);
        }
        return mapOfAverageDegrees;
    }

    // Pobierz średnicę
    public double getGraphDiameter(Graph<String, String> graph){
        GraphMeasurer<String, String> graphMeasurer = new GraphMeasurer (graph);
        return graphMeasurer.getDiameter();
    }

    // Pobierz promień
    public double getGraphRadius(Graph<String, String> graph){
        GraphMeasurer<String, String> graphMeasurer = new GraphMeasurer (graph);
        return graphMeasurer.getRadius();
    }

    // Generowanie i zapisywanie ścieżek do pliku CSV
    public void saveNodePths(MutableValueGraph<String, String> graph, String fileName) throws IOException {

        GraphConnectedComponents connectedComponents = new GraphConnectedComponents();
        connectedComponents.countConnectedComponents(graph);
        connectedComponents.computeListOfConnectedComponents();
        List<String> maxSubGraphList = connectedComponents.findTheBiggestConnectedComponentsList();
        MutableValueGraph<String, String> maxSubGraph = connectedComponents.calculateMaxSubGraph(graph, maxSubGraphList, fileName);

        GraphShortestPath graphShortestPath = new GraphShortestPath(maxSubGraph);
        graphShortestPath.calculateShortestPath();
    }

    // Metoda zapisująca macierz sąsiedztwa
    public void saveAdjacencyMatrix(MutableValueGraph<String, String> graph) throws IOException {
        Set<String> nodes = graph.nodes();
        int amountOfNodes = nodes.size();
        List<Set<String>> adjacencySet = new ArrayList<>(amountOfNodes);
        CSVWriter csvWriter = new CSVWriter();

        for(String node : nodes){
            adjacencySet.add(graph.adjacentNodes(node));
        }
        csvWriter.savAdjacencyMatrixToTXT(new FileWriter("adjacencyMatrix.txt"), adjacencySet, nodes);
    }

    // Pobierz map sąsiedztwa
    public Map<String, Set<String>> getAdjacencyMap(MutableValueGraph<String, String> graph){
        Map<String, Set<String>> adjacencyList = new HashMap<>();

        for(String node : graph.nodes()){
            adjacencyList.put(node, graph.adjacentNodes(node));
        }
        return adjacencyList;
    }

    // Pobierz listę posortowanych wierzchołków
    public List<String> getListOfSortedNodes(MutableValueGraph<String, String> graph){
        return graph.nodes()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Pobierz listę wierzchołków odizolowanych
    public List<String> getListOfIsolatedNodes(MutableValueGraph<String, String> graph){
        List<String> isolatedNodes = new LinkedList<>();
        for (String node : graph.nodes()){
            if (graph.hasEdgeConnecting(node, node) && graph.degree(node) == 2){
                isolatedNodes.add(node);
            }
        }
        return isolatedNodes;
    }

    // Metoda usuwająca węzły odizolowane
    public MutableValueGraph<String, String> removeIsolatedNodes(MutableValueGraph<String, String> graph, String fileName){
        List<String> listOfIsolatedNodes = getListOfIsolatedNodes(graph);
        GuavaGraphCreator guavaGraphCreator = new GuavaGraphCreator(fileName);
        MutableValueGraph<String, String> graphWithoutIsolatedNodes = guavaGraphCreator.createGraphFromFile();

        listOfIsolatedNodes.forEach(graphWithoutIsolatedNodes::removeNode);

        return graphWithoutIsolatedNodes;
    }

    // Metoda usuwająca wierzchołki
    public MutableValueGraph<String, String> removeNodes(MutableValueGraph<String, String> graph, List<String> listOfNodes, String fileName){
        List<String> listOfSortedNodes = getListOfSortedNodes(graph);

        GuavaGraphCreator guavaGraphCreator = new GuavaGraphCreator(fileName);
        MutableValueGraph<String, String> newGraph = guavaGraphCreator.createGraphFromFile();

        for (String node : listOfSortedNodes) {
            if (!listOfNodes.contains(node)) {
                newGraph.removeNode(node);
            }
        }
        return newGraph;
    }
}