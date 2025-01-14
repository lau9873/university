package org.catacombae.hfsexplorer.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;
import javax.swing.text.PlainDocument;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/JTextAreaOutputStream.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/JTextAreaOutputStream.class */
public class JTextAreaOutputStream extends OutputStream {
    private static final int MAX_LENGTH = 80000;
    private final PrintStream stdErr;
    private final JTextArea textArea;
    private final JScrollPane textAreaScroller;
    private final Object syncObject;
    private final String encoding;
    private final GapContent content;
    private boolean updateRequested;
    private PlainDocument document;

    public JTextAreaOutputStream(PrintStream stdErr, JTextArea textArea) {
        this(stdErr, textArea, textArea);
    }

    public JTextAreaOutputStream(PrintStream stdErr, JTextArea textArea, Object syncObject) {
        this(stdErr, textArea, syncObject, null);
    }

    public JTextAreaOutputStream(PrintStream stdErr, JTextArea textArea, Object syncObject, String encoding) {
        this(stdErr, textArea, null, syncObject, encoding);
    }

    public JTextAreaOutputStream(PrintStream stdErr, JTextArea textArea, JScrollPane textAreaScroller, Object syncObject, String encoding) {
        this.updateRequested = false;
        if (stdErr == null) {
            throw new IllegalArgumentException("stdErr == null");
        }
        if (textArea == null) {
            throw new IllegalArgumentException("textArea == null");
        }
        if (syncObject == null) {
            throw new IllegalArgumentException("syncObject == null");
        }
        this.stdErr = stdErr;
        this.textArea = textArea;
        this.textAreaScroller = textAreaScroller;
        this.syncObject = syncObject;
        this.encoding = encoding;
        this.content = new GapContent();
        this.document = new PlainDocument(this.content);
        textArea.setDocument(this.document);
    }

    @Override // java.io.OutputStream
    public void write(int b2) throws IOException {
        write(new byte[]{(byte) b2}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b2) throws IOException {
        write(b2, 0, b2.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b2, int off, int len) throws IOException {
        String s;
        synchronized (this.syncObject) {
            try {
                if (this.encoding == null) {
                    s = new String(b2, off, len);
                } else {
                    s = new String(b2, off, len, this.encoding);
                }
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                Util.buildStackTrace(e2, Integer.MAX_VALUE, sb);
                this.stdErr.println(sb.toString());
            }
            try {
                if (s.length() > 80000) {
                    s = s.substring(s.length() - 80000);
                }
                int overrun = ((this.document.getLength() - 2) + s.length()) - 80000;
                if (overrun > 0) {
                    this.document.remove(0, overrun);
                }
                this.document.insertString(this.document.getLength(), s, (AttributeSet) null);
                if (this.textAreaScroller != null && !this.updateRequested) {
                    this.updateRequested = true;
                    SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.io.JTextAreaOutputStream.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (JTextAreaOutputStream.this.syncObject) {
                                JTextAreaOutputStream.this.updateRequested = false;
                                JScrollBar sb2 = JTextAreaOutputStream.this.textAreaScroller.getVerticalScrollBar();
                                sb2.setValue(sb2.getMaximum() - sb2.getVisibleAmount());
                            }
                        }
                    });
                }
            } catch (BadLocationException ex) {
                throw new RuntimeException("Exception while updating content", ex);
            }
        }
    }
}
