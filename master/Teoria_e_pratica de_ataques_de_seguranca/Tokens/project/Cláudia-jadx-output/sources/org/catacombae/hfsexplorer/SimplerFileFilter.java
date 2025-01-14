package org.catacombae.hfsexplorer;

import java.io.File;
import javax.swing.filechooser.FileFilter;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/SimplerFileFilter.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/SimplerFileFilter.class */
public class SimplerFileFilter extends FileFilter {
    private String extension;
    private String description;

    public SimplerFileFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }

    public boolean accept(File f2) {
        if (f2.isDirectory() || f2.getName().endsWith(this.extension)) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExtension() {
        return this.extension;
    }
}
