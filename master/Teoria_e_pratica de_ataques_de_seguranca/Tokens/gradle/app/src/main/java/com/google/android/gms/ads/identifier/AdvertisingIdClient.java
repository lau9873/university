package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p070c.p084d.p085a.p086a.p087c.p088a.C0895a;
import p070c.p084d.p085a.p086a.p087c.p088a.C0896b;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.ServiceConnectionC1105i;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p097g.C1097a;
import p070c.p084d.p085a.p086a.p102h.AbstractBinderC1184q1;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1181p1;

/* loaded from: classes.dex */
public class AdvertisingIdClient {
    public final Context mContext;
    public ServiceConnectionC1105i zzams;
    public InterfaceC1181p1 zzamt;
    public boolean zzamu;
    public Object zzamv;
    public C1437a zzamw;
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

    /* renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient$a */
    /* loaded from: classes.dex */
    public static class C1437a extends Thread {

        /* renamed from: a */
        public WeakReference<AdvertisingIdClient> f6084a;

        /* renamed from: b */
        public long f6085b;

        /* renamed from: c */
        public CountDownLatch f6086c = new CountDownLatch(1);

        /* renamed from: d */
        public boolean f6087d = false;

        public C1437a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f6084a = new WeakReference<>(advertisingIdClient);
            this.f6085b = j;
            start();
        }

        /* renamed from: a */
        public final void m4391a() {
            AdvertisingIdClient advertisingIdClient = this.f6084a.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f6087d = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f6086c.await(this.f6085b, TimeUnit.MILLISECONDS)) {
                    return;
                }
                m4391a();
            } catch (InterruptedException unused) {
                m4391a();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.zzamv = new Object();
        C1049c0.m5294a(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.mContext = context;
        this.zzamu = false;
        this.zzamy = j;
        this.zzamx = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        C0896b c0896b = new C0896b(context);
        boolean m5652a = c0896b.m5652a("gads:ad_id_app_context:enabled", false);
        float m5654a = c0896b.m5654a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String m5653a = c0896b.m5653a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, m5652a, c0896b.m5652a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, m5652a, m5654a, SystemClock.elapsedRealtime() - elapsedRealtime, m5653a, null);
            return info;
        } finally {
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        C0896b c0896b = new C0896b(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, c0896b.m5652a("gads:ad_id_app_context:enabled", false), c0896b.m5652a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
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
        C1049c0.m5287b("Calling this from your main thread can lead to deadlock");
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

    public static InterfaceC1181p1 zza(Context context, ServiceConnectionC1105i serviceConnectionC1105i) {
        try {
            return AbstractBinderC1184q1.m5017a(serviceConnectionC1105i.m5126a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
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
        new C0895a(this, hashMap).start();
        return true;
    }

    private final void zzbm() {
        synchronized (this.zzamv) {
            if (this.zzamw != null) {
                this.zzamw.f6086c.countDown();
                try {
                    this.zzamw.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzamy > 0) {
                this.zzamw = new C1437a(this, this.zzamy);
            }
        }
    }

    public static ServiceConnectionC1105i zzc(Context context, boolean z) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int mo5123a = C1109m.m5125a().mo5123a(context);
            if (mo5123a == 0 || mo5123a == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                ServiceConnectionC1105i serviceConnectionC1105i = new ServiceConnectionC1105i();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (C1097a.m5147a().m5146a(context, intent, serviceConnectionC1105i, 1)) {
                        return serviceConnectionC1105i;
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
        C1049c0.m5287b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzams == null) {
                return;
            }
            if (this.zzamu) {
                C1097a.m5147a();
                this.mContext.unbindService(this.zzams);
            }
            this.zzamu = false;
            this.zzamt = null;
            this.zzams = null;
        }
    }

    public Info getInfo() {
        Info info;
        C1049c0.m5287b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamu) {
                synchronized (this.zzamv) {
                    if (this.zzamw == null || !this.zzamw.f6087d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamu) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            C1049c0.m5294a(this.zzams);
            C1049c0.m5294a(this.zzamt);
            try {
                info = new Info(this.zzamt.mo5016a(), this.zzamt.mo5015d(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzbm();
        return info;
    }

    public boolean getIsAdIdFakeForDebugLogging() {
        boolean mo5014f;
        C1049c0.m5287b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamu) {
                synchronized (this.zzamv) {
                    if (this.zzamw == null || !this.zzamw.f6087d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamu) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            C1049c0.m5294a(this.zzams);
            C1049c0.m5294a(this.zzamt);
            try {
                mo5014f = this.zzamt.mo5014f();
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzbm();
        return mo5014f;
    }

    public void start() {
        start(true);
    }
}
