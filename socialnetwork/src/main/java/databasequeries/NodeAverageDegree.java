package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NodeAverageDegree {

    private final DatabaseConnectionHandler databaseConnectionHandler;
    private final GetAllEdges getAllEdges;

    private final String query = "Select a.authorConnectionSum FROM (Select id_autora, count(id_autora) AS authorConnectionSum\n" +
            "from tab_lacz1 \n" +
            "group by id_autora) AS a";

    public NodeAverageDegree() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
        this.getAllEdges = new GetAllEdges();
    }

    public List<Double> get() throws SQLException {
        ResultSet numberOfEdges = databaseConnectionHandler.getData(query);
        ArrayList<Double> averageDegreeList = new ArrayList<>();
        double averageDegree = 0.0;

        int edgesAmount = getAllEdges.countAllEdges();

        for(;!numberOfEdges.isAfterLast();){
            numberOfEdges.next();
            averageDegree = numberOfEdges.getDouble("authorConnectionSum")/edgesAmount;
            averageDegreeList.add(averageDegree);

            if (numberOfEdges.isLast())
                break;
        }

        databaseConnectionHandler.closeEnvironment();
        return averageDegreeList;
    }
}
