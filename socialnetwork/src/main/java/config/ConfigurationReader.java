package config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ConfigurationReader {
    private final String fileName;

    public ConfigurationReader() {
        this.fileName = "databaseconfig.txt";
    }

    public ConfigurationReader(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getKeyWord(String keyWord){
        Stream<String> lines = null;

        try {
            lines = Files.lines(Paths.get(getFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<String> user = null;
        String lineWithKeyWord = null;
        if (lines != null) {
            user = lines.filter(line -> line.contains(keyWord)).findFirst();
            lineWithKeyWord = user.get();
        }else{
            throw new NullPointerException("Given key word is not correct!");
        }

        String[] split = lineWithKeyWord.replaceAll("\\s+","").split(":");
        if (split.length <= 1){
            return " ";
        }
        return split[1];
    }

    private String getProjectPath(){
        return new File("").getAbsolutePath();
    }

    private String getFilePath(){
        return getProjectPath() + "//" + fileName;
    }
}