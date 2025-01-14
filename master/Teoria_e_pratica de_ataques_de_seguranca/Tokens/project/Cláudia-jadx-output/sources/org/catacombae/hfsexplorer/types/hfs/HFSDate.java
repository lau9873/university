package org.catacombae.hfsexplorer.types.hfs;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/HFSDate.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/HFSDate.class */
public class HFSDate {
    public static Date localTimestampToDate(int hfsTimestamp) {
        Date baseDate = getBaseDate(TimeZone.getDefault());
        return new Date(baseDate.getTime() + ((hfsTimestamp & 4294967295L) * 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date getBaseDate(TimeZone tz) {
        Calendar c2 = Calendar.getInstance(tz);
        c2.clear();
        c2.set(1, 1904);
        return c2.getTime();
    }
}
