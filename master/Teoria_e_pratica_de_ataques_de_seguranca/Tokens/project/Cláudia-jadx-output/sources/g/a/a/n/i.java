package g.a.a.n;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
/* compiled from: RegionMonitoringState.java */
/* loaded from: classes.dex */
public class i implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6120d = i.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f6121a = false;

    /* renamed from: b  reason: collision with root package name */
    public long f6122b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final a f6123c;

    public i(a aVar) {
        this.f6123c = aVar;
    }

    public a a() {
        return this.f6123c;
    }

    public boolean b() {
        return this.f6121a;
    }

    public boolean c() {
        this.f6122b = SystemClock.elapsedRealtime();
        if (this.f6121a) {
            return false;
        }
        this.f6121a = true;
        return true;
    }

    public void d() {
        this.f6121a = false;
        this.f6122b = 0L;
    }

    public boolean e() {
        if (!this.f6121a || this.f6122b <= 0 || SystemClock.elapsedRealtime() - this.f6122b <= BeaconManager.H()) {
            return false;
        }
        g.a.a.m.d.a(f6120d, "We are newly outside the region because the lastSeenTime of %s was %s seconds ago, and that is over the expiration duration of %s", Long.valueOf(this.f6122b), Long.valueOf(SystemClock.elapsedRealtime() - this.f6122b), Long.valueOf(BeaconManager.H()));
        d();
        return true;
    }
}
