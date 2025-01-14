package org.catacombae.util;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/util/GUIUtil.class
 */
/* loaded from: csframework.jar:org/catacombae/util/GUIUtil.class */
public class GUIUtil {
    public static void displayExceptionDialog(Throwable t, Component c2) {
        displayExceptionDialog(t, 10, c2, "", "Exception", 0);
    }

    public static void displayExceptionDialog(Throwable t, int maxStackTraceLines, Component c2) {
        displayExceptionDialog(t, maxStackTraceLines, c2, "", "Exception", 0);
    }

    public static void displayExceptionDialog(Throwable t, int maxStackTraceLines, Component c2, String message) {
        displayExceptionDialog(t, maxStackTraceLines, c2, message, "Exception", 0);
    }

    public static void displayExceptionDialog(Throwable t, int maxStackTraceLines, final Component c2, String message, final String title, final int messageType) {
        StringBuilder sb = new StringBuilder();
        if (message.length() > 0) {
            sb.append(message);
            sb.append("\n\n");
        }
        Util.buildStackTrace(t, maxStackTraceLines, sb);
        final String finalMessage = sb.toString();
        try {
            Runnable r = new Runnable() { // from class: org.catacombae.util.GUIUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    JOptionPane.showMessageDialog(c2, finalMessage, title, messageType);
                }
            };
            if (SwingUtilities.isEventDispatchThread()) {
                r.run();
            } else {
                SwingUtilities.invokeAndWait(r);
            }
        } catch (Exception e2) {
            throw new RuntimeException("Exception during invokeAndWait!", e2);
        }
    }
}
