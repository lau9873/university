package c.a.a;

import android.text.TextUtils;
/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2762a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2763b;

    public e(String str, String str2) {
        this.f2762a = str;
        this.f2763b = str2;
    }

    public final String a() {
        return this.f2762a;
    }

    public final String b() {
        return this.f2763b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f2762a, eVar.f2762a) && TextUtils.equals(this.f2763b, eVar.f2763b);
    }

    public int hashCode() {
        return (this.f2762a.hashCode() * 31) + this.f2763b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f2762a + ",value=" + this.f2763b + "]";
    }
}
