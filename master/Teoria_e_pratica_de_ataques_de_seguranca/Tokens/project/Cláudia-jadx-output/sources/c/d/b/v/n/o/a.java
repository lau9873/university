package c.d.b.v.n.o;

import java.util.TimeZone;
/* compiled from: ISO8601Utils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f3886a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ca A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, NumberFormatException -> 0x01b9, IndexOutOfBoundsException -> 0x01bb, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c4, B:49:0x00ca, B:51:0x00d1, B:75:0x017e, B:55:0x00db, B:56:0x00f6, B:57:0x00f7, B:61:0x0113, B:63:0x0120, B:66:0x0129, B:68:0x0148, B:71:0x0157, B:72:0x0179, B:74:0x017c, B:60:0x0102, B:77:0x01af, B:78:0x01b6, B:40:0x00b2, B:41:0x00b5), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, NumberFormatException -> 0x01b9, IndexOutOfBoundsException -> 0x01bb, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b7, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c4, B:49:0x00ca, B:51:0x00d1, B:75:0x017e, B:55:0x00db, B:56:0x00f6, B:57:0x00f7, B:61:0x0113, B:63:0x0120, B:66:0x0129, B:68:0x0148, B:71:0x0157, B:72:0x0179, B:74:0x017c, B:60:0x0102, B:77:0x01af, B:78:0x01b6, B:40:0x00b2, B:41:0x00b5), top: B:94:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date a(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.v.n.o.a.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -digit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - digit2;
            i4 = i6;
        }
        return -i5;
    }

    public static int a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }
}
