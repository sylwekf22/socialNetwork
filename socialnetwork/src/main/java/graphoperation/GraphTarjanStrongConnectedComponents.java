package graphoperation;

import com.google.common.graph.MutableValueGraph;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GraphTarjanStrongConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int[] low;
    private int pre;
    private int count;
    private Stack<String> stack;

    private List<String> sortedListOfNodes;

    public GraphTarjanStrongConnectedComponents() {
    }

    public void doDepthFirstSearch(MutableValueGraph<String, String> graph, String startNode) {
        marked[getIndexOfNode(startNode)] = true;
        low[getIndexOfNode(startNode)] = pre++;
        int min = low[getIndexOfNode(startNode)];
        stack.push(startNode);

        for (String node : graph.adjacentNodes(startNode)) {
            if (!marked[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
            }
            if (low[getIndexOfNode(node)] < min){
                min = low[getIndexOfNode(node)];
            }
        }
        if (min < low[getIndexOfNode(startNode)]) {
            low[getIndexOfNode(startNode)] = min;
            return;
        }

        String node;
        do {
            node = stack.pop();
            id[getIndexOfNode(node)] = count;
            low[getIndexOfNode(node)] = getNumberOfNodes(graph);
        } while (!node.equals(startNode));
        count++;
    }

    public void countStrongConnectedComponents(MutableValueGraph<String, String> graph){
        marked = new boolean[getNumberOfNodes(graph)];
        stack = new Stack<>();
        id = new int[getNumberOfNodes(graph)];
        low = new int[getNumberOfNodes(graph)];

        sortedListOfNodes = getListOfSortedNodes(graph);

        for (String node : getListOfSortedNodes(graph)) {
            if (!marked[getIndexOfNode(node)]) {
                doDepthFirstSearch(graph, node);
            }
        }
    }

    private int getNumberOfNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().size();
    }

    private int getIndexOfNode(String node) {
        return sortedListOfNodes.indexOf(node);
    }

    private List<String> getListOfSortedNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().stream().sorted().collect(Collectors.toList());
    }

    public int getId(String node) {
        return id[getIndexOfNode(node)];
    }

    public int getCount() {
        return count;
    }
}
