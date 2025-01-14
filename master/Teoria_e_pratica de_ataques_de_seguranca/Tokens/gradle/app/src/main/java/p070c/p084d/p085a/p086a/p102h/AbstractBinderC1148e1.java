package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.h.e1 */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1148e1 extends BinderC1175n1 implements InterfaceC1145d1 {
    public AbstractBinderC1148e1() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (m5026a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 3) {
            mo5064a((C0900a) C1178o1.m5023a(parcel, C0900a.CREATOR), (C1136a1) C1178o1.m5023a(parcel, C1136a1.CREATOR));
        } else if (i == 4) {
            mo5060b((Status) C1178o1.m5023a(parcel, Status.CREATOR));
        } else if (i == 6) {
            mo5062a((Status) C1178o1.m5023a(parcel, Status.CREATOR));
        } else if (i == 7) {
            mo5061a((Status) C1178o1.m5023a(parcel, Status.CREATOR), (GoogleSignInAccount) C1178o1.m5023a(parcel, GoogleSignInAccount.CREATOR));
        } else if (i != 8) {
            return false;
        } else {
            mo5063a((C1166k1) C1178o1.m5023a(parcel, C1166k1.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
