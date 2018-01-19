package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetNodesWithoutIsolated {

    private final DatabaseConnectionHandler databaseConnectionHandler;

    public GetNodesWithoutIsolated() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public Integer get() throws SQLException {

        int nodesAmount;
        GetAllEdges getAllEdges = new GetAllEdges();
        IsolatedNodes IsolatedNodes = new IsolatedNodes();

        return getAllEdges.get() - IsolatedNodes.get();
    }
}
