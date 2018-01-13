package sample;

import javafx.fxml.FXML;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private Main main;
}