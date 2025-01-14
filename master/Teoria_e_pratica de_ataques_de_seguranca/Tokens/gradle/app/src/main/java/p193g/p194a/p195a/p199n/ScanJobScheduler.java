package p193g.p194a.p195a.p199n;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.bluetooth.le.ScanResult;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.service.ScanJob;
import p193g.p194a.p195a.BeaconLocalBroadcastProcessor;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.m */
/* loaded from: classes.dex */
public class ScanJobScheduler {

    /* renamed from: d */
    public static final String f8608d = "m";

    /* renamed from: e */
    public static final Object f8609e = new Object();

    /* renamed from: f */
    public static volatile ScanJobScheduler f8610f;

    /* renamed from: a */
    public Long f8611a = 0L;

    /* renamed from: b */
    public List<ScanResult> f8612b = new ArrayList();

    /* renamed from: c */
    public BeaconLocalBroadcastProcessor f8613c;

    /* renamed from: b */
    public static ScanJobScheduler m2319b() {
        ScanJobScheduler scanJobScheduler = f8610f;
        if (scanJobScheduler == null) {
            synchronized (f8609e) {
                scanJobScheduler = f8610f;
                if (scanJobScheduler == null) {
                    scanJobScheduler = new ScanJobScheduler();
                    f8610f = scanJobScheduler;
                }
            }
        }
        return scanJobScheduler;
    }

    /* renamed from: a */
    public List<ScanResult> m2325a() {
        List<ScanResult> list = this.f8612b;
        this.f8612b = new ArrayList();
        return list;
    }

    /* renamed from: c */
    public void m2317c(Context context) {
        m2323a(context, ScanState.m2314a(context), false);
    }

    /* renamed from: a */
    public final void m2320a(Context context, BeaconManager beaconManager, ScanState scanState) {
        scanState.m2313a(beaconManager);
        String str = f8608d;
        LogManager.m2432a(str, "Applying scan job settings with background mode " + scanState.m2312b(), new Object[0]);
        m2323a(context, scanState, false);
    }

    /* renamed from: a */
    public void m2321a(Context context, BeaconManager beaconManager) {
        LogManager.m2432a(f8608d, "Applying settings to ScanJob", new Object[0]);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        m2320a(context, beaconManager, ScanState.m2314a(context));
    }

    /* renamed from: b */
    public void m2318b(Context context) {
        if (this.f8613c == null) {
            this.f8613c = new BeaconLocalBroadcastProcessor(context);
        }
        this.f8613c.m2488a();
    }

    /* renamed from: a */
    public void m2324a(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        jobScheduler.cancel(ScanJob.m403a(context));
        jobScheduler.cancel(ScanJob.m399b(context));
        BeaconLocalBroadcastProcessor beaconLocalBroadcastProcessor = this.f8613c;
        if (beaconLocalBroadcastProcessor != null) {
            beaconLocalBroadcastProcessor.m2487b();
        }
    }

    /* renamed from: a */
    public void m2322a(Context context, List<ScanResult> list) {
        if (list != null) {
            this.f8612b.addAll(list);
        }
        synchronized (this) {
            if (System.currentTimeMillis() - this.f8611a.longValue() > 10000) {
                String str = f8608d;
                LogManager.m2432a(str, "scheduling an immediate scan job because last did " + (System.currentTimeMillis() - this.f8611a.longValue()) + "seconds ago.", new Object[0]);
                this.f8611a = Long.valueOf(System.currentTimeMillis());
                m2323a(context, ScanState.m2314a(context), true);
                return;
            }
            LogManager.m2432a(f8608d, "Not scheduling an immediate scan job because we just did recently.", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m2323a(Context context, ScanState scanState, boolean z) {
        long elapsedRealtime;
        m2318b(context);
        long m2304j = scanState.m2304j() - scanState.m2303k();
        if (z) {
            LogManager.m2432a(f8608d, "We just woke up in the background based on a new scan result.  Start scan job immediately.", new Object[0]);
            elapsedRealtime = 0;
        } else {
            elapsedRealtime = m2304j > 0 ? SystemClock.elapsedRealtime() % scanState.m2304j() : 0L;
            if (elapsedRealtime < 50) {
                elapsedRealtime = 50;
            }
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (scanState.m2306h().m2394d().size() + scanState.m2305i().size() > 0) {
            if (!z && scanState.m2312b().booleanValue()) {
                LogManager.m2432a(f8608d, "Not scheduling an immediate scan because we are in background mode.   Cancelling existing immediate ScanJob.", new Object[0]);
                jobScheduler.cancel(ScanJob.m403a(context));
            } else if (elapsedRealtime < scanState.m2304j() - 50) {
                LogManager.m2432a(f8608d, "Scheduling immediate ScanJob to run in " + elapsedRealtime + " millis", new Object[0]);
                int schedule = jobScheduler.schedule(new JobInfo.Builder(ScanJob.m403a(context), new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle()).setMinimumLatency(elapsedRealtime).setOverrideDeadline(elapsedRealtime).build());
                if (schedule < 0) {
                    LogManager.m2430b(f8608d, "Failed to schedule scan job.  Beacons will not be detected. Error: " + schedule, new Object[0]);
                }
            } else {
                LogManager.m2432a(f8608d, "Not scheduling immediate scan, assuming periodic is about to run", new Object[0]);
            }
            JobInfo.Builder extras = new JobInfo.Builder(ScanJob.m399b(context), new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle());
            if (Build.VERSION.SDK_INT >= 24) {
                extras.setPeriodic(scanState.m2304j(), 0L).build();
            } else {
                extras.setPeriodic(scanState.m2304j()).build();
            }
            JobInfo build = extras.build();
            LogManager.m2432a(f8608d, "Scheduling ScanJob " + build + " to run every " + scanState.m2304j() + " millis", new Object[0]);
            int schedule2 = jobScheduler.schedule(build);
            if (schedule2 < 0) {
                LogManager.m2430b(f8608d, "Failed to schedule scan job.  Beacons will not be detected. Error: " + schedule2, new Object[0]);
                return;
            }
            return;
        }
        LogManager.m2432a(f8608d, "We are not monitoring or ranging any regions.  We are going to cancel all scan jobs.", new Object[0]);
        jobScheduler.cancel(ScanJob.m403a(context));
        jobScheduler.cancel(ScanJob.m399b(context));
    }
}
