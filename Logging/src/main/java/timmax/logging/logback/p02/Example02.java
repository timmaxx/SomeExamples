package timmax.logging.logback.p02;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Example02 {
    public static void main(String[] args) {
        Logger parentLogger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback");
        parentLogger.setLevel(Level.INFO);

        Logger childlogger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback.tests");

        parentLogger.warn("This message is logged because WARN > INFO.");
        parentLogger.debug("This message is not logged because DEBUG < INFO.");
        childlogger.info("INFO == INFO");
        childlogger.debug("DEBUG < INFO");
    }
}
