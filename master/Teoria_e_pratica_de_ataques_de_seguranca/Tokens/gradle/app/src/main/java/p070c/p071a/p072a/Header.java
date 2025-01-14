package p070c.p071a.p072a;

import android.text.TextUtils;

/* renamed from: c.a.a.e */
/* loaded from: classes.dex */
public final class Header {

    /* renamed from: a */
    public final String f4552a;

    /* renamed from: b */
    public final String f4553b;

    public Header(String str, String str2) {
        this.f4552a = str;
        this.f4553b = str2;
    }

    /* renamed from: a */
    public final String m6229a() {
        return this.f4552a;
    }

    /* renamed from: b */
    public final String m6228b() {
        return this.f4553b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.f4552a, header.f4552a) && TextUtils.equals(this.f4553b, header.f4553b);
    }

    public int hashCode() {
        return (this.f4552a.hashCode() * 31) + this.f4553b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f4552a + ",value=" + this.f4553b + "]";
    }
}
