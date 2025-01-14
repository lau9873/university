package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p093e.p094e.C0918b;
import p070c.p084d.p085a.p086a.p093e.p094e.C1041q;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1046b0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* loaded from: classes.dex */
public final class Status extends AbstractC1134a implements InterfaceC0928g, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;

    /* renamed from: e */
    public static final Status f6106e = new Status(0);

    /* renamed from: f */
    public static final Status f6107f;

    /* renamed from: g */
    public static final Status f6108g;

    /* renamed from: h */
    public static final Status f6109h;

    /* renamed from: a */
    public int f6110a;

    /* renamed from: b */
    public final int f6111b;

    /* renamed from: c */
    public final String f6112c;

    /* renamed from: d */
    public final PendingIntent f6113d;

    static {
        new Status(14);
        f6107f = new Status(8);
        f6108g = new Status(15);
        f6109h = new Status(16);
        new Status(17);
        new Status(18);
        CREATOR = new C1041q();
    }

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f6110a = i;
        this.f6111b = i2;
        this.f6112c = str;
        this.f6113d = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g
    /* renamed from: a */
    public final Status mo4374a() {
        return this;
    }

    /* renamed from: b */
    public final int m4373b() {
        return this.f6111b;
    }

    /* renamed from: c */
    public final String m4372c() {
        return this.f6112c;
    }

    /* renamed from: d */
    public final boolean m4371d() {
        return this.f6113d != null;
    }

    /* renamed from: e */
    public final boolean m4370e() {
        return this.f6111b <= 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.f6110a == status.f6110a && this.f6111b == status.f6111b && C1095z.m5149a(this.f6112c, status.f6112c) && C1095z.m5149a(this.f6113d, status.f6113d);
        }
        return false;
    }

    /* renamed from: f */
    public final String m4369f() {
        String str = this.f6112c;
        return str != null ? str : C0918b.m5603a(this.f6111b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6110a), Integer.valueOf(this.f6111b), this.f6112c, this.f6113d});
    }

    public final String toString() {
        C1046b0 m5150a = C1095z.m5150a(this);
        m5150a.m5298a("statusCode", m4369f());
        m5150a.m5298a("resolution", this.f6113d);
        return m5150a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, m4373b());
        C1140c.m5072a(parcel, 2, m4372c(), false);
        C1140c.m5073a(parcel, 3, (Parcelable) this.f6113d, i, false);
        C1140c.m5066b(parcel, 1000, this.f6110a);
        C1140c.m5065c(parcel, m5080a);
    }
}
