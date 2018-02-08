package graph;

import com.google.common.graph.MutableValueGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;
    private List<String> sortedListOfNodes;
    private List[] components;

    public GraphConnectedComponents(MutableValueGraph<String, String> graph) {
        marked = new boolean[getNumberOfNodes(graph)];
        id = new int[getNumberOfNodes(graph)];
        size = new int[getNumberOfNodes(graph)];
        sortedListOfNodes = getListOfSortedNodes(graph);
    }

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

    public void countConnectedComponents(MutableValueGraph<String, String> graph){
        for (String node : sortedListOfNodes){
            if (!marked[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
                count++;
            }
        }
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

    public void printListOfConnectedComponents(){
        int numberOfConnectedComponents = getCount();
        for (int i = 0; i < numberOfConnectedComponents; i++) {
            System.out.println("Component : " + i + " Nodes : " + components[i]);
        }
    }

    public int findTheBiggestConnectedComponents(){
        int numberOfConnectedComponents = getCount();
        int max = 0;
        for (int i = 0; i < numberOfConnectedComponents; i++) {
            if (components[i].size() > max) {
                max = components[i].size();
            }
        }
        return max;
    }

    public int findTheSmallestConnectedComponents(){
        int numberOfConnectedComponents = getCount();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfConnectedComponents; i++) {
            if (components[i].size() < min) {
                min = components[i].size();
            }
        }
        return min;
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