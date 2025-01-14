package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexRecord.class */
public abstract class CommonBTIndexRecord<K extends CommonBTKey<K>> extends CommonBTRecord {
    protected final K key;
    protected final byte[] index = new byte[4];

    public static <K extends CommonBTKey<K>> CommonBTIndexRecord<K> createHFS(K key, byte[] data, int offset) {
        return new HFSImplementation(key, data, offset);
    }

    public static <K extends CommonBTKey<K>> CommonBTIndexRecord<K> createHFSPlus(K key, byte[] data, int offset) {
        return new HFSPlusImplementation(key, data, offset);
    }

    protected CommonBTIndexRecord(K key, byte[] data, int offset) {
        this.key = key;
        System.arraycopy(data, offset + key.occupiedSize(), this.index, 0, this.index.length);
    }

    public K getKey() {
        return this.key;
    }

    public long getIndex() {
        return Util.unsign(Util.readIntBE(this.index));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [byte[], byte[][]] */
    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
    public byte[] getBytes() {
        byte[] res = new byte[getSize()];
        Util.zero((byte[][]) new byte[]{res});
        byte[] keyData = this.key.getBytes();
        System.arraycopy(keyData, 0, res, 0, keyData.length);
        int i2 = 0 + keyData.length;
        System.arraycopy(this.index, 0, res, i2, this.index.length);
        int i3 = i2 + this.index.length;
        if (i3 != res.length) {
            throw new RuntimeException("Assertion failed: i == res.length (i=" + i3 + ",res.length=" + res.length + ")");
        }
        return res;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CommonBTIndexRecord:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " key:");
        this.key.print(ps, prefix + "  ");
        ps.println(prefix + " index: " + getIndex());
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexRecord$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexRecord$HFSImplementation.class */
    private static class HFSImplementation<K extends CommonBTKey<K>> extends CommonBTIndexRecord<K> {
        public HFSImplementation(K key, byte[] data, int offset) {
            super(key, data, offset);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            return this.key.occupiedSize() + this.index.length;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexRecord$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexRecord$HFSPlusImplementation.class */
    private static class HFSPlusImplementation<K extends CommonBTKey<K>> extends CommonBTIndexRecord<K> {
        public HFSPlusImplementation(K key, byte[] data, int offset) {
            super(key, data, offset);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            return this.key.occupiedSize() + this.index.length;
        }
    }
}
