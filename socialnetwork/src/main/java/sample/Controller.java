package sample;

import javafx.fxml.FXML;
import sample.config.DatabaseConnectionHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
       DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
       ResultSet data = databaseConnectionHandler.getData("SELECT * FROM autorzy");
    }

    private Main main;
}