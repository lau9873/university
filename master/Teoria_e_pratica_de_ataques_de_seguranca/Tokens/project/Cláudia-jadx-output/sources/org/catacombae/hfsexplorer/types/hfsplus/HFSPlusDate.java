package org.catacombae.hfsexplorer.types.hfsplus;

import java.util.Date;
import java.util.TimeZone;
import org.catacombae.hfsexplorer.types.hfs.HFSDate;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusDate.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusDate.class */
public class HFSPlusDate extends HFSDate {
    public static Date gmtTimestampToDate(int hfsPlusTimestamp) {
        Date baseDate = getBaseDate(TimeZone.getTimeZone("GMT"));
        return new Date(baseDate.getTime() + ((hfsPlusTimestamp & 4294967295L) * 1000));
    }
}
