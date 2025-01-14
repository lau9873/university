package c.d.a.a.e.f;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class w implements v {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3551a;

    public w(IBinder iBinder) {
        this.f3551a = iBinder;
    }

    @Override // c.d.a.a.e.f.v
    public final void a(t tVar, c1 c1Var) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(tVar.asBinder());
            obtain.writeInt(1);
            c1Var.writeToParcel(obtain, 0);
            this.f3551a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3551a;
    }
}
