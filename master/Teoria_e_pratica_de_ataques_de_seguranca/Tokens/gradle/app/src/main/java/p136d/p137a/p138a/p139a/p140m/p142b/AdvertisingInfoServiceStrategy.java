package p136d.p137a.p138a.p139a.p140m.p142b;

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
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: d.a.a.a.m.b.e */
/* loaded from: classes.dex */
public class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {

    /* renamed from: a */
    public final Context f6430a;

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* renamed from: d.a.a.a.m.b.e$b */
    /* loaded from: classes.dex */
    public static final class ServiceConnectionC1488b implements ServiceConnection {

        /* renamed from: a */
        public boolean f6431a;

        /* renamed from: b */
        public final LinkedBlockingQueue<IBinder> f6432b;

        public ServiceConnectionC1488b() {
            this.f6431a = false;
            this.f6432b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder m4122a() {
            if (this.f6431a) {
                Fabric.m4197h().mo4160c("Fabric", "getBinder already called");
            }
            this.f6431a = true;
            try {
                return this.f6432b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f6432b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f6432b.clear();
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* renamed from: d.a.a.a.m.b.e$c */
    /* loaded from: classes.dex */
    public static final class C1489c implements IInterface {

        /* renamed from: a */
        public final IBinder f6433a;

        public C1489c(IBinder iBinder) {
            this.f6433a = iBinder;
        }

        /* renamed from: a */
        public String m4121a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f6433a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception unused) {
                    Fabric.m4197h().mo4157e("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
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
            return this.f6433a;
        }

        /* renamed from: h */
        public boolean m4120h() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(1);
                    this.f6433a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                    Fabric.m4197h().mo4157e("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public AdvertisingInfoServiceStrategy(Context context) {
        this.f6430a = context.getApplicationContext();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p142b.AdvertisingInfoStrategy
    /* renamed from: a */
    public AdvertisingInfo mo4119a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Fabric.m4197h().mo4157e("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f6430a.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC1488b serviceConnectionC1488b = new ServiceConnectionC1488b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f6430a.bindService(intent, serviceConnectionC1488b, 1)) {
                    try {
                        C1489c c1489c = new C1489c(serviceConnectionC1488b.m4122a());
                        AdvertisingInfo advertisingInfo = new AdvertisingInfo(c1489c.m4121a(), c1489c.m4120h());
                        this.f6430a.unbindService(serviceConnectionC1488b);
                        return advertisingInfo;
                    } catch (Exception e) {
                        Fabric.m4197h().mo4161b("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                        this.f6430a.unbindService(serviceConnectionC1488b);
                    }
                } else {
                    Fabric.m4197h().mo4157e("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                }
            } catch (Throwable th) {
                Fabric.m4197h().mo4163a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Fabric.m4197h().mo4157e("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            Fabric.m4197h().mo4163a("Fabric", "Unable to determine if Google Play Services is available", e2);
            return null;
        }
    }
}
