package databasequeries;

import java.sql.SQLException;

public class GetNodesWithoutIsolated {

    private final GetAllEdges getAllEdges;
    private final IsolatedNodes isolatedNodes;

    public GetNodesWithoutIsolated() {
        this.getAllEdges = new GetAllEdges();
        this.isolatedNodes = new IsolatedNodes();
    }

    public Integer get() throws SQLException {
        return getAllEdges.countAllEdges() - isolatedNodes.get();
    }
}
