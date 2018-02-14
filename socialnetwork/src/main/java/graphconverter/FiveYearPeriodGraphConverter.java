package graphconverter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// klasa jak poprzednia służy do zapisania grafu w zmiennej List<List<String>>

public class FiveYearPeriodGraphConverter extends GraphConverter{

    private String startDate;
    private String endDate;

    public FiveYearPeriodGraphConverter(String startDate, String endDate) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public List<List<String>> convertGraphToList() {
        List<List<String>> graph = new LinkedList<>();
        List<Integer> authors = authorsTitlesHibernate.getAuthorsIdBetweenTwoPublicationYears(startDate, endDate);

        for (Integer author: authors){
            List<Integer> titles = authorsTitlesHibernate.getTitlesGivingAuthorAndBetweenTwoPublicationYears(author, startDate, endDate);
            saveAuthorsTitles(graph, author, titles);
        }
        return graph;
    }

    @Override
    protected void saveAuthorsTitles(List<List<String>> graph, Integer author, List<Integer> titles) {
        for (Integer title: titles){
            List<Integer> coAuthors = authorsTitlesHibernate.getAuthorsGivingTitleAndBetweenTwoPublicationYears(title, startDate, endDate);
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
    protected void saveConnectionBetweenAuthorTitleAndCoAuthors(List<List<String>> graph, Integer author, Integer title, Set<Integer> coAuthorsSet) {
        for (Integer coAuthor : coAuthorsSet) {
            List<String> relationLine = new LinkedList<>();
            relationLine.add(String.valueOf(author));
            relationLine.add(String.valueOf(title));
            relationLine.add(String.valueOf(coAuthor));

            graph.add(relationLine);
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}