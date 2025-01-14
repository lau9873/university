package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c.d.a.a.c.a.b;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.i;
import c.d.a.a.e.m;
import c.d.a.a.h.p1;
import c.d.a.a.h.q1;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class AdvertisingIdClient {
    public final Context mContext;
    public i zzams;
    public p1 zzamt;
    public boolean zzamu;
    public Object zzamv;
    public a zzamw;
    public boolean zzamx;
    public long zzamy;

    /* loaded from: classes.dex */
    public static final class Info {
        public final String zzane;
        public final boolean zzanf;

        public Info(String str, boolean z) {
            this.zzane = str;
            this.zzanf = z;
        }

        public final String getId() {
            return this.zzane;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzanf;
        }

        public final String toString() {
            String str = this.zzane;
            boolean z = this.zzanf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<AdvertisingIdClient> f4050a;

        /* renamed from: b  reason: collision with root package name */
        public long f4051b;

        /* renamed from: c  reason: collision with root package name */
        public CountDownLatch f4052c = new CountDownLatch(1);

        /* renamed from: d  reason: collision with root package name */
        public boolean f4053d = false;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f4050a = new WeakReference<>(advertisingIdClient);
            this.f4051b = j;
            start();
        }

        public final void a() {
            AdvertisingIdClient advertisingIdClient = this.f4050a.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f4053d = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f4052c.await(this.f4051b, TimeUnit.MILLISECONDS)) {
                    return;
                }
                a();
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.zzamv = new Object();
        c0.a(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.mContext = context;
        this.zzamu = false;
        this.zzamy = j;
        this.zzamx = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        b bVar = new b(context);
        boolean a2 = bVar.a("gads:ad_id_app_context:enabled", false);
        float a3 = bVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String a4 = bVar.a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, a2, bVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, a2, a3, SystemClock.elapsedRealtime() - elapsedRealtime, a4, null);
            return info;
        } finally {
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        b bVar = new b(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, bVar.a("gads:ad_id_app_context:enabled", false), bVar.a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.start(false);
            return advertisingIdClient.getIsAdIdFakeForDebugLogging();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) {
        c0.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamu) {
                finish();
            }
            this.zzams = zzc(this.mContext, this.zzamx);
            this.zzamt = zza(this.mContext, this.zzams);
            this.zzamu = true;
            if (z) {
                zzbm();
            }
        }
    }

    public static p1 zza(Context context, i iVar) {
        try {
            return q1.a(iVar.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f2, long j, String str, Throwable th) {
        if (Math.random() > f2) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (info != null && info.getId() != null) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new c.d.a.a.c.a.a(this, hashMap).start();
        return true;
    }

    private final void zzbm() {
        synchronized (this.zzamv) {
            if (this.zzamw != null) {
                this.zzamw.f4052c.countDown();
                try {
                    this.zzamw.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzamy > 0) {
                this.zzamw = new a(this, this.zzamy);
            }
        }
    }

    public static i zzc(Context context, boolean z) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int a2 = m.a().a(context);
            if (a2 == 0 || a2 == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                i iVar = new i();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (c.d.a.a.e.g.a.a().a(context, intent, iVar, 1)) {
                        return iVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            }
            throw new IOException("Google Play services not available");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public void finalize() {
        finish();
        super.finalize();
    }

    public void finish() {
        c0.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzams == null) {
                return;
            }
            if (this.zzamu) {
                c.d.a.a.e.g.a.a();
                this.mContext.unbindService(this.zzams);
            }
            this.zzamu = false;
            this.zzamt = null;
            this.zzams = null;
        }
    }

    public Info getInfo() {
        Info info;
        c0.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamu) {
                synchronized (this.zzamv) {
                    if (this.zzamw == null || !this.zzamw.f4053d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamu) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            c0.a(this.zzams);
            c0.a(this.zzamt);
            try {
                info = new Info(this.zzamt.a(), this.zzamt.d(true));
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception");
            }
        }
        zzbm();
        return info;
    }

    public boolean getIsAdIdFakeForDebugLogging() {
        boolean f2;
        c0.b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamu) {
                synchronized (this.zzamv) {
                    if (this.zzamw == null || !this.zzamw.f4053d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamu) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            c0.a(this.zzams);
            c0.a(this.zzamt);
            try {
                f2 = this.zzamt.f();
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception");
            }
        }
        zzbm();
        return f2;
    }

    public void start() {
        start(true);
    }
}
