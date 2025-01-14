package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.Bundle;
import android.os.Parcel;
import p070c.p084d.p085a.p086a.p102h.BinderC1175n1;
import p070c.p084d.p085a.p086a.p102h.C1178o1;

/* renamed from: c.d.a.a.e.f.u */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1085u extends BinderC1175n1 implements InterfaceC1083t {
    public AbstractBinderC1085u() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (m5026a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            mo5185a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) C1178o1.m5023a(parcel, Bundle.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            mo5184b(parcel.readInt(), (Bundle) C1178o1.m5023a(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
