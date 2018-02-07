package graph;

import csv.CSVReader;
import org._3pq.jgrapht.edge.DefaultEdge;
import org._3pq.jgrapht.*;
import org.jgrapht.*;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

import java.util.Iterator;
import java.util.stream.Stream;

public class GraphCreatorToCalculation {

    private CSVReader csvReader;

    public CSVReader getCsvReader() {
        return csvReader;
    }

    public void setCsvReader(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public GraphCreatorToCalculation(CSVReader csvReader) {
        this.csvReader = csvReader;
    }


        public Graph<String, String> createGraphFromFile(){

            Graph<String, String> graph
                    = new SimpleGraph<>(String.class);

            Stream<String> csvLines = csvReader.readCSV();
            Iterator<String> iterator = csvLines.iterator();

            while (iterator.hasNext()) {
                String[] splitLine = splitLine(iterator.next());
                if(splitLine[0].equals(splitLine[2]))
                    continue;
                graph.addVertex(splitLine[0]);
                graph.addVertex(splitLine[2]);
                graph.addEdge(splitLine[0], splitLine[2], splitLine[1]);
            }
            return graph;
        }

    private String[] splitLine(String line){
        return line.split(",");
    }
}
