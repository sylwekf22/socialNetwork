package graphoperation;

import com.google.common.graph.MutableValueGraph;

import java.util.*;
import java.util.stream.Collectors;

public class GraphBreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private String[] edgeTo;
    private int[] distTo;

    private List<String> sortedListOfNodes;

    public GraphBreadthFirstPaths() {

    }

    public void doBreadthFirstSearch(MutableValueGraph<String, String> graph, Iterable<String> sources){
        Queue<String> queue = new LinkedList<>();
        for (String node : sources) {
            marked[getIndexOfNode(node)] = true;
            distTo[getIndexOfNode(node)] = 0;
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            String v = queue.remove();
            System.out.println(v);
            for (String w : graph.adjacentNodes(v)) {
                if (!marked[getIndexOfNode(w)]) {
                    edgeTo[getIndexOfNode(w)] = v;
                    distTo[getIndexOfNode(w)] = distTo[getIndexOfNode(v)] + 1;
                    marked[getIndexOfNode(w)] = true;
                    queue.add(w);
                }
            }
        }
    }

    public void countShortestPaths(MutableValueGraph<String, String> graph, Iterable<String> sources) {
        marked = new boolean[getNumberOfNodes(graph)];
        distTo = new int[getNumberOfNodes(graph)];
        edgeTo = new String[getNumberOfNodes(graph)];

        sortedListOfNodes = getListOfSortedNodes(graph);

        for (int v = 0; v < getNumberOfNodes(graph); v++) {
            distTo[v] = INFINITY;
        }

        doBreadthFirstSearch(graph, sources);
    }

    public void printResult(Iterable<String> sources){
        for (String node : sortedListOfNodes) {
            if (hasPathTo(node)) {
                System.out.print(sources + " " + node + " " + distTo(node));
                for (String x : pathTo(node)) {
                    for (String s : sources) {
                        if (x == s) {
                            System.out.print(x);
                        }
                        System.out.print(" " + x);
                    }
                }
                System.out.println();
            }
            System.out.println(sources + " " + node);
        }
    }

    public int distTo(String node) {
        return distTo[getIndexOfNode(node)];
    }

    public boolean hasPathTo(String node) {
        return marked[getIndexOfNode(node)];
    }

    public Iterable<String> pathTo(String node) {
        if (!hasPathTo(node)){
            return null;
        }

        Stack<String> path = new Stack<>();
        String x;
        for (x = node; distTo[getIndexOfNode(x)] != 0; x = edgeTo[getIndexOfNode(x)]) {
            path.push(x);
        }

        path.push(x);
        return path;
    }

    private List<String> getListOfSortedNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().stream().sorted().collect(Collectors.toList());
    }

    private int getIndexOfNode(String node) {
        return sortedListOfNodes.indexOf(node);
    }

    private int getNumberOfNodes(MutableValueGraph<String, String> graph) {
        return graph.nodes().size();
    }
}
