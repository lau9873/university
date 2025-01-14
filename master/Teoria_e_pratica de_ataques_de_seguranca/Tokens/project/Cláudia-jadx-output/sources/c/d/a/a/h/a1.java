package c.d.a.a.h;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class a1 extends a implements c.d.a.a.e.e.g {
    public static final Parcelable.Creator<a1> CREATOR = new b1();

    /* renamed from: a  reason: collision with root package name */
    public int f3595a;

    /* renamed from: b  reason: collision with root package name */
    public int f3596b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f3597c;

    public a1() {
        this(0, null);
    }

    public a1(int i2, int i3, Intent intent) {
        this.f3595a = i2;
        this.f3596b = i3;
        this.f3597c = intent;
    }

    public a1(int i2, Intent intent) {
        this(2, 0, null);
    }

    @Override // c.d.a.a.e.e.g
    public final Status a() {
        return this.f3596b == 0 ? Status.f4067e : Status.f4070h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f3595a);
        c.b(parcel, 2, this.f3596b);
        c.a(parcel, 3, (Parcelable) this.f3597c, i2, false);
        c.c(parcel, a2);
    }
}
