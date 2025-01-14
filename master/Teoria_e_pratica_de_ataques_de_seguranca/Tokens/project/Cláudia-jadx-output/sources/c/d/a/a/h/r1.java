package c.d.a.a.h;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class r1 extends m1 implements p1 {
    public r1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // c.d.a.a.h.p1
    public final String a() {
        Parcel a2 = a(1, h());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // c.d.a.a.h.p1
    public final boolean d(boolean z) {
        Parcel h2 = h();
        o1.a(h2, true);
        Parcel a2 = a(2, h2);
        boolean a3 = o1.a(a2);
        a2.recycle();
        return a3;
    }

    @Override // c.d.a.a.h.p1
    public final boolean f() {
        Parcel a2 = a(6, h());
        boolean a3 = o1.a(a2);
        a2.recycle();
        return a3;
    }
}
