package databasequeries;

import connection.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NodeAverageDegree {

    private final DatabaseConnectionHandler databaseConnectionHandler;
    private final AllEdges allEdges;

    private final String query = "Select a.authorConnectionSum FROM (Select id_autora, count(id_autora) AS authorConnectionSum\n" +
            "from tab_lacz1 \n" +
            "group by id_autora) AS a";

    public NodeAverageDegree() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
        this.allEdges = new AllEdges();
    }

    public List<Double> getAverageNodesDegree() throws SQLException {
        ResultSet authors = databaseConnectionHandler.getData(query);
        ArrayList<Double> averageDegreeList = new ArrayList<>();
        double averageDegree = 0.0;

        int amountOfEdges = allEdges.countAllEdges();

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
