package sample;

import com.google.common.graph.MutableValueGraph;
import csv.CSVReader;
import databasequeries.GraphConverter;
import dto.AuthorDto;
import dto.TitleDto;
import hibernatequeries.AuthorsNodesHibernate;
import hibernatequeries.TitlesHibernate;
import javafx.fxml.FXML;
import pojo.Author;
import pojo.Title;

import java.util.List;
import java.util.Set;

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