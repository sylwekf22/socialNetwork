package hibernatequeries;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.Author;

import java.util.List;

public class AuthorsNodesHibernate {
    private final SessionFactory sessionFactory;

    public AuthorsNodesHibernate() {
        this.sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Author.class)
                .buildSessionFactory();
    }

    public Long countAuthors(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct count(a.id) FROM Author a");
        Long nodes = (Long) query.uniqueResult();

        transaction.commit();
        session.close();

        return nodes;
    }

    public List<Integer> getAuthorsId(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct a.id FROM Author a ORDER BY a.id ASC");
        List<Integer> authors = query.list();

        transaction.commit();
        session.close();

        return authors;
    }

    public Author getAuthor(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Author a WHERE a.id = :authorId ORDER BY a.id ASC");
        query.setParameter("authorId", Integer.valueOf(id));

        Author author = (Author) query.uniqueResult();

        transaction.commit();
        session.close();

        return author;
    }
}