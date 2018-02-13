package controller;

import dto.AdjacencyListDto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FiveYearPeriodStatisticsController {
    public FiveYearPeriodStatisticsController() {
    }

    @FXML
    private void initialize(){

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


}