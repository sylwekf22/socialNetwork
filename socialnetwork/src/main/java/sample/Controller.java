package sample;

import javafx.fxml.FXML;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
        
        MenageDatabase md = new MenageDatabase();
        
        ResultSet rs = md.getData("SELECT * FROM kategorie");
        rs.first();
        
        do {
            System.out.println(rs.getString(2));
        }
        while(rs.next());
        
        md.cleaEnvironment();
    }
    private Main main;
    
}