package org.catacombae.hfsexplorer.types.hfsplus;

import java.util.Date;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogAttributes.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogAttributes.class */
public interface HFSPlusCatalogAttributes {
    short getRecordType();

    short getFlags();

    int getCreateDate();

    int getContentModDate();

    int getAttributeModDate();

    int getAccessDate();

    int getBackupDate();

    HFSPlusBSDInfo getPermissions();

    int getTextEncoding();

    Date getCreateDateAsDate();

    Date getContentModDateAsDate();

    Date getAttributeModDateAsDate();

    Date getAccessDateAsDate();

    Date getBackupDateAsDate();
}
