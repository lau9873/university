package p000a.p006b.p030g.p041g;

import java.util.HashSet;
import java.util.Locale;

/* renamed from: a.b.g.g.e */
/* loaded from: classes.dex */
public final class LocaleListHelper {

    /* renamed from: b */
    public static final Locale[] f1471b = new Locale[0];

    /* renamed from: a */
    public final Locale[] f1472a;

    static {
        new LocaleListHelper(new Locale[0]);
        new Locale("en", "XA");
        new Locale("ar", "XB");
        LocaleHelper.m9749a("en-Latn");
    }

    public LocaleListHelper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f1472a = f1471b;
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    localeArr2[i] = locale2;
                    sb.append(LocaleHelper.m9748a(locale2));
                    if (i < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                } else {
                    throw new IllegalArgumentException("list[" + i + "] is a repetition");
                }
            } else {
                throw new NullPointerException("list[" + i + "] is null");
            }
        }
        this.f1472a = localeArr2;
        sb.toString();
    }

    /* renamed from: a */
    public Locale m9741a(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f1472a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListHelper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListHelper) obj).f1472a;
        if (this.f1472a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f1472a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f1472a;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f1472a;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < this.f1472a.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
