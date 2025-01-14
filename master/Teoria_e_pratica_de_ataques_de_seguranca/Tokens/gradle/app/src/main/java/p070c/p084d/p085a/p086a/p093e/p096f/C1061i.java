package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;

/* renamed from: c.d.a.a.e.f.i */
/* loaded from: classes.dex */
public final class C1061i {

    /* renamed from: a */
    public final String f5436a;

    /* renamed from: b */
    public final String f5437b;

    /* renamed from: c */
    public final ComponentName f5438c;

    /* renamed from: d */
    public final int f5439d;

    public C1061i(String str, String str2, int i) {
        C1049c0.m5292a(str);
        this.f5436a = str;
        C1049c0.m5292a(str2);
        this.f5437b = str2;
        this.f5438c = null;
        this.f5439d = i;
    }

    /* renamed from: a */
    public final ComponentName m5223a() {
        return this.f5438c;
    }

    /* renamed from: a */
    public final Intent m5222a(Context context) {
        String str = this.f5436a;
        return str != null ? new Intent(str).setPackage(this.f5437b) : new Intent().setComponent(this.f5438c);
    }

    /* renamed from: b */
    public final String m5221b() {
        return this.f5437b;
    }

    /* renamed from: c */
    public final int m5220c() {
        return this.f5439d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1061i) {
            C1061i c1061i = (C1061i) obj;
            return C1095z.m5149a(this.f5436a, c1061i.f5436a) && C1095z.m5149a(this.f5437b, c1061i.f5437b) && C1095z.m5149a(this.f5438c, c1061i.f5438c) && this.f5439d == c1061i.f5439d;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5436a, this.f5437b, this.f5438c, Integer.valueOf(this.f5439d)});
    }

    public final String toString() {
        String str = this.f5436a;
        return str == null ? this.f5438c.flattenToString() : str;
    }
}
