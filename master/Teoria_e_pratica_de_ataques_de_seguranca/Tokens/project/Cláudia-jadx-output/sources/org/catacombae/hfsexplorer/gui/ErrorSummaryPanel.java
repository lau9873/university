package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.tools.bzip2.BZip2Constants;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ErrorSummaryPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ErrorSummaryPanel.class */
public class ErrorSummaryPanel extends JPanel {
    private JButton closeButton;
    private JPanel closeButtonPanel;
    private JScrollPane contantsAreaScroller;
    private JTextArea contentsAreaScroller;
    private JLabel titleLabel;

    private ErrorSummaryPanel(final JDialog dialog, List<String> errorMessages) {
        this(errorMessages);
        this.closeButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.gui.ErrorSummaryPanel.1
            public void actionPerformed(ActionEvent e2) {
                dialog.dispose();
            }
        });
    }

    private ErrorSummaryPanel(List<String> errorMessages) {
        initComponents();
        for (String msg : errorMessages) {
            this.contentsAreaScroller.append(msg + "\n");
        }
    }

    public static JDialog createErrorSummaryDialog(Dialog owner, List<String> errorMessages) {
        JDialog dialog = new JDialog(owner, "Error summary", true);
        fillErrorSummaryDialog(dialog, errorMessages);
        return dialog;
    }

    public static JDialog createErrorSummaryDialog(Frame owner, List<String> errorMessages) {
        JDialog dialog = new JDialog(owner, "Error summary", true);
        fillErrorSummaryDialog(dialog, errorMessages);
        return dialog;
    }

    private static void fillErrorSummaryDialog(JDialog dialog, List<String> errorMessages) {
        ErrorSummaryPanel esp = new ErrorSummaryPanel(dialog, errorMessages);
        dialog.add(esp);
        dialog.pack();
        dialog.setLocationRelativeTo((Component) null);
    }

    private void initComponents() {
        this.titleLabel = new JLabel();
        this.contantsAreaScroller = new JScrollPane();
        this.contentsAreaScroller = new JTextArea();
        this.closeButtonPanel = new JPanel();
        this.closeButton = new JButton();
        this.titleLabel.setText("The following errors were encountered when extracting files:");
        this.contentsAreaScroller.setColumns(20);
        this.contentsAreaScroller.setEditable(false);
        this.contentsAreaScroller.setLineWrap(true);
        this.contentsAreaScroller.setRows(5);
        this.contantsAreaScroller.setViewportView(this.contentsAreaScroller);
        this.closeButtonPanel.setLayout(new FlowLayout(1, 0, 0));
        this.closeButton.setText("Close");
        this.closeButtonPanel.add(this.closeButton);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(1, this.contantsAreaScroller, -1, 655, 32767).add(1, (Component) this.titleLabel).add(1, this.closeButtonPanel, -1, 655, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.titleLabel).addPreferredGap(0).add(this.contantsAreaScroller, -1, BZip2Constants.MAX_ALPHA_SIZE, 32767).addPreferredGap(0).add(this.closeButtonPanel, -2, -1, -2).addContainerGap()));
    }
}
