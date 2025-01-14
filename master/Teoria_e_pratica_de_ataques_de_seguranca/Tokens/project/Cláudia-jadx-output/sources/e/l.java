package e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: Cookie.java */
/* loaded from: classes.dex */
public final class l {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    public final String f5890a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5891b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5892c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5893d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5894e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5895f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5896g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5897h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5898i;

    public l(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5890a = str;
        this.f5891b = str2;
        this.f5892c = j2;
        this.f5893d = str3;
        this.f5894e = str4;
        this.f5895f = z;
        this.f5896g = z2;
        this.f5898i = z3;
        this.f5897h = z4;
    }

    public String a() {
        return this.f5890a;
    }

    public String b() {
        return this.f5891b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return lVar.f5890a.equals(this.f5890a) && lVar.f5891b.equals(this.f5891b) && lVar.f5893d.equals(this.f5893d) && lVar.f5894e.equals(this.f5894e) && lVar.f5892c == this.f5892c && lVar.f5895f == this.f5895f && lVar.f5896g == this.f5896g && lVar.f5897h == this.f5897h && lVar.f5898i == this.f5898i;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f5892c;
        return ((((((((((((((((527 + this.f5890a.hashCode()) * 31) + this.f5891b.hashCode()) * 31) + this.f5893d.hashCode()) * 31) + this.f5894e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f5895f ? 1 : 0)) * 31) + (!this.f5896g ? 1 : 0)) * 31) + (!this.f5897h ? 1 : 0)) * 31) + (!this.f5898i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }

    public static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !e.i0.c.d(str);
    }

    public static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    public static l a(u uVar, String str) {
        return a(System.currentTimeMillis(), uVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e.l a(long r24, e.u r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.a(long, e.u, java.lang.String):e.l");
    }

    public static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
                i8 = parseInt2;
                i5 = parseInt;
            } else if (i6 == -1 && matcher.usePattern(l).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(k).matches()) {
                i7 = k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(j).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 >= 1601) {
            if (i7 != -1) {
                if (i6 < 1 || i6 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i5 < 0 || i5 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i8 < 0 || i8 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i9 >= 0 && i9 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(e.i0.c.n);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i4);
                    gregorianCalendar.set(2, i7 - 1);
                    gregorianCalendar.set(5, i6);
                    gregorianCalendar.set(11, i5);
                    gregorianCalendar.set(12, i8);
                    gregorianCalendar.set(13, i9);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String b2 = e.i0.c.b(str);
            if (b2 != null) {
                return b2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(u uVar, t tVar) {
        List<String> b2 = tVar.b("Set-Cookie");
        int size = b2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            l a2 = a(uVar, b2.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5890a);
        sb.append('=');
        sb.append(this.f5891b);
        if (this.f5897h) {
            if (this.f5892c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(e.i0.g.d.a(new Date(this.f5892c)));
            }
        }
        if (!this.f5898i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f5893d);
        }
        sb.append("; path=");
        sb.append(this.f5894e);
        if (this.f5895f) {
            sb.append("; secure");
        }
        if (this.f5896g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
