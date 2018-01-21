package databasequeries;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import csv.CSVReader;
import dto.AuthorDto;
import dto.AuthorDtoConverter;
import dto.TitleDto;
import dto.TitleDtoConverter;
import hibernatequeries.AuthorsNodesHibernate;
import hibernatequeries.TitlesHibernate;
import pojo.Author;
import pojo.Title;

import java.util.Iterator;
import java.util.stream.Stream;

public class GraphConverter {
    private final AuthorsNodesHibernate authorsNodesHibernate;
    private final TitlesHibernate titlesHibernate;
    private CSVReader csvReader;

    public GraphConverter(CSVReader csvReader) {
        this.csvReader = csvReader;
        this.authorsNodesHibernate = new AuthorsNodesHibernate();
        this.titlesHibernate = new TitlesHibernate();
    }

    public CSVReader getCsvReader() {
        return csvReader;
    }

    public void setCsvReader(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public MutableValueGraph<String, String> convertCSVToGraph(){
        MutableValueGraph<String, String> valueGraph = ValueGraphBuilder.undirected().allowsSelfLoops(true).build();
        Stream<String> csvLines = csvReader.readCSV();
        Iterator<String> iterator = csvLines.iterator();

        while (iterator.hasNext()) {
            String[] splitLine = splitLine(iterator.next());
            valueGraph.putEdgeValue(splitLine[0], splitLine[2], splitLine[1]);
        }
        return valueGraph;
    }

    public MutableValueGraph<AuthorDto, TitleDto> convertCSVToGraphObjects(){
        MutableValueGraph<AuthorDto, TitleDto> valueGraph = ValueGraphBuilder.undirected().allowsSelfLoops(true).build();
        Stream<String> csvLines = csvReader.readCSV();
        Iterator<String> iterator = csvLines.iterator();

        while (iterator.hasNext()) {
            String[] splitLine = splitLine(iterator.next());
            Author firstAuthor = authorsNodesHibernate.getAuthor(splitLine[0]);
            Title title = titlesHibernate.getTitle(splitLine[1]);
            Author secondAuthor = authorsNodesHibernate.getAuthor(splitLine[2]);

            valueGraph.putEdgeValue(AuthorDtoConverter.convert(firstAuthor),
                                    AuthorDtoConverter.convert(secondAuthor),
                                    TitleDtoConverter.convert(title));
        }

        return valueGraph;
    }

    private String[] splitLine(String line){
        return line.split(",");
    }
}