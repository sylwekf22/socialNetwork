package controller;

import dto.AdjacencyListDto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class GeneralStatisticsController {
    public GeneralStatisticsController() {
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void showAdjacencyMatrix(){

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
    private TableView<AdjacencyListDto> AdjacencyListTableView;

    @FXML
    private TableColumn<AdjacencyListDto, String> nodesTableColumn;

    @FXML
    private TableColumn<AdjacencyListDto, String> adjacencyNodesTableColumn;

    @FXML
    private Label adjacencyMatrixLabel;

    @FXML
    private Button adjacencyMatrixButton;
}
