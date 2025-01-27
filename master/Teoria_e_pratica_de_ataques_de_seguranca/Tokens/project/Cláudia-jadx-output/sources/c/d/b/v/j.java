package c.d.b.v;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* compiled from: PreJava9DateFormatProvider.java */
/* loaded from: classes.dex */
public class j {
    public static DateFormat a(int i2, int i3) {
        return new SimpleDateFormat(a(i2) + " " + b(i3), Locale.US);
    }

    public static String b(int i2) {
        if (i2 == 0 || i2 == 1) {
            return "h:mm:ss a z";
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return "h:mm a";
            }
            throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
        }
        return "h:mm:ss a";
    }

    public static String a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }
}
