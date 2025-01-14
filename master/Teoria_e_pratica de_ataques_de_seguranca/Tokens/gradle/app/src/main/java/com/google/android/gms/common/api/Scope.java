package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import p070c.p084d.p085a.p086a.p093e.p094e.C1040p;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* loaded from: classes.dex */
public final class Scope extends AbstractC1134a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new C1040p();

    /* renamed from: a */
    public int f6104a;

    /* renamed from: b */
    public final String f6105b;

    public Scope(int i, String str) {
        C1049c0.m5291a(str, (Object) "scopeUri must not be null or empty");
        this.f6104a = i;
        this.f6105b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f6105b.equals(((Scope) obj).f6105b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6105b.hashCode();
    }

    public final String toString() {
        return this.f6105b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f6104a);
        C1140c.m5072a(parcel, 2, this.f6105b, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
