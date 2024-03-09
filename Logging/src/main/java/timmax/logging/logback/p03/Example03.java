package timmax.logging.logback.p03;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Example03 {
    public static void main(String[] args) {
        Logger logger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback");
        logger.debug("Hi there!");

        Logger rootLogger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        logger.debug("This message is logged because DEBUG == DEBUG.");

        rootLogger.setLevel(Level.ERROR);

        logger.warn("This message is not logged because WARN < ERROR.");
        logger.error("This is logged.");

    }
}
