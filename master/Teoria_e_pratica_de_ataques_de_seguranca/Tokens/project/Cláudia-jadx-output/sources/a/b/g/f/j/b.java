package a.b.g.f.j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* compiled from: IMediaSession.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IMediaSession.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: IMediaSession.java */
        /* renamed from: a.b.g.f.j.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0024a implements b {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f951a;

            public C0024a(IBinder iBinder) {
                this.f951a = iBinder;
            }

            @Override // a.b.g.f.j.b
            public void a(a.b.g.f.j.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f951a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f951a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0024a(iBinder);
        }
    }

    void a(a.b.g.f.j.a aVar);
}
