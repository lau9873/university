package org.catacombae.xml;

import java.nio.charset.Charset;
import org.catacombae.dmgextractor.io.SynchronizedRandomAccessStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/NodeBuilder.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/NodeBuilder.class */
public class NodeBuilder extends DefaultHandler {
    private XMLNode artificialRoot = new XMLNode(null, null, null, null, null);
    private XMLNode currentNode = this.artificialRoot;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String namespaceURI, String sName, String qName, Attributes attrs) throws SAXException {
        Attribute2[] attributes = new Attribute2[attrs.getLength()];
        for (int i2 = 0; i2 < attributes.length; i2++) {
            attributes[i2] = new Attribute2(attrs.getLocalName(i2), attrs.getQName(i2), attrs.getType(i2), attrs.getURI(i2), attrs.getValue(i2));
        }
        startElementInternal(namespaceURI, sName, qName, attributes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startElementInternal(String namespaceURI, String sName, String qName, Attribute2[] attributes) throws SAXException {
        XMLNode newNode = new XMLNode(namespaceURI, sName, qName, attributes, this.currentNode);
        this.currentNode.addChild(newNode);
        this.currentNode = newNode;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String namespaceURI, String sName, String qName) throws SAXException {
        this.currentNode = this.currentNode.parent;
    }

    public void characters(SynchronizedRandomAccessStream file, Charset encoding, int startLine, int startColumn, int endLine, int endColumn) {
        this.currentNode.addChild(new XMLText(file, encoding, startLine, startColumn, endLine, endColumn));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] buf, int offset, int len) throws SAXException {
        String s = new String(buf, offset, len).trim();
        if (s.length() != 0) {
            this.currentNode.addChild(new XMLText(s));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void notationDecl(String name, String publicId, String systemId) throws SAXException {
    }

    public XMLNode[] getRoots() throws RuntimeException {
        if (this.artificialRoot != this.currentNode) {
            throw new RuntimeException("Tree was not closed!");
        }
        int numberOfNodes = 0;
        for (XMLElement xe : this.artificialRoot.getChildren()) {
            if (xe instanceof XMLNode) {
                numberOfNodes++;
            }
        }
        XMLNode[] result = new XMLNode[numberOfNodes];
        int i2 = 0;
        XMLElement[] arr$ = this.artificialRoot.getChildren();
        for (XMLElement xe2 : arr$) {
            if (xe2 instanceof XMLNode) {
                int i3 = i2;
                i2++;
                result[i3] = (XMLNode) xe2;
            }
        }
        return result;
    }
}
