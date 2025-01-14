package org.catacombae.jparted.lib.ps;

import java.util.LinkedList;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
import org.catacombae.jparted.lib.DataLocator;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemDetector.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemDetector.class */
public class PartitionSystemDetector {
    public static PartitionSystemType[] detectPartitionSystem(DataLocator inputDataLocator) {
        ReadableRandomAccessStream dlStream = inputDataLocator.createReadOnlyFile();
        PartitionSystemType[] result = detectPartitionSystem(dlStream);
        dlStream.close();
        return result;
    }

    public static PartitionSystemType[] detectPartitionSystem(ReadableRandomAccessStream psStream) {
        long len;
        try {
            len = psStream.length();
        } catch (RuntimeIOException e2) {
            len = -1;
        }
        return detectPartitionSystem(psStream, 0L, len);
    }

    public static PartitionSystemType[] detectPartitionSystem(ReadableRandomAccessStream psStream, long off, long len) {
        LinkedList<PartitionSystemType> result = new LinkedList<>();
        PartitionSystemType[] arr$ = PartitionSystemType.values();
        for (PartitionSystemType type : arr$) {
            PartitionSystemHandlerFactory fact = type.createDefaultHandlerFactory();
            if (fact != null && fact.getRecognizer().detect(psStream, off, len)) {
                result.add(type);
            }
        }
        return (PartitionSystemType[]) result.toArray(new PartitionSystemType[result.size()]);
    }
}
