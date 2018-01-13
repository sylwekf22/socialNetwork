package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NodeAverageDegree {

    private final DatabaseConnectionHandler databaseConnectionHandler;

    private final String queryEdges = "Select a.authorConnectionSum FROM (Select id_autora, count(id_autora) AS authorConnectionSum\n" +
            "from tab_lacz1 \n" +
            "group by id_autora) AS a";

    public NodeAverageDegree() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public List<Double> get() throws SQLException {
        ResultSet numberOfNodes = databaseConnectionHandler.getData(queryEdges);
        GetAllEdges allEdgesHandler = new GetAllEdges();
        int edgesAmount = allEdgesHandler.get();
        double node;
        ArrayList<Double> averageDegreeList = new ArrayList<>();
        // Setting cursor on the value

        for(;!numberOfNodes.isAfterLast();){
            numberOfNodes.next();
            node = numberOfNodes.getDouble("authorConnectionSum")/edgesAmount;
            averageDegreeList.add(node);
            if (numberOfNodes.isLast())
                break;
        }
        databaseConnectionHandler.closeEnvironment();

        return averageDegreeList;
    }
}
