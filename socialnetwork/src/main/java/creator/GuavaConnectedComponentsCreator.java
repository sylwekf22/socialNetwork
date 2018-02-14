package creator;

import reader.CSVConnectedComponentsReader;

import java.util.*;
import java.util.stream.Stream;

// Klasa tworząca intepretację w kodzie programu listy spójnyh składowych
public class GuavaConnectedComponentsCreator {

    private CSVConnectedComponentsReader csvConnectedComponentsReader;

    // Konstruktor do którego podajemy nazwę pliku w celu odczytania spójnych składowych z pliku
    public GuavaConnectedComponentsCreator(String fileName) {
        this.csvConnectedComponentsReader = new CSVConnectedComponentsReader(fileName);
    }

    // Tworzenie spójnych składowych
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

    // Rozdzielenie linii na index i listę wierzchołków znajdujących się w danej składowej
    private String[] splitLineIntoIndexAndListOfNodes(String line){
        return line.split(",",2);
    }

    // Rozdzielenie każdego elementu w danym Stringu
    private String[] splitNodes(String line) {
        return line.split(",");
    }
}