package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    private static byte byteValue = 10;
    private static short shortValue = 20;
    private static int intValue = 30;
    private static long longValue = 40L;

    private static float floatValue = 50.0f;
    private static double doubleValue = 60.0;

    private static char charValue = 'a';
    private static boolean boolValue = true;

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        LOG.debug("Numbers examples byte -> {} short -> {} int -> {} long -> {} ",
                byteValue, shortValue, intValue, longValue);
        LOG.debug("Floating point nums float -> {} double -> {}", floatValue, doubleValue);
        LOG.debug("And other char -> {} boolean-> {}", charValue, boolValue);
    }
}
