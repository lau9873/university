package p193g.p194a.p195a.p199n;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.i */
/* loaded from: classes.dex */
public class RegionMonitoringState implements Serializable {

    /* renamed from: d */
    public static final String f8582d = RegionMonitoringState.class.getSimpleName();

    /* renamed from: a */
    public boolean f8583a = false;

    /* renamed from: b */
    public long f8584b = 0;

    /* renamed from: c */
    public final C1836a f8585c;

    public RegionMonitoringState(C1836a c1836a) {
        this.f8585c = c1836a;
    }

    /* renamed from: a */
    public C1836a m2366a() {
        return this.f8585c;
    }

    /* renamed from: b */
    public boolean m2365b() {
        return this.f8583a;
    }

    /* renamed from: c */
    public boolean m2364c() {
        this.f8584b = SystemClock.elapsedRealtime();
        if (this.f8583a) {
            return false;
        }
        this.f8583a = true;
        return true;
    }

    /* renamed from: d */
    public void m2363d() {
        this.f8583a = false;
        this.f8584b = 0L;
    }

    /* renamed from: e */
    public boolean m2362e() {
        if (!this.f8583a || this.f8584b <= 0 || SystemClock.elapsedRealtime() - this.f8584b <= BeaconManager.m483H()) {
            return false;
        }
        LogManager.m2432a(f8582d, "We are newly outside the region because the lastSeenTime of %s was %s seconds ago, and that is over the expiration duration of %s", Long.valueOf(this.f8584b), Long.valueOf(SystemClock.elapsedRealtime() - this.f8584b), Long.valueOf(BeaconManager.m483H()));
        m2363d();
        return true;
    }
}
