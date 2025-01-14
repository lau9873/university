package p193g.p194a.p195a.p199n;

import android.os.SystemClock;

/* renamed from: g.a.a.n.b */
/* loaded from: classes.dex */
public class DetectionTracker {

    /* renamed from: b */
    public static final DetectionTracker f8559b = new DetectionTracker();

    /* renamed from: a */
    public long f8560a = 0;

    /* renamed from: c */
    public static DetectionTracker m2416c() {
        return f8559b;
    }

    /* renamed from: a */
    public long m2418a() {
        return this.f8560a;
    }

    /* renamed from: b */
    public void m2417b() {
        this.f8560a = SystemClock.elapsedRealtime();
    }
}
