package databasequeries;

import config.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllEdges {

    private final DatabaseConnectionHandler databaseConnectionHandler;
    private final String queryEdges = "Select SUM((a.liczba/2)*(a.liczba-1)) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu) As a\n" +
            "having krawedz > 1\n" +
            "UNION\n" +
            "Select COUNT(id_tytulu) as krawedz  FROM (Select id_tytulu, count(id_autora) As liczba\n" +
            "from tab_lacz1 \n" +
            "group by id_tytulu HAVING LICZBA = 1) As b";

    public GetAllEdges() {
        this.databaseConnectionHandler = new DatabaseConnectionHandler();
    }

    public Integer countAuthors() throws SQLException {
        ResultSet numberOfEdges = databaseConnectionHandler.getData(queryEdges);

        // Setting cursor on the value
        numberOfEdges.next();
        Integer edge = numberOfEdges.getInt("krawedz");
        numberOfEdges.next();
        edge += numberOfEdges.getInt("krawedz");

        databaseConnectionHandler.closeEnvironment();
        return edge;
    }
}
