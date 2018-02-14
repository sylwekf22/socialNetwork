package creator;

import reader.CSVConnectedComponentsReader;

import java.util.*;
import java.util.stream.Stream;

// Klasa służąca do odczytywania spójnych składowych z pliku CSV
public class GuavaConnectedComponentsCreator {

    private CSVConnectedComponentsReader csvConnectedComponentsReader;

    // Podajemy reader, który odczytuje pod daną nazwą pliku
    public GuavaConnectedComponentsCreator(String fileName) {
        this.csvConnectedComponentsReader = new CSVConnectedComponentsReader(fileName);
    }

    // Tworzenie mapy spójnych komponentów, w którym klucz to identyfikator/indeks spójnego komponentu
    // Set to zbiór wierzchołków jakie zawiera dany komponent
    public Map<String, Set<String>> createConnectedComponentsMap(){
        Map<String, Set<String>> mapOfConnectedComponents = new HashMap<>();
        Stream<String> csvLines = csvConnectedComponentsReader.readCSV();
        Iterator<String> iterator = csvLines.iterator();

        while (iterator.hasNext()) {
            String[] arrayOfIndexOfConnectedComponentsAndNodes = splitLineIntoIndexAndListOfNodes(iterator.next());
            String[] arrayOfNodes = splitNodes(arrayOfIndexOfConnectedComponentsAndNodes[1]);

            Set<String> setOfNodes = new HashSet<>();
            setOfNodes.addAll(Arrays.asList(arrayOfNodes));

            mapOfConnectedComponents.put(arrayOfIndexOfConnectedComponentsAndNodes[0], setOfNodes);
        }

        return mapOfConnectedComponents;
    }

    // Robi split na danym wierszu w pliku i dzieli na indeks i set
    private String[] splitLineIntoIndexAndListOfNodes(String line){
        return line.split(",",2);
    }

    // Robi split na każdym stringu oddzielonym przecinkiem
    private String[] splitNodes(String line) {
        return line.split(",");
    }
}