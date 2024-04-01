package top.yxy.boot.log.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author Administrator
 */
@Slf4j
public class LogTest {
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        LOGGER.trace("Trace 日志...");
        LOGGER.debug("Debug 日志...");
        LOGGER.info("Info 日志...");
        LOGGER.warn("Warn 日志...");
        LOGGER.error("Error 日志...");
       /* Logger myLogger = (Logger) LoggerFactory.getLogger("myLogger");
        myLogger.info("hello world");*/
    }
}
