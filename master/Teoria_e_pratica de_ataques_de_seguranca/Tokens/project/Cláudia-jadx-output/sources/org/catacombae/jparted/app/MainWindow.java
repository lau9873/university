package org.catacombae.jparted.app;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainWindow.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/app/MainWindow.class */
public class MainWindow extends JFrame {
    private JMenuItem loadFileItem;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
    private JPanel mainPanel;

    public MainWindow(JPanel mainPanel) {
        super("jParted");
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        add(mainPanel, "Center");
        setupMenus();
        pack();
        setLocationRelativeTo(null);
    }

    private static void setAbstractButtonListener(AbstractButton button, ActionListener listener) {
        ActionListener[] arr$ = button.getActionListeners();
        for (ActionListener al : arr$) {
            button.removeActionListener(al);
        }
        button.addActionListener(listener);
    }

    public void setLoadFileItemListener(ActionListener listener) {
        setAbstractButtonListener(this.loadFileItem, listener);
    }

    public void setExitItemListener(ActionListener listener) {
        setAbstractButtonListener(this.exitItem, listener);
    }

    public void setAboutItemListener(ActionListener listener) {
        setAbstractButtonListener(this.aboutItem, listener);
    }

    private void setupMenus() {
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        this.loadFileItem = new JMenuItem("Load from file...");
        fileMenu.add(this.loadFileItem);
        this.exitItem = new JMenuItem("Quit");
        fileMenu.add(this.exitItem);
        this.aboutItem = new JMenuItem("About...");
        helpMenu.add(this.aboutItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }
}
