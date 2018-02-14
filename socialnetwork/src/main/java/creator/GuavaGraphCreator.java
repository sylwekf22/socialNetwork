package creator;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import reader.CSVGraphReader;

import java.util.Iterator;
import java.util.stream.Stream;

// Metoda tworząca z pliku CSV graf za pomocą biblioteki Guava
public class GuavaGraphCreator {

    private CSVGraphReader csvGraphReader;

    public GuavaGraphCreator(String fileName) {
        this.csvGraphReader = new CSVGraphReader(fileName);
    }

    // Tworzymy graf danego typu xdddd
    public MutableValueGraph<String, String> createGraphFromFile(){
        MutableValueGraph<String, String> valueGraph = ValueGraphBuilder.undirected().allowsSelfLoops(true).build();
        Stream<String> csvLines = csvGraphReader.readCSV();
        Iterator<String> iterator = csvLines.iterator();

        while (iterator.hasNext()) {
            String[] splitLine = splitLine(iterator.next());
            valueGraph.putEdgeValue(splitLine[0], splitLine[2], splitLine[1]);
        }
        return valueGraph;
    }

    // dzielimy każdy wiersz na trzy części bo tyle znajduję się informacji w danym wierszu
    private String[] splitLine(String line){
        return line.split(",");
    }
}