package a.b.g.g;

import java.util.HashSet;
import java.util.Locale;
/* compiled from: LocaleListHelper.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final Locale[] f961b = new Locale[0];

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f962a;

    static {
        new e(new Locale[0]);
        new Locale("en", "XA");
        new Locale("ar", "XB");
        c.a("en-Latn");
    }

    public e(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f962a = f961b;
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < localeArr.length; i2++) {
            Locale locale = localeArr[i2];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    localeArr2[i2] = locale2;
                    sb.append(c.a(locale2));
                    if (i2 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                } else {
                    throw new IllegalArgumentException("list[" + i2 + "] is a repetition");
                }
            } else {
                throw new NullPointerException("list[" + i2 + "] is null");
            }
        }
        this.f962a = localeArr2;
        sb.toString();
    }

    public Locale a(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f962a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        Locale[] localeArr = ((e) obj).f962a;
        if (this.f962a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f962a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        int i2 = 1;
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.f962a;
            if (i3 >= localeArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + localeArr[i3].hashCode();
            i3++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f962a;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.f962a.length - 1) {
                    sb.append(',');
                }
                i2++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
