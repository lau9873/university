package org.catacombae.jparted.lib.fs;

import java.util.LinkedList;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
import org.catacombae.jparted.lib.DataLocator;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemDetector.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemDetector.class */
public class FileSystemDetector {
    public static FileSystemMajorType[] detectFileSystem(DataLocator inputDataLocator) {
        ReadableRandomAccessStream dlStream = inputDataLocator.createReadOnlyFile();
        FileSystemMajorType[] result = detectFileSystem(dlStream);
        dlStream.close();
        return result;
    }

    public static FileSystemMajorType[] detectFileSystem(ReadableRandomAccessStream fsStream) {
        long len;
        try {
            len = fsStream.length();
        } catch (RuntimeIOException e2) {
            len = -1;
        }
        return detectFileSystem(fsStream, 0L, len);
    }

    public static FileSystemMajorType[] detectFileSystem(ReadableRandomAccessStream fsStream, long off, long len) {
        LinkedList<FileSystemMajorType> result = new LinkedList<>();
        FileSystemMajorType[] arr$ = FileSystemMajorType.values();
        for (FileSystemMajorType type : arr$) {
            FileSystemHandlerFactory fact = type.createDefaultHandlerFactory();
            if (fact != null && fact.getRecognizer().detect(fsStream, off, len)) {
                result.add(type);
            }
        }
        return (FileSystemMajorType[]) result.toArray(new FileSystemMajorType[result.size()]);
    }
}
