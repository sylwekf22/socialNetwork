package databasequeries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.Title;

import java.util.List;

public class TitlesHibernate {
    private final SessionFactory sessionFactory;

    public TitlesHibernate() {
        this.sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Title.class)
                .buildSessionFactory();
    }

    public Long countTitles(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct count(a.id) FROM Title a");
        Long nodes = (Long) query.uniqueResult();

        transaction.commit();
        session.close();

        return nodes;
    }

    public List<Integer> getTitlesId(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct a.id FROM Title a");
        List<Integer> titles = query.list();

        transaction.commit();
        session.close();

        return titles;
    }

    public List<String> getTitlesNames(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct a.title FROM Title a");
        List<String> titlesNames = query.list();

        transaction.commit();
        session.close();

        return titlesNames;
    }

}
