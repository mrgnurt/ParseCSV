import java.util.Collections;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class ParseUtils {
    /**
     * Parse String line file CSV with format column1|column2...|columnn
     * @param str String line file CS
     * @return The resulting string
     */
    public String parseCSVLine(String str) {
        StringBuilder builder = new StringBuilder();
        boolean isQuote = false;
        for (int i = 0; i < str.length(); i++) {
            if (isQuote) {
                if (str.charAt(i) == Constant.QUOTE) {
                    //if have double queue, check next character is comma
                    //if true is end of column, if false append builder
                    if (i + 1 < str.length() && str.charAt(i+1) == Constant.COMMA) {
                        isQuote = false;
                    } else {
                        builder.append(str.charAt(i));
                    }
                } else {
                    builder.append(str.charAt(i));
                }
            } else {
                //handle case no prefix quote
                if (str.charAt(i) == Constant.QUOTE) {
                    isQuote = true;
                } else if (str.charAt(i) == Constant.COMMA){
                    builder.append(Constant.VERTICAL);
                } else {
                    builder.append(str.charAt(i));
                }
            }
        }

        return builder.toString();
    }
}
