package graphoperation;

import com.google.common.graph.MutableValueGraph;
import creator.GuavaGraphCreator;

import java.util.*;
import java.util.stream.Collectors;

// Klasa do obliczania spójnych składowych
public class GraphConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;
    private List<String> sortedListOfNodes;
    private List[] components;

    public GraphConnectedComponents() {
    }

    // Implementacja przeszukiwania w głąb
    public void doDepthFirstSearch(MutableValueGraph<String, String> graph, String startNode) {
        marked[getIndexOfNode(startNode)] = true;
        id[getIndexOfNode(startNode)] = count;
        size[count]++;

        for (String node : graph.adjacentNodes(startNode)) {
            if (!marked[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
            }
        }
    }

    // Metoda oblicza spójne składowe
    public void countConnectedComponents(MutableValueGraph<String, String> graph){
        marked = new boolean[getNumberOfNodes(graph)];
        id = new int[getNumberOfNodes(graph)];
        size = new int[getNumberOfNodes(graph)];
        sortedListOfNodes = getListOfSortedNodes(graph);

        for (String node : sortedListOfNodes){
            if (!marked[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
                count++;
            }
        }
    }

    // Pobierz posortowaną listę wierzchołków
    private List<String> getListOfSortedNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().stream().sorted().collect(Collectors.toList());
    }

    // Pobierz liczbę wierzchołków
    private int getNumberOfNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().size();
    }

    // Pobierz indeks wierzchołka
    private int getIndexOfNode(String node) {
        return sortedListOfNodes.indexOf(node);
    }

    // Tworzenie tablicy spójnych komponentów
    public void computeListOfConnectedComponents(){
        int numberOfConnectedComponents = getCount();
        components = new List[numberOfConnectedComponents];

        for (int i = 0; i < numberOfConnectedComponents; i++) {
            components[i] = new LinkedList();
        }

        for (String node : sortedListOfNodes) {
            components[getNodeId(node)].add(node);
        }
    }

    // Metoda opisująca spójne składowe
    public void printListOfConnectedComponents(){
        for (int i = 0; i < components.length; i++) {
            System.out.println("Component : " + i + " Nodes : " + components[i]);
        }
    }

    // Znajdź największą spójną składową
    public int findTheBiggestConnectedComponent(){
        int max = 0;
        for (int i = 0; i < components.length; i++) {
            if (components[i].size() > max) {
                max = components[i].size();
            }
        }
        return max;
    }

    // Znajdź największą spójną składową z mapy
    public int findTheBiggestConnectedComponentFromMap(Map<String, Set<String>> mapOfConnectedComponents){
        int max = 0;
        for (Set<String> connectedComponent : mapOfConnectedComponents.values()) {
            if (connectedComponent.size() > max) {
                max = connectedComponent.size();
            }
        }
        return max;
    }

    // Znajdź największe spójne składowe
    public int findTheBiggestConnectedComponents(int theBiggestConnectedComponent){
        int theBiggestConnectedComponentCounter = 0;
        for (int i = 0; i < components.length; i++) {
            if (components[i].size() == theBiggestConnectedComponent) {
                theBiggestConnectedComponentCounter++;
            }
        }
        return theBiggestConnectedComponentCounter;
    }

    // Znajdź największe spójne składowe za pomocą mapy
    public int findTheBiggestConnectedComponentsFromMap(int theBiggestConnectedComponent, Map<String, Set<String>> mapOfConnectedComponents){
        int theBiggestConnectedComponentCounter = 0;
        for (Set<String> connectedComponent : mapOfConnectedComponents.values()) {
            if (connectedComponent.size() ==  theBiggestConnectedComponent) {
                theBiggestConnectedComponentCounter++;
            }
        }
        return theBiggestConnectedComponentCounter;
    }

    // Znajdź najmniejszą spójną składową
    public int findTheSmallestConnectedComponent(){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < components.length; i++) {
            if (components[i].size() < min) {
                min = components[i].size();
            }
        }
        return min;
    }

    // Znajdź najmniejszą spójną składową za pomocą grafu
    public int findTheSmallestConnectedComponentFromMap(Map<String, Set<String>> mapOfConnectedComponents){
        int min = Integer.MAX_VALUE;
        for (Set<String> connectedComponent : mapOfConnectedComponents.values()) {
            if (connectedComponent.size() <  min) {
                min = connectedComponent.size();
            }
        }
        return min;
    }

    // Znajdź najwiekszą spójną składową
    public List getTheBiggestConnectedComponent(){
        int max = 0;
        List<String> componentNodes = new LinkedList<>();
        for (int i = 0; i < components.length; i++) {
            if (components[i].size() > max) {
                max = components[i].size();
                componentNodes = new LinkedList<>(components[i]);
            }
        }
        return componentNodes;
    }

    // Pobierz najwięszą spójną składową
    public List getTheBiggestConnectedComponent(Map<String, Set<String>> mapOfConnectedComponents){
        int max = 0;
        List<String> componentNodes = new LinkedList<>();
        for (Map.Entry<String, Set<String>> map : mapOfConnectedComponents.entrySet()) {
            if (map.getValue().size() > max) {
                max = map.getValue().size();
                componentNodes = new LinkedList<>(map.getValue());
            }
        }
        return componentNodes;
    }

    // Pobierz mapę identycznych spójnych skłądowych
    public Map<Integer, List<Integer>> getMapOfIdenticalComponentsLength(){
        Map<Integer, List<Integer>> mapOfComponentsLength = new HashMap<>();
        int theBiggestConnectedComponent = findTheBiggestConnectedComponent();
        int componentLength = 1;

        while (componentLength <= theBiggestConnectedComponent) {
            List<Integer> listOfComponents = new LinkedList<>();
            for (int i = 0; i < components.length; i++) {
                if (components[i].size() == componentLength) {
                    listOfComponents.add(i);
                }
            }
            mapOfComponentsLength.put(componentLength, listOfComponents);
            componentLength++;
        }
        return mapOfComponentsLength;
    }

    // Pobierz najwięszą spójną składową
    public List<String> findTheBiggestConnectedComponentsList(){
        int numberOfConnectedComponents = getCount();
        List<String> maxSubGraphList = null;
        int max = 0;
        for (int i = 0; i < numberOfConnectedComponents; i++) {
            if (components[i].size() > max) {
                max = components[i].size();
                maxSubGraphList =  components[i];
            }
        }
        return maxSubGraphList;
    }

    // Zwraca nawiększy podgraf
    public MutableValueGraph<String, String> calculateMaxSubGraph(MutableValueGraph<String, String> graph, List<String> maxSubGraphList, String fileName){

        GuavaGraphCreator guavaGraphCreator = new GuavaGraphCreator(fileName);
        MutableValueGraph<String, String> graphFromFile = guavaGraphCreator.createGraphFromFile();

        GraphOperation graphOperation = new GraphOperation();
        MutableValueGraph<String, String> stringStringMutableValueGraph = graphOperation.removeIsolatedNodes(graphFromFile, fileName);

        Set<String> graphVertex = stringStringMutableValueGraph.nodes();

        Iterator<String> vertexIterator = graphVertex.iterator();
        List<String> vertexToDelete = new LinkedList<>();
        String vertex;
        while(vertexIterator.hasNext()){
            vertex = vertexIterator.next();
            if (!maxSubGraphList.contains(vertex)){
                vertexToDelete.add(vertex);
            }
        }
        removeVertex(vertexToDelete, stringStringMutableValueGraph);
        return stringStringMutableValueGraph;
    }

    // Metoda usuwająca wierzchołki
    private void removeVertex(List<String> vertexes, MutableValueGraph<String, String> graph){
        for(String vertex : vertexes){
            graph.removeNode(vertex);
        }
    }

    public int[] getId() {
        return id;
    }

    public int getNodeId(String node){
        return id[getIndexOfNode(node)];
    }

    public int[] getSize() {
        return size;
    }

    public int getNodeSize(String node){
        return size[id[getIndexOfNode(node)]];
    }

    public int getCount() {
        return count;
    }

    public List[] getComponents() {
        return components;
    }
}