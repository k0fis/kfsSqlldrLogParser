package kfs.kfsSqlldrLogParser;

/**
 *
 * @author pavedrim
 */
public class kfsSqlldrLogParserException extends Exception {

    kfsSqlldrLogParserException(String msg) {
        super(msg);
    }

    kfsSqlldrLogParserException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
