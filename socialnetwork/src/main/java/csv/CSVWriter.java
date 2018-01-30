package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    private final char separator;

    public CSVWriter() {
        this.separator = ',';
    }

    public CSVWriter(char separator) {
        this.separator = separator;
    }

    public void writeLine(FileWriter w, List<String> values) throws IOException {
        writeLine(w, values, separator, ' ');
    }

    public void writeLine(FileWriter w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    public void writeLine(FileWriter fileWriter, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        if (separators == ' ') {
            separators = separator;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String value : values) {
            if (!first) {
                stringBuilder.append(separators);
            }
            if (customQuote == ' ') {
                stringBuilder.append(replaceQuotes(value));
            } else {
                stringBuilder.append(customQuote).append(replaceQuotes(value)).append(customQuote);
            }

            first = false;
        }
        stringBuilder.append("\n");
        fileWriter.append(stringBuilder.toString());
    }

    private static String replaceQuotes(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public void saveDataToCSV(List<List<String>> data, String fileName) throws IOException {
        String csvFileName = fileName + ".csv";
        FileWriter writer = new FileWriter(csvFileName);

        for (List<String> relationLine: data){
            writeLine(writer, relationLine, ',');
        }

        writer.flush();
        writer.close();
    }
}