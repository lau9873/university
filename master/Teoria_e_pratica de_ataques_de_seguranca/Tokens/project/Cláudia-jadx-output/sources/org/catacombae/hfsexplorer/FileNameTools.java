package org.catacombae.hfsexplorer;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileNameTools.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileNameTools.class */
public class FileNameTools {
    private static HashSet<String> reservedWindowsFilenames = null;

    public static String autoRenameIllegalFilename(String filename, File outDir, boolean isDirectory) {
        String createdFilename;
        char c2;
        if (isReservedWindowsFilename(filename)) {
            filename = getSafeRandomFilename("hfsx");
        }
        char[] filenameChars = filename.toCharArray();
        for (int i2 = 0; i2 < filenameChars.length; i2++) {
            int c3 = Util.unsign(filenameChars[i2]);
            if (c3 < 32 || c3 == 127 || (c3 >= 128 && c3 <= 159)) {
                filenameChars[i2] = '_';
            } else if (isIllegalWindowsCharacter(c3)) {
                filenameChars[i2] = '_';
            }
        }
        for (int i3 = filenameChars.length - 1; i3 >= 0 && ((c2 = filenameChars[i3]) == ' ' || c2 == '.'); i3--) {
            filenameChars[i3] = '_';
        }
        String filename2 = new String(filenameChars);
        String createdFilename2 = tryCreate(filename2, outDir, isDirectory);
        if (createdFilename2 != null) {
            return createdFilename2;
        }
        if (filename2.length() > 240) {
            filename2 = filename2.substring(0, 240);
            String createdFilename3 = tryCreate(filename2, outDir, isDirectory);
            if (createdFilename3 != null) {
                return createdFilename3;
            }
        }
        if (filename2.length() > 27) {
            filename2 = filename2.substring(0, 27);
            String createdFilename4 = tryCreate(filename2, outDir, isDirectory);
            if (createdFilename4 != null) {
                return createdFilename4;
            }
        }
        if (filename2.length() > 8 && (createdFilename = tryCreate(filename2.substring(0, 8), outDir, isDirectory)) != null) {
            return createdFilename;
        }
        String createdFilename5 = tryCreate(getSafeRandomFilename("hfsx"), outDir, isDirectory);
        if (createdFilename5 != null) {
            return createdFilename5;
        }
        return null;
    }

    public static String getSafeRandomFilename(String prefix) {
        int suffixLength = 8 - prefix.length();
        if (suffixLength <= 0) {
            return prefix.substring(0, 8);
        }
        int suffixBase = 1;
        for (int i2 = 0; i2 < suffixLength; i2++) {
            suffixBase *= 10;
        }
        String suffixString = Integer.toString((int) (Math.random() * (suffixBase - 1)));
        return prefix + suffixString;
    }

    public static String tryCreate(String filename, File outDir, boolean asDirectory) {
        File f2 = new File(outDir, filename);
        int i2 = 0;
        while (f2.exists() && i2 < 999) {
            int i3 = i2;
            i2++;
            filename = filename + "." + i3;
            f2 = new File(outDir, filename);
        }
        if (f2.exists()) {
            return null;
        }
        try {
            if (asDirectory) {
                if (f2.mkdir()) {
                    f2.delete();
                    return filename;
                }
                return null;
            } else if (f2.createNewFile()) {
                f2.delete();
                return filename;
            } else {
                return null;
            }
        } catch (IOException e2) {
            System.err.println("IOException while trying to create \"" + f2.getAbsolutePath() + "\" as " + (asDirectory ? "directory" : "file") + ":");
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isIllegalWindowsCharacter(char c2) {
        return isIllegalWindowsCharacter(Util.unsign(c2));
    }

    private static boolean isIllegalWindowsCharacter(int c2) {
        if (c2 < 32) {
            return true;
        }
        switch (c2) {
            case 34:
            case 42:
            case 47:
            case 58:
            case 60:
            case 62:
            case 63:
            case 92:
            case 124:
                return true;
            default:
                return false;
        }
    }

    public static boolean isReservedWindowsFilename(String filename) {
        if (reservedWindowsFilenames == null) {
            reservedWindowsFilenames = buildReservedWindowsFilenames();
        }
        if (reservedWindowsFilenames.contains(filename)) {
            return true;
        }
        if (filename.charAt(4) == '.' && reservedWindowsFilenames.contains(filename.substring(0, 4))) {
            return true;
        }
        if (filename.charAt(3) == '.' && reservedWindowsFilenames.contains(filename.substring(0, 3))) {
            return true;
        }
        return false;
    }

    public static HashSet<String> buildReservedWindowsFilenames() {
        HashSet<String> result = new HashSet<>();
        result.add("CON");
        result.add("PRN");
        result.add("AUX");
        result.add("NUL");
        for (int i2 = 0; i2 < 10; i2++) {
            result.add("COM" + i2);
        }
        for (int i3 = 0; i3 < 10; i3++) {
            result.add("LPT" + i3);
        }
        result.add("CLOCK$");
        return result;
    }
}
