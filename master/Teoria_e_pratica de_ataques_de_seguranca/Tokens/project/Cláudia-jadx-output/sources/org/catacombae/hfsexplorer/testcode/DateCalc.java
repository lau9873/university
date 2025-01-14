package org.catacombae.hfsexplorer.testcode;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/DateCalc.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/DateCalc.class */
public class DateCalc {
    public static void main(String[] args) {
        Date d2 = new Date(0L);
        TimeZone usedTZ = TimeZone.getTimeZone("GMT+00:00");
        System.out.println(usedTZ);
        System.out.println(usedTZ.useDaylightTime());
        Calendar c1 = Calendar.getInstance(usedTZ);
        c1.setTime(d2);
        c1.set(1904, 0, 1);
        Calendar c2 = Calendar.getInstance(usedTZ);
        c2.setTime(d2);
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        DateFormat dti = DateFormat.getDateTimeInstance(3, 3);
        dti.setTimeZone(usedTZ);
        System.out.println("c1.getTime(): " + dti.format(c1.getTime()));
        System.out.println("c2.getTime(): " + dti.format(c2.getTime()));
        System.out.println("d: " + dti.format(d2));
        System.out.println("c1.getTime().getTime(): " + c1.getTime().getTime());
        System.out.println("c2.getTime().getTime(): " + c2.getTime().getTime());
        System.out.println("d.getTime(): " + d2.getTime());
        System.out.println("Diff in millis: " + (c2.getTime().getTime() - c1.getTime().getTime()));
    }
}
