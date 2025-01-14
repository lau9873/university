package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1056f0;

/* renamed from: c.d.a.a.h.k1 */
/* loaded from: classes.dex */
public final class C1166k1 extends AbstractC1134a {
    public static final Parcelable.Creator<C1166k1> CREATOR = new C1169l1();

    /* renamed from: a */
    public int f5553a;

    /* renamed from: b */
    public final C0900a f5554b;

    /* renamed from: c */
    public final C1056f0 f5555c;

    public C1166k1(int i) {
        this(new C0900a(8, null), null);
    }

    public C1166k1(int i, C0900a c0900a, C1056f0 c1056f0) {
        this.f5553a = i;
        this.f5554b = c0900a;
        this.f5555c = c1056f0;
    }

    public C1166k1(C0900a c0900a, C1056f0 c1056f0) {
        this(1, c0900a, null);
    }

    /* renamed from: b */
    public final C0900a m5036b() {
        return this.f5554b;
    }

    /* renamed from: c */
    public final C1056f0 m5035c() {
        return this.f5555c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5553a);
        C1140c.m5073a(parcel, 2, (Parcelable) this.f5554b, i, false);
        C1140c.m5073a(parcel, 3, (Parcelable) this.f5555c, i, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
