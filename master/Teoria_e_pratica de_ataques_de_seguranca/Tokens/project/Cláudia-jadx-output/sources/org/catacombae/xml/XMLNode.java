package org.catacombae.xml;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.dmgextractor.Util;
import org.catacombae.dmgextractor.io.ConcatenatedReader;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/XMLNode.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/XMLNode.class */
public class XMLNode extends XMLElement {
    public final String namespaceURI;
    public final String sName;
    public final String qName;
    public final Attribute2[] attrs;
    public final XMLNode parent;
    private final LinkedList<XMLElement> children = new LinkedList<>();

    public XMLNode(String namespaceURI, String sName, String qName, Attribute2[] attrs, XMLNode parent) {
        this.namespaceURI = namespaceURI;
        this.sName = sName;
        this.qName = qName;
        this.attrs = attrs;
        this.parent = parent;
    }

    public void addChild(XMLElement x) {
        this.children.addLast(x);
    }

    public void printTree(PrintStream pw) {
        _printTree(pw, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.catacombae.xml.XMLElement
    public void _printTree(PrintStream pw, int level) {
        for (int i2 = 0; i2 < level; i2++) {
            pw.print(" ");
        }
        pw.print(SimpleComparison.LESS_THAN_OPERATION);
        pw.print(this.qName);
        Attribute2[] arr$ = this.attrs;
        for (Attribute2 a2 : arr$) {
            pw.print(" " + a2.qName + SimpleComparison.EQUAL_TO_OPERATION + a2.value);
        }
        pw.println(SimpleComparison.GREATER_THAN_OPERATION);
        Iterator i$ = this.children.iterator();
        while (i$.hasNext()) {
            XMLElement xe = i$.next();
            xe._printTree(pw, level + 1);
        }
        for (int i3 = 0; i3 < level; i3++) {
            pw.print(" ");
        }
        pw.println("</" + this.qName + SimpleComparison.GREATER_THAN_OPERATION);
    }

    public XMLElement[] getChildren() {
        return (XMLElement[]) this.children.toArray(new XMLElement[this.children.size()]);
    }

    public XMLNode cd(String type) {
        XMLElement[] arr$ = getChildren();
        for (XMLElement xn : arr$) {
            if ((xn instanceof XMLNode) && ((XMLNode) xn).qName.equals(type)) {
                return (XMLNode) xn;
            }
        }
        return null;
    }

    public XMLNode cdkey(String key) {
        boolean keyFound = false;
        XMLElement[] arr$ = getChildren();
        for (XMLElement xn : arr$) {
            if (xn instanceof XMLNode) {
                if (keyFound) {
                    return (XMLNode) xn;
                }
                if (((XMLNode) xn).qName.equals("key")) {
                    XMLElement[] arr$2 = ((XMLNode) xn).getChildren();
                    for (XMLElement xn2 : arr$2) {
                        try {
                            if (xn2 instanceof XMLText) {
                                String s = Util.readFully(((XMLText) xn2).getText());
                                if (s.equals(key)) {
                                    keyFound = true;
                                }
                            }
                        } catch (Exception e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public Reader getKeyValue(String key) {
        ConcatenatedReader result;
        XMLNode keyNode = cdkey(key);
        XMLElement[] nodeChildren = keyNode.getChildren();
        if (nodeChildren.length != 1) {
            LinkedList<Reader> collectedReaders = new LinkedList<>();
            XMLElement[] arr$ = keyNode.getChildren();
            for (XMLElement xe : arr$) {
                if (xe instanceof XMLText) {
                    try {
                        Reader xt = ((XMLText) xe).getText();
                        collectedReaders.addLast(xt);
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
            if (collectedReaders.size() == 0) {
                result = null;
            } else {
                result = new ConcatenatedReader((Reader[]) collectedReaders.toArray(new Reader[collectedReaders.size()]));
            }
            return result;
        } else if (nodeChildren[0] instanceof XMLText) {
            try {
                return ((XMLText) nodeChildren[0]).getText();
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        } else {
            return null;
        }
    }
}
