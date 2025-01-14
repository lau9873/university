package org.catacombae.xml;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.nio.charset.Charset;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/DebugXMLContentHandler.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/DebugXMLContentHandler.class */
public class DebugXMLContentHandler extends XMLContentHandler {
    public DebugXMLContentHandler(Charset encoding) {
        super(encoding);
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void xmlDecl(String version, String encoding, Boolean standalone) {
        print("xmlDecl: <?xml version=\"" + version + "\"");
        if (encoding != null) {
            print(" encoding=\"" + encoding + "\"");
        }
        if (standalone != null) {
            print(" standalone=\"");
            if (standalone.booleanValue()) {
                print("yes");
            } else {
                print("no");
            }
            print("\"");
        }
        println("?>");
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void pi(String id, String content) {
        print("pi: <?" + id);
        if (content != null) {
            print(" " + content);
        }
        println("?>");
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void comment(String content) {
        println("comment: <!--" + content + "-->");
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void doctype(String name, ExternalID eid) {
        print("doctype: <!DOCTYPE " + name);
        if (eid != null) {
            if (eid.type == 0) {
                print("SYSTEM \"" + eid.systemLiteral + "\"");
            } else if (eid.type == 1) {
                print("PUBLIC \"" + eid.pubidLiteral + "\" \"" + eid.systemLiteral + "\"");
            }
        }
        println(SimpleComparison.GREATER_THAN_OPERATION);
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void cdata(String cdata) {
        println("cdata: <![CDATA[" + cdata + "]]>");
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void emptyElement(String name, List<Attribute> attributes) {
        print("emptyElement: <" + name);
        for (Attribute attr : attributes) {
            print(" " + attr.identifier + "=\"" + attr.value + "\"");
        }
        println("/>");
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void startElement(String name, List<Attribute> attributes) {
        print("startElement: <" + name);
        for (Attribute attr : attributes) {
            print(" " + attr.identifier + "=\"" + attr.value + "\"");
        }
        println(SimpleComparison.GREATER_THAN_OPERATION);
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void endElement(String name) {
        println("endElement: </" + name + SimpleComparison.GREATER_THAN_OPERATION);
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void chardata(int beginLine, int beginColumn, int endLine, int endColumn) {
        println("chardata: starting at (" + beginLine + "," + beginColumn + ") and ending at (" + endLine + "," + endColumn + ")");
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void reference(String ref) {
        println("reference: \"" + ref + "\"");
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
