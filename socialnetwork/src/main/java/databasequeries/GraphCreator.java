package databasequeries;

import hibernatequeries.AuthorsNodesHibernate;
import hibernatequeries.AuthorsTitlesHibernate;

import java.util.*;

public class GraphCreator {

    private final AuthorsNodesHibernate authorsNodesHibernate;
    private final AuthorsTitlesHibernate authorsTitlesHibernate;

    public GraphCreator() {
        this.authorsNodesHibernate = new AuthorsNodesHibernate();
        this.authorsTitlesHibernate = new AuthorsTitlesHibernate();
    }

    public List<List<String>> createGraph(){
        List<List<String>> graph = new LinkedList<>();
        List<Integer> authors = authorsNodesHibernate.getAuthorsId();

        for (Integer author: authors){
            List<Integer> titles = authorsTitlesHibernate.getTitlesGivingAuthor(author);

            for (Integer title: titles){
                List<Integer> coAuthors = authorsTitlesHibernate.getAuthorsGivingTitle(title);
                Set<Integer> coAuthorsSet = new HashSet<>(coAuthors);

                if (coAuthorsSet.size() <= 1){
                    for (Integer coAuthor : coAuthorsSet) {
                        List<String> relationLine = new LinkedList<>();
                        relationLine.add(String.valueOf(author));
                        relationLine.add(String.valueOf(title));
                        relationLine.add(String.valueOf(coAuthor));

                        graph.add(relationLine);
                    }
                } else if (coAuthorsSet.contains(author)) {
                    coAuthorsSet.remove(author);

                    for (Integer coAuthor : coAuthorsSet) {
                        List<String> relationLine = new LinkedList<>();
                        relationLine.add(String.valueOf(author));
                        relationLine.add(String.valueOf(title));
                        relationLine.add(String.valueOf(coAuthor));

                        graph.add(relationLine);
                    }
                }else{
                    for (Integer coAuthor : coAuthorsSet) {
                        List<String> relationLine = new LinkedList<>();
                        relationLine.add(String.valueOf(author));
                        relationLine.add(String.valueOf(title));
                        relationLine.add(String.valueOf(coAuthor));

                        graph.add(relationLine);
                    }
                }
            }
        }
        return graph;
    }
}