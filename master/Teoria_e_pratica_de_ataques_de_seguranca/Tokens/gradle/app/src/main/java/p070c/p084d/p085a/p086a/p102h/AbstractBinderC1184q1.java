package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: c.d.a.a.h.q1 */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1184q1 extends BinderC1175n1 implements InterfaceC1181p1 {
    /* renamed from: a */
    public static InterfaceC1181p1 m5017a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof InterfaceC1181p1 ? (InterfaceC1181p1) queryLocalInterface : new C1187r1(iBinder);
    }
}
