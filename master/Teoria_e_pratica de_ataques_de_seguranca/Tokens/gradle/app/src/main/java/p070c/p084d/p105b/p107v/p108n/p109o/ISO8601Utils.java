package p070c.p084d.p105b.p107v.p108n.p109o;

import java.util.TimeZone;

/* renamed from: c.d.b.v.n.o.a */
/* loaded from: classes.dex */
public class ISO8601Utils {

    /* renamed from: a */
    public static final TimeZone f5891a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ca A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, NumberFormatException -> 0x01b9, IndexOutOfBoundsException -> 0x01bb, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c4, B:49:0x00ca, B:51:0x00d1, B:75:0x017e, B:55:0x00db, B:56:0x00f6, B:57:0x00f7, B:61:0x0113, B:63:0x0120, B:66:0x0129, B:68:0x0148, B:71:0x0157, B:72:0x0179, B:74:0x017c, B:60:0x0102, B:77:0x01af, B:78:0x01b6, B:40:0x00b2, B:41:0x00b5), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, NumberFormatException -> 0x01b9, IndexOutOfBoundsException -> 0x01bb, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c4, B:49:0x00ca, B:51:0x00d1, B:75:0x017e, B:55:0x00db, B:56:0x00f6, B:57:0x00f7, B:61:0x0113, B:63:0x0120, B:66:0x0129, B:68:0x0148, B:71:0x0157, B:72:0x0179, B:74:0x017c, B:60:0x0102, B:77:0x01af, B:78:0x01b6, B:40:0x00b2, B:41:0x00b5), top: B:94:0x0004 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date m4746a(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p107v.p108n.p109o.ISO8601Utils.m4746a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    /* renamed from: a */
    public static boolean m4748a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    /* renamed from: a */
    public static int m4747a(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i3 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -digit;
        } else {
            i3 = i;
            i4 = 0;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            int digit2 = Character.digit(str.charAt(i3), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - digit2;
            i3 = i5;
        }
        return -i4;
    }

    /* renamed from: a */
    public static int m4749a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
