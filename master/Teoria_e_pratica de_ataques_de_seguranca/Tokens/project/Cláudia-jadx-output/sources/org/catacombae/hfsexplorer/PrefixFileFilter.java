package org.catacombae.hfsexplorer;

import java.io.File;
import javax.swing.filechooser.FileFilter;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/PrefixFileFilter.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/PrefixFileFilter.class */
public class PrefixFileFilter extends FileFilter {
    private final String description;
    private final String prefix;

    public PrefixFileFilter(String description, String prefix) {
        this.description = description;
        this.prefix = prefix;
    }

    public boolean accept(File f2) {
        if (f2.isDirectory() || f2.getName().startsWith(this.prefix)) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }
}
