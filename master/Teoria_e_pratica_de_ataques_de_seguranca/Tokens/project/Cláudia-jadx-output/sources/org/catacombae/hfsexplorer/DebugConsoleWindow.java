package org.catacombae.hfsexplorer;

import java.awt.BorderLayout;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.catacombae.hfsexplorer.io.JTextAreaOutputStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/DebugConsoleWindow.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/DebugConsoleWindow.class */
public class DebugConsoleWindow extends JFrame {
    private static final int WINDOW_NUMBER_OF_COLUMNS = 80;
    private static final int WINDOW_NUMBER_OF_LINES = 25;
    private final JScrollPane debugAreaScroller;
    private final JTextArea debugArea;
    private final Object syncObject;
    private final OutputStream debugStream;

    public DebugConsoleWindow(PrintStream stdErr) {
        super("Debug Console");
        this.syncObject = new Object();
        setLayout(new BorderLayout());
        this.debugArea = new JTextArea(25, 80);
        this.debugAreaScroller = new JScrollPane(this.debugArea, 22, 31);
        this.debugArea.setLineWrap(true);
        this.debugArea.setEditable(false);
        add(this.debugAreaScroller, "Center");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(2);
        this.debugStream = new JTextAreaOutputStream(stdErr, this.debugArea, this.debugAreaScroller, this.syncObject, null);
    }

    public OutputStream getDebugStream() {
        return this.debugStream;
    }
}
