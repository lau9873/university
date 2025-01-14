package p193g.p194a.p195a.p199n;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.g */
/* loaded from: classes.dex */
public class RangedBeacon implements Serializable {

    /* renamed from: f */
    public static long f8574f = 5000;

    /* renamed from: c */
    public Beacon f8577c;

    /* renamed from: a */
    public boolean f8575a = true;

    /* renamed from: b */
    public long f8576b = 0;

    /* renamed from: d */
    public transient RssiFilter f8578d = null;

    /* renamed from: e */
    public int f8579e = 0;

    public RangedBeacon(Beacon beacon) {
        m2379a(beacon);
    }

    /* renamed from: a */
    public void m2379a(Beacon beacon) {
        this.f8579e++;
        this.f8577c = beacon;
        m2378a(Integer.valueOf(this.f8577c.m2496i()));
    }

    /* renamed from: b */
    public Beacon m2376b() {
        return this.f8577c;
    }

    /* renamed from: c */
    public final RssiFilter m2375c() {
        if (this.f8578d == null) {
            try {
                this.f8578d = (RssiFilter) BeaconManager.m482I().getConstructors()[0].newInstance(new Object[0]);
            } catch (Exception unused) {
                LogManager.m2430b("RangedBeacon", "Could not construct RssiFilterImplClass %s", BeaconManager.m482I().getName());
            }
        }
        return this.f8578d;
    }

    /* renamed from: d */
    public long m2374d() {
        return SystemClock.elapsedRealtime() - this.f8576b;
    }

    /* renamed from: e */
    public boolean m2373e() {
        return m2374d() > f8574f;
    }

    /* renamed from: f */
    public boolean m2372f() {
        return this.f8575a;
    }

    /* renamed from: g */
    public boolean m2371g() {
        return m2375c().mo2361a();
    }

    /* renamed from: a */
    public void m2377a(boolean z) {
        this.f8575a = z;
    }

    /* renamed from: a */
    public void m2380a() {
        if (!m2375c().mo2361a()) {
            double mo2359b = m2375c().mo2359b();
            this.f8577c.m2512a(mo2359b);
            this.f8577c.m2501d(m2375c().mo2358c());
            LogManager.m2432a("RangedBeacon", "calculated new runningAverageRssi: %s", Double.valueOf(mo2359b));
        } else {
            LogManager.m2432a("RangedBeacon", "No measurements available to calculate running average", new Object[0]);
        }
        this.f8577c.m2505b(this.f8579e);
        this.f8579e = 0;
    }

    /* renamed from: a */
    public void m2378a(Integer num) {
        if (num.intValue() != 127) {
            this.f8575a = true;
            this.f8576b = SystemClock.elapsedRealtime();
            m2375c().mo2360a(num);
        }
    }
}
