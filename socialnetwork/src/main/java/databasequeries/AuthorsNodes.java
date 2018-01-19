package databasequeries;

import config.DatabaseConnectionHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorsNodes {
    private final DatabaseConnectionHandler databaseConnectionHandler;
    private final String queryWithConcat = "SELECT distinct count(concat(a.imie, ' ', a.nazwisko)) as nodes FROM autorzy a";
    private final String queryWithoutConcat = "SELECT distinct count(a.id_autora) as nodes FROM autorzy a";

    public AuthorsNodes() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public Integer countAuthors() throws SQLException {
        ResultSet numberOfNodes = databaseConnectionHandler.getData(queryWithoutConcat);
        numberOfNodes.next();
        Integer nodes = numberOfNodes.getInt("nodes");
        databaseConnectionHandler.closeEnvironment();

        return nodes;
    }
}