package d.a.a.a.m.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* compiled from: AdvertisingInfoServiceStrategy.java */
/* loaded from: classes.dex */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4238a;

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* loaded from: classes.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4239a;

        /* renamed from: b  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f4240b;

        public b() {
            this.f4239a = false;
            this.f4240b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f4239a) {
                d.a.a.a.c.h().c("Fabric", "getBinder already called");
            }
            this.f4239a = true;
            try {
                return this.f4240b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f4240b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f4240b.clear();
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* loaded from: classes.dex */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f4241a;

        public c(IBinder iBinder) {
            this.f4241a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f4241a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception unused) {
                    d.a.a.a.c.h().e("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f4241a;
        }

        public boolean h() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(1);
                    this.f4241a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                    d.a.a.a.c.h().e("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public e(Context context) {
        this.f4238a = context.getApplicationContext();
    }

    @Override // d.a.a.a.m.b.f
    public d.a.a.a.m.b.b a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d.a.a.a.c.h().e("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f4238a.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f4238a.bindService(intent, bVar, 1)) {
                    try {
                        c cVar = new c(bVar.a());
                        d.a.a.a.m.b.b bVar2 = new d.a.a.a.m.b.b(cVar.a(), cVar.h());
                        this.f4238a.unbindService(bVar);
                        return bVar2;
                    } catch (Exception e2) {
                        d.a.a.a.c.h().b("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e2);
                        this.f4238a.unbindService(bVar);
                    }
                } else {
                    d.a.a.a.c.h().e("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                }
            } catch (Throwable th) {
                d.a.a.a.c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            d.a.a.a.c.h().e("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e3) {
            d.a.a.a.c.h().a("Fabric", "Unable to determine if Google Play Services is available", e3);
            return null;
        }
    }
}
