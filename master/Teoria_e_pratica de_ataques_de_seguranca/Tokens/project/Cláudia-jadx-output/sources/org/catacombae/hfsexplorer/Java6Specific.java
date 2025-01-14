package org.catacombae.hfsexplorer;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/Java6Specific.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/Java6Specific.class */
public class Java6Specific {
    public static boolean canOpen() {
        return Desktop.getDesktop().isSupported(Desktop.Action.OPEN);
    }

    public static void openFile(File f2) throws IOException {
        Desktop.getDesktop().open(f2);
    }

    public static void setIconImages(ImageIcon[] icons, Window window) {
        LinkedList<Image> iconImages = new LinkedList<>();
        for (ImageIcon ii : icons) {
            iconImages.addLast(ii.getImage());
        }
        window.setIconImages(iconImages);
    }

    public static void addRowSorter(JTable table, DefaultTableModel tableModel, int defaultSortColumn, List<Comparator<?>> columnComparators) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        int i2 = 0;
        for (Comparator<?> c2 : columnComparators) {
            if (c2 != null) {
                sorter.setComparator(i2, c2);
            }
            i2++;
        }
        sorter.toggleSortOrder(defaultSortColumn);
        table.setRowSorter(sorter);
    }
}
