package graph;

import com.google.common.graph.MutableValueGraph;

import java.util.List;
import java.util.stream.Collectors;

public class GraphConnectedComponents {

    private boolean[] visitedNodes;
    private int[] arrayOfConnectedComponentInNode;
    private int[] numberOfNodesInComponent;
    private int connectedComponentsCounter;
    private List<String> sortedListOfNodes;

    public GraphConnectedComponents(MutableValueGraph<String, String> graph) {
        visitedNodes = new boolean[getNumberOfNodes(graph)];
        arrayOfConnectedComponentInNode = new int[getNumberOfNodes(graph)];
        numberOfNodesInComponent = new int[getNumberOfNodes(graph)];
        sortedListOfNodes = getListOfSortedNodes(graph);
    }

    public void doDepthFirstSearch(MutableValueGraph<String, String> graph, String startNode) {
        visitedNodes[getIndexOfNode(startNode)] = true;
        arrayOfConnectedComponentInNode[getIndexOfNode(startNode)] = connectedComponentsCounter;
        numberOfNodesInComponent[connectedComponentsCounter]++;

        for (String node : graph.adjacentNodes(startNode)) {
            if (!visitedNodes[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
            }
        }
    }

    public int countConnectedComponents(MutableValueGraph<String, String> graph){
        for (String node : getListOfSortedNodes(graph)){
            if (!visitedNodes[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
                connectedComponentsCounter++;
            }
        }
        return connectedComponentsCounter;
    }

    private List<String> getListOfSortedNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().stream().sorted().collect(Collectors.toList());
    }

    private int getNumberOfNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().size();
    }

    private int getIndexOfNode(String node) {
        return sortedListOfNodes.indexOf(node);
    }

    public int[] getArrayOfConnectedComponentInNode() {
        return arrayOfConnectedComponentInNode;
    }

    public int[] getNumberOfNodesInComponent() {
        return numberOfNodesInComponent;
    }

    public int getConnectedComponentsCounter() {
        return connectedComponentsCounter;
    }
}