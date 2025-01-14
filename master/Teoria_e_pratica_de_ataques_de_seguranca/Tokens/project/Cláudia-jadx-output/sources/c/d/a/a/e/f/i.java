package c.d.a.a.e.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f3503a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3504b;

    /* renamed from: c  reason: collision with root package name */
    public final ComponentName f3505c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3506d;

    public i(String str, String str2, int i2) {
        c0.a(str);
        this.f3503a = str;
        c0.a(str2);
        this.f3504b = str2;
        this.f3505c = null;
        this.f3506d = i2;
    }

    public final ComponentName a() {
        return this.f3505c;
    }

    public final Intent a(Context context) {
        String str = this.f3503a;
        return str != null ? new Intent(str).setPackage(this.f3504b) : new Intent().setComponent(this.f3505c);
    }

    public final String b() {
        return this.f3504b;
    }

    public final int c() {
        return this.f3506d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return z.a(this.f3503a, iVar.f3503a) && z.a(this.f3504b, iVar.f3504b) && z.a(this.f3505c, iVar.f3505c) && this.f3506d == iVar.f3506d;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3503a, this.f3504b, this.f3505c, Integer.valueOf(this.f3506d)});
    }

    public final String toString() {
        String str = this.f3503a;
        return str == null ? this.f3505c.flattenToString() : str;
    }
}
