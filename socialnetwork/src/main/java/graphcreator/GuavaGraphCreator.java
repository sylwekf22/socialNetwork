package graphcreator;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.util.Iterator;
import java.util.stream.Stream;

public class GuavaGraphCreator extends GraphCreator{

    public GuavaGraphCreator(String fileName) {
        super(fileName);
    }

    public MutableValueGraph<String, String> createGraphFromFile(){
        MutableValueGraph<String, String> valueGraph = ValueGraphBuilder.undirected().allowsSelfLoops(true).build();
        Stream<String> csvLines = csvReader.readCSV();
        Iterator<String> iterator = csvLines.iterator();

        while (iterator.hasNext()) {
            String[] splitLine = splitLine(iterator.next());
            valueGraph.putEdgeValue(splitLine[0], splitLine[2], splitLine[1]);
        }
        return valueGraph;
    }
}