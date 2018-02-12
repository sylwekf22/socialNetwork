package creator;

import org.jgrapht.graph.*;
import reader.CSVGraphReader;

import java.util.Iterator;
import java.util.stream.Stream;

public class JGraphTGraphCreator {

    private CSVGraphReader csvGraphReader;

    public JGraphTGraphCreator(String fileName) {
        this.csvGraphReader = new CSVGraphReader(fileName);
    }

    public Multigraph<String, String> createGraphFromFile(){
        Multigraph<String, String> graph = new Multigraph<>(String.class);
        Stream<String> csvLines = csvGraphReader.readCSV();
        Iterator<String> iterator = csvLines.iterator();

        while (iterator.hasNext()) {
            String[] splitLine = splitLine(iterator.next());

            if (splitLine[0].equals(splitLine[2])) {
                continue;
            }

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