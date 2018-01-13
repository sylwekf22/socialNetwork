package sample;

import javafx.fxml.FXML;
import java.sql.SQLException;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
    }

    private Main main;
}