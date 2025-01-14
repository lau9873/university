package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.catacombae.io.InputStreamReadable;
import org.catacombae.io.Readable;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/DisplayTextFilePanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/DisplayTextFilePanel.class */
public class DisplayTextFilePanel extends JPanel {
    private static final String[] sortingPrefixes = {"US-ASCII", "UTF-8", "ISO-8859", "UTF", "IBM4", "IBM8", "IBM"};
    private byte[] fileData;
    private final Frame parentFrame;
    private final String baseTitle;
    private JComboBox encodingBox;
    private JLabel encodingLabel;
    private JTextArea textPane;
    private JScrollPane textPaneScroller;

    public DisplayTextFilePanel() {
        this(null);
    }

    public DisplayTextFilePanel(Frame parentFrame) {
        this.fileData = new byte[]{0};
        this.parentFrame = parentFrame;
        if (parentFrame != null) {
            this.baseTitle = parentFrame.getTitle();
        } else {
            this.baseTitle = "";
        }
        initComponents();
        this.textPaneScroller.getVerticalScrollBar().setMinimum(0);
        this.textPaneScroller.getVerticalScrollBar().setMaximum(Integer.MAX_VALUE);
        this.textPaneScroller.getHorizontalScrollBar().setMinimum(0);
        this.textPaneScroller.getHorizontalScrollBar().setMaximum(Integer.MAX_VALUE);
        Set<String> keySet = Charset.availableCharsets().keySet();
        ArrayList<String> charsets = new ArrayList<>(keySet);
        LinkedList<String> listItems = new LinkedList<>();
        String[] arr$ = sortingPrefixes;
        for (String prefix : arr$) {
            int i2 = 0;
            while (i2 < charsets.size()) {
                String curCharset = charsets.get(i2);
                if (curCharset.startsWith(prefix)) {
                    listItems.add(curCharset);
                    charsets.remove(i2);
                } else {
                    i2++;
                }
            }
        }
        Iterator i$ = charsets.iterator();
        while (i$.hasNext()) {
            listItems.add(i$.next());
        }
        this.encodingBox.removeAllItems();
        Iterator i$2 = listItems.iterator();
        while (i$2.hasNext()) {
            String curItem = i$2.next();
            this.encodingBox.addItem(curItem);
        }
        if (this.encodingBox.getItemCount() > 0) {
            this.encodingBox.setSelectedIndex(0);
        }
        this.encodingBox.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.gui.DisplayTextFilePanel.1
            public void actionPerformed(ActionEvent e2) {
                DisplayTextFilePanel.this.refreshView();
            }
        });
    }

    public void loadFile(File file) {
        if (file.length() < 2147483647L) {
            try {
                FileInputStream fis = new FileInputStream(file);
                loadStream(fis);
                fis.close();
                if (this.parentFrame != null) {
                    this.parentFrame.setTitle(this.baseTitle + " - [" + file.getName() + "]");
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(this, "Exception while loading file:\n  " + e2 + "\"");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "File too large for memory address space! (" + file.length() + "bytes)");
    }

    public void loadStream(InputStream is) {
        loadStream(new InputStreamReadable(is));
    }

    public void loadStream(Readable is) {
        try {
            byte[] tmp = new byte[65536];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true) {
                int bytesRead = is.read(tmp);
                if (bytesRead > 0) {
                    baos.write(tmp, 0, bytesRead);
                } else {
                    this.fileData = baos.toByteArray();
                    refreshView();
                    SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.DisplayTextFilePanel.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int vMin = DisplayTextFilePanel.this.textPaneScroller.getVerticalScrollBar().getMinimum();
                            int hMin = DisplayTextFilePanel.this.textPaneScroller.getHorizontalScrollBar().getMinimum();
                            DisplayTextFilePanel.this.textPaneScroller.getVerticalScrollBar().setValue(vMin);
                            DisplayTextFilePanel.this.textPaneScroller.getHorizontalScrollBar().setValue(hMin);
                        }
                    });
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(this, "Exception while loading file:\n  " + e2 + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshView() {
        try {
            final int vValue = this.textPaneScroller.getVerticalScrollBar().getValue();
            final int hValue = this.textPaneScroller.getHorizontalScrollBar().getValue();
            this.textPane.setText(new String(this.fileData, getSelectedEncoding()));
            SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.DisplayTextFilePanel.3
                @Override // java.lang.Runnable
                public void run() {
                    DisplayTextFilePanel.this.textPaneScroller.getVerticalScrollBar().setValue(vValue);
                    DisplayTextFilePanel.this.textPaneScroller.getHorizontalScrollBar().setValue(hValue);
                }
            });
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(this, "Exception while decoding file data:\n  " + e2 + "\"");
        }
    }

    private String getSelectedEncoding() {
        return this.encodingBox.getSelectedItem().toString();
    }

    private void initComponents() {
        this.textPaneScroller = new JScrollPane();
        this.textPane = new JTextArea();
        this.encodingLabel = new JLabel();
        this.encodingBox = new JComboBox();
        this.textPane.setColumns(20);
        this.textPane.setEditable(false);
        this.textPane.setRows(5);
        this.textPaneScroller.setViewportView(this.textPane);
        this.encodingLabel.setText("Encoding:");
        this.encodingBox.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.encodingLabel).addPreferredGap(0).add(this.encodingBox, 0, 650, 32767).addContainerGap()).add(this.textPaneScroller, -1, 721, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.encodingLabel).add(this.encodingBox, -2, -1, -2)).addPreferredGap(0).add(this.textPaneScroller, -1, 445, 32767)));
    }
}
