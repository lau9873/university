package p181e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p181e.p182i0.Util;
import p181e.p182i0.p185g.HttpDate;

/* renamed from: e.l */
/* loaded from: classes.dex */
public final class Cookie {

    /* renamed from: j */
    public static final Pattern f8298j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    public static final Pattern f8299k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    public static final Pattern f8300l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    public static final Pattern f8301m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    public final String f8302a;

    /* renamed from: b */
    public final String f8303b;

    /* renamed from: c */
    public final long f8304c;

    /* renamed from: d */
    public final String f8305d;

    /* renamed from: e */
    public final String f8306e;

    /* renamed from: f */
    public final boolean f8307f;

    /* renamed from: g */
    public final boolean f8308g;

    /* renamed from: h */
    public final boolean f8309h;

    /* renamed from: i */
    public final boolean f8310i;

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f8302a = str;
        this.f8303b = str2;
        this.f8304c = j;
        this.f8305d = str3;
        this.f8306e = str4;
        this.f8307f = z;
        this.f8308g = z2;
        this.f8310i = z3;
        this.f8309h = z4;
    }

    /* renamed from: a */
    public String m2801a() {
        return this.f8302a;
    }

    /* renamed from: b */
    public String m2792b() {
        return this.f8303b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return cookie.f8302a.equals(this.f8302a) && cookie.f8303b.equals(this.f8303b) && cookie.f8305d.equals(this.f8305d) && cookie.f8306e.equals(this.f8306e) && cookie.f8304c == this.f8304c && cookie.f8307f == this.f8307f && cookie.f8308g == this.f8308g && cookie.f8309h == this.f8309h && cookie.f8310i == this.f8310i;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f8304c;
        return ((((((((((((((((527 + this.f8302a.hashCode()) * 31) + this.f8303b.hashCode()) * 31) + this.f8305d.hashCode()) * 31) + this.f8306e.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.f8307f ? 1 : 0)) * 31) + (!this.f8308g ? 1 : 0)) * 31) + (!this.f8309h ? 1 : 0)) * 31) + (!this.f8310i ? 1 : 0);
    }

    public String toString() {
        return m2793a(false);
    }

    /* renamed from: a */
    public static boolean m2794a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.m3148d(str);
    }

    /* renamed from: b */
    public static long m2791b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static Cookie m2798a(HttpUrl httpUrl, String str) {
        return m2800a(System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0131  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p181e.Cookie m2800a(long r24, p181e.HttpUrl r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p181e.Cookie.m2800a(long, e.u, java.lang.String):e.l");
    }

    /* renamed from: a */
    public static long m2796a(String str, int i, int i2) {
        int m2795a = m2795a(str, i, i2, false);
        Matcher matcher = f8301m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (m2795a < i2) {
            int m2795a2 = m2795a(str, m2795a + 1, i2, true);
            matcher.region(m2795a, m2795a2);
            if (i4 == -1 && matcher.usePattern(f8301m).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i4 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(f8300l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f8299k).matches()) {
                i6 = f8299k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f8298j).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            m2795a = m2795a(str, m2795a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 >= 1601) {
            if (i6 != -1) {
                if (i5 < 1 || i5 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 0 || i4 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 >= 0 && i8 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.f7947n);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i3);
                    gregorianCalendar.set(2, i6 - 1);
                    gregorianCalendar.set(5, i5);
                    gregorianCalendar.set(11, i4);
                    gregorianCalendar.set(12, i7);
                    gregorianCalendar.set(13, i8);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static int m2795a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m2797a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String m3153b = Util.m3153b(str);
            if (m3153b != null) {
                return m3153b;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<Cookie> m2799a(HttpUrl httpUrl, Headers headers) {
        List<String> m2760b = headers.m2760b("Set-Cookie");
        int size = m2760b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie m2798a = m2798a(httpUrl, m2760b.get(i));
            if (m2798a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m2798a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    public String m2793a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8302a);
        sb.append('=');
        sb.append(this.f8303b);
        if (this.f8309h) {
            if (this.f8304c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.m3074a(new Date(this.f8304c)));
            }
        }
        if (!this.f8310i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f8305d);
        }
        sb.append("; path=");
        sb.append(this.f8306e);
        if (this.f8307f) {
            sb.append("; secure");
        }
        if (this.f8308g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
