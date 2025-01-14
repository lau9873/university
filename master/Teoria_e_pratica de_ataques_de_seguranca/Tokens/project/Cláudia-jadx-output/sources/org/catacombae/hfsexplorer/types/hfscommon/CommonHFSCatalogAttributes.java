package org.catacombae.hfsexplorer.types.hfscommon;

import java.util.Date;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusBSDInfo;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogAttributes.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogAttributes.class */
public interface CommonHFSCatalogAttributes {
    short getRecordType();

    short getFlags();

    int getCreateDate();

    int getContentModDate();

    int getAttributeModDate();

    int getAccessDate();

    int getBackupDate();

    boolean hasCreateDate();

    boolean hasContentModDate();

    boolean hasAttributeModDate();

    boolean hasAccessDate();

    boolean hasBackupDate();

    boolean hasPermissions();

    HFSPlusBSDInfo getPermissions();

    Date getCreateDateAsDate();

    Date getContentModDateAsDate();

    Date getAttributeModDateAsDate();

    Date getAccessDateAsDate();

    Date getBackupDateAsDate();
}
