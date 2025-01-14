package g.a.a.n;

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
/* compiled from: ScanJobScheduler.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6144d = "m";

    /* renamed from: e  reason: collision with root package name */
    public static final Object f6145e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static volatile m f6146f;

    /* renamed from: a  reason: collision with root package name */
    public Long f6147a = 0L;

    /* renamed from: b  reason: collision with root package name */
    public List<ScanResult> f6148b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public g.a.a.e f6149c;

    public static m b() {
        m mVar = f6146f;
        if (mVar == null) {
            synchronized (f6145e) {
                mVar = f6146f;
                if (mVar == null) {
                    mVar = new m();
                    f6146f = mVar;
                }
            }
        }
        return mVar;
    }

    public List<ScanResult> a() {
        List<ScanResult> list = this.f6148b;
        this.f6148b = new ArrayList();
        return list;
    }

    public void c(Context context) {
        a(context, n.a(context), false);
    }

    public final void a(Context context, BeaconManager beaconManager, n nVar) {
        nVar.a(beaconManager);
        String str = f6144d;
        g.a.a.m.d.a(str, "Applying scan job settings with background mode " + nVar.b(), new Object[0]);
        a(context, nVar, false);
    }

    public void a(Context context, BeaconManager beaconManager) {
        g.a.a.m.d.a(f6144d, "Applying settings to ScanJob", new Object[0]);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        a(context, beaconManager, n.a(context));
    }

    public void b(Context context) {
        if (this.f6149c == null) {
            this.f6149c = new g.a.a.e(context);
        }
        this.f6149c.a();
    }

    public void a(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        jobScheduler.cancel(ScanJob.a(context));
        jobScheduler.cancel(ScanJob.b(context));
        g.a.a.e eVar = this.f6149c;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void a(Context context, List<ScanResult> list) {
        if (list != null) {
            this.f6148b.addAll(list);
        }
        synchronized (this) {
            if (System.currentTimeMillis() - this.f6147a.longValue() > 10000) {
                String str = f6144d;
                g.a.a.m.d.a(str, "scheduling an immediate scan job because last did " + (System.currentTimeMillis() - this.f6147a.longValue()) + "seconds ago.", new Object[0]);
                this.f6147a = Long.valueOf(System.currentTimeMillis());
                a(context, n.a(context), true);
                return;
            }
            g.a.a.m.d.a(f6144d, "Not scheduling an immediate scan job because we just did recently.", new Object[0]);
        }
    }

    public final void a(Context context, n nVar, boolean z) {
        long elapsedRealtime;
        b(context);
        long j = nVar.j() - nVar.k();
        if (z) {
            g.a.a.m.d.a(f6144d, "We just woke up in the background based on a new scan result.  Start scan job immediately.", new Object[0]);
            elapsedRealtime = 0;
        } else {
            elapsedRealtime = j > 0 ? SystemClock.elapsedRealtime() % nVar.j() : 0L;
            if (elapsedRealtime < 50) {
                elapsedRealtime = 50;
            }
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (nVar.h().d().size() + nVar.i().size() > 0) {
            if (!z && nVar.b().booleanValue()) {
                g.a.a.m.d.a(f6144d, "Not scheduling an immediate scan because we are in background mode.   Cancelling existing immediate ScanJob.", new Object[0]);
                jobScheduler.cancel(ScanJob.a(context));
            } else if (elapsedRealtime < nVar.j() - 50) {
                g.a.a.m.d.a(f6144d, "Scheduling immediate ScanJob to run in " + elapsedRealtime + " millis", new Object[0]);
                int schedule = jobScheduler.schedule(new JobInfo.Builder(ScanJob.a(context), new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle()).setMinimumLatency(elapsedRealtime).setOverrideDeadline(elapsedRealtime).build());
                if (schedule < 0) {
                    g.a.a.m.d.b(f6144d, "Failed to schedule scan job.  Beacons will not be detected. Error: " + schedule, new Object[0]);
                }
            } else {
                g.a.a.m.d.a(f6144d, "Not scheduling immediate scan, assuming periodic is about to run", new Object[0]);
            }
            JobInfo.Builder extras = new JobInfo.Builder(ScanJob.b(context), new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle());
            if (Build.VERSION.SDK_INT >= 24) {
                extras.setPeriodic(nVar.j(), 0L).build();
            } else {
                extras.setPeriodic(nVar.j()).build();
            }
            JobInfo build = extras.build();
            g.a.a.m.d.a(f6144d, "Scheduling ScanJob " + build + " to run every " + nVar.j() + " millis", new Object[0]);
            int schedule2 = jobScheduler.schedule(build);
            if (schedule2 < 0) {
                g.a.a.m.d.b(f6144d, "Failed to schedule scan job.  Beacons will not be detected. Error: " + schedule2, new Object[0]);
                return;
            }
            return;
        }
        g.a.a.m.d.a(f6144d, "We are not monitoring or ranging any regions.  We are going to cancel all scan jobs.", new Object[0]);
        jobScheduler.cancel(ScanJob.a(context));
        jobScheduler.cancel(ScanJob.b(context));
    }
}
