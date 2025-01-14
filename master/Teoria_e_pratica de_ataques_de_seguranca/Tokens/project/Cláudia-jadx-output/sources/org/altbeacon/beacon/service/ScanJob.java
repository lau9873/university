package org.altbeacon.beacon.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import g.a.a.c;
import g.a.a.j;
import g.a.a.l.e;
import g.a.a.m.d;
import g.a.a.n.i;
import g.a.a.n.l;
import g.a.a.n.m;
import g.a.a.n.n;
import g.a.b.b;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
@TargetApi(21)
/* loaded from: classes.dex */
public class ScanJob extends JobService {

    /* renamed from: f  reason: collision with root package name */
    public static final String f7621f = ScanJob.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    public static int f7622g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f7623h = -1;

    /* renamed from: c  reason: collision with root package name */
    public l f7626c;

    /* renamed from: a  reason: collision with root package name */
    public n f7624a = null;

    /* renamed from: b  reason: collision with root package name */
    public Handler f7625b = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public boolean f7627d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7628e = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JobParameters f7629a;

        /* renamed from: org.altbeacon.beacon.service.ScanJob$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0175a implements Runnable {

            /* renamed from: org.altbeacon.beacon.service.ScanJob$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0176a implements Runnable {
                public RunnableC0176a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ScanJob.this.c();
                }
            }

            public RunnableC0175a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = ScanJob.f7621f;
                d.c(str, "Scan job runtime expired: " + ScanJob.this, new Object[0]);
                ScanJob.this.f();
                ScanJob.this.f7624a.l();
                a aVar = a.this;
                ScanJob.this.jobFinished(aVar.f7629a, false);
                ScanJob.this.f7625b.post(new RunnableC0176a());
            }
        }

        public a(JobParameters jobParameters) {
            this.f7629a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean e2;
            if (!ScanJob.this.a()) {
                d.b(ScanJob.f7621f, "Cannot allocate a scanner to look for beacons.  System resources are low.", new Object[0]);
                ScanJob.this.jobFinished(this.f7629a, false);
            }
            m.b().b(ScanJob.this.getApplicationContext());
            if (this.f7629a.getJobId() == ScanJob.a((Context) ScanJob.this)) {
                String str = ScanJob.f7621f;
                d.c(str, "Running immediate scan job: instance is " + ScanJob.this, new Object[0]);
            } else {
                String str2 = ScanJob.f7621f;
                d.c(str2, "Running periodic scan job: instance is " + ScanJob.this, new Object[0]);
            }
            List<ScanResult> a2 = m.b().a();
            d.a(ScanJob.f7621f, "Processing %d queued scan resuilts", Integer.valueOf(a2.size()));
            for (ScanResult scanResult : a2) {
                ScanRecord scanRecord = scanResult.getScanRecord();
                if (scanRecord != null && ScanJob.this.f7626c != null) {
                    ScanJob.this.f7626c.a(scanResult.getDevice(), scanResult.getRssi(), scanRecord.getBytes());
                }
            }
            d.a(ScanJob.f7621f, "Done processing queued scan resuilts", new Object[0]);
            synchronized (ScanJob.this) {
                if (ScanJob.this.f7628e) {
                    d.a(ScanJob.f7621f, "Quitting scan job before we even start.  Somebody told us to stop.", new Object[0]);
                    ScanJob.this.jobFinished(this.f7629a, false);
                    return;
                }
                if (ScanJob.this.f7627d) {
                    d.a(ScanJob.f7621f, "Scanning already started.  Resetting for current parameters", new Object[0]);
                    e2 = ScanJob.this.b();
                } else {
                    e2 = ScanJob.this.e();
                }
                ScanJob.this.f7625b.removeCallbacksAndMessages(null);
                if (e2) {
                    if (ScanJob.this.f7624a != null) {
                        String str3 = ScanJob.f7621f;
                        d.c(str3, "Scan job running for " + ScanJob.this.f7624a.k() + " millis", new Object[0]);
                        ScanJob.this.f7625b.postDelayed(new RunnableC0175a(), (long) ScanJob.this.f7624a.k());
                    }
                } else {
                    d.c(ScanJob.f7621f, "Scanning not started so Scan job is complete.", new Object[0]);
                    ScanJob.this.f();
                    ScanJob.this.f7624a.l();
                    String str4 = ScanJob.f7621f;
                    d.a(str4, "ScanJob Lifecycle STOP (start fail): " + ScanJob.this, new Object[0]);
                    ScanJob.this.jobFinished(this.f7629a, false);
                }
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String str = f7621f;
        d.a(str, "ScanJob Lifecycle START: " + this, new Object[0]);
        new Thread(new a(jobParameters)).start();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        synchronized (this) {
            this.f7628e = true;
            if (jobParameters.getJobId() == b((Context) this)) {
                String str = f7621f;
                d.c(str, "onStopJob called for periodic scan " + this, new Object[0]);
            } else {
                String str2 = f7621f;
                d.c(str2, "onStopJob called for immediate scan " + this, new Object[0]);
            }
            String str3 = f7621f;
            d.a(str3, "ScanJob Lifecycle STOP: " + this, new Object[0]);
            this.f7625b.removeCallbacksAndMessages(null);
            f();
            d();
            if (this.f7626c != null) {
                this.f7626c.i();
            }
        }
        return false;
    }

    public final boolean a() {
        this.f7624a = n.a(this);
        if (this.f7624a != null) {
            l lVar = new l(this);
            this.f7624a.a(System.currentTimeMillis());
            lVar.a(this.f7624a.h());
            lVar.a(this.f7624a.i());
            lVar.a(this.f7624a.d());
            lVar.a(this.f7624a.e());
            if (lVar.a() == null) {
                try {
                    lVar.a(this.f7624a.b().booleanValue(), (b) null);
                } catch (OutOfMemoryError unused) {
                    d.d(f7621f, "Failed to create CycledLeScanner thread.", new Object[0]);
                    return false;
                }
            }
            this.f7626c = lVar;
            return true;
        }
        return false;
    }

    public final boolean b() {
        l lVar;
        if (this.f7624a == null || (lVar = this.f7626c) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            lVar.h();
        }
        long longValue = (this.f7624a.b().booleanValue() ? this.f7624a.c() : this.f7624a.g()).longValue();
        long longValue2 = (this.f7624a.b().booleanValue() ? this.f7624a.a() : this.f7624a.f()).longValue();
        if (this.f7626c.a() != null) {
            this.f7626c.a().a(longValue, longValue2, this.f7624a.b().booleanValue());
        }
        this.f7627d = true;
        if (longValue <= 0) {
            d.d(f7621f, "Starting scan with scan period of zero.  Exiting ScanJob.", new Object[0]);
            if (this.f7626c.a() != null) {
                this.f7626c.a().r();
            }
            return false;
        } else if (this.f7626c.d().size() <= 0 && this.f7626c.c().d().size() <= 0) {
            if (this.f7626c.a() != null) {
                this.f7626c.a().r();
            }
            return false;
        } else {
            if (this.f7626c.a() != null) {
                this.f7626c.a().p();
            }
            return true;
        }
    }

    public final void c() {
        n nVar = this.f7624a;
        if (nVar != null) {
            if (!nVar.b().booleanValue()) {
                d.a(f7621f, "In foreground mode, schedule next scan", new Object[0]);
                m.b().c(this);
                return;
            }
            d();
        }
    }

    public final void d() {
        if (this.f7624a != null) {
            d.a(f7621f, "Checking to see if we need to start a passive scan", new Object[0]);
            boolean z = false;
            for (j jVar : new ArrayList(this.f7624a.h().d())) {
                i d2 = this.f7624a.h().d(jVar);
                if (d2 != null && d2.b()) {
                    z = true;
                }
            }
            if (z) {
                d.c(f7621f, "We are inside a beacon region.  We will not scan between cycles.", new Object[0]);
            } else if (Build.VERSION.SDK_INT >= 26) {
                l lVar = this.f7626c;
                if (lVar != null) {
                    lVar.b(this.f7624a.d());
                }
            } else {
                d.a(f7621f, "This is not Android O.  No scanning between cycles when using ScanJob", new Object[0]);
            }
        }
    }

    public final boolean e() {
        BeaconManager a2 = BeaconManager.a(getApplicationContext());
        a2.c(true);
        if (a2.y()) {
            d.c(f7621f, "scanJob version %s is starting up on the main process", "2.16.3");
        } else {
            d.c(f7621f, "beaconScanJob library version %s is starting up on a separate process", "2.16.3");
            g.a.a.p.a aVar = new g.a.a.p.a(this);
            String str = f7621f;
            d.c(str, "beaconScanJob PID is " + aVar.b() + " with process name " + aVar.c(), new Object[0]);
        }
        c.a(new e(this, BeaconManager.G()));
        return b();
    }

    public final void f() {
        this.f7627d = false;
        l lVar = this.f7626c;
        if (lVar != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                lVar.h();
            }
            if (this.f7626c.a() != null) {
                this.f7626c.a().r();
                this.f7626c.a().f();
            }
        }
        d.a(f7621f, "Scanning stopped", new Object[0]);
    }

    public static int a(Context context) {
        if (f7622g >= 0) {
            String str = f7621f;
            d.c(str, "Using ImmediateScanJobId from static override: " + f7622g, new Object[0]);
            return f7622g;
        }
        return a(context, "immediateScanJobId");
    }

    public static int a(Context context, String str) {
        ServiceInfo serviceInfo;
        Bundle bundle;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, ScanJob.class), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfo = null;
        }
        if (serviceInfo != null && (bundle = ((PackageItemInfo) serviceInfo).metaData) != null && bundle.get(str) != null) {
            int i2 = ((PackageItemInfo) serviceInfo).metaData.getInt(str);
            String str2 = f7621f;
            d.c(str2, "Using " + str + " from manifest: " + i2, new Object[0]);
            return i2;
        }
        throw new RuntimeException("Cannot get job id from manifest.  Make sure that the " + str + " is configured in the manifest for the ScanJob.");
    }

    public static int b(Context context) {
        if (f7622g >= 0) {
            String str = f7621f;
            d.c(str, "Using PeriodicScanJobId from static override: " + f7623h, new Object[0]);
            return f7623h;
        }
        return a(context, "periodicScanJobId");
    }
}
