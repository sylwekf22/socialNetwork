package graph;

import hibernatequeries.AuthorsNodesHibernate;
import hibernatequeries.AuthorsTitlesHibernate;
import hibernatequeries.TitlesHibernate;

import java.util.List;

public abstract class GraphConverter {
    AuthorsNodesHibernate authorsNodesHibernate;
    AuthorsTitlesHibernate authorsTitlesHibernate;
    TitlesHibernate titlesHibernate;

    GraphConverter() {
        this.authorsNodesHibernate = new AuthorsNodesHibernate();
        this.authorsTitlesHibernate = new AuthorsTitlesHibernate();
        this.titlesHibernate = new TitlesHibernate();
    }

    public abstract List<List<String>> convertGraphToList();
}
