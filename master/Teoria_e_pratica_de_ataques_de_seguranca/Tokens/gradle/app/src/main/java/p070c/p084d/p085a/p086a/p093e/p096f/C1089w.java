package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: c.d.a.a.e.f.w */
/* loaded from: classes.dex */
public final class C1089w implements InterfaceC1087v {

    /* renamed from: a */
    public final IBinder f5484a;

    public C1089w(IBinder iBinder) {
        this.f5484a = iBinder;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1087v
    /* renamed from: a */
    public final void mo5166a(InterfaceC1083t interfaceC1083t, C1050c1 c1050c1) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(interfaceC1083t.asBinder());
            obtain.writeInt(1);
            c1050c1.writeToParcel(obtain, 0);
            this.f5484a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5484a;
    }
}
