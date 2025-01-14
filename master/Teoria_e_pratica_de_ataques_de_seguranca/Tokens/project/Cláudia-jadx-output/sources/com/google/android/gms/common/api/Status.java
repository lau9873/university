package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.a.e.e.b;
import c.d.a.a.e.e.g;
import c.d.a.a.e.e.q;
import c.d.a.a.e.f.b0;
import c.d.a.a.e.f.z;
import c.d.a.a.h.a;
import c.d.a.a.h.c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class Status extends a implements g, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;

    /* renamed from: e  reason: collision with root package name */
    public static final Status f4067e = new Status(0);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f4068f;

    /* renamed from: g  reason: collision with root package name */
    public static final Status f4069g;

    /* renamed from: h  reason: collision with root package name */
    public static final Status f4070h;

    /* renamed from: a  reason: collision with root package name */
    public int f4071a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4072b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4073c;

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f4074d;

    static {
        new Status(14);
        f4068f = new Status(8);
        f4069g = new Status(15);
        f4070h = new Status(16);
        new Status(17);
        new Status(18);
        CREATOR = new q();
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f4071a = i2;
        this.f4072b = i3;
        this.f4073c = str;
        this.f4074d = pendingIntent;
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }

    @Override // c.d.a.a.e.e.g
    public final Status a() {
        return this;
    }

    public final int b() {
        return this.f4072b;
    }

    public final String c() {
        return this.f4073c;
    }

    public final boolean d() {
        return this.f4074d != null;
    }

    public final boolean e() {
        return this.f4072b <= 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.f4071a == status.f4071a && this.f4072b == status.f4072b && z.a(this.f4073c, status.f4073c) && z.a(this.f4074d, status.f4074d);
        }
        return false;
    }

    public final String f() {
        String str = this.f4073c;
        return str != null ? str : b.a(this.f4072b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4071a), Integer.valueOf(this.f4072b), this.f4073c, this.f4074d});
    }

    public final String toString() {
        b0 a2 = z.a(this);
        a2.a("statusCode", f());
        a2.a("resolution", this.f4074d);
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, b());
        c.a(parcel, 2, c(), false);
        c.a(parcel, 3, (Parcelable) this.f4074d, i2, false);
        c.b(parcel, 1000, this.f4071a);
        c.c(parcel, a2);
    }
}
