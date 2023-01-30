package logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    private static final Logger LOGGER = LogManager.getLogger(TestLogger.class);

    public static void logInfo(String info) {
        LOGGER.info(info);
    }

    public static void logError(String error, Exception exception) {
        LOGGER.error(error, exception);
    }

    public static void logMail(String mailString) {
        LOGGER.fatal(mailString);
    }
}