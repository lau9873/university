package org.catacombae.xml;

import java.nio.charset.Charset;
import java.util.List;
import org.catacombae.dmgextractor.io.SynchronizedRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/NodeBuilderContentHandler.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/NodeBuilderContentHandler.class */
public class NodeBuilderContentHandler extends XMLContentHandler {
    private NodeBuilder nodeBuilder;
    private SynchronizedRandomAccessStream sras;
    private Charset encoding;

    public NodeBuilderContentHandler(NodeBuilder nodeBuilder, SynchronizedRandomAccessStream sras, Charset encoding) {
        super(encoding);
        this.nodeBuilder = nodeBuilder;
        this.sras = sras;
        this.encoding = encoding;
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
        try {
            this.nodeBuilder.characters(cdata.toCharArray(), 0, cdata.length());
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void emptyElement(String name, List<Attribute> attributes) {
        try {
            startElement(name, attributes);
            endElement(name);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void startElement(String name, List<Attribute> attributes) {
        try {
            Attribute2[] attrs = new Attribute2[attributes.size()];
            int i2 = 0;
            for (Attribute a2 : attributes) {
                int i3 = i2;
                i2++;
                attrs[i3] = new Attribute2("", a2.identifier, "CDATA", "", a2.value.toString());
            }
            this.nodeBuilder.startElementInternal(null, null, name, attrs);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void endElement(String name) {
        try {
            this.nodeBuilder.endElement(null, null, name);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void chardata(int beginLine, int beginColumn, int endLine, int endColumn) {
        this.nodeBuilder.characters(this.sras, this.encoding, beginLine, beginColumn, endLine, endColumn);
    }

    @Override // org.catacombae.xml.XMLContentHandler
    public void reference(String ref) {
        try {
            if (ref.startsWith("&#")) {
                int[] codePoints = new int[1];
                if (ref.startsWith("&#x")) {
                    codePoints[0] = Integer.parseInt(ref.substring(3), 16);
                } else {
                    codePoints[0] = Integer.parseInt(ref.substring(2), 10);
                }
                char[] cp_ca = Character.toChars(codePoints[0]);
                this.nodeBuilder.characters(cp_ca, 0, cp_ca.length);
            } else {
                System.out.println("WARNING: Encountered external references, which cannot be resolved with this version of the parser.");
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
