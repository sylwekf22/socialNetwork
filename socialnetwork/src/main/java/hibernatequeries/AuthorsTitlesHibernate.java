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

        Query query = session.createQuery("SELECT a.id, t.id FROM Author a " +
                                             "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id " +
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

        Query query = session.createQuery("SELECT t.id FROM Author a " +
                                             "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id " +
                                             "JOIN Title t ON tabl1.title_id = t.id " +
                                             "WHERE a.id = :givenId " +
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

        Query query = session.createQuery("SELECT a.id FROM Author a " +
                                             "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id " +
                                             "JOIN Title t ON tabl1.title_id = t.id " +
                                             "WHERE t.id = :givenId " +
                                             "ORDER BY a.id ASC");
        query.setParameter("givenId", titleId);

        List<Integer> authors = query.list();

        transaction.commit();
        session.close();

        return authors;
    }

    public List<Integer> getAuthorsIdBetweenTwoPublicationYears(String startDate, String endDate){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT DISTINCT a.id " +
                                             "FROM Author a " +
                                             "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id " +
                                             "JOIN Title t ON tabl1.title_id = t.id " +
                                             "WHERE t.publication_year BETWEEN :startDate AND :endDate " +
                                             "ORDER BY a.id ASC");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        List<Integer> authors = query.list();

        transaction.commit();
        session.close();

        return authors;
    }

    public List<Integer> getTitlesGivingAuthorAndBetweenTwoPublicationYears(Integer authorId, String startDate, String endDate){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT t.id " +
                                             "FROM Author a " +
                                             "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id " +
                                             "JOIN Title t ON tabl1.title_id = t.id " +
                                             "WHERE a.id = :givenId " +
                                             "AND t.publication_year BETWEEN :startDate AND :endDate " +
                                             "ORDER BY t.id ASC");
        query.setParameter("givenId", authorId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        List<Integer> titles = query.list();

        transaction.commit();
        session.close();

        return titles;
    }

    public List<Integer> getAuthorsGivingTitleAndBetweenTwoPublicationYears(Integer titleId, String startDate, String endDate){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT a.id FROM Author a " +
                                             "JOIN TableConnectOne tabl1 ON a.id = tabl1.author_id " +
                                             "JOIN Title t ON tabl1.title_id = t.id " +
                                             "WHERE t.id = :givenId " +
                                             "AND t.publication_year BETWEEN :startDate AND :endDate " +
                                             "ORDER BY a.id ASC");
        query.setParameter("givenId", titleId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        List<Integer> authors = query.list();

        transaction.commit();
        session.close();

        return authors;
    }
}