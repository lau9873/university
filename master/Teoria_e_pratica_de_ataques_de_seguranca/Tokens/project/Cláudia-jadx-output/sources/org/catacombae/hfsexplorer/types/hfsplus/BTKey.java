package org.catacombae.hfsexplorer.types.hfsplus;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTKey.class */
public abstract class BTKey implements Comparable<BTKey> {
    public abstract short getKeyLength();

    public abstract int length();

    public abstract byte[] getBytes();

    @Override // java.lang.Comparable
    public int compareTo(BTKey btk) {
        byte[] thisData = getBytes();
        byte[] thatData = btk.getBytes();
        for (int i2 = 0; i2 < Math.min(thisData.length, thatData.length); i2++) {
            int a2 = thisData[i2] & 255;
            int b2 = thatData[i2] & 255;
            if (a2 < b2) {
                return -1;
            }
            if (a2 > b2) {
                return 1;
            }
        }
        if (thisData.length < thatData.length) {
            return -1;
        }
        if (thisData.length > thatData.length) {
            return 1;
        }
        return 0;
    }
}
