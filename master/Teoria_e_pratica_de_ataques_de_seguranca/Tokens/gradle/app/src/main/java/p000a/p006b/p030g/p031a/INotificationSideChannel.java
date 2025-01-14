package p000a.p006b.p030g.p031a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: a.b.g.a.u */
/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {
    /* renamed from: a */
    void mo10079a(String str);

    /* renamed from: a */
    void mo10078a(String str, int i, String str2);

    /* renamed from: a */
    void mo10077a(String str, int i, String str2, Notification notification);

    /* compiled from: INotificationSideChannel.java */
    /* renamed from: a.b.g.a.u$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0184a extends Binder implements INotificationSideChannel {
        /* renamed from: a */
        public static INotificationSideChannel m10080a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface != null && (queryLocalInterface instanceof INotificationSideChannel)) {
                return (INotificationSideChannel) queryLocalInterface;
            }
            return new C0185a(iBinder);
        }

        /* compiled from: INotificationSideChannel.java */
        /* renamed from: a.b.g.a.u$a$a */
        /* loaded from: classes.dex */
        public static class C0185a implements INotificationSideChannel {

            /* renamed from: a */
            public IBinder f1279a;

            public C0185a(IBinder iBinder) {
                this.f1279a = iBinder;
            }

            @Override // p000a.p006b.p030g.p031a.INotificationSideChannel
            /* renamed from: a */
            public void mo10077a(String str, int i, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1279a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1279a;
            }

            @Override // p000a.p006b.p030g.p031a.INotificationSideChannel
            /* renamed from: a */
            public void mo10078a(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.f1279a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // p000a.p006b.p030g.p031a.INotificationSideChannel
            /* renamed from: a */
            public void mo10079a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    this.f1279a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
