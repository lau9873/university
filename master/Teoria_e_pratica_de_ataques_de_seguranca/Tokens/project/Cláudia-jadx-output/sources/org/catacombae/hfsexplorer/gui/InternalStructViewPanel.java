package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.catacombae.csjc.structelements.Array;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.FlagField;
import org.catacombae.csjc.structelements.StringRepresentableField;
import org.catacombae.csjc.structelements.StructElement;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/InternalStructViewPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/InternalStructViewPanel.class */
public class InternalStructViewPanel extends JPanel {
    private JPanel fieldsPanel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel structNameLabel;

    public InternalStructViewPanel(String label, Dictionary dict) {
        this(label);
        String str;
        String[] keys = dict.getKeys();
        JPanel[] subPanels = new JPanel[keys.length];
        for (int i2 = 0; i2 < keys.length; i2++) {
            String curKey = keys[i2];
            StructElement curElement = dict.getElement(curKey);
            String curDescription = dict.getDescription(curKey);
            if (curDescription != null) {
                str = curDescription;
            } else {
                str = curKey;
            }
            String subLabel = str;
            subPanels[i2] = createPanel(subLabel, curElement);
            subPanels[i2].setBorder(new EmptyBorder(0, 0, 5, 0));
        }
        this.fieldsPanel.removeAll();
        for (JPanel subPanel : subPanels) {
            this.fieldsPanel.add(subPanel);
        }
    }

    public InternalStructViewPanel(String label, Array array) {
        this(label);
        StructElement[] elems = array.getElements();
        JPanel[] subPanels = new JPanel[elems.length];
        for (int i2 = 0; i2 < elems.length; i2++) {
            StructElement curElement = elems[i2];
            subPanels[i2] = createPanel("[" + i2 + "]", curElement);
            subPanels[i2].setBorder(new EmptyBorder(0, 0, 5, 0));
        }
        this.fieldsPanel.removeAll();
        for (JPanel subPanel : subPanels) {
            this.fieldsPanel.add(subPanel);
        }
    }

    private InternalStructViewPanel(String label) {
        initComponents();
        this.structNameLabel.setText(label);
    }

    private static JPanel createPanel(String label, StructElement elem) {
        if (elem instanceof StringRepresentableField) {
            StringRepresentableField f2 = (StringRepresentableField) elem;
            return new TextViewPanel(label + ":", f2);
        } else if (elem instanceof FlagField) {
            FlagField f3 = (FlagField) elem;
            return new FlagViewPanel(label, f3);
        } else if (elem instanceof Array) {
            Array a2 = (Array) elem;
            return new InternalStructViewPanel(label + ":", a2);
        } else if (elem instanceof Dictionary) {
            Dictionary d2 = (Dictionary) elem;
            return new InternalStructViewPanel(label + ":", d2);
        } else {
            throw new RuntimeException("Unsupported StructElement subtype: " + elem.getClass());
        }
    }

    private void initComponents() {
        this.structNameLabel = new JLabel();
        this.fieldsPanel = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.structNameLabel.setText("structName");
        this.fieldsPanel.setLayout(new BoxLayout(this.fieldsPanel, 3));
        this.jLabel1.setText("jLabel1");
        this.fieldsPanel.add(this.jLabel1);
        this.jLabel2.setText("jLabel2");
        this.fieldsPanel.add(this.jLabel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.structNameLabel).addContainerGap()).add(2, layout.createSequentialGroup().addContainerGap().add(this.fieldsPanel, -1, 342, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.structNameLabel).addPreferredGap(0).add(this.fieldsPanel, -1, 285, 32767)));
    }
}
