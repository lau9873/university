package p070c.p084d.p105b.p107v;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: c.d.b.v.j */
/* loaded from: classes.dex */
public class PreJava9DateFormatProvider {
    /* renamed from: a */
    public static DateFormat m4826a(int i, int i2) {
        return new SimpleDateFormat(m4827a(i) + " " + m4825b(i2), Locale.US);
    }

    /* renamed from: b */
    public static String m4825b(int i) {
        if (i == 0 || i == 1) {
            return "h:mm:ss a z";
        }
        if (i != 2) {
            if (i == 3) {
                return "h:mm a";
            }
            throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
        return "h:mm:ss a";
    }

    /* renamed from: a */
    public static String m4827a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }
}
