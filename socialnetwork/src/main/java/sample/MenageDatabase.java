/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sylwester
 */
public class MenageDatabase {

    private Connection connection;
    private String dataBase;
    private String user;
    private String password;
    private Statement stmt;
    private ResultSet rs;

    MenageDatabase() {
        this.connection = null;
        this.dataBase = "rsds_data";
        this.user = "root";
        this.password = "nero11";
        this.stmt = null;
        this.rs = null;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBase + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData(String sql) throws SQLException {

        stmt = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        rs = stmt.executeQuery(sql);

        return rs;
    }

    public void cleaEnvironment() throws SQLException {
        rs.close();
        stmt.close();
        connection.close();
    }
}
