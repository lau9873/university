package c.d.a.a.e.f;

import android.os.Parcel;
import c.d.a.a.h.n1;
import c.d.a.a.h.o1;
/* loaded from: classes.dex */
public abstract class s extends n1 implements r {
    public s() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (a(i2, parcel, parcel2, i3)) {
            return true;
        }
        if (i2 == 1) {
            c.d.a.a.f.a e2 = e();
            parcel2.writeNoException();
            o1.a(parcel2, e2);
        } else if (i2 != 2) {
            return false;
        } else {
            int g2 = g();
            parcel2.writeNoException();
            parcel2.writeInt(g2);
        }
        return true;
    }
}
