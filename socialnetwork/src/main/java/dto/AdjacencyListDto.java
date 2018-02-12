package dto;

import javafx.beans.property.SimpleStringProperty;

import java.util.Set;

public class AdjacencyListDto {
    private SimpleStringProperty node;
    private SimpleStringProperty adjacencyNodes;

    public AdjacencyListDto(String node, Set<String> setOfAdjacencyNodes) {
        this.node = new SimpleStringProperty(node);
        this.adjacencyNodes = new SimpleStringProperty(setOfAdjacencyNodes.toString());
    }

    public String getNode() {
        return node.get();
    }

    public SimpleStringProperty getNodeProperty() {
        return node;
    }

    public void setNode(String node) {
        this.node.set(node);
    }

    public String getAdjacencyNodes() {
        return adjacencyNodes.get();
    }

    public SimpleStringProperty getAdjacencyNodesProperty() {
        return adjacencyNodes;
    }

    public void setAdjacencyNodes(String adjacencyNodes) {
        this.adjacencyNodes.set(adjacencyNodes);
    }
}