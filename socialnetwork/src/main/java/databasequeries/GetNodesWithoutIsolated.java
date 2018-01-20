package databasequeries;

import java.sql.SQLException;

public class GetNodesWithoutIsolated {

    private final AllEdges allEdges;
    private final IsolatedNodes isolatedNodes;

    public GetNodesWithoutIsolated() {
        this.allEdges = new AllEdges();
        this.isolatedNodes = new IsolatedNodes();
    }

    public Integer getNodesWithoutIsolated() throws SQLException {
        return allEdges.countAllEdges() - isolatedNodes.getIsolatedNodes();
    }
}
