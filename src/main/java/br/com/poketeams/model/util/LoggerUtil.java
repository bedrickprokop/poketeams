package br.com.poketeams.model.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoggerUtil<T> {

    private Logger logger;

    public LoggerUtil(Class<T> clazz) {
        logger = Logger.getLogger(clazz);
    }

    public void log(String message) {
        log(message, Level.INFO);
    }

    public void log(String message, Level level) {
        log(message, level, null);
    }

    public void log(String message, Level level, Map<String, String> details) {
        Set<String> keys = new HashSet<String>();
        if (details != null || !details.isEmpty()) {
            keys = details.keySet();
        }

        if (level.equals(Level.INFO)) {
            logger.info(message);
            for (String key : keys) {
                logger.info(key.concat(": ").concat(details.get(key)));
            }
        } else if (level.equals(Level.WARN)) {
            logger.warn(message);
            for (String key : keys) {
                logger.warn(key.concat(": ").concat(details.get(key)));
            }
        } else if (level.equals(Level.ERROR)) {
            logger.error(message);
            for (String key : keys) {
                logger.error(key.concat(": ").concat(details.get(key)));
            }
        }
    }
}
