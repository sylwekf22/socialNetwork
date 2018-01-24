package sample;

import com.google.common.graph.MutableValueGraph;
import csv.CSVReader;
import csv.CSVWriter;
import databasequeries.GraphConverter;
import databasequeries.GraphCreator;
import databasequeries.GraphOperation;
import dto.AuthorDto;
import dto.TitleDto;
import hibernatequeries.AuthorsNodesHibernate;
import hibernatequeries.TitlesHibernate;
import javafx.fxml.FXML;
import pojo.Author;
import pojo.Title;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws IOException {
        GraphCreator graphCreator = new GraphCreator();
        List<List<String>> graphWithInformation = graphCreator.createGraphWithInformation();
        FileWriter fileWriter = new FileWriter("bid_data.csv");

        CSVWriter csvWriter = new CSVWriter();

        for (List<String> list : graphWithInformation) {
            csvWriter.writeLine(fileWriter, list);
        }

        fileWriter.flush();
        fileWriter.close();
    }

    private Main main;
}