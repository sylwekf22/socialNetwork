package graphconverter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MediumGraphConverter extends GraphConverter{

    public MediumGraphConverter() {
        super();
    }

    @Override
    public List<List<String>> convertGraphToList() {
        List<List<String>> graph = new LinkedList<>();
        List<Integer> authors = authorsNodesHibernate.getAuthorsId();

        for (Integer author: authors){
            List<Integer> titles = authorsTitlesHibernate.getTitlesGivingAuthor(author);
            saveAuthorsTitles(graph, author, titles);
        }
        return graph;
    }

    @Override
    protected void saveAuthorsTitles(List<List<String>> graph, Integer author, List<Integer> titles) {
        for (Integer title: titles){
            List<Integer> coAuthors = authorsTitlesHibernate.getAuthorsGivingTitle(title);
            Set<Integer> coAuthorsSet = new HashSet<>(coAuthors);

            if (coAuthorsSet.size() <= 1){
                saveConnectionBetweenAuthorTitleAndCoAuthors(graph, author, title, coAuthorsSet);
            } else if (coAuthorsSet.contains(author)) {
                coAuthorsSet.remove(author);
                saveConnectionBetweenAuthorTitleAndCoAuthors(graph, author, title, coAuthorsSet);
            }else{
                saveConnectionBetweenAuthorTitleAndCoAuthors(graph, author, title, coAuthorsSet);
            }
        }
    }

    @Override
    protected void saveConnectionBetweenAuthorTitleAndCoAuthors(List<List<String>> graph,
                                                                Integer author,
                                                                Integer title,
                                                                Set<Integer> coAuthorsSet) {
        for (Integer coAuthor : coAuthorsSet) {
            List<String> relationLine = new LinkedList<>();

            relationLine.add(String.valueOf(author));
            relationLine.addAll(authorsNodesHibernate.getFirstNameAndSecondName(String.valueOf(author)));
            relationLine.add(String.valueOf(title));
            relationLine.add(titlesHibernate.getTitle(String.valueOf(title)));
            relationLine.add(String.valueOf(coAuthor));
            relationLine.addAll(authorsNodesHibernate.getFirstNameAndSecondName(String.valueOf(coAuthor)));

            graph.add(relationLine);
        }
    }
}