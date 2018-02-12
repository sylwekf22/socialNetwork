package creator;

import reader.CSVConnectedComponentsReader;

import java.util.*;
import java.util.stream.Stream;

public class GuavaConnectedComponentsCreator {

    private CSVConnectedComponentsReader csvConnectedComponentsReader;

    public GuavaConnectedComponentsCreator(String fileName) {
        this.csvConnectedComponentsReader = new CSVConnectedComponentsReader(fileName);
    }

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

    private String[] splitLineIntoIndexAndListOfNodes(String line){
        return line.split(",",2);
    }

    private String[] splitNodes(String line) {
        return line.split(",");
    }
}