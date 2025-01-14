package org.catacombae.xml;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/ExternalID.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/ExternalID.class */
public class ExternalID {
    public static final int SYSTEM = 0;
    public static final int PUBLIC = 1;
    public int type = 1;
    public String pubidLiteral;
    public String systemLiteral;

    public ExternalID(String pubidLiteral, String systemLiteral) {
        this.pubidLiteral = pubidLiteral;
        this.systemLiteral = systemLiteral;
    }

    public ExternalID(String systemLiteral) {
        this.systemLiteral = systemLiteral;
    }
}
