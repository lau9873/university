package c.d.a.a.h;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class e1 extends n1 implements d1 {
    public e1() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (a(i2, parcel, parcel2, i3)) {
            return true;
        }
        if (i2 == 3) {
            a((c.d.a.a.e.a) o1.a(parcel, c.d.a.a.e.a.CREATOR), (a1) o1.a(parcel, a1.CREATOR));
        } else if (i2 == 4) {
            b((Status) o1.a(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            a((Status) o1.a(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            a((Status) o1.a(parcel, Status.CREATOR), (GoogleSignInAccount) o1.a(parcel, GoogleSignInAccount.CREATOR));
        } else if (i2 != 8) {
            return false;
        } else {
            a((k1) o1.a(parcel, k1.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
