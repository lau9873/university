package a.b.g.a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* compiled from: INotificationSideChannel.java */
/* loaded from: classes.dex */
public interface u extends IInterface {
    void a(String str);

    void a(String str, int i2, String str2);

    void a(String str, int i2, String str2, Notification notification);

    /* compiled from: INotificationSideChannel.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements u {
        public static u a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface != null && (queryLocalInterface instanceof u)) {
                return (u) queryLocalInterface;
            }
            return new C0016a(iBinder);
        }

        /* compiled from: INotificationSideChannel.java */
        /* renamed from: a.b.g.a.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0016a implements u {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f808a;

            public C0016a(IBinder iBinder) {
                this.f808a = iBinder;
            }

            @Override // a.b.g.a.u
            public void a(String str, int i2, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f808a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f808a;
            }

            @Override // a.b.g.a.u
            public void a(String str, int i2, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    this.f808a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // a.b.g.a.u
            public void a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    this.f808a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
