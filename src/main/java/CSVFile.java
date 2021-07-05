import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    /**
     * Read and parse file CSV
     * @param fileName
     * @return String list after parse row in file CSV
     */
    public List<String> parseCSVFile(String fileName) {
        List<String> result = new ArrayList<>();
        ParseUtils parseUtils = new ParseUtils();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream != null) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            try {
                BufferedReader buffer = new BufferedReader(reader);
                String line;
                while ((line = buffer.readLine()) != null) {
                    result.add(parseUtils.parseCSVLine(line));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
