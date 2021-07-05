import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class CSVFileTest {
    private CSVFile csvFile;

    @BeforeEach
    void setUp() {
        csvFile = new CSVFile();
    }

    @Test
    public void testNormal() {
        List<String> tests = csvFile.parseCSVFile("test.csv");
        List<String> expected = new ArrayList<>();
        expected.add("java|python|javascript|golang|html|css");
        expected.add("java|python|javascript,golang,html,css");
        expected.add("java|python|javascript,golang|html|css");
        expected.add("java|python,javasc\"ript,golang,html,css");
        expected.add("java|python,javasc\"ript,golang|html|css");
        expected.add("java|@python|javascript|golang##|html|*css*");

        assertEquals(expected, tests);
    }
}
