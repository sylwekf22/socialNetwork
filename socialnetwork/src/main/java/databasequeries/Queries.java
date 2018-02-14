package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Klasa z implementacjami zapytań do bazy danych
public class Queries {

    // Zapytania
    private DatabaseConnectionHandler databaseConnectionHandler;
    private String allAuthorsQuery = "SELECT distinct count(a.id_autora) as nodes FROM autorzy a";
    private String isolatedNodesQuery = "Select COUNT(id_tytulu) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu HAVING LICZBA = 1) As b";
    private String averageDegreeQuery = "Select a.authorConnectionSum FROM (Select id_autora, count(id_autora) AS authorConnectionSum\n" +
            "from tab_lacz1 \n" +
            "group by id_autora) AS a";

    // Konstruktor ustawiający DatabaseConnectionHandler
    public Queries() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    // Oblicz liczbę autorów
    public Integer countAuthors() throws SQLException {
        ResultSet numberOfNodes = databaseConnectionHandler.getData(allAuthorsQuery);
        numberOfNodes.next();
        Integer nodes = numberOfNodes.getInt("nodes");
        databaseConnectionHandler.closeEnvironment();

        return nodes;
    }

    // Pobierz wierzchołki odizolowane
    public int getIsolatedNodes() throws SQLException {
        ResultSet IsolatedNodes = databaseConnectionHandler.getData(isolatedNodesQuery);

        IsolatedNodes.next();
        int nodesAmount = IsolatedNodes.getInt("krawedz");

        databaseConnectionHandler.closeEnvironment();
        return nodesAmount;
    }
}
