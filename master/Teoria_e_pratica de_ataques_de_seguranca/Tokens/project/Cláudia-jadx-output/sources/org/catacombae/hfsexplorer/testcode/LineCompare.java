package org.catacombae.hfsexplorer.testcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/LineCompare.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/LineCompare.class */
public class LineCompare {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedReader file2 = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
        long lineNumber = 0;
        String line1 = "";
        String line2 = "";
        while (true) {
            if (line1 != null || line2 != null) {
                if (line1 == null) {
                    System.out.println("File 1 ended at line " + lineNumber + ". Files are not equal.");
                    System.exit(1);
                } else if (line2 == null) {
                    System.out.println("File 2 ended at line " + lineNumber + ". Files are not equal.");
                    System.exit(1);
                } else if (!line1.equals(line2)) {
                    System.out.println("Files differ at line " + lineNumber + ":");
                    System.out.println("File 1:");
                    System.out.println(line1);
                    System.out.println("File 2:");
                    System.out.println(line2);
                    System.exit(1);
                }
                lineNumber++;
                String str = "";
                while (true) {
                    line1 = str;
                    if (line1 == null || !line1.trim().equals("")) {
                        break;
                    }
                    str = file1.readLine();
                }
                String str2 = "";
                while (true) {
                    line2 = str2;
                    if (line2 != null && line2.trim().equals("")) {
                        str2 = file2.readLine();
                    }
                }
            } else {
                System.out.println("Files are equal (ignoring empty lines and different line endings).");
                return;
            }
        }
    }
}
