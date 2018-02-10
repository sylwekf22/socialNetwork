package sample;

import javafx.fxml.FXML;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
    }

    private Main main;
}