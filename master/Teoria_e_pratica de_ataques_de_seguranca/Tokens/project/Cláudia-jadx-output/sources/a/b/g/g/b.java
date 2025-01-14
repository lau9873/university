package a.b.g.g;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* compiled from: IResultReceiver.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IResultReceiver.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: IResultReceiver.java */
        /* renamed from: a.b.g.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0026a implements b {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f957a;

            public C0026a(IBinder iBinder) {
                this.f957a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f957a;
            }
        }

        public a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0026a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    void a(int i2, Bundle bundle);
}
