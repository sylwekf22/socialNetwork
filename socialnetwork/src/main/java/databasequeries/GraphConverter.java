package databasequeries;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import csv.CSVReader;

import java.util.Iterator;
import java.util.stream.Stream;

public class GraphConverter {
    private CSVReader csvReader;

    public GraphConverter(CSVReader csvReader) {
        this.csvReader = csvReader;
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

    private String[] splitLine(String line){
        return line.split(",");
    }
}