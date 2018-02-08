package graphcreator;

import csv.CSVReader;

public abstract class GraphCreator {
    protected CSVReader csvReader;

    public GraphCreator(String fileName) {
        this.csvReader = new CSVReader(fileName);
    }

    public abstract Object createGraphFromFile();

    protected String[] splitLine(String line){
        return line.split(",");
    }
}
