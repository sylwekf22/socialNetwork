package hibernatequeries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.Author;
import pojo.Title;

import java.util.LinkedList;
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

    public Title getTitle(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Title t WHERE t.id = :titleId ORDER BY t.id ASC");
        query.setParameter("titleId", Integer.valueOf(id));

        Title title = (Title)query.uniqueResult();

        transaction.commit();
        session.close();

        return title;
    }

    public List<String> getTitleAndConvertToList(String id){
        Title title = getTitle(id);
        List<String> listTitle = new LinkedList<>();

        listTitle.add(String.valueOf(title.getId()));
        listTitle.add(String.valueOf(title.getTitle()));
        listTitle.add(String.valueOf(title.getPublication_place()));
        listTitle.add(String.valueOf(title.getPublication_year()));
        listTitle.add(String.valueOf(title.getPublisher_id()));
        listTitle.add(String.valueOf(title.getPublication_month()));
        listTitle.add(String.valueOf(title.getBook_chapter()));
        listTitle.add(String.valueOf(title.getPages()));
        listTitle.add(String.valueOf(title.getBook_volume()));
        listTitle.add(String.valueOf(title.getNote()));
        listTitle.add(String.valueOf(title.getBook_series()));
        listTitle.add(String.valueOf(title.getSubtitle()));
        listTitle.add(String.valueOf(title.getSchool()));
        listTitle.add(String.valueOf(title.getUser_id()));
        listTitle.add(String.valueOf(title.getUrl()));
        listTitle.add(String.valueOf(title.getIsbn()));
        listTitle.add(String.valueOf(title.getPreface()));
        listTitle.add(String.valueOf(title.getIssn()));
        listTitle.add(String.valueOf(title.getClassifier()));
        listTitle.add(String.valueOf(title.getReturn_date()));
        listTitle.add(String.valueOf(title.getPublic_key()));
        listTitle.add(String.valueOf(title.getEe_dblp()));
        listTitle.add(String.valueOf(title.getUrl_dblp()));
        listTitle.add(String.valueOf(title.getCdrom_dblp()));
        listTitle.add(String.valueOf(title.getCrossref_dblp()));
        listTitle.add(String.valueOf(title.getHowpublished()));
        listTitle.add(String.valueOf(title.getType()));
        listTitle.add(String.valueOf(title.getInstitution()));
        listTitle.add(String.valueOf(title.getConfirmation()));

        return listTitle;
    }
}
