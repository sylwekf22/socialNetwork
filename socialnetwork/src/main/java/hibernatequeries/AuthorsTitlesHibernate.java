package hibernatequeries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.Author;
import pojo.TableConnectOne;
import pojo.Title;

import java.util.*;

public class AuthorsTitlesHibernate {
    private final SessionFactory sessionFactory;

    public AuthorsTitlesHibernate() {
        this.sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(TableConnectOne.class)
                .addAnnotatedClass(Title.class)
                .buildSessionFactory();
    }

    public Map<Integer, Integer> getAuthorsAndTitles(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT a.id, t.id FROM Author a \n" +
                "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id\n" +
                "JOIN Title t ON tabl1.title_id = t.id ORDER BY a.id ASC, t.id ASC");

        Map<Integer, Integer> authorsTitles = new LinkedHashMap<>();

        List list = query.list();

        for (Object aList : list) {
            Object[] row = (Object[]) aList;
            Integer authorId = (Integer) row[0];
            Integer titleId = (Integer) row[1];

            authorsTitles.put(authorId, titleId);
        }

        transaction.commit();
        session.close();

        return authorsTitles;
    }

    public List<Integer> getTitlesGivingAuthor(Integer authorId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT t.id FROM Author a \n" +
                "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id\n" +
                "JOIN Title t ON tabl1.title_id = t.id\n" +
                "WHERE a.id = :givenId\n" +
                "ORDER BY t.id ASC");
        query.setParameter("givenId", authorId);

        List<Integer> titles = query.list();

        transaction.commit();
        session.close();

        return titles;
    }

    public List<Integer> getAuthorsGivingTitle(Integer titleId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT a.id FROM Author a \n" +
                "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id\n" +
                "JOIN Title t ON tabl1.title_id = t.id\n" +
                "WHERE t.id = :givenId\n" +
                "ORDER BY a.id ASC");
        query.setParameter("givenId", titleId);

        List<Integer> authors = query.list();

        transaction.commit();
        session.close();

        return authors;
    }
}
