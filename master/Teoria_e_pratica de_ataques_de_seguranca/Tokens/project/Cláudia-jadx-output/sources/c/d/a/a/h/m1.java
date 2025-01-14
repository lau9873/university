package c.d.a.a.h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class m1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3620a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3621b;

    public m1(IBinder iBinder, String str) {
        this.f3620a = iBinder;
        this.f3621b = str;
    }

    public final Parcel a(int i2, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f3620a.transact(i2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3620a;
    }

    public final void b(int i2, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f3620a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3621b);
        return obtain;
    }
}
