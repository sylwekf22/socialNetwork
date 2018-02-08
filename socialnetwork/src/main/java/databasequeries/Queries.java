package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    private DatabaseConnectionHandler databaseConnectionHandler;
    private String allEdgesQuery = "Select SUM((a.liczba/2)*(a.liczba-1)) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu) As a\n" +
            "having krawedz > 1\n" +
            "UNION\n" +
            "Select COUNT(id_tytulu) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu HAVING LICZBA = 1) As b";
    private String allAuthorsQuery = "SELECT distinct count(a.id_autora) as nodes FROM autorzy a";
    private String isolatedNodesQuery = "Select COUNT(id_tytulu) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu HAVING LICZBA = 1) As b";
    private String averageDegreeQuery = "Select a.authorConnectionSum FROM (Select id_autora, count(id_autora) AS authorConnectionSum\n" +
            "from tab_lacz1 \n" +
            "group by id_autora) AS a";


    public Queries() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public Integer countAllEdges() throws SQLException {
        ResultSet numberOfEdges = databaseConnectionHandler.getData(allEdgesQuery);

        numberOfEdges.next();
        Integer edge = numberOfEdges.getInt("krawedz");
        numberOfEdges.next();
        edge += numberOfEdges.getInt("krawedz");

        databaseConnectionHandler.closeEnvironment();
        return edge;
    }

    public Integer countAuthors() throws SQLException {
        ResultSet numberOfNodes = databaseConnectionHandler.getData(allAuthorsQuery);
        numberOfNodes.next();
        Integer nodes = numberOfNodes.getInt("nodes");
        databaseConnectionHandler.closeEnvironment();

        return nodes;
    }

    public int getIsolatedNodes() throws SQLException {
        ResultSet IsolatedNodes = databaseConnectionHandler.getData(isolatedNodesQuery);

        IsolatedNodes.next();
        int nodesAmount = IsolatedNodes.getInt("krawedz");

        databaseConnectionHandler.closeEnvironment();
        return nodesAmount;
    }

    public Integer getNodesWithoutIsolated() throws SQLException {
        return countAllEdges() - getIsolatedNodes();
    }

    public List<Double> getAverageNodesDegree() throws SQLException {
        ResultSet authors = databaseConnectionHandler.getData(averageDegreeQuery);
        ArrayList<Double> averageDegreeList = new ArrayList<>();
        double averageDegree = 0.0;

        int amountOfEdges = countAllEdges();

        for(;!authors.isAfterLast();){
            authors.next();
            averageDegree = authors.getDouble("authorConnectionSum")/amountOfEdges;
            averageDegreeList.add(averageDegree);

            if (authors.isLast())
                break;
        }

        databaseConnectionHandler.closeEnvironment();
        return averageDegreeList;
    }
}
