package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.Parcel;
import p070c.p084d.p085a.p086a.p099f.InterfaceC1119a;
import p070c.p084d.p085a.p086a.p102h.BinderC1175n1;
import p070c.p084d.p085a.p086a.p102h.C1178o1;

/* renamed from: c.d.a.a.e.f.s */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1081s extends BinderC1175n1 implements InterfaceC1079r {
    public AbstractBinderC1081s() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (m5026a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            InterfaceC1119a mo5111e = mo5111e();
            parcel2.writeNoException();
            C1178o1.m5024a(parcel2, mo5111e);
        } else if (i != 2) {
            return false;
        } else {
            int mo5110g = mo5110g();
            parcel2.writeNoException();
            parcel2.writeInt(mo5110g);
        }
        return true;
    }
}
