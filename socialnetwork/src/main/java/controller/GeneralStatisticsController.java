package controller;

import com.google.common.graph.MutableValueGraph;
import creator.GuavaConnectedComponentsCreator;
import dto.AdjacencyListDto;
import graphoperation.GraphConnectedComponents;
import graphoperation.GraphOperation;
import creator.GuavaGraphCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.AdjacencyMatrix;

import java.util.Map;
import java.util.Set;

public class GeneralStatisticsController {
    public GeneralStatisticsController() {
        guavaGraphCreator = new GuavaGraphCreator("data.csv");
        graph = guavaGraphCreator.createGraphFromFile();

        graphOperation = new GraphOperation();
        graphWithoutIsolatedNodes = graphOperation.removeIsolatedNodes(graph, "data.csv");

        guavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("isolated_data_connected_components.csv");
        connectedComponentsMap = guavaConnectedComponentsCreator.createConnectedComponentsMap();

        graphConnectedComponents = new GraphConnectedComponents();
    }

    @FXML
    private void initialize() {
        numberOfNodesValueLabel.setText(String.valueOf(graphOperation.getNumberOfNodes(graph)));
        numberOfEdgesValueLabel.setText(String.valueOf(graphOperation.getNumberOfEdges(graph)));
        averageDegreeOfNodesValueLabel.setText(String.valueOf(graphOperation.getNumberOfAverageDegree(graph)));
        numberOfIsolatedNodesValueLabel.setText(String.valueOf(graphOperation.getListOfIsolatedNodes(graph).size()));
        numberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(graphOperation.getNumberOfNodes(graphWithoutIsolatedNodes)));
        averageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(graphOperation.getNumberOfAverageDegree(graphWithoutIsolatedNodes)));
        numberOfComponentsValueLabel.setText(String.valueOf(connectedComponentsMap.size()));

        int theSmallestConnectedComponent = graphConnectedComponents.findTheSmallestConnectedComponentFromMap(connectedComponentsMap);
        int theBiggestConnectedComponent = graphConnectedComponents.findTheBiggestConnectedComponentFromMap(connectedComponentsMap);

        rangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        numberTheGreatestComponentValueLabel.
                setText(String.valueOf(graphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, connectedComponentsMap)));


        fillAdjacencyList();
        setAdjacencyTableByItems();

        nodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        adjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    @FXML
    private void showAdjacencyMatrix(){
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix();
        adjacencyMatrix.start(new Stage());
    }

    private void fillAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = graphOperation.getAdjacencyMap(graphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            adjacencyList.add(adjacencyListDto);
        }
    }

    private void setAdjacencyTableByItems() {
        adjacencyListTableView.setItems(adjacencyList);
    }

    public void printAlert(String title, String headerText, String contextText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

    @FXML
    private Label rsdsSocialNetwork;

    @FXML
    private Label summary;

    @FXML
    private GridPane generalStatisticsGridPane;

    @FXML
    private Label numberOfNodesLabel;

    @FXML
    private Label numberOfEdgesLabel;

    @FXML
    private Label averageDegreeOfNodesLabel;

    @FXML
    private Label numberOfIsolatedNodesLabel;

    @FXML
    private Label numberOfNodesAfterDeletionOfIsolatedNodesLabel;

    @FXML
    private Label averageDegreeOfNodesAfterDeletionLabel;

    @FXML
    private Label numberOfComponentsLabel;

    @FXML
    private Label rangeOfNumberOfNodesLabel;

    @FXML
    private Label numberTheGreatestComponentLabel;

    @FXML
    private Label distributionOfDistancesLabel;

    @FXML
    private Label averageDistanceBetweenNodesLabel;

    @FXML
    private Label diameterOfComonentLabel;

    @FXML
    private Label radiousOfComponentLabel;


    @FXML
    private Label numberOfNodesValueLabel;

    @FXML
    private Label numberOfEdgesValueLabel;

    @FXML
    private Label averageDegreeOfNodesValueLabel;

    @FXML
    private Label numberOfIsolatedNodesValueLabel;

    @FXML
    private Label numberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label averageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label numberOfComponentsValueLabel;

    @FXML
    private Label rangeOfNumberOfNodesValueLabel;

    @FXML
    private Label numberTheGreatestComponentValueLabel;

    @FXML
    private Label distributionOfDistancesValueLabel;

    @FXML
    private Label averageDistanceBetweenNodesValueLabel;

    @FXML
    private Label diameterOfComonentValueLabel;

    @FXML
    private Label radiousOfComponentValueLabel;


    @FXML
    private Label adjacencyListLabel;

    @FXML
    private TableView<AdjacencyListDto> adjacencyListTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> nodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> adjacencyNodesTableColumn;

    @FXML
    private Label adjacencyMatrixLabel;

    @FXML
    private Button adjacencyMatrixButton;

    private GuavaGraphCreator guavaGraphCreator;
    private GuavaConnectedComponentsCreator guavaConnectedComponentsCreator;

    private GraphOperation graphOperation;
    private GraphConnectedComponents graphConnectedComponents;

    private Map<String, Set<String>> connectedComponentsMap;

    private MutableValueGraph<String, String> graph;
    private MutableValueGraph<String, String> graphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> adjacencyList = FXCollections.observableArrayList();
}
