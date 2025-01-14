package org.catacombae.hfsexplorer.testcode.editgpt;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.catacombae.csjc.structelements.Array;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.StringRepresentableField;
import org.catacombae.csjc.structelements.StructElement;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/editgpt/ContainerPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/editgpt/ContainerPanel.class */
public class ContainerPanel extends JPanel {
    private LinkedList<ContainerPanel> subPanels;
    private LinkedList<EditStringValuePanel> fields;
    private JPanel contentsPanel;
    private JLabel descriptionLabel;
    private JButton saveButton;

    public ContainerPanel() {
        this(null);
    }

    public ContainerPanel(String label) {
        this.subPanels = new LinkedList<>();
        this.fields = new LinkedList<>();
        initComponents();
        if (label != null) {
            this.descriptionLabel.setText(label);
            this.saveButton.setVisible(false);
            return;
        }
        this.descriptionLabel.setVisible(false);
        this.saveButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.testcode.editgpt.ContainerPanel.1
            public void actionPerformed(ActionEvent evt) {
                ContainerPanel.this.actionSave();
            }
        });
    }

    private void initComponents() {
        this.contentsPanel = new JPanel();
        this.descriptionLabel = new JLabel();
        this.saveButton = new JButton();
        this.contentsPanel.setLayout(new BoxLayout(this.contentsPanel, 3));
        this.descriptionLabel.setText("jLabel1");
        this.saveButton.setText("Save");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().add(10, 10, 10).add(this.contentsPanel, -1, 219, 32767)).add(layout.createSequentialGroup().add((Component) this.descriptionLabel).addPreferredGap(0, 109, 32767).add((Component) this.saveButton))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.descriptionLabel).add((Component) this.saveButton)).addPreferredGap(0).add(this.contentsPanel, -1, 107, 32767).addContainerGap()));
    }

    public void setFields(Dictionary rootDict) {
        this.contentsPanel.removeAll();
        String[] keys = rootDict.getKeys();
        for (String key : keys) {
            System.err.println("setFields processing key \"" + key + "\"...");
            StructElement curElem = rootDict.getElement(key);
            System.err.println("  curElem = " + curElem);
            if (curElem instanceof StringRepresentableField) {
                StringRepresentableField curField = (StringRepresentableField) curElem;
                EditStringValuePanel panel = new EditStringValuePanel();
                panel.setDecription(key + " (" + curField.getTypeName() + ")");
                panel.setValue(curField.getValueAsString());
                panel.setUserData(curField);
                System.err.println("  (1)adding " + panel + " to containerpanel");
                addComponent(panel);
                this.fields.add(panel);
            } else if (curElem instanceof Dictionary) {
                Dictionary curDict = (Dictionary) curElem;
                ContainerPanel panel2 = new ContainerPanel(key + " (" + curDict.getTypeName() + ")");
                panel2.setFields(curDict);
                System.err.println("  (2)adding " + panel2 + " to containerpanel");
                addComponent(panel2);
                this.subPanels.add(panel2);
            } else if (curElem instanceof Array) {
                Array curArray = (Array) curElem;
                ContainerPanel panel3 = new ContainerPanel(key + " (" + curArray.getTypeName() + ")");
                panel3.setFields(curArray);
                System.err.println("  (2)adding " + panel3 + " to containerpanel");
                addComponent(panel3);
                this.subPanels.add(panel3);
            } else {
                throw new RuntimeException("Unknown StructElement type: " + curElem.getClass());
            }
        }
        this.contentsPanel.add(Box.createVerticalGlue());
    }

    public void setFields(Array rootArray) {
        this.contentsPanel.removeAll();
        StructElement[] elements = rootArray.getElements();
        for (int i2 = 0; i2 < elements.length; i2++) {
            StructElement curElem = elements[i2];
            System.err.println("setFields processing array element...");
            System.err.println("  curElem = " + curElem);
            if (curElem instanceof StringRepresentableField) {
                StringRepresentableField curField = (StringRepresentableField) curElem;
                EditStringValuePanel panel = new EditStringValuePanel();
                panel.setDecription("[" + i2 + "] (" + curField.getTypeName() + ")");
                panel.setValue(curField.getValueAsString());
                panel.setUserData(curField);
                System.err.println("  (1)adding " + panel + " to containerpanel");
                addComponent(panel);
            } else if (curElem instanceof Dictionary) {
                Dictionary curDict = (Dictionary) curElem;
                ContainerPanel panel2 = new ContainerPanel("[" + i2 + "] (" + curDict.getTypeName() + ")");
                panel2.setFields(curDict);
                System.err.println("  (2)adding " + panel2 + " to containerpanel");
                addComponent(panel2);
            } else if (curElem instanceof Array) {
                Array curArray = (Array) curElem;
                ContainerPanel panel3 = new ContainerPanel("[" + i2 + "] (" + curArray.getTypeName() + ")");
                panel3.setFields(curArray);
                System.err.println("  (3)adding " + panel3 + " to containerpanel");
                addComponent(panel3);
            } else {
                throw new RuntimeException("Unknown StructElement type: " + curElem.getClass());
            }
        }
        this.contentsPanel.add(Box.createVerticalGlue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionSave() {
        List<EditStringValuePanel> modifiedFields = getModifiedFields();
        if (modifiedFields.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nothing to save.", "Information", 1);
            return;
        }
        StringBuilder messageBuilder = new StringBuilder();
        for (EditStringValuePanel vp : modifiedFields) {
            StringRepresentableField field = vp.getUserData();
            String validateRes = field.validateStringValue(vp.getValue());
            if (validateRes != null) {
                messageBuilder.append(vp.getDescription()).append(": ").append(vp.getValue());
                messageBuilder.append(" [").append(validateRes).append("]\n");
            }
        }
        if (messageBuilder.length() != 0) {
            JOptionPane.showMessageDialog(this, "The following fields failed to validate:\n\n" + messageBuilder.toString(), "Error", 0);
            return;
        }
        messageBuilder.append("The following modifications were made:\n\n");
        for (EditStringValuePanel vp2 : modifiedFields) {
            messageBuilder.append(vp2.getDescription()).append(": \"").append(vp2.getValue()).append("\"\n");
        }
        messageBuilder.append("\nCarry on with save?");
        JOptionPane.showConfirmDialog(this, messageBuilder.toString(), "Confirm save", 0, 3);
    }

    private List<EditStringValuePanel> getModifiedFields() {
        LinkedList<EditStringValuePanel> tmpList = new LinkedList<>();
        Iterator i$ = this.fields.iterator();
        while (i$.hasNext()) {
            EditStringValuePanel field = i$.next();
            if (field.isModified()) {
                tmpList.add(field);
            }
        }
        Iterator i$2 = this.subPanels.iterator();
        while (i$2.hasNext()) {
            ContainerPanel cp = i$2.next();
            tmpList.addAll(cp.getModifiedFields());
        }
        return tmpList;
    }

    private void addComponent(JComponent jc) {
        this.contentsPanel.add(jc);
    }
}
