package sample;

import databasequeries.AuthorsNodes;
import javafx.fxml.FXML;
import config.DatabaseConnectionHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.Authors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Controller {

    public Controller() { }

    public Controller(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() throws SQLException {
        AuthorsNodes authorsNodes = new AuthorsNodes();
        Integer integer = authorsNodes.countAuthors();
        System.out.println(integer.intValue());

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Authors.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Authors");
        List list = query.list();

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            Authors authors = (Authors) iterator.next();
            System.out.println(authors.getId());
        }
    }

    private Main main;
}