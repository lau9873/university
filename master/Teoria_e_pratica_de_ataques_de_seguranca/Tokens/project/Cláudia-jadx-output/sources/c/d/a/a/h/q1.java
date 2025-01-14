package c.d.a.a.h;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class q1 extends n1 implements p1 {
    public static p1 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof p1 ? (p1) queryLocalInterface : new r1(iBinder);
    }
}
