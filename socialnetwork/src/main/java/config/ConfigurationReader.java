package config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

class ConfigurationReader {
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

    public String get(String keyWord){
        /*
          Parameter keyWord can only get one of 3 values:
          - databaseName
          - user
          - password
         */
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(getFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<String> user = lines.filter(s -> s.contains(keyWord)).findFirst();
        String s = user.get();

        String[] split = s.replaceAll("\\s+","").split(":");
        if (split.length <= 1){
            return " ";
        }
        return split[1];
    }

    private String getProjectPath(){
        return new File("").getAbsolutePath();
    }

    private String getFilePath(){
        return getProjectPath() + "//" + this.fileName;
    }
}