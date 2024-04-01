package top.yxy.boot.mp.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author Administrator
 */
public class LogTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args){
        LOGGER.trace("Trace 日志...");
        LOGGER.debug("debug 日志...");
        LOGGER.info("info 日志...");
        LOGGER.warn("warn 日志...");
        LOGGER.error("error 日志...");
    }
}
