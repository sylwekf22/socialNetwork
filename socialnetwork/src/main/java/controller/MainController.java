package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.FiveYearPeriodStatistics;
import main.GeneralStatistics;

public class MainController {

    public MainController() { }

    @FXML
    private void initialize() {
    }

    @FXML
    private void openWindowWithGeneralStatistics(){
        GeneralStatistics generalStatistics = new GeneralStatistics();
        generalStatistics.start(new Stage());
    }

    @FXML
    private void openWindowWithFiveYearPeriodStatistics(){
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