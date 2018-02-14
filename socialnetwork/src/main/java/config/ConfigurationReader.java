package config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ConfigurationReader {
    private final String fileName;

    // Zwykły konstruktor bezargumentowy
    public ConfigurationReader() {
        this.fileName = "databaseconfig.txt";
    }

    // Konstruktor z parametrem określającym nazwę pliku
    public ConfigurationReader(String fileName) {
        this.fileName = fileName;
    }

    // Zwykły get
    public String getFileName() {
        return fileName;
    }

    // Pobierz słowo kluczowe z pliku databaseconfig.txt
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

    // Pobranie ścieżki projektu
    private String getProjectPath(){
        return new File("").getAbsolutePath();
    }

    // Pobranie ścieżki pliku databaseconfig.txt
    private String getFilePath(){
        return getProjectPath() + "//" + fileName;
    }
}