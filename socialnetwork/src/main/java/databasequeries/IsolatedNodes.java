package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IsolatedNodes {

    private final DatabaseConnectionHandler databaseConnectionHandler;

    private final String queryEdges = "Select COUNT(id_tytulu) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu HAVING LICZBA = 1) As b";

    public IsolatedNodes() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public int get() throws SQLException {
        ResultSet numberOfNodes = databaseConnectionHandler.getData(queryEdges);
        numberOfNodes.next();
        int nodesAmount = numberOfNodes.getInt("krawedz");
        databaseConnectionHandler.closeEnvironment();
        return nodesAmount;
    }
}
