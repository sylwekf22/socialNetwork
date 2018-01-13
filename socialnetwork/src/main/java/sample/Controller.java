package sample;

import databasequeries.AuthorsNodes;
import javafx.fxml.FXML;
import config.DatabaseConnectionHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
        AuthorsNodes authorsNodes = new AuthorsNodes();
        Integer integer = authorsNodes.countAuthors();
        System.out.println(integer.intValue());
    }

    private Main main;
}