package databasequeries;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AvgDegree {
    private final SessionFactory sessionFactory;
    private final AuthorsNodesHibernate authorsNodesHibernate;
    private final TitlesHibernate titlesHibernate;
    private final AuthorsTitlesHibernate authorsTitlesHibernate;

    public AvgDegree() {
        this.sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        this.authorsNodesHibernate = new AuthorsNodesHibernate();
        this.titlesHibernate = new TitlesHibernate();
        this.authorsTitlesHibernate = new AuthorsTitlesHibernate();
    }

    public float countAvgDegree(){
        List<Integer> authorsId = authorsNodesHibernate.getAuthorsId();
        Set<Integer> degree = new LinkedHashSet<>();
        float sum = 0;

        for(Integer authorId: authorsId){
            List<Integer> authorTitles = authorsTitlesHibernate.getTitlesGivingAuthor(authorId);

            for(Integer authorTitle: authorTitles){
                List<Integer> coAuthors = authorsTitlesHibernate.getAuthorsGivingTitle(authorTitle);
                degree.addAll(coAuthors);
            }
            degree.remove(authorId);
            sum+=degree.size();
            System.out.println("Autor : " + authorId + " Sum : " + sum + " degree : " + degree.size());
            degree.clear();
        }
        return sum / authorsId.size();
    }
}