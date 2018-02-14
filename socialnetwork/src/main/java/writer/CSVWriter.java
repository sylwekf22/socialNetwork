package writer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Klasa zapisująca dane do pliku CSV
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

    public void saveDataToCSV(List<List<String>> data, String fileName) {
        String csvFileName = fileName + ".csv";
        FileWriter writer = null;
        try {
            writer = new FileWriter(csvFileName);

            for (List<String> relationLine: data){
                writeLine(writer, relationLine, ',');
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createHeaders(FileWriter fileWriter) throws IOException {

        fileWriter.append("source node").append(",");
        fileWriter.append("target node").append(",");
        fileWriter.append("path size").append("\n");
    }

    public void saveNodePaths(FileWriter fileWriter, String sourcrNode,  List<String> targetNodes, List<Integer> nodesPathSize) throws IOException {

        for(int i = 0; i < targetNodes.size(); i++) {
            fileWriter.append(sourcrNode).append(",");
            fileWriter.append(targetNodes.get(i)).append(",");
            fileWriter.append(nodesPathSize.get(i).toString()).append("\n");
        }
        fileWriter.flush();
    }

    public void savAdjacencyMatrixToTXT(FileWriter writer, List<Set<String>> adjencyList, Set<String> nodes) throws IOException {

        int nodeSize = nodes.size();
        Set<String> relatedAdjency;
        int i = 0;
            for (String rownode : nodes){
                relatedAdjency = adjencyList.get(i);
                writer.write("");
                for(String columnnode : nodes){
                    if(rownode.equals(columnnode) && relatedAdjency.contains(columnnode)){
                        writer.append("2 ");
                    }
                else if(relatedAdjency.contains(columnnode)) {
                    writer.append("1 ");
                }
                else {
                    writer.append("0 ");
                }
            }
                i += 1;
                writer.append("\n");

        }
        writer.flush();
        writer.close();
    }
}