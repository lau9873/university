package org.catacombae.hfsexplorer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/SimpleDictionaryParser.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/SimpleDictionaryParser.class */
public class SimpleDictionaryParser {
    private static final String SPD_HEADER = "!SimpleDictionary";
    private Hashtable<String, String> dictionaryTable = new Hashtable<>();

    public SimpleDictionaryParser(InputStream is) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String firstLine = buf.readLine();
            firstLine.indexOf(":");
            String spdTag = firstLine.substring(0, firstLine.indexOf(":"));
            String spdVersion = firstLine.substring(firstLine.indexOf(":") + 1).trim();
            if (!spdTag.equals("!SimpleDictionary") || !spdVersion.equals("1.0")) {
                throw new RuntimeException("Invalid SimpleDictionary data.");
            }
            for (String currentLine = buf.readLine(); currentLine != null; currentLine = buf.readLine()) {
                currentLine.indexOf(":");
                String key = currentLine.substring(0, currentLine.indexOf(":"));
                String value = currentLine.substring(currentLine.indexOf(":") + 1).trim();
                this.dictionaryTable.put(key, value);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public String getValue(String key) {
        return this.dictionaryTable.get(key);
    }
}
