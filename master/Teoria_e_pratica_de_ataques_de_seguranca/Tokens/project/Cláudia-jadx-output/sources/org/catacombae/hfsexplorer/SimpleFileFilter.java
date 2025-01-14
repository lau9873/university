package org.catacombae.hfsexplorer;

import java.io.File;
import java.util.Vector;
import javax.swing.filechooser.FileFilter;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/SimpleFileFilter.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/SimpleFileFilter.class */
public class SimpleFileFilter extends FileFilter {
    private Vector<String> extensions = new Vector<>();
    private String description = "";

    public void addExtension(String extension) {
        this.extensions.add(extension);
    }

    public void setDescription(String idescription) {
        this.description = idescription;
    }

    public void removeExtension(String iextension) {
        for (int i2 = 0; i2 < this.extensions.size(); i2++) {
            if (this.extensions.get(i2).equals(iextension)) {
                this.extensions.remove(i2);
            }
        }
    }

    public boolean accept(File f2) {
        if (f2.isDirectory()) {
            return true;
        }
        for (int i2 = 0; i2 < this.extensions.size(); i2++) {
            if (f2.getName().endsWith(this.extensions.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }
}
