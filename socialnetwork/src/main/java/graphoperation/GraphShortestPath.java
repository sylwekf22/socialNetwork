package graphoperation;

import com.google.common.graph.MutableValueGraph;
import writer.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GraphShortestPath {

    private MutableValueGraph<String, String> maxSubGraph;
    private int diameter;
    private int tempDiameter;
    private int radius;
    private double averageDistance;
    private boolean[] marked;
    private Queue<Node> queue;
    private List<String> nodeList;
    private List<String> targetNodeList;
    private List<Integer> nodePathSize;


    public GraphShortestPath(MutableValueGraph<String, String> maxSubGraph) {
        this.maxSubGraph = maxSubGraph;
        this.queue = new LinkedList<>();
        diameter = Integer.MIN_VALUE;
        radius = Integer.MAX_VALUE;
        marked = new boolean[this.maxSubGraph.nodes().size()];
        nodeList = getListOfNodes();

    }

    public int breadthFirstSearchRecursion(Node currentNode) {

        for (String childNodeName : maxSubGraph.adjacentNodes(currentNode.name)) {
            if (!marked[getIndexOfNode(childNodeName)]) {
                marked[getIndexOfNode(childNodeName)] = true;
                Node node = new Node(childNodeName, currentNode.pathSize + 1);
                queue.add(node);
            }
        }
        nodePathSize.add(currentNode.pathSize);
        targetNodeList.add(currentNode.name);

        if (tempDiameter < currentNode.pathSize) {
            tempDiameter = currentNode.pathSize;
        }

        if (queue.size() == 0) {
            return currentNode.pathSize;
        }
        return breadthFirstSearchRecursion(queue.poll()) + currentNode.pathSize;
    }

    public int breadthFirstSearchIteration(Node rootNode) {
        queue.add(rootNode);
        marked[getIndexOfNode(rootNode.name)] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            Node parent = queue.remove();
            Node child;
            distance += parent.pathSize;

            nodePathSize.add(parent.pathSize);
            targetNodeList.add(parent.name);
            if (tempDiameter < parent.pathSize) {
                tempDiameter = parent.pathSize;
            }
            for (String childNodeName : maxSubGraph.adjacentNodes(parent.name)) {
                if (!marked[getIndexOfNode(childNodeName)]) {
                    child = new Node(childNodeName, parent.pathSize + 1);
                    marked[getIndexOfNode(childNodeName)] = true;
                    queue.add(child);
                }
            }
        }
        return distance;
    }


    public void calculateShortestPath() throws IOException {

        Set<String> nodeSet = maxSubGraph.nodes();
        double currentCalculatedDistance = 0;
        int calculatedNodes = 0;
        CSVWriter csvWriter = new CSVWriter();
        FileWriter fileWriter = new FileWriter("nodePaths.csv");
        csvWriter.createHeaders(fileWriter);

        for (String startNode : nodeSet) {
            nodePathSize = new ArrayList<>();
            targetNodeList = new ArrayList<>();
            marked[getIndexOfNode(startNode)] = true;
            calculatedNodes++;
//            currentCalculatedDistance = breadthFirstSearchRecursion(new Node(startNode, 0));
            currentCalculatedDistance = breadthFirstSearchIteration(new Node(startNode, 0));
            updatePathDistanceProperty(currentCalculatedDistance, nodeSet.size());
            csvWriter.saveNodePaths(fileWriter, startNode, targetNodeList, nodePathSize);
            resetMarkings();
        }
        averageDistance /= nodeSet.size();
        fileWriter.close();
    }

    private void updatePathDistanceProperty(Double currentCalculatedDistance, int nodesSize) {

        averageDistance += currentCalculatedDistance / nodesSize;

        if (diameter < tempDiameter) {
            diameter = tempDiameter;
        }
        if (radius > tempDiameter) {
            radius = tempDiameter;
        }
        tempDiameter = 0;
    }

    private void resetMarkings() {

        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
    }

    private int getIndexOfNode(String node) {
        return nodeList.indexOf(node);
    }

    private List<String> getListOfNodes() {
        return maxSubGraph.nodes().stream().collect(Collectors.toList());
    }

    public int getGraphDiameter() {
        if (diameter == Integer.MAX_VALUE) {
            try {
                calculateShortestPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return diameter;
    }

    public int getGraphRadius() {
        if (radius == 0) {
            try {
                calculateShortestPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return radius;
    }

    public double getAverageNodeDistance() {
        return averageDistance;
    }

    class Node {
        private String name;
        private int pathSize;

        public Node(String name, int pathSize) {
            this.name = name;
            this.pathSize = pathSize;
        }
    }
}