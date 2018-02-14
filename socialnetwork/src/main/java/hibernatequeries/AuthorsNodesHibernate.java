package hibernatequeries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import dao.Author;

import java.util.LinkedList;
import java.util.List;

// Klasa z zapytaniami do tabeli autorzy z dazy danych

public class AuthorsNodesHibernate {
    private final SessionFactory sessionFactory;

    public AuthorsNodesHibernate() {
        this.sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Author.class)
                .buildSessionFactory();
    }

    // Obliczenie liczby autorów
    public Long countAuthors(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct count(a.id) FROM Author a");
        Long nodes = (Long) query.uniqueResult();

        transaction.commit();
        session.close();

        return nodes;
    }

    // Pobierz listę id autorów
    public List<Integer> getAuthorsId(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT distinct a.id FROM Author a ORDER BY a.id ASC");
        List<Integer> authors = query.list();

        transaction.commit();
        session.close();

        return authors;
    }

    // Pobierz autora za pomocą id
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

    // Pobierz imię i nazwisko autora za pomocą id
    public List<String> getFirstNameAndSecondName(String id){
        List<String> initialsList = new LinkedList<>();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT a.firstName, a.secondName FROM Author a WHERE a.id = :authorId ORDER BY a.id ASC");
        query.setParameter("authorId", Integer.valueOf(id));

        Object[] initials = (Object[]) query.uniqueResult();
        initialsList.add((String) initials[0]);
        initialsList.add((String) initials[1]);

        transaction.commit();
        session.close();

        return initialsList;
    }

    // Konwerter autora
    public List<String> getAuthorAndConvertToList(String id){
        Author author = getAuthor(id);
        List<String> listAuthor = new LinkedList<>();

        listAuthor.add(String.valueOf(author.getId()));
        listAuthor.add(String.valueOf(author.getMail()));
        listAuthor.add(String.valueOf(author.getWww()));
        listAuthor.add(String.valueOf(author.getCity()));
        listAuthor.add(String.valueOf(author.getCountry()));
        listAuthor.add(String.valueOf(author.getContinent()));
        listAuthor.add(String.valueOf(author.getFirstName()));
        listAuthor.add(String.valueOf(author.getSecondName()));
        listAuthor.add(String.valueOf(author.getGroup()));
        listAuthor.add(String.valueOf(author.getLeader()));
        listAuthor.add(String.valueOf(author.getHistory()));
        listAuthor.add(String.valueOf(author.getTested()));
        listAuthor.add(String.valueOf(author.getAdd_date()));
        listAuthor.add(String.valueOf(author.getConfirmation()));

        return listAuthor;
    }
}