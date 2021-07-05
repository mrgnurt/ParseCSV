import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseUtilsTest {
    private ParseUtils utils;

    @BeforeEach
    void setUp() {
        utils = new ParseUtils();
    }

    @Test
    public void testNormal() {
        String test = "java,python,javascript,golang,html,css";
        String expected = "java|python|javascript|golang|html|css";
        assertEquals(expected, utils.parseCSVLine(test));
    }

    @Test
    public void testWithOneQuote() {
        String test = "java,python,\"javascript,golang,html,css";
        String expected = "java|python|javascript,golang,html,css";
        assertEquals(expected, utils.parseCSVLine(test));
    }

    @Test
    public void testWithTwoQuoteEnded() {
        String test = "java,python,\"javascript,golang\",html,css";
        String expected = "java|python|javascript,golang|html|css";
        assertEquals(expected, utils.parseCSVLine(test));
    }

    @Test
    public void testWithTwoQuoteNotEnded() {
        String test = "java,\"python,javasc\"ript,golang,html,css";
        String expected = "java|python,javasc\"ript,golang,html,css";
        assertEquals(expected, utils.parseCSVLine(test));
    }

    @Test
    public void testWithMultipleQuote() {
        String test = "java,\"python,javasc\"ript,golang\",html,css";
        String expected = "java|python,javasc\"ript,golang|html|css";
        assertEquals(expected, utils.parseCSVLine(test));
    }

    @Test
    public void testWithMultipleQuote1() {
        String test = "java,\"python,javascript\",\"golang,html\",css";
        String expected = "java|python,javascript|golang,html|css";
        assertEquals(expected, utils.parseCSVLine(test));
    }

    @Test
    public void testWithSpecialCharacter() {
        String test = "java,@python,javascript,golang##,html,*css*";
        String expected = "java|@python|javascript|golang##|html|*css*";
        assertEquals(expected, utils.parseCSVLine(test));
    }
}
