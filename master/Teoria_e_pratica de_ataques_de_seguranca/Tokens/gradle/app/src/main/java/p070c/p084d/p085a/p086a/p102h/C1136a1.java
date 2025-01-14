package p070c.p084d.p085a.p086a.p102h;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;

/* renamed from: c.d.a.a.h.a1 */
/* loaded from: classes.dex */
public final class C1136a1 extends AbstractC1134a implements InterfaceC0928g {
    public static final Parcelable.Creator<C1136a1> CREATOR = new C1139b1();

    /* renamed from: a */
    public int f5528a;

    /* renamed from: b */
    public int f5529b;

    /* renamed from: c */
    public Intent f5530c;

    public C1136a1() {
        this(0, null);
    }

    public C1136a1(int i, int i2, Intent intent) {
        this.f5528a = i;
        this.f5529b = i2;
        this.f5530c = intent;
    }

    public C1136a1(int i, Intent intent) {
        this(2, 0, null);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g
    /* renamed from: a */
    public final Status mo4374a() {
        return this.f5529b == 0 ? Status.f6106e : Status.f6109h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5528a);
        C1140c.m5066b(parcel, 2, this.f5529b);
        C1140c.m5073a(parcel, 3, (Parcelable) this.f5530c, i, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
