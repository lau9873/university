package p070c.p084d.p085a.p086a.p099f;

import android.os.IBinder;
import android.os.IInterface;
import p070c.p084d.p085a.p086a.p102h.BinderC1175n1;

/* renamed from: c.d.a.a.f.a */
/* loaded from: classes.dex */
public interface InterfaceC1119a extends IInterface {

    /* renamed from: c.d.a.a.f.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1120a extends BinderC1175n1 implements InterfaceC1119a {
        public AbstractBinderC1120a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: a */
        public static InterfaceC1119a m5103a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof InterfaceC1119a ? (InterfaceC1119a) queryLocalInterface : new C1121b(iBinder);
        }
    }
}
