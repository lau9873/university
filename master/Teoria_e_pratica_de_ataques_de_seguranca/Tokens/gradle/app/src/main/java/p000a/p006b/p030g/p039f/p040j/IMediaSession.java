package p000a.p006b.p030g.p039f.p040j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: a.b.g.f.j.b */
/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    /* compiled from: IMediaSession.java */
    /* renamed from: a.b.g.f.j.b$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0228a extends Binder implements IMediaSession {

        /* compiled from: IMediaSession.java */
        /* renamed from: a.b.g.f.j.b$a$a */
        /* loaded from: classes.dex */
        public static class C0229a implements IMediaSession {

            /* renamed from: a */
            public IBinder f1461a;

            public C0229a(IBinder iBinder) {
                this.f1461a = iBinder;
            }

            @Override // p000a.p006b.p030g.p039f.p040j.IMediaSession
            /* renamed from: a */
            public void mo9796a(IMediaControllerCallback iMediaControllerCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                    this.f1461a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1461a;
            }
        }

        /* renamed from: a */
        public static IMediaSession m9797a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) queryLocalInterface;
            }
            return new C0229a(iBinder);
        }
    }

    /* renamed from: a */
    void mo9796a(IMediaControllerCallback iMediaControllerCallback);
}
