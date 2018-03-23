package javase03.t01;

import java.util.Calendar;
import java.util.Formatter;

public class CrazyLogger {
    StringBuilder logger = new StringBuilder();

    void addMessage(String message) {
        Calendar calendar = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%1td-%<tm-%<tY : %<tH-%<tM – %s;\n", calendar, message);
        logger.append(formatter);
    }

    String search(String str) {
        StringBuilder result = new StringBuilder();
        String line;
        int beginningOfLine;
        int endOfLine;

        beginningOfLine = 0;
        do {
            endOfLine = logger.indexOf("\n", beginningOfLine) + 1;
            line = logger.substring(beginningOfLine, endOfLine);
            beginningOfLine = endOfLine;

            if (line.contains(str))
                result.append(line);
        } while (endOfLine != logger.length());
        return result.toString();
    }
}
