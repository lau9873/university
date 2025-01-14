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
import com.j256.ormlite.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p197l.ModelSpecificDistanceCalculator;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.RegionMonitoringState;
import p193g.p194a.p195a.p199n.ScanHelper;
import p193g.p194a.p195a.p199n.ScanJobScheduler;
import p193g.p194a.p195a.p199n.ScanState;
import p193g.p194a.p195a.p202p.ProcessUtils;
import p193g.p194a.p203b.BluetoothCrashResolver;

@TargetApi(21)
/* loaded from: classes.dex */
public class ScanJob extends JobService {

    /* renamed from: f */
    public static final String f10638f = ScanJob.class.getSimpleName();

    /* renamed from: g */
    public static int f10639g = -1;

    /* renamed from: h */
    public static int f10640h = -1;

    /* renamed from: c */
    public ScanHelper f10643c;

    /* renamed from: a */
    public ScanState f10641a = null;

    /* renamed from: b */
    public Handler f10642b = new Handler();

    /* renamed from: d */
    public boolean f10644d = false;

    /* renamed from: e */
    public boolean f10645e = false;

    /* renamed from: org.altbeacon.beacon.service.ScanJob$a */
    /* loaded from: classes.dex */
    public class RunnableC2661a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ JobParameters f10646a;

        /* renamed from: org.altbeacon.beacon.service.ScanJob$a$a */
        /* loaded from: classes.dex */
        public class RunnableC2662a implements Runnable {

            /* renamed from: org.altbeacon.beacon.service.ScanJob$a$a$a */
            /* loaded from: classes.dex */
            public class RunnableC2663a implements Runnable {
                public RunnableC2663a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ScanJob.this.m397c();
                }
            }

            public RunnableC2662a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = ScanJob.f10638f;
                LogManager.m2428c(str, "Scan job runtime expired: " + ScanJob.this, new Object[0]);
                ScanJob.this.m391f();
                ScanJob.this.f10641a.m2302l();
                RunnableC2661a runnableC2661a = RunnableC2661a.this;
                ScanJob.this.jobFinished(runnableC2661a.f10646a, false);
                ScanJob.this.f10642b.post(new RunnableC2663a());
            }
        }

        public RunnableC2661a(JobParameters jobParameters) {
            this.f10646a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean m393e;
            if (!ScanJob.this.m404a()) {
                LogManager.m2430b(ScanJob.f10638f, "Cannot allocate a scanner to look for beacons.  System resources are low.", new Object[0]);
                ScanJob.this.jobFinished(this.f10646a, false);
            }
            ScanJobScheduler.m2319b().m2318b(ScanJob.this.getApplicationContext());
            if (this.f10646a.getJobId() == ScanJob.m403a((Context) ScanJob.this)) {
                String str = ScanJob.f10638f;
                LogManager.m2428c(str, "Running immediate scan job: instance is " + ScanJob.this, new Object[0]);
            } else {
                String str2 = ScanJob.f10638f;
                LogManager.m2428c(str2, "Running periodic scan job: instance is " + ScanJob.this, new Object[0]);
            }
            List<ScanResult> m2325a = ScanJobScheduler.m2319b().m2325a();
            LogManager.m2432a(ScanJob.f10638f, "Processing %d queued scan resuilts", Integer.valueOf(m2325a.size()));
            for (ScanResult scanResult : m2325a) {
                ScanRecord scanRecord = scanResult.getScanRecord();
                if (scanRecord != null && ScanJob.this.f10643c != null) {
                    ScanJob.this.f10643c.m2354a(scanResult.getDevice(), scanResult.getRssi(), scanRecord.getBytes());
                }
            }
            LogManager.m2432a(ScanJob.f10638f, "Done processing queued scan resuilts", new Object[0]);
            synchronized (ScanJob.this) {
                if (ScanJob.this.f10645e) {
                    LogManager.m2432a(ScanJob.f10638f, "Quitting scan job before we even start.  Somebody told us to stop.", new Object[0]);
                    ScanJob.this.jobFinished(this.f10646a, false);
                    return;
                }
                if (ScanJob.this.f10644d) {
                    LogManager.m2432a(ScanJob.f10638f, "Scanning already started.  Resetting for current parameters", new Object[0]);
                    m393e = ScanJob.this.m400b();
                } else {
                    m393e = ScanJob.this.m393e();
                }
                ScanJob.this.f10642b.removeCallbacksAndMessages(null);
                if (m393e) {
                    if (ScanJob.this.f10641a != null) {
                        String str3 = ScanJob.f10638f;
                        LogManager.m2428c(str3, "Scan job running for " + ScanJob.this.f10641a.m2303k() + " millis", new Object[0]);
                        ScanJob.this.f10642b.postDelayed(new RunnableC2662a(), (long) ScanJob.this.f10641a.m2303k());
                    }
                } else {
                    LogManager.m2428c(ScanJob.f10638f, "Scanning not started so Scan job is complete.", new Object[0]);
                    ScanJob.this.m391f();
                    ScanJob.this.f10641a.m2302l();
                    String str4 = ScanJob.f10638f;
                    LogManager.m2432a(str4, "ScanJob Lifecycle STOP (start fail): " + ScanJob.this, new Object[0]);
                    ScanJob.this.jobFinished(this.f10646a, false);
                }
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String str = f10638f;
        LogManager.m2432a(str, "ScanJob Lifecycle START: " + this, new Object[0]);
        new Thread(new RunnableC2661a(jobParameters)).start();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        synchronized (this) {
            this.f10645e = true;
            if (jobParameters.getJobId() == m399b((Context) this)) {
                String str = f10638f;
                LogManager.m2428c(str, "onStopJob called for periodic scan " + this, new Object[0]);
            } else {
                String str2 = f10638f;
                LogManager.m2428c(str2, "onStopJob called for immediate scan " + this, new Object[0]);
            }
            String str3 = f10638f;
            LogManager.m2432a(str3, "ScanJob Lifecycle STOP: " + this, new Object[0]);
            this.f10642b.removeCallbacksAndMessages(null);
            m391f();
            m395d();
            if (this.f10643c != null) {
                this.f10643c.m2330i();
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m404a() {
        this.f10641a = ScanState.m2314a(this);
        if (this.f10641a != null) {
            ScanHelper scanHelper = new ScanHelper(this);
            this.f10641a.m2315a(System.currentTimeMillis());
            scanHelper.m2350a(this.f10641a.m2306h());
            scanHelper.m2346a(this.f10641a.m2305i());
            scanHelper.m2345a(this.f10641a.m2310d());
            scanHelper.m2351a(this.f10641a.m2309e());
            if (scanHelper.m2355a() == null) {
                try {
                    scanHelper.m2344a(this.f10641a.m2312b().booleanValue(), (BluetoothCrashResolver) null);
                } catch (OutOfMemoryError unused) {
                    LogManager.m2427d(f10638f, "Failed to create CycledLeScanner thread.", new Object[0]);
                    return false;
                }
            }
            this.f10643c = scanHelper;
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m400b() {
        ScanHelper scanHelper;
        if (this.f10641a == null || (scanHelper = this.f10643c) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            scanHelper.m2331h();
        }
        long longValue = (this.f10641a.m2312b().booleanValue() ? this.f10641a.m2311c() : this.f10641a.m2307g()).longValue();
        long longValue2 = (this.f10641a.m2312b().booleanValue() ? this.f10641a.m2316a() : this.f10641a.m2308f()).longValue();
        if (this.f10643c.m2355a() != null) {
            this.f10643c.m2355a().m2279a(longValue, longValue2, this.f10641a.m2312b().booleanValue());
        }
        this.f10644d = true;
        if (longValue <= 0) {
            LogManager.m2427d(f10638f, "Starting scan with scan period of zero.  Exiting ScanJob.", new Object[0]);
            if (this.f10643c.m2355a() != null) {
                this.f10643c.m2355a().m2259r();
            }
            return false;
        } else if (this.f10643c.m2338d().size() <= 0 && this.f10643c.m2340c().m2394d().size() <= 0) {
            if (this.f10643c.m2355a() != null) {
                this.f10643c.m2355a().m2259r();
            }
            return false;
        } else {
            if (this.f10643c.m2355a() != null) {
                this.f10643c.m2355a().m2260p();
            }
            return true;
        }
    }

    /* renamed from: c */
    public final void m397c() {
        ScanState scanState = this.f10641a;
        if (scanState != null) {
            if (!scanState.m2312b().booleanValue()) {
                LogManager.m2432a(f10638f, "In foreground mode, schedule next scan", new Object[0]);
                ScanJobScheduler.m2319b().m2317c(this);
                return;
            }
            m395d();
        }
    }

    /* renamed from: d */
    public final void m395d() {
        if (this.f10641a != null) {
            LogManager.m2432a(f10638f, "Checking to see if we need to start a passive scan", new Object[0]);
            boolean z = false;
            for (Region region : new ArrayList(this.f10641a.m2306h().m2394d())) {
                RegionMonitoringState m2393d = this.f10641a.m2306h().m2393d(region);
                if (m2393d != null && m2393d.m2365b()) {
                    z = true;
                }
            }
            if (z) {
                LogManager.m2428c(f10638f, "We are inside a beacon region.  We will not scan between cycles.", new Object[0]);
            } else if (Build.VERSION.SDK_INT >= 26) {
                ScanHelper scanHelper = this.f10643c;
                if (scanHelper != null) {
                    scanHelper.m2341b(this.f10641a.m2310d());
                }
            } else {
                LogManager.m2432a(f10638f, "This is not Android O.  No scanning between cycles when using ScanJob", new Object[0]);
            }
        }
    }

    /* renamed from: e */
    public final boolean m393e() {
        BeaconManager m477a = BeaconManager.m477a(getApplicationContext());
        m477a.m459c(true);
        if (m477a.m434y()) {
            LogManager.m2428c(f10638f, "scanJob version %s is starting up on the main process", "2.16.3");
        } else {
            LogManager.m2428c(f10638f, "beaconScanJob library version %s is starting up on a separate process", "2.16.3");
            ProcessUtils processUtils = new ProcessUtils(this);
            String str = f10638f;
            LogManager.m2428c(str, "beaconScanJob PID is " + processUtils.m2236b() + " with process name " + processUtils.m2235c(), new Object[0]);
        }
        Beacon.m2509a(new ModelSpecificDistanceCalculator(this, BeaconManager.m484G()));
        return m400b();
    }

    /* renamed from: f */
    public final void m391f() {
        this.f10644d = false;
        ScanHelper scanHelper = this.f10643c;
        if (scanHelper != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                scanHelper.m2331h();
            }
            if (this.f10643c.m2355a() != null) {
                this.f10643c.m2355a().m2259r();
                this.f10643c.m2355a().m2269f();
            }
        }
        LogManager.m2432a(f10638f, "Scanning stopped", new Object[0]);
    }

    /* renamed from: a */
    public static int m403a(Context context) {
        if (f10639g >= 0) {
            String str = f10638f;
            LogManager.m2428c(str, "Using ImmediateScanJobId from static override: " + f10639g, new Object[0]);
            return f10639g;
        }
        return m402a(context, "immediateScanJobId");
    }

    /* renamed from: a */
    public static int m402a(Context context, String str) {
        ServiceInfo serviceInfo;
        Bundle bundle;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, ScanJob.class), Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfo = null;
        }
        if (serviceInfo != null && (bundle = ((PackageItemInfo) serviceInfo).metaData) != null && bundle.get(str) != null) {
            int i = ((PackageItemInfo) serviceInfo).metaData.getInt(str);
            String str2 = f10638f;
            LogManager.m2428c(str2, "Using " + str + " from manifest: " + i, new Object[0]);
            return i;
        }
        throw new RuntimeException("Cannot get job id from manifest.  Make sure that the " + str + " is configured in the manifest for the ScanJob.");
    }

    /* renamed from: b */
    public static int m399b(Context context) {
        if (f10639g >= 0) {
            String str = f10638f;
            LogManager.m2428c(str, "Using PeriodicScanJobId from static override: " + f10640h, new Object[0]);
            return f10640h;
        }
        return m402a(context, "periodicScanJobId");
    }
}
