package c.d.a.a.f;

import android.os.IBinder;
import android.os.IInterface;
import c.d.a.a.h.n1;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: c.d.a.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0059a extends n1 implements a {
        public AbstractBinderC0059a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new b(iBinder);
        }
    }
}
