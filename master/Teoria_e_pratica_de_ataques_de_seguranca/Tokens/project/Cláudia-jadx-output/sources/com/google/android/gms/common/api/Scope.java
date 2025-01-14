package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.a.e.e.p;
import c.d.a.a.e.f.c0;
import c.d.a.a.h.a;
import c.d.a.a.h.c;
import com.google.android.gms.common.internal.ReflectedParcelable;
/* loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f4065a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4066b;

    public Scope(int i2, String str) {
        c0.a(str, (Object) "scopeUri must not be null or empty");
        this.f4065a = i2;
        this.f4066b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f4066b.equals(((Scope) obj).f4066b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4066b.hashCode();
    }

    public final String toString() {
        return this.f4066b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f4065a);
        c.a(parcel, 2, this.f4066b, false);
        c.c(parcel, a2);
    }
}
