package timmax.logging.logback.p04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example04 {
    public static void main(String[] args) {
        Logger logger =
                LoggerFactory.getLogger("com.baeldung.logback");

        String message = "This is a String";
        Integer zero = 0;

        try {
            logger.debug("Logging message: {}", message);
            logger.debug("Going to divide {} by {}", 42, zero);
            int result = 42 / zero;
        } catch (Exception e) {
            logger.error("Error dividing {} by {} ", 42, zero, e);
        }
    }
}
