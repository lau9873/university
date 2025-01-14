package g.a.a.n;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
/* compiled from: RangedBeacon.java */
/* loaded from: classes.dex */
public class g implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static long f6112f = 5000;

    /* renamed from: c  reason: collision with root package name */
    public g.a.a.c f6115c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6113a = true;

    /* renamed from: b  reason: collision with root package name */
    public long f6114b = 0;

    /* renamed from: d  reason: collision with root package name */
    public transient j f6116d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f6117e = 0;

    public g(g.a.a.c cVar) {
        a(cVar);
    }

    public void a(g.a.a.c cVar) {
        this.f6117e++;
        this.f6115c = cVar;
        a(Integer.valueOf(this.f6115c.i()));
    }

    public g.a.a.c b() {
        return this.f6115c;
    }

    public final j c() {
        if (this.f6116d == null) {
            try {
                this.f6116d = (j) BeaconManager.I().getConstructors()[0].newInstance(new Object[0]);
            } catch (Exception unused) {
                g.a.a.m.d.b("RangedBeacon", "Could not construct RssiFilterImplClass %s", BeaconManager.I().getName());
            }
        }
        return this.f6116d;
    }

    public long d() {
        return SystemClock.elapsedRealtime() - this.f6114b;
    }

    public boolean e() {
        return d() > f6112f;
    }

    public boolean f() {
        return this.f6113a;
    }

    public boolean g() {
        return c().a();
    }

    public void a(boolean z) {
        this.f6113a = z;
    }

    public void a() {
        if (!c().a()) {
            double b2 = c().b();
            this.f6115c.a(b2);
            this.f6115c.d(c().c());
            g.a.a.m.d.a("RangedBeacon", "calculated new runningAverageRssi: %s", Double.valueOf(b2));
        } else {
            g.a.a.m.d.a("RangedBeacon", "No measurements available to calculate running average", new Object[0]);
        }
        this.f6115c.b(this.f6117e);
        this.f6117e = 0;
    }

    public void a(Integer num) {
        if (num.intValue() != 127) {
            this.f6113a = true;
            this.f6114b = SystemClock.elapsedRealtime();
            c().a(num);
        }
    }
}
