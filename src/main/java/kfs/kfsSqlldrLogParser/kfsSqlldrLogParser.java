package kfs.kfsSqlldrLogParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pavedrim
 */
public class kfsSqlldrLogParser {

    private final Pattern successfullyreaded = Pattern.compile("^(^\\d+) Rows successfully loaded.$");

    public Integer readSuccessfullyReaded(String s) {
        if (s != null) {
            Matcher m = successfullyreaded.matcher(s.trim());
            if (m.find()) {
                return Integer.parseInt(m.group(1));
            }
        }
        return null;
    }

    public Integer readSuccessfullyReadedFromLogFile(String file) throws kfsSqlldrLogParserException{
        if (file == null) {
            throw new kfsSqlldrLogParserException("Null filename");
        } else {
            File fil = new File(file);
            if (!fil.exists()) {
                throw new kfsSqlldrLogParserException("File " + file + " doesnot exist");
            } else {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(fil));
                } catch (FileNotFoundException ex) {
                    throw new kfsSqlldrLogParserException("Cannot open file " + file, ex);
                }
                if (br != null) {
                    String line;
                    Integer readed = null;
                    try {
                        while ((line = br.readLine()) != null) {
                            if ((readed = readSuccessfullyReaded(line)) != null) {
                                break;
                            }
                        }
                    } catch (IOException ex) {
                        throw new kfsSqlldrLogParserException("Cannot read file " + file, ex);
                    }
                    try {
                        br.close();
                    } catch (IOException ex) {
                        throw new kfsSqlldrLogParserException("Cannot close file", ex);
                    }
                    return readed;
                }
            }
        }
        return null;
    }
}
