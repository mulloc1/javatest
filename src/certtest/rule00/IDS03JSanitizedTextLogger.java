package certtest.rule00;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDS03JSanitizedTextLogger extends Logger {
    Logger delegate;

    public IDS03JSanitizedTextLogger(Logger delegate) {
        super(delegate.getName(), delegate.getResourceBundleName());
        this.delegate = delegate;
    }

    public String sanitize(String msg) {
        Pattern newline = Pattern.compile("\n");
        Matcher matcher = newline.matcher(msg);
        return matcher.replaceAll("\n   ");
    }

    public void severe(String msg) {
        delegate.severe(sanitize(msg));
    }
}
