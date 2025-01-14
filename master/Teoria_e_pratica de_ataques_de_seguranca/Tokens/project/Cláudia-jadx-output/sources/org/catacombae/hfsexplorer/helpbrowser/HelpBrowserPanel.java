package org.catacombae.hfsexplorer.helpbrowser;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/helpbrowser/HelpBrowserPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/helpbrowser/HelpBrowserPanel.class */
public class HelpBrowserPanel extends JPanel {
    private static final String TEST_HOME = "http://hem.bredband.net/catacombae/hfsx.html";
    private final URL homePage;
    private URL currentPage = null;
    private LinkedList<URL> history = new LinkedList<>();
    private JButton backButton;
    private JButton homeButton;
    private JTextPane htmlView;
    private JScrollPane htmlViewScroller;

    public HelpBrowserPanel(URL iHomePage) {
        this.homePage = iHomePage;
        initComponents();
        this.htmlView.setEditable(false);
        this.htmlView.addHyperlinkListener(new HyperlinkListener() { // from class: org.catacombae.hfsexplorer.helpbrowser.HelpBrowserPanel.1
            public void hyperlinkUpdate(HyperlinkEvent e2) {
                URL url;
                if (e2.getEventType() == HyperlinkEvent.EventType.ACTIVATED && (url = e2.getURL()) != null) {
                    HelpBrowserPanel.this.goToPage(url);
                }
            }
        });
        this.backButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.helpbrowser.HelpBrowserPanel.2
            public void actionPerformed(ActionEvent e2) {
                HelpBrowserPanel.this.goBack();
            }
        });
        this.homeButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.helpbrowser.HelpBrowserPanel.3
            public void actionPerformed(ActionEvent e2) {
                HelpBrowserPanel.this.goHome();
            }
        });
        goHome();
    }

    protected void goHome() {
        goToPage(this.homePage);
    }

    protected void goBack() {
        try {
            URL previousPage = this.history.getLast();
            this.htmlView.setPage(previousPage);
            this.currentPage = previousPage;
            this.history.removeLast();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "Could not load page " + this.currentPage, (Throwable) ex);
        } catch (NoSuchElementException e2) {
        }
    }

    protected void goToPage(URL iUrl) {
        try {
            if (this.currentPage != null && iUrl.equals(this.currentPage)) {
                this.htmlView.setPage(this.currentPage);
            } else {
                if (this.currentPage != null) {
                    this.history.addLast(this.currentPage);
                }
                this.htmlView.setPage(iUrl);
                this.currentPage = iUrl;
            }
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "Could not load page " + iUrl, (Throwable) ex);
        }
    }

    public static void showHelpBrowserWindow(String iTitle, URL iHomePage) {
        JFrame f2 = new JFrame(iTitle);
        f2.setDefaultCloseOperation(2);
        JPanel helpBrowserPanel = new HelpBrowserPanel(iHomePage);
        f2.add(helpBrowserPanel);
        f2.pack();
        f2.setLocationRelativeTo((Component) null);
        f2.setVisible(true);
    }

    private void initComponents() {
        this.backButton = new JButton();
        this.homeButton = new JButton();
        this.htmlViewScroller = new JScrollPane();
        this.htmlView = new JTextPane();
        this.backButton.setText("Back");
        this.homeButton.setText("Home");
        this.htmlViewScroller.setViewportView(this.htmlView);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.backButton).addPreferredGap(0).add((Component) this.homeButton).addContainerGap(486, 32767)).add(this.htmlViewScroller, -1, 616, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.backButton).add((Component) this.homeButton)).addPreferredGap(0).add(this.htmlViewScroller, -1, 330, 32767)));
    }
}
