package org.catacombae.xml;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import org.catacombae.dmgextractor.io.ByteCountInputStream;
import org.catacombae.dmgextractor.io.CharByCharReader;
import org.catacombae.dmgextractor.io.RandomAccessInputStream;
import org.catacombae.dmgextractor.io.SynchronizedRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/XMLText.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/XMLText.class */
public class XMLText extends XMLElement {
    private static final char CR = '\r';
    private static final char LF = '\n';
    private static final char TAB = '\t';
    private final String text;
    private int beginLine;
    private int beginColumn;
    private int endLine;
    private int endColumn;
    private long beginOffset;
    private long endOffset;
    private final SynchronizedRandomAccessStream xmlFile;
    private Charset encoding;

    public XMLText(String text) {
        this.beginLine = -1;
        this.beginColumn = -1;
        this.endLine = -1;
        this.endColumn = -1;
        this.text = text;
        this.xmlFile = null;
    }

    public XMLText(SynchronizedRandomAccessStream xmlFile, Charset encoding, long beginOffset, long endOffset) {
        this.beginLine = -1;
        this.beginColumn = -1;
        this.endLine = -1;
        this.endColumn = -1;
        this.text = null;
        this.xmlFile = xmlFile;
        this.encoding = encoding;
        this.beginOffset = beginOffset;
        this.endOffset = endOffset;
    }

    public XMLText(SynchronizedRandomAccessStream xmlFile, Charset encoding, int beginLine, int beginColumn, int endLine, int endColumn) {
        this(xmlFile, encoding, -1L, -1L);
        if (endLine < beginLine || (endLine == beginLine && endColumn < beginColumn)) {
            throw new IllegalArgumentException("negative interval length");
        }
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public Reader getText() throws IOException {
        if (this.text == null) {
            if (this.beginOffset == -1 && this.endOffset == -1) {
                calculateOffsets();
            }
            return new InputStreamReader(new RandomAccessInputStream(this.xmlFile, this.beginOffset, this.endOffset - this.beginOffset), this.encoding);
        }
        return new StringReader(this.text);
    }

    private void calculateOffsets() throws IOException {
        ByteCountInputStream bcis = new ByteCountInputStream(new BufferedInputStream(new RandomAccessInputStream(this.xmlFile)));
        Reader lnr = new CharByCharReader(bcis, this.encoding);
        boolean previousCR = false;
        long lineNumber = 1;
        long colNumber = -1;
        int i2 = 0;
        while (true) {
            int currentChar = i2;
            if (currentChar < 0) {
                break;
            }
            char c2 = (char) currentChar;
            boolean lfskip = false;
            if (c2 == '\r') {
                lineNumber++;
                previousCR = true;
            } else if (c2 == '\n') {
                if (!previousCR) {
                    lineNumber++;
                    colNumber = 0;
                } else {
                    previousCR = false;
                    lfskip = true;
                }
            } else if (c2 == '\t') {
                colNumber += 8;
                previousCR = false;
            } else {
                colNumber++;
                previousCR = false;
            }
            if (!lfskip) {
                if (lineNumber == this.beginLine && colNumber == this.beginColumn) {
                    this.beginOffset = bcis.getBytesRead() - 1;
                }
                if (lineNumber == this.endLine && colNumber == this.endColumn) {
                    this.endOffset = bcis.getBytesRead();
                    break;
                }
            }
            i2 = lnr.read();
        }
        if (this.beginOffset == -1 || this.endOffset == -1) {
            throw new RuntimeException("Could not find the requested interval! (begin: (" + this.beginLine + "," + this.beginColumn + ") end: (" + this.endLine + "," + this.endColumn + "))");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.catacombae.xml.XMLElement
    public void _printTree(PrintStream pw, int level) {
        for (int i2 = 0; i2 < level; i2++) {
            pw.print(" ");
        }
        pw.println(this.text.toString());
    }
}
