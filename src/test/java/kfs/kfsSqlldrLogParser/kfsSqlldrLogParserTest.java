package kfs.kfsSqlldrLogParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class kfsSqlldrLogParserTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public kfsSqlldrLogParserTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(kfsSqlldrLogParserTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testTestLine() {
        String s = "  6300 Rows successfully loaded.";
        kfsSqlldrLogParser p = new kfsSqlldrLogParser();
        Integer i = p.readSuccessfullyReaded(s);
        assertNotNull("Cannot return null for this string", i);
        assertEquals("return must be 6300", 6300, i.intValue());
        i = p.readSuccessfullyReaded("puva jebat");
        assertNull("Must be null for this string", i);
    }
}
