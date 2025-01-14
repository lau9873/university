package org.catacombae.xml;

import java.nio.charset.Charset;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/NullXMLContentHandler.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/NullXMLContentHandler.class */
public class NullXMLContentHandler extends XMLContentHandler {
    public NullXMLContentHandler(Charset encoding) {
        super(encoding);
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void xmlDecl(String version, String encoding, Boolean standalone) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void pi(String id, String content) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void comment(String comment) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void doctype(String name, ExternalID eid) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void cdata(String cdata) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void emptyElement(String name, List<Attribute> attributes) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void startElement(String name, List<Attribute> attributes) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void endElement(String name) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void chardata(int beginLine, int beginColumn, int endLine, int endColumn) {
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void reference(String ref) {
    }
}
