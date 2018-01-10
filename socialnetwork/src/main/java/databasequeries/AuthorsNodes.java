package databasequeries;

import config.DatabaseConnectionHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorsNodes {
    private final DatabaseConnectionHandler databaseConnectionHandler;

    public AuthorsNodes() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public Integer countAuthors() throws SQLException {
        ResultSet numberOfNodes = databaseConnectionHandler.getData("SELECT count(nazwisko) as nodes FROM autorzy");

        // Setting cursor on the value
        numberOfNodes.next();
        Integer nodes = numberOfNodes.getInt("nodes");

        databaseConnectionHandler.closeEnvironment();

        return nodes;
    }
}