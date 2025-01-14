package p000a.p006b.p030g.p041g;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: a.b.g.g.b */
/* loaded from: classes.dex */
public interface IResultReceiver extends IInterface {

    /* compiled from: IResultReceiver.java */
    /* renamed from: a.b.g.g.b$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0239a extends Binder implements IResultReceiver {

        /* compiled from: IResultReceiver.java */
        /* renamed from: a.b.g.g.b$a$a */
        /* loaded from: classes.dex */
        public static class C0240a implements IResultReceiver {

            /* renamed from: a */
            public IBinder f1467a;

            public C0240a(IBinder iBinder) {
                this.f1467a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1467a;
            }
        }

        public AbstractBinderC0239a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        /* renamed from: a */
        public static IResultReceiver m9750a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IResultReceiver)) {
                return (IResultReceiver) queryLocalInterface;
            }
            return new C0240a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                mo9738a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    /* renamed from: a */
    void mo9738a(int i, Bundle bundle);
}
