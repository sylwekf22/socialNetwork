package graphconverter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Klasa tworząca graf w postaci List<List<String>>
// Za pomocą tej klasy stworzyć graf za pomocą biblioteki Guava
public class BigGraphConverter extends GraphConverter{

    public BigGraphConverter() {
        super();
    }

    // Konwertuje dane z dazy danych do postaci grafu List<List<String>>
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

    // Metoda zapisuje tytuły autorów
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

    // Metoda zapisująca połączenie pomiędzy autorem, tytułem i współautorami
    @Override
    protected void saveConnectionBetweenAuthorTitleAndCoAuthors(List<List<String>> graph,
                                                                Integer author,
                                                                Integer title,
                                                                Set<Integer> coAuthorsSet) {
        for (Integer coAuthor : coAuthorsSet) {
            List<String> relationLine = new LinkedList<>();
            relationLine.addAll(authorsNodesHibernate.getAuthorAndConvertToList(String.valueOf(author)));
            relationLine.addAll(titlesHibernate.getTitleAndConvertToList(String.valueOf(title)));
            relationLine.addAll(authorsNodesHibernate.getAuthorAndConvertToList(String.valueOf(coAuthor)));

            graph.add(relationLine);
        }
    }
}
