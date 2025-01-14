package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: c.d.a.a.h.m1 */
/* loaded from: classes.dex */
public class C1172m1 implements IInterface {

    /* renamed from: a */
    public final IBinder f5557a;

    /* renamed from: b */
    public final String f5558b;

    public C1172m1(IBinder iBinder, String str) {
        this.f5557a = iBinder;
        this.f5558b = str;
    }

    /* renamed from: a */
    public final Parcel m5034a(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f5557a.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f5557a;
    }

    /* renamed from: b */
    public final void m5033b(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f5557a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* renamed from: h */
    public final Parcel m5032h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f5558b);
        return obtain;
    }
}
