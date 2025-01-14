package org.catacombae.jparted.lib.fs.hfscommon;

import java.util.Date;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusBSDInfo;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.WindowsFileAttributes;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSAttributes.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSAttributes.class */
class HFSCommonFSAttributes extends FSAttributes {
    private final FSEntry parentEntry;
    private final CommonHFSCatalogAttributes attributes;
    private FSAttributes.POSIXFileAttributes posixAttributes = null;

    public HFSCommonFSAttributes(FSEntry parentEntry, CommonHFSCatalogAttributes attributes) {
        this.parentEntry = parentEntry;
        this.attributes = attributes;
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasPOSIXFileAttributes() {
        return this.attributes.hasPermissions();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public FSAttributes.POSIXFileAttributes getPOSIXFileAttributes() {
        if (this.attributes.hasPermissions()) {
            if (this.posixAttributes == null) {
                HFSPlusBSDInfo permissions = this.attributes.getPermissions();
                this.posixAttributes = new FSAttributes.DefaultPOSIXFileAttributes(Util.unsign(permissions.getOwnerID()), Util.unsign(permissions.getGroupID()), permissions.getFileMode());
            }
            return this.posixAttributes;
        }
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public WindowsFileAttributes getWindowsFileAttributes() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public Date getModifyDate() {
        return this.attributes.getContentModDateAsDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasWindowsFileAttributes() {
        return false;
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasCreateDate() {
        return this.attributes.hasCreateDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public Date getCreateDate() {
        return this.attributes.getCreateDateAsDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasModifyDate() {
        return this.attributes.hasContentModDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasAttributeModifyDate() {
        return this.attributes.hasAttributeModDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasAccessDate() {
        return this.attributes.hasAccessDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public Date getAccessDate() {
        return this.attributes.getAccessDateAsDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public boolean hasBackupDate() {
        return this.attributes.hasBackupDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public Date getBackupDate() {
        return this.attributes.getBackupDateAsDate();
    }

    @Override // org.catacombae.jparted.lib.fs.FSAttributes
    public Date getAttributeModifyDate() {
        return this.attributes.getAttributeModDateAsDate();
    }
}
