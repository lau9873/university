package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/IntegerFieldRepresentation.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/IntegerFieldRepresentation.class */
public enum IntegerFieldRepresentation {
    DECIMAL("", 10),
    HEXADECIMAL("0x", 16),
    OCTAL("0", 8),
    BINARY("0b", 2);
    
    private final String prefix;
    private final int radix;

    IntegerFieldRepresentation(String prefix, int radix) {
        this.prefix = prefix;
        this.radix = radix;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public int getRadix() {
        return this.radix;
    }
}
