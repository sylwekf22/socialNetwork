package graphconverter;

import hibernatequeries.AuthorsNodesHibernate;
import hibernatequeries.AuthorsTitlesHibernate;
import hibernatequeries.TitlesHibernate;

import java.util.List;
import java.util.Set;

// klasa abstrakcyjna z deklaracjami metod

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

    protected abstract void saveConnectionBetweenAuthorTitleAndCoAuthors(List<List<String>> graph,
                                                                         Integer author,
                                                                         Integer title,
                                                                         Set<Integer> coAuthorsSet);

    protected abstract void saveAuthorsTitles(List<List<String>> graph, Integer author, List<Integer> titles);
}
