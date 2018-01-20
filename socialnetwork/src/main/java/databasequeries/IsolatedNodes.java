package databasequeries;

import connection.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IsolatedNodes {

    private final DatabaseConnectionHandler databaseConnectionHandler;

    private final String query = "Select COUNT(id_tytulu) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu HAVING LICZBA = 1) As b";

    public IsolatedNodes() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public int getIsolatedNodes() throws SQLException {
        ResultSet IsolatedNodes = databaseConnectionHandler.getData(query);

        IsolatedNodes.next();
        int nodesAmount = IsolatedNodes.getInt("krawedz");

        databaseConnectionHandler.closeEnvironment();
        return nodesAmount;
    }
}
