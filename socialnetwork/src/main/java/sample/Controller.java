package sample;

import databasequeries.AuthorsTitlesHibernate;
import databasequeries.AvgDegree;
import databasequeries.TitlesHibernate;
import javafx.fxml.FXML;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
        AvgDegree avgDegree = new AvgDegree();
        float v = avgDegree.countAvgDegree();
        System.out.println(v);
    }

    private Main main;
}