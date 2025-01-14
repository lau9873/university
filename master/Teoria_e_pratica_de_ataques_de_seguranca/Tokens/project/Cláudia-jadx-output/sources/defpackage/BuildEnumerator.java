package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;
/* renamed from: BuildEnumerator  reason: default package */
/* loaded from: hfsexplorer-0_21-src.zip:lib/buildenumerator.jar:BuildEnumerator.class */
public class BuildEnumerator {
    public static final String OPENING_SIGNATURE = "//[BuildEnumerator:Opening]";
    public static final String STANDARD_OPENING = "//[BuildEnumerator:Opening] WARNING: The following lines are managed by an external program. Do NOT change.";
    public static final String CLOSING_SIGNATURE = "//[BuildEnumerator:Closing]";
    public static final String STANDARD_CLOSING = "//[BuildEnumerator:Closing] The lines managed by an external program end here.";
    public static final String VARIABLE_DECLARATION = "public static final long BUILD_NUMBER = ";

    public static void main(String[] strArr) {
        String trim;
        if (strArr.length != 2) {
            System.err.println("Only two arguments allowed.");
            System.exit(1);
        }
        try {
            if (!new File(strArr[0]).exists()) {
                System.out.println("ERROR: The file does not exist!");
                System.exit(1);
            }
            int parseInt = Integer.parseInt(strArr[1]);
            RandomAccessFile randomAccessFile = new RandomAccessFile(strArr[0], "rw");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            boolean z = false;
            for (String readLine = randomAccessFile.readLine(); readLine != null; readLine = randomAccessFile.readLine()) {
                printStream.println(readLine);
                if (readLine.trim().startsWith(OPENING_SIGNATURE)) {
                    String trim2 = randomAccessFile.readLine().trim();
                    String substring = trim2.substring(trim2.lastIndexOf(32) + 1, trim2.lastIndexOf(59));
                    if (substring.endsWith("L")) {
                        substring = substring.substring(0, substring.length() - 1);
                    }
                    long parseLong = Long.parseLong(substring) + parseInt;
                    System.out.println("Current build number: " + parseLong);
                    printStream.println(readLine.substring(0, readLine.indexOf(trim)) + VARIABLE_DECLARATION + parseLong + "L;");
                    z = true;
                }
            }
            printStream.flush();
            if (z) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                randomAccessFile.setLength(byteArray.length);
                randomAccessFile.seek(0L);
                randomAccessFile.write(byteArray);
                randomAccessFile.close();
            } else {
                System.out.println("BuildEnumerator found no lines to change! The input file is untouched.");
                System.exit(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            System.exit(1);
        }
    }
}
