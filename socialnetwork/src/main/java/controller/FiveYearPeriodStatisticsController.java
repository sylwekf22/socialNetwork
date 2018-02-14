package controller;

import com.google.common.graph.MutableValueGraph;
import creator.GuavaConnectedComponentsCreator;
import creator.GuavaGraphCreator;
import dto.AdjacencyListDto;
import graphoperation.GraphConnectedComponents;
import graphoperation.GraphOperation;
import graphoperation.GraphShortestPath;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Kontroler wyników co 5 lat grafu
public class FiveYearPeriodStatisticsController {
    public FiveYearPeriodStatisticsController() throws IOException {
        setFirstData();
        setSecondData();
        setThirdData();
        setFourthData();
        setFifthData();
        setSixthData();
    }

    // Metody ustawiające zmiennej w kontrolerze
    private void setFirstData() throws IOException {
        firstGuavaGraphCreator = new GuavaGraphCreator("1981-1985.csv");
        firstGraph = firstGuavaGraphCreator.createGraphFromFile();

        firstGraphOperation = new GraphOperation();
        firstGraphWithoutIsolatedNodes = firstGraphOperation.removeIsolatedNodes(firstGraph, "1981-1985.csv");

        firstGuavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("1981-1985_graph_without_isolated_nodes_connected_components.csv");
        firstConnectedComponentsMap = firstGuavaConnectedComponentsCreator.createConnectedComponentsMap();

        firstGraphConnectedComponents = new GraphConnectedComponents();

        firstTheBiggestConnectedComponent = firstGraphConnectedComponents.getTheBiggestConnectedComponent(firstConnectedComponentsMap);

        MutableValueGraph<String, String> mutableValueGraph = firstGraphConnectedComponents.
                calculateMaxSubGraph(firstGraphWithoutIsolatedNodes, firstTheBiggestConnectedComponent, "1981-1985.csv");

        firstGraphShortestPath = new GraphShortestPath(mutableValueGraph);
        firstGraphShortestPath.calculateShortestPath();
        firstGraphOperation.saveNodePths(mutableValueGraph, "1981-1985.csv");
    }

    private void setSecondData() throws IOException {
        secondGuavaGraphCreator = new GuavaGraphCreator("1981-1990.csv");
        secondGraph = secondGuavaGraphCreator.createGraphFromFile();

        secondGraphOperation = new GraphOperation();
        secondGraphWithoutIsolatedNodes = secondGraphOperation.removeIsolatedNodes(secondGraph, "1981-1990.csv");

        secondGuavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("1981-1990_graph_without_isolated_nodes_connected_components.csv");
        secondConnectedComponentsMap = secondGuavaConnectedComponentsCreator.createConnectedComponentsMap();

        secondGraphConnectedComponents = new GraphConnectedComponents();

        secondTheBiggestConnectedComponent = secondGraphConnectedComponents.getTheBiggestConnectedComponent(secondConnectedComponentsMap);

        MutableValueGraph<String, String> mutableValueGraph = secondGraphConnectedComponents.
                calculateMaxSubGraph(secondGraphWithoutIsolatedNodes, secondTheBiggestConnectedComponent, "1981-1990.csv");

        secondGraphShortestPath = new GraphShortestPath(mutableValueGraph);
        secondGraphShortestPath.calculateShortestPath();
        secondGraphOperation.saveNodePths(mutableValueGraph, "1981-1990.csv");
    }

    private void setThirdData() throws IOException {
        thirdGuavaGraphCreator = new GuavaGraphCreator("1981-1995.csv");
        thirdGraph = thirdGuavaGraphCreator.createGraphFromFile();

        thirdGraphOperation = new GraphOperation();
        thirdGraphWithoutIsolatedNodes = thirdGraphOperation.removeIsolatedNodes(thirdGraph, "1981-1995.csv");

        thirdGuavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("1981-1995_graph_without_isolated_nodes_connected_components.csv");
        thirdConnectedComponentsMap = thirdGuavaConnectedComponentsCreator.createConnectedComponentsMap();

        thirdGraphConnectedComponents = new GraphConnectedComponents();

        thirdTheBiggestConnectedComponent = thirdGraphConnectedComponents.getTheBiggestConnectedComponent(thirdConnectedComponentsMap);

        MutableValueGraph<String, String> mutableValueGraph = thirdGraphConnectedComponents.
                calculateMaxSubGraph(thirdGraphWithoutIsolatedNodes, thirdTheBiggestConnectedComponent, "1981-1995.csv");

        thirdGraphShortestPath = new GraphShortestPath(mutableValueGraph);
        thirdGraphShortestPath.calculateShortestPath();
        thirdGraphOperation.saveNodePths(mutableValueGraph, "1981-1995.csv");
    }

    private void setFourthData() throws IOException {
        fourthGuavaGraphCreator = new GuavaGraphCreator("1981-2000.csv");
        fourthGraph = fourthGuavaGraphCreator.createGraphFromFile();

        fourthGraphOperation = new GraphOperation();
        fourthGraphWithoutIsolatedNodes = fourthGraphOperation.removeIsolatedNodes(fourthGraph, "1981-2000.csv");

        fourthGuavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("1981-2000_graph_without_isolated_nodes_connected_components.csv");
        fourthConnectedComponentsMap = fourthGuavaConnectedComponentsCreator.createConnectedComponentsMap();

        fourthGraphConnectedComponents = new GraphConnectedComponents();

//        fourthTheBiggestConnectedComponent = fourthGraphConnectedComponents.getTheBiggestConnectedComponent(fourthConnectedComponentsMap);
//
//        MutableValueGraph<String, String> mutableValueGraph = fourthGraphConnectedComponents.
//                calculateMaxSubGraph(fourthGraphWithoutIsolatedNodes, fourthTheBiggestConnectedComponent, "1981-2000.csv");
//
//        fourthGraphShortestPath = new GraphShortestPath(mutableValueGraph);
//        fourthGraphShortestPath.calculateShortestPath();
//        fourthGraphOperation.saveNodePths(mutableValueGraph, "1981-2000.csv");
    }

    private void setFifthData() {
        fifthGuavaGraphCreator = new GuavaGraphCreator("1981-2005.csv");
        fifthGraph = fifthGuavaGraphCreator.createGraphFromFile();

        fifthGraphOperation = new GraphOperation();
        fifthGraphWithoutIsolatedNodes = fifthGraphOperation.removeIsolatedNodes(fifthGraph, "1981-2005.csv");

        fifthGuavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("1981-2005_graph_without_isolated_nodes_connected_components.csv");
        fifthConnectedComponentsMap = fifthGuavaConnectedComponentsCreator.createConnectedComponentsMap();

        fifthGraphConnectedComponents = new GraphConnectedComponents();

//        fifthGraphShortestPath = new GraphShortestPath(fifthGraphWithoutIsolatedNodes);
//        fifthGraphShortestPath.calculateShortestPath();
    }

    private void setSixthData() {
        sixthGuavaGraphCreator = new GuavaGraphCreator("1981-2010.csv");
        sixthGraph = sixthGuavaGraphCreator.createGraphFromFile();

        sixthGraphOperation = new GraphOperation();
        sixthGraphWithoutIsolatedNodes = sixthGraphOperation.removeIsolatedNodes(sixthGraph, "1981-2010.csv");

        sixthGuavaConnectedComponentsCreator = new GuavaConnectedComponentsCreator("1981-2010_graph_without_isolated_nodes_connected_components.csv");
        sixthConnectedComponentsMap = sixthGuavaConnectedComponentsCreator.createConnectedComponentsMap();

        sixthGraphConnectedComponents = new GraphConnectedComponents();

//        sixthGraphShortestPath = new GraphShortestPath(sixthGraphWithoutIsolatedNodes);
//        sixthGraphShortestPath.calculateShortestPath();
    }

    @FXML
    private void initialize(){
        initFirstData();
        initSecondData();
        initThirdData();
        initFourthData();
        initFifthData();
        initSixthData();
    }

    // Metody inicjalizujące dane w kontrolerze
    private void initFirstData() {
        firstNumberOfNodesValueLabel.setText(String.valueOf(firstGraphOperation.getNumberOfNodes(firstGraph)));
        firstNumberOfEdgesValueLabel.setText(String.valueOf(firstGraphOperation.getNumberOfEdges(firstGraph)));
        firstAverageDegreeOfNodesValueLabel.setText(String.valueOf(firstGraphOperation.getNumberOfAverageDegree(firstGraph)));
        firstNumberOfIsolatedNodesValueLabel.setText(String.valueOf(firstGraphOperation.getListOfIsolatedNodes(firstGraph).size()));
        firstNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(firstGraphOperation.getNumberOfNodes(firstGraphWithoutIsolatedNodes)));
        firstAverageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(firstGraphOperation.getNumberOfAverageDegree(firstGraphWithoutIsolatedNodes)));
        firstNumberOfComponentsValueLabel.setText(String.valueOf(firstConnectedComponentsMap.size()));

        int theSmallestConnectedComponent = firstGraphConnectedComponents.findTheSmallestConnectedComponentFromMap(firstConnectedComponentsMap);
        int theBiggestConnectedComponent = firstGraphConnectedComponents.findTheBiggestConnectedComponentFromMap(firstConnectedComponentsMap);

        firstRangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        firstNumberTheGreatestComponentValueLabel.
                setText(String.valueOf(firstGraphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, firstConnectedComponentsMap)));

        // tu się coś dzieje
        firstAverageDistanceBetweenNodesValueLabel.setText(String.valueOf(firstGraphShortestPath.getAverageNodeDistance()));
        firstDiameterOfComonentValueLabel.setText(String.valueOf(firstGraphShortestPath.getGraphDiameter()));
        firstRadiousOfComponentValueLabel.setText(String.valueOf(firstGraphShortestPath.getGraphRadius()));

        fillFirstAdjacencyList();
        setFirstAdjacencyTableByItems();

        firstNodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        firstAdjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    private void initSecondData() {
        secondNumberOfNodesValueLabel.setText(String.valueOf(secondGraphOperation.getNumberOfNodes(secondGraph)));
        secondNumberOfEdgesValueLabel.setText(String.valueOf(secondGraphOperation.getNumberOfEdges(secondGraph)));
        secondAverageDegreeOfNodesValueLabel.setText(String.valueOf(secondGraphOperation.getNumberOfAverageDegree(secondGraph)));
        secondNumberOfIsolatedNodesValueLabel.setText(String.valueOf(secondGraphOperation.getListOfIsolatedNodes(secondGraph).size()));
        secondNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(secondGraphOperation.getNumberOfNodes(secondGraphWithoutIsolatedNodes)));
        secondAverageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(secondGraphOperation.getNumberOfAverageDegree(secondGraphWithoutIsolatedNodes)));
        secondNumberOfComponentsValueLabel.setText(String.valueOf(secondConnectedComponentsMap.size()));

        int theSmallestConnectedComponent = secondGraphConnectedComponents.findTheSmallestConnectedComponentFromMap(secondConnectedComponentsMap);
        int theBiggestConnectedComponent = secondGraphConnectedComponents.findTheBiggestConnectedComponentFromMap(secondConnectedComponentsMap);

        secondRangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        secondNumberTheGreatestComponentValueLabel.
                setText(String.valueOf(secondGraphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, secondConnectedComponentsMap)));

        // tu się coś dzieje
        secondAverageDistanceBetweenNodesValueLabel.setText(String.valueOf(secondGraphShortestPath.getAverageNodeDistance()));
        secondDiameterOfComonentValueLabel.setText(String.valueOf(secondGraphShortestPath.getGraphDiameter()));
        secondRadiousOfComponentValueLabel.setText(String.valueOf(secondGraphShortestPath.getGraphRadius()));

        fillSecondAdjacencyList();
        setSecondAdjacencyTableByItems();

        secondNodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        secondAdjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    private void initThirdData() {
        thirdNumberOfNodesValueLabel.setText(String.valueOf(thirdGraphOperation.getNumberOfNodes(thirdGraph)));
        thirdNumberOfEdgesValueLabel.setText(String.valueOf(thirdGraphOperation.getNumberOfEdges(thirdGraph)));
        thirdAverageDegreeOfNodesValueLabel.setText(String.valueOf(thirdGraphOperation.getNumberOfAverageDegree(thirdGraph)));
        thirdNumberOfIsolatedNodesValueLabel.setText(String.valueOf(thirdGraphOperation.getListOfIsolatedNodes(thirdGraph).size()));
        thirdNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(thirdGraphOperation.getNumberOfNodes(thirdGraphWithoutIsolatedNodes)));
        thirdAverageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(thirdGraphOperation.getNumberOfAverageDegree(thirdGraphWithoutIsolatedNodes)));
        thirdNumberOfComponentsValueLabel.setText(String.valueOf(thirdConnectedComponentsMap.size()));

        int theSmallestConnectedComponent = thirdGraphConnectedComponents.findTheSmallestConnectedComponentFromMap(thirdConnectedComponentsMap);
        int theBiggestConnectedComponent = thirdGraphConnectedComponents.findTheBiggestConnectedComponentFromMap(thirdConnectedComponentsMap);

        thirdRangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        thirdNumberTheGreatestComponentValueLabel.
                setText(String.valueOf(thirdGraphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, thirdConnectedComponentsMap)));


        // tu się coś dzieje
        thirdAverageDistanceBetweenNodesValueLabel.setText(String.valueOf(thirdGraphShortestPath.getAverageNodeDistance()));
        thirdDiameterOfComonentValueLabel.setText(String.valueOf(thirdGraphShortestPath.getGraphDiameter()));
        thirdRadiousOfComponentValueLabel.setText(String.valueOf(thirdGraphShortestPath.getGraphRadius()));

        fillThirdAdjacencyList();
        setThirdAdjacencyTableByItems();

        thirdNodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        thirdAdjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    private void initFourthData() {
        fourthNumberOfNodesValueLabel.setText(String.valueOf(fourthGraphOperation.getNumberOfNodes(fourthGraph)));
        fourthNumberOfEdgesValueLabel.setText(String.valueOf(fourthGraphOperation.getNumberOfEdges(fourthGraph)));
        fourthAverageDegreeOfNodesValueLabel.setText(String.valueOf(fourthGraphOperation.getNumberOfAverageDegree(fourthGraph)));
        fourthNumberOfIsolatedNodesValueLabel.setText(String.valueOf(fourthGraphOperation.getListOfIsolatedNodes(fourthGraph).size()));
        fourthNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(fourthGraphOperation.getNumberOfNodes(fourthGraphWithoutIsolatedNodes)));
        fourthAverageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(fourthGraphOperation.getNumberOfAverageDegree(fourthGraphWithoutIsolatedNodes)));
        fourthNumberOfComponentsValueLabel.setText(String.valueOf(fourthConnectedComponentsMap.size()));

        int theSmallestConnectedComponent = fourthGraphConnectedComponents.findTheSmallestConnectedComponentFromMap(fourthConnectedComponentsMap);
        int theBiggestConnectedComponent = fourthGraphConnectedComponents.findTheBiggestConnectedComponentFromMap(fourthConnectedComponentsMap);

        fourthRangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        fourthNumberTheGreatestComponentValueLabel.
                setText(String.valueOf(fourthGraphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, fourthConnectedComponentsMap)));

//        // tu się coś dzieje
//        fourthAverageDistanceBetweenNodesValueLabel.setText(String.valueOf(fourthGraphShortestPath.getAverageNodeDistance()));
//        fourthDiameterOfComonentValueLabel.setText(String.valueOf(fourthGraphShortestPath.getGraphDiameter()));
//        fourthRadiousOfComponentValueLabel.setText(String.valueOf(fourthGraphShortestPath.getGraphRadius()));

        fillFourthAdjacencyList();
        setFourthAdjacencyTableByItems();

        fourthNodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        fourthAdjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    private void initFifthData() {
        fifthNumberOfNodesValueLabel.setText(String.valueOf(fifthGraphOperation.getNumberOfNodes(fifthGraph)));
        fifthNumberOfEdgesValueLabel.setText(String.valueOf(fifthGraphOperation.getNumberOfEdges(fifthGraph)));
        fifthAverageDegreeOfNodesValueLabel.setText(String.valueOf(fifthGraphOperation.getNumberOfAverageDegree(fifthGraph)));
        fifthNumberOfIsolatedNodesValueLabel.setText(String.valueOf(fifthGraphOperation.getListOfIsolatedNodes(fifthGraph).size()));
        fifthNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(fifthGraphOperation.getNumberOfNodes(fifthGraphWithoutIsolatedNodes)));
        fifthAverageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(fifthGraphOperation.getNumberOfAverageDegree(fifthGraphWithoutIsolatedNodes)));
        fifthNumberOfComponentsValueLabel.setText(String.valueOf(fifthConnectedComponentsMap.size()));

        int theSmallestConnectedComponent = fifthGraphConnectedComponents.findTheSmallestConnectedComponentFromMap(fifthConnectedComponentsMap);
        int theBiggestConnectedComponent = fifthGraphConnectedComponents.findTheBiggestConnectedComponentFromMap(fifthConnectedComponentsMap);

        fifthRangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        fifthNumberTheGreatestComponentValueLabel.
                setText(String.valueOf(fifthGraphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, fifthConnectedComponentsMap)));

        fillFifthAdjacencyList();
        setFifthAdjacencyTableByItems();

        fifthNodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        fifthAdjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    private void initSixthData() {
        sixthNumberOfNodesValueLabel.setText(String.valueOf(sixthGraphOperation.getNumberOfNodes(sixthGraph)));
        sixthNumberOfEdgesValueLabel.setText(String.valueOf(sixthGraphOperation.getNumberOfEdges(sixthGraph)));
        sixthAverageDegreeOfNodesValueLabel.setText(String.valueOf(sixthGraphOperation.getNumberOfAverageDegree(sixthGraph)));
        sixthNumberOfIsolatedNodesValueLabel.setText(String.valueOf(sixthGraphOperation.getListOfIsolatedNodes(sixthGraph).size()));
        sixthNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel.setText(String.valueOf(sixthGraphOperation.getNumberOfNodes(sixthGraphWithoutIsolatedNodes)));
        sixthAverageDegreeOfNodesAfterDeletionValueLabel.setText(String.valueOf(sixthGraphOperation.getNumberOfAverageDegree(sixthGraphWithoutIsolatedNodes)));
        sixthNumberOfComponentsValueLabel.setText(String.valueOf(sixthConnectedComponentsMap.size()));

        int theSmallestConnectedComponent = sixthGraphConnectedComponents.findTheSmallestConnectedComponentFromMap(sixthConnectedComponentsMap);
        int theBiggestConnectedComponent = sixthGraphConnectedComponents.findTheBiggestConnectedComponentFromMap(sixthConnectedComponentsMap);

        sixthRangeOfNumberOfNodesValueLabel.setText(theSmallestConnectedComponent + " - " + theBiggestConnectedComponent);

        sixthNumberTheGreatestComponentValueLabel.
                setText(String.valueOf(sixthGraphConnectedComponents.findTheBiggestConnectedComponentsFromMap(theBiggestConnectedComponent, sixthConnectedComponentsMap)));

        fillSixthAdjacencyList();
        setSixthAdjacencyTableByItems();

        sixthNodesTableColumn.setCellValueFactory(node -> node.getValue().getNodeProperty());
        sixthAdjacencyNodesTableColumn.setCellValueFactory(adjacencyNode -> adjacencyNode.getValue().getAdjacencyNodesProperty());
    }

    // Wypełnienie Macierzy sąsiedztwa
    private void fillFirstAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = firstGraphOperation.getAdjacencyMap(firstGraphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            firstAdjacencyList.add(adjacencyListDto);
        }
    }

    private void setFirstAdjacencyTableByItems() {
        firstTableView.setItems(firstAdjacencyList);
    }

    private void fillSecondAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = secondGraphOperation.getAdjacencyMap(secondGraphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            secondAdjacencyList.add(adjacencyListDto);
        }
    }

    private void setSecondAdjacencyTableByItems() {
        secondTableView.setItems(secondAdjacencyList);
    }

    private void fillThirdAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = thirdGraphOperation.getAdjacencyMap(thirdGraphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            thirdAdjacencyList.add(adjacencyListDto);
        }
    }

    private void setThirdAdjacencyTableByItems() {
        thirdTableView.setItems(thirdAdjacencyList);
    }

    private void fillFourthAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = fourthGraphOperation.getAdjacencyMap(fourthGraphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            fourthAdjacencyList.add(adjacencyListDto);
        }
    }

    private void setFourthAdjacencyTableByItems() {
        fourthTableView.setItems(fourthAdjacencyList);
    }

    private void fillFifthAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = fifthGraphOperation.getAdjacencyMap(fifthGraphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            fifthAdjacencyList.add(adjacencyListDto);
        }
    }

    private void setFifthAdjacencyTableByItems() {
        fifthTableView.setItems(fifthAdjacencyList);
    }

    private void fillSixthAdjacencyList(){
        Map<String, Set<String>> adjacencyMap = sixthGraphOperation.getAdjacencyMap(sixthGraphWithoutIsolatedNodes);
        for (Map.Entry<String, Set<String>> row : adjacencyMap.entrySet()) {
            AdjacencyListDto adjacencyListDto = new AdjacencyListDto(row.getKey(), row.getValue());
            sixthAdjacencyList.add(adjacencyListDto);
        }
    }

    private void setSixthAdjacencyTableByItems() {
        sixthTableView.setItems(sixthAdjacencyList);
    }

    // Metoda do wypisywania Alterów
    public void printAlert(String title, String headerText, String contextText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

    @FXML
    private void openFirstAdjacencyMatrix(){

    }
    // First tab
    @FXML
    private Tab firstTab;

    @FXML
    private Label firstRsdsSocialNetworkLabel;

    @FXML
    private Label firstSummary;

    @FXML
    private GridPane firstGridPane;

    @FXML
    private Label firstNumberOfNodesValueLabel;

    @FXML
    private Label firstNumberOfEdgesValueLabel;

    @FXML
    private Label firstAverageDegreeOfNodesValueLabel;

    @FXML
    private Label firstNumberOfIsolatedNodesValueLabel;

    @FXML
    private Label firstNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label firstAverageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label firstNumberOfComponentsValueLabel;

    @FXML
    private Label firstRangeOfNumberOfNodesValueLabel;

    @FXML
    private Label firstNumberTheGreatestComponentValueLabel;

    @FXML
    private Label firstDistributionOfDistancesValueLabel;

    @FXML
    private Label firstAverageDistanceBetweenNodesValueLabel;

    @FXML
    private Label firstDiameterOfComonentValueLabel;

    @FXML
    private Label firstRadiousOfComponentValueLabel;

    @FXML
    private TableView<AdjacencyListDto> firstTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> firstNodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> firstAdjacencyNodesTableColumn;

    @FXML
    private Button firstAdjacencyMatrixButton;


    // Second tab
    @FXML
    private Tab secondTab;

    @FXML
    private Label secondRsdsSocialNetworkLabel;

    @FXML
    private Label secondSummary;

    @FXML
    private GridPane secondGridPane;

    @FXML
    private Label secondNumberOfNodesValueLabel;

    @FXML
    private Label secondNumberOfEdgesValueLabel;

    @FXML
    private Label secondAverageDegreeOfNodesValueLabel;

    @FXML
    private Label secondNumberOfIsolatedNodesValueLabel;

    @FXML
    private Label secondNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label secondAverageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label secondNumberOfComponentsValueLabel;

    @FXML
    private Label secondRangeOfNumberOfNodesValueLabel;

    @FXML
    private Label secondNumberTheGreatestComponentValueLabel;

    @FXML
    private Label secondDistributionOfDistancesValueLabel;

    @FXML
    private Label secondAverageDistanceBetweenNodesValueLabel;

    @FXML
    private Label secondDiameterOfComonentValueLabel;

    @FXML
    private Label secondRadiousOfComponentValueLabel;

    @FXML
    private TableView<AdjacencyListDto> secondTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> secondNodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> secondAdjacencyNodesTableColumn;

    @FXML
    private Button secondAdjacencyMatrixButton;


    // Third tab
    @FXML
    private Tab thirdTab;

    @FXML
    private Label thirdRsdsSocialNetworkLabel;

    @FXML
    private Label thirdSummary;

    @FXML
    private GridPane thirdGridPane;

    @FXML
    private Label thirdNumberOfNodesValueLabel;

    @FXML
    private Label thirdNumberOfEdgesValueLabel;

    @FXML
    private Label thirdAverageDegreeOfNodesValueLabel;

    @FXML
    private Label thirdNumberOfIsolatedNodesValueLabel;

    @FXML
    private Label thirdNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label thirdAverageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label thirdNumberOfComponentsValueLabel;

    @FXML
    private Label thirdRangeOfNumberOfNodesValueLabel;

    @FXML
    private Label thirdNumberTheGreatestComponentValueLabel;

    @FXML
    private Label thirdDistributionOfDistancesValueLabel;

    @FXML
    private Label thirdAverageDistanceBetweenNodesValueLabel;

    @FXML
    private Label thirdDiameterOfComonentValueLabel;

    @FXML
    private Label thirdRadiousOfComponentValueLabel;

    @FXML
    private TableView<AdjacencyListDto> thirdTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> thirdNodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> thirdAdjacencyNodesTableColumn;

    @FXML
    private Button thirdAdjacencyMatrixButton;


    // Fourth tab
    @FXML
    private Tab fourthTab;

    @FXML
    private Label fourthRsdsSocialNetworkLabel;

    @FXML
    private Label fourthSummary;

    @FXML
    private GridPane fourthGridPane;

    @FXML
    private Label fourthNumberOfNodesValueLabel;

    @FXML
    private Label fourthNumberOfEdgesValueLabel;

    @FXML
    private Label fourthAverageDegreeOfNodesValueLabel;

    @FXML
    private Label fourthNumberOfIsolatedNodesValueLabel;

    @FXML
    private Label fourthNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label fourthAverageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label fourthNumberOfComponentsValueLabel;

    @FXML
    private Label fourthRangeOfNumberOfNodesValueLabel;

    @FXML
    private Label fourthNumberTheGreatestComponentValueLabel;

    @FXML
    private Label fourthDistributionOfDistancesValueLabel;

    @FXML
    private Label fourthAverageDistanceBetweenNodesValueLabel;

    @FXML
    private Label fourthDiameterOfComonentValueLabel;

    @FXML
    private Label fourthRadiousOfComponentValueLabel;

    @FXML
    private TableView<AdjacencyListDto> fourthTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> fourthNodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> fourthAdjacencyNodesTableColumn;

    @FXML
    private Button fourthAdjacencyMatrixButton;


    // Fifth tab
    @FXML
    private Tab fifthTab;

    @FXML
    private Label fifthRsdsSocialNetworkLabel;

    @FXML
    private Label fifthSummary;

    @FXML
    private GridPane fifthGridPane;

    @FXML
    private Label fifthNumberOfNodesValueLabel;

    @FXML
    private Label fifthNumberOfEdgesValueLabel;

    @FXML
    private Label fifthAverageDegreeOfNodesValueLabel;

    @FXML
    private Label fifthNumberOfIsolatedNodesValueLabel;

    @FXML
    private Label fifthNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label fifthAverageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label fifthNumberOfComponentsValueLabel;

    @FXML
    private Label fifthRangeOfNumberOfNodesValueLabel;

    @FXML
    private Label fifthNumberTheGreatestComponentValueLabel;

    @FXML
    private Label fifthDistributionOfDistancesValueLabel;

    @FXML
    private Label fifthAverageDistanceBetweenNodesValueLabel;

    @FXML
    private Label fifthDiameterOfComonentValueLabel;

    @FXML
    private Label fifthRadiousOfComponentValueLabel;

    @FXML
    private TableView<AdjacencyListDto> fifthTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> fifthNodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> fifthAdjacencyNodesTableColumn;

    @FXML
    private Button fifthAdjacencyMatrixButton;


    // Sixth tab
    @FXML
    private Tab sixthTab;

    @FXML
    private Label sixthRsdsSocialNetworkLabel;

    @FXML
    private Label sixthSummary;

    @FXML
    private GridPane sixthGridPane;

    @FXML
    private Label sixthNumberOfNodesValueLabel;

    @FXML
    private Label sixthNumberOfEdgesValueLabel;

    @FXML
    private Label sixthAverageDegreeOfNodesValueLabel;

    @FXML
    private Label sixthNumberOfIsolatedNodesValueLabel;

    @FXML
    private Label sixthNumberOfNodesAfterDeletionOfIsolatedNodesValueLabel;

    @FXML
    private Label sixthAverageDegreeOfNodesAfterDeletionValueLabel;

    @FXML
    private Label sixthNumberOfComponentsValueLabel;

    @FXML
    private Label sixthRangeOfNumberOfNodesValueLabel;

    @FXML
    private Label sixthNumberTheGreatestComponentValueLabel;

    @FXML
    private Label sixthDistributionOfDistancesValueLabel;

    @FXML
    private Label sixthAverageDistanceBetweenNodesValueLabel;

    @FXML
    private Label sixthDiameterOfComonentValueLabel;

    @FXML
    private Label sixthRadiousOfComponentValueLabel;

    @FXML
    private TableView<AdjacencyListDto> sixthTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> sixthNodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> sixthAdjacencyNodesTableColumn;

    @FXML
    private Button sixthAdjacencyMatrixButton;

    // First
    private GuavaGraphCreator firstGuavaGraphCreator;
    private GuavaConnectedComponentsCreator firstGuavaConnectedComponentsCreator;

    private GraphOperation firstGraphOperation;
    private GraphConnectedComponents firstGraphConnectedComponents;
    private GraphShortestPath firstGraphShortestPath;

    private Map<String, Set<String>> firstConnectedComponentsMap;

    private MutableValueGraph<String, String> firstGraph;
    private MutableValueGraph<String, String> firstGraphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> firstAdjacencyList = FXCollections.observableArrayList();

    private List firstTheBiggestConnectedComponent = null;

    // Second
    private GuavaGraphCreator secondGuavaGraphCreator;
    private GuavaConnectedComponentsCreator secondGuavaConnectedComponentsCreator;

    private GraphOperation secondGraphOperation;
    private GraphConnectedComponents secondGraphConnectedComponents;
    private GraphShortestPath secondGraphShortestPath;

    private Map<String, Set<String>> secondConnectedComponentsMap;

    private MutableValueGraph<String, String> secondGraph;
    private MutableValueGraph<String, String> secondGraphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> secondAdjacencyList = FXCollections.observableArrayList();

    private List secondTheBiggestConnectedComponent = null;

    // Third
    private GuavaGraphCreator thirdGuavaGraphCreator;
    private GuavaConnectedComponentsCreator thirdGuavaConnectedComponentsCreator;

    private GraphOperation thirdGraphOperation;
    private GraphConnectedComponents thirdGraphConnectedComponents;
    private GraphShortestPath thirdGraphShortestPath;

    private Map<String, Set<String>> thirdConnectedComponentsMap;

    private MutableValueGraph<String, String> thirdGraph;
    private MutableValueGraph<String, String> thirdGraphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> thirdAdjacencyList = FXCollections.observableArrayList();

    private List thirdTheBiggestConnectedComponent = null;

    // Fourth
    private GuavaGraphCreator fourthGuavaGraphCreator;
    private GuavaConnectedComponentsCreator fourthGuavaConnectedComponentsCreator;

    private GraphOperation fourthGraphOperation;
    private GraphConnectedComponents fourthGraphConnectedComponents;
    private GraphShortestPath fourthGraphShortestPath;

    private Map<String, Set<String>> fourthConnectedComponentsMap;

    private MutableValueGraph<String, String> fourthGraph;
    private MutableValueGraph<String, String> fourthGraphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> fourthAdjacencyList = FXCollections.observableArrayList();

    private List fourthTheBiggestConnectedComponent = null;

    // Fifth
    private GuavaGraphCreator fifthGuavaGraphCreator;
    private GuavaConnectedComponentsCreator fifthGuavaConnectedComponentsCreator;

    private GraphOperation fifthGraphOperation;
    private GraphConnectedComponents fifthGraphConnectedComponents;
    private GraphShortestPath fifthGraphShortestPath;

    private Map<String, Set<String>> fifthConnectedComponentsMap;

    private MutableValueGraph<String, String> fifthGraph;
    private MutableValueGraph<String, String> fifthGraphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> fifthAdjacencyList = FXCollections.observableArrayList();

    // Sixth
    private GuavaGraphCreator sixthGuavaGraphCreator;
    private GuavaConnectedComponentsCreator sixthGuavaConnectedComponentsCreator;

    private GraphOperation sixthGraphOperation;
    private GraphConnectedComponents sixthGraphConnectedComponents;
    private GraphShortestPath sixthGraphShortestPath;

    private Map<String, Set<String>> sixthConnectedComponentsMap;

    private MutableValueGraph<String, String> sixthGraph;
    private MutableValueGraph<String, String> sixthGraphWithoutIsolatedNodes;

    private ObservableList<AdjacencyListDto> sixthAdjacencyList = FXCollections.observableArrayList();
}