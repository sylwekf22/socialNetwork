package controller;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import creator.GuavaConnectedComponentsCreator;
import creator.GuavaGraphCreator;
import graphoperation.GraphConnectedComponents;
import graphoperation.GraphOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.FiveYearPeriodStatistics;
import main.GeneralStatistics;
import writer.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainController {

    public MainController() { }

    @FXML
    private void initialize() {
    }

    // Otworzenie okna GeneralStatistics
    @FXML
    private void openWindowWithGeneralStatistics(){
        GeneralStatistics generalStatistics = new GeneralStatistics();
        generalStatistics.start(new Stage());
    }

    // Otworzenie okna GeneralStatistics
    @FXML
    private void openWindowWithc(){
        FiveYearPeriodStatistics fiveYearPeriodStatistics = new FiveYearPeriodStatistics();
        fiveYearPeriodStatistics.start(new Stage());
    }

    @FXML
    private Label socialNetworkLabel;

    @FXML
    private Label rsdsGraphAnalysisLabel;

    @FXML
    private Button generalRSDSGraphStatisticsButton;

    @FXML
    private Button fiveYearPeriodRSDSGraphStatisticsButton;
}