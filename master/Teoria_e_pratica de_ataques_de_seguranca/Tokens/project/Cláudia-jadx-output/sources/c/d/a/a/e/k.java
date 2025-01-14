package c.d.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class k extends c.d.a.a.h.a {
    public static final Parcelable.Creator<k> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    public String f3568a;

    /* renamed from: b  reason: collision with root package name */
    public int f3569b;

    public k(String str, int i2) {
        this.f3568a = str;
        this.f3569b = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.a(parcel, 1, this.f3568a, false);
        c.d.a.a.h.c.b(parcel, 2, this.f3569b);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
