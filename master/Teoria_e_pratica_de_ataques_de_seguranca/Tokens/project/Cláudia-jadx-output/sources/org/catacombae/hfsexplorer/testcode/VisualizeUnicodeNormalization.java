package org.catacombae.hfsexplorer.testcode;

import java.awt.Font;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.catacombae.hfsexplorer.UnicodeNormalizationToolkit;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/VisualizeUnicodeNormalization.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/VisualizeUnicodeNormalization.class */
public class VisualizeUnicodeNormalization extends JFrame {
    public VisualizeUnicodeNormalization() {
        super("HFS+ Unicode Decomposition Table");
        JPanel mainPanel = new JPanel();
        JScrollPane mainPanelScroller = new JScrollPane(mainPanel, 20, 31);
        mainPanel.setLayout(new BoxLayout(mainPanel, 1));
        mainPanelScroller.getVerticalScrollBar().setUnitIncrement(20);
        UnicodeNormalizationToolkit unt = UnicodeNormalizationToolkit.getDefaultInstance();
        Map<Character, char[]> table = unt.getDecompositionTable();
        StringBuilder sb = new StringBuilder();
        Comparator<Map.Entry<Character, char[]>> cmp = new Comparator<Map.Entry<Character, char[]>>() { // from class: org.catacombae.hfsexplorer.testcode.VisualizeUnicodeNormalization.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<Character, char[]> o1, Map.Entry<Character, char[]> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };
        TreeSet<Map.Entry<Character, char[]>> ts = new TreeSet<>(cmp);
        for (Map.Entry<Character, char[]> ent : table.entrySet()) {
            ts.add(ent);
        }
        Iterator i$ = ts.iterator();
        while (i$.hasNext()) {
            Map.Entry<Character, char[]> ent2 = i$.next();
            Character key = ent2.getKey();
            char[] value = ent2.getValue();
            sb.append(Util.toHexStringBE(key.charValue()));
            sb.append(": \" ");
            sb.append(key.toString());
            sb.append(" \" -> \" ");
            sb.append(value[0]);
            for (int i2 = 1; i2 < value.length; i2++) {
                sb.append(" \", \" ");
                sb.append(value[i2]);
            }
            sb.append(" \"");
            JLabel cur = new JLabel(sb.toString());
            cur.setFont(new Font("Monospaced", 0, 20));
            mainPanel.add(cur);
            sb.setLength(0);
        }
        add(mainPanelScroller, "Center");
        setDefaultCloseOperation(3);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame frame = new VisualizeUnicodeNormalization();
        frame.setVisible(true);
    }
}
