package reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CSVConnectedComponentsReader {
    private String fileName;

    public CSVConnectedComponentsReader() {
        this.fileName = "";
    }

    public CSVConnectedComponentsReader(String fileName) {
        this.fileName = fileName;
    }

    public Stream<String> readCSV(){
        Stream<String> lines = null;

        try {
            lines = Files.lines(Paths.get(getFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String getProjectPath(){
        return new File("").getAbsolutePath();
    }

    private String getFilePath(){
        return getProjectPath() + "//src//main//resources//connectedcomponents//" + fileName;
    }

    private String getFilePath(String fileName){
        return getProjectPath() + "//src//main//resources//connectedcomponents//" + fileName;
    }
}
