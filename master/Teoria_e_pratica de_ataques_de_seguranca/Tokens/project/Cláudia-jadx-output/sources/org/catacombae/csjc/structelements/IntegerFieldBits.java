package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/IntegerFieldBits.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/IntegerFieldBits.class */
public enum IntegerFieldBits {
    BITS_8(8),
    BITS_16(16),
    BITS_32(32),
    BITS_64(64);
    
    private final int bitCount;

    IntegerFieldBits(int bitCount) {
        this.bitCount = bitCount;
    }

    public int getBits() {
        return this.bitCount;
    }

    public int getBytes() {
        return this.bitCount / 8;
    }
}
