package org.catacombae.udif;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import net.iharder.base64.Base64;
import org.catacombae.dmgextractor.Util;
import org.catacombae.dmgextractor.io.RandomAccessInputStream;
import org.catacombae.dmgextractor.io.ReaderInputStream;
import org.catacombae.dmgextractor.io.SynchronizedRandomAccessStream;
import org.catacombae.io.ReadableByteArrayStream;
import org.catacombae.xml.NodeBuilder;
import org.catacombae.xml.NodeBuilderContentHandler;
import org.catacombae.xml.NullXMLContentHandler;
import org.catacombae.xml.XMLElement;
import org.catacombae.xml.XMLNode;
import org.catacombae.xml.apx.APXParser;
import org.catacombae.xml.apx.ParseException;
import org.xml.sax.SAXException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/Plist.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/Plist.class */
public class Plist {
    private XMLNode rootNode;

    public Plist(byte[] data) {
        this(data, 0, data.length);
    }

    public Plist(byte[] data, boolean useSAXParser) {
        this(data, 0, data.length, useSAXParser);
    }

    public Plist(byte[] data, int offset, int length) {
        this(data, offset, length, false);
    }

    public Plist(byte[] data, int offset, int length, boolean useSAXParser) {
        this.rootNode = parseXMLData(data, useSAXParser);
    }

    public PlistPartition[] getPartitions() throws IOException {
        LinkedList<PlistPartition> partitionList = new LinkedList<>();
        XMLNode current = this.rootNode.cd("dict").cdkey("resource-fork").cdkey("blkx");
        int length = current.getChildren().length;
        long previousOutOffset = 0;
        long previousInOffset = 0;
        XMLElement[] arr$ = current.getChildren();
        for (XMLElement xe : arr$) {
            if (xe instanceof XMLNode) {
                XMLNode xn = (XMLNode) xe;
                String partitionName = Util.readFully(xn.getKeyValue("Name"));
                String partitionID = Util.readFully(xn.getKeyValue("ID"));
                String partitionAttributes = Util.readFully(xn.getKeyValue("Attributes"));
                Reader base64Data = xn.getKeyValue("Data");
                InputStream base64DataInputStream = new Base64.InputStream(new ReaderInputStream(base64Data, Charset.forName("US-ASCII")));
                PlistPartition dpp = new PlistPartition(partitionName, partitionID, partitionAttributes, base64DataInputStream, previousOutOffset, previousInOffset);
                previousOutOffset = dpp.getFinalOutOffset();
                previousInOffset = dpp.getFinalInOffset();
                partitionList.addLast(dpp);
            }
        }
        return (PlistPartition[]) partitionList.toArray(new PlistPartition[partitionList.size()]);
    }

    private XMLNode parseXMLData(byte[] plistData, boolean defaultToSAX) {
        NodeBuilder handler = new NodeBuilder();
        if (defaultToSAX) {
            parseXMLDataSAX(plistData, handler);
        } else {
            try {
                parseXMLDataAPX(plistData, handler);
            } catch (Exception e2) {
                e2.printStackTrace();
                System.err.println("APX parser threw exception... falling back to SAX parser. Report this error!");
                handler = new NodeBuilder();
                parseXMLDataSAX(plistData, handler);
            }
        }
        XMLNode[] rootNodes = handler.getRoots();
        if (rootNodes.length != 1) {
            throw new RuntimeException("Could not parse DMG-file!");
        }
        return rootNodes[0];
    }

    private void parseXMLDataAPX(byte[] buffer, NodeBuilder handler) {
        try {
            ReadableByteArrayStream ya = new ReadableByteArrayStream(buffer);
            SynchronizedRandomAccessStream bufferStream = new SynchronizedRandomAccessStream(ya);
            InputStream is = new RandomAccessInputStream(bufferStream);
            APXParser encodingParser = APXParser.create(new InputStreamReader(is, "US-ASCII"), new NullXMLContentHandler(Charset.forName("US-ASCII")));
            String encodingName = encodingParser.xmlDecl();
            if (encodingName == null) {
                encodingName = "US-ASCII";
            }
            Charset encoding = Charset.forName(encodingName);
            InputStream is2 = new RandomAccessInputStream(bufferStream);
            Reader usedReader = new BufferedReader(new InputStreamReader(is2, encoding));
            APXParser documentParser = APXParser.create(usedReader, new NodeBuilderContentHandler(handler, bufferStream, encoding));
            documentParser.xmlDocument();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException(uee);
        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }

    private void parseXMLDataSAX(byte[] buffer, NodeBuilder handler) {
        try {
            InputStream is = new ByteArrayInputStream(buffer);
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(is, handler);
        } catch (SAXException se) {
            se.printStackTrace();
            throw new RuntimeException(se);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
