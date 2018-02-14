package config;

import java.sql.*;

// Klasa DatabaseConnectionHandler
public class DatabaseConnectionHandler {
    // zmienne określające sslOpiton i timeZoneOption
    private String sslOption = "?useSSL=false";
    private String timeZoneOption = "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private final ConfigurationReader configurationReader;

    // Dane konfigurające
    private final String databaseName;
    private final String user;
    private final String password;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // Konstrutor odczytujący słowa kluczowe z pliku databaseconfig.txt
    public DatabaseConnectionHandler() {
        this.configurationReader = new ConfigurationReader();

        this.databaseName = configurationReader.getKeyWord("databaseName");
        this.user = configurationReader.getKeyWord("user");
        this.password = configurationReader.getKeyWord("password");

        this.connection = null;
        this.preparedStatement = null;
        this.resultSet = null;

        setUpConnection();
    }

    // Konstruktor odczytujący słowa kluczowe za pomocą klasy ConfigurationReader
    public DatabaseConnectionHandler(ConfigurationReader configurationReader) {
        this.configurationReader = configurationReader;

        this.databaseName = configurationReader.getKeyWord("databaseName");
        this.user = configurationReader.getKeyWord("user");
        this.password = configurationReader.getKeyWord("password");

        this.connection = null;
        this.preparedStatement = null;
        this.resultSet = null;

        setUpConnection();
    }

    // Metoda do odczytywania danych bazy danych
    public ResultSet getData(String sqlQuery) throws SQLException {
        this.preparedStatement = connection.prepareStatement(sqlQuery);
        this.resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    // Rozpoczęcie połączenia z bazą danych
    private void setUpConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName + sslOption +" &" + timeZoneOption, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // zamknięcie połączenia
    public void closeEnvironment(){
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
