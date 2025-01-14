package org.catacombae.xml;

import java.nio.charset.Charset;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/XMLContentHandler.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/XMLContentHandler.class */
public abstract class XMLContentHandler {
    protected Charset encoding;

    public abstract void xmlDecl(String str, String str2, Boolean bool);

    public abstract void pi(String str, String str2);

    public abstract void comment(String str);

    public abstract void doctype(String str, ExternalID externalID);

    public abstract void cdata(String str);

    public abstract void emptyElement(String str, List<Attribute> list);

    public abstract void startElement(String str, List<Attribute> list);

    public abstract void endElement(String str);

    public abstract void chardata(int i2, int i3, int i4, int i5);

    public abstract void reference(String str);

    public XMLContentHandler(Charset encoding) {
        this.encoding = encoding;
    }
}
