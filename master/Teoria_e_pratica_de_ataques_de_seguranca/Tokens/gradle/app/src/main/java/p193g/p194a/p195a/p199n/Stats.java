package p193g.p194a.p195a.p199n;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.q */
/* loaded from: classes.dex */
public class Stats {

    /* renamed from: g */
    public static final Stats f8638g = new Stats();

    /* renamed from: h */
    public static final SimpleDateFormat f8639h = new SimpleDateFormat("HH:mm:ss.SSS");

    /* renamed from: a */
    public ArrayList<C1844a> f8640a;

    /* renamed from: b */
    public long f8641b = 0;

    /* renamed from: c */
    public boolean f8642c;

    /* renamed from: d */
    public boolean f8643d;

    /* renamed from: e */
    public boolean f8644e;

    /* renamed from: f */
    public C1844a f8645f;

    /* compiled from: Stats.java */
    /* renamed from: g.a.a.n.q$a */
    /* loaded from: classes.dex */
    public static class C1844a {

        /* renamed from: a */
        public long f8646a = 0;

        /* renamed from: b */
        public long f8647b;

        /* renamed from: c */
        public Date f8648c;

        /* renamed from: d */
        public Date f8649d;

        /* renamed from: e */
        public Date f8650e;

        /* renamed from: f */
        public Date f8651f;
    }

    public Stats() {
        m2290a();
    }

    /* renamed from: f */
    public static Stats m2282f() {
        return f8638g;
    }

    /* renamed from: a */
    public void m2289a(Beacon beacon) {
        m2283e();
        C1844a c1844a = this.f8645f;
        c1844a.f8646a++;
        if (c1844a.f8648c == null) {
            c1844a.f8648c = new Date();
        }
        if (this.f8645f.f8649d != null) {
            long time = new Date().getTime() - this.f8645f.f8649d.getTime();
            C1844a c1844a2 = this.f8645f;
            if (time > c1844a2.f8647b) {
                c1844a2.f8647b = time;
            }
        }
        this.f8645f.f8649d = new Date();
    }

    /* renamed from: b */
    public boolean m2286b() {
        return this.f8644e;
    }

    /* renamed from: c */
    public final void m2285c() {
        boolean z = true;
        LogManager.m2432a("Stats", "--- Stats for %s samples", Integer.valueOf(this.f8640a.size()));
        Iterator<C1844a> it = this.f8640a.iterator();
        while (it.hasNext()) {
            m2288a(it.next(), z);
            z = false;
        }
    }

    /* renamed from: d */
    public void m2284d() {
        Date date = new Date();
        C1844a c1844a = this.f8645f;
        if (c1844a != null) {
            date = new Date(c1844a.f8650e.getTime() + this.f8641b);
            C1844a c1844a2 = this.f8645f;
            c1844a2.f8651f = date;
            if (!this.f8643d && this.f8642c) {
                m2288a(c1844a2, true);
            }
        }
        this.f8645f = new C1844a();
        C1844a c1844a3 = this.f8645f;
        c1844a3.f8650e = date;
        this.f8640a.add(c1844a3);
        if (this.f8643d) {
            m2285c();
        }
    }

    /* renamed from: e */
    public final void m2283e() {
        if (this.f8645f == null || (this.f8641b > 0 && new Date().getTime() - this.f8645f.f8650e.getTime() >= this.f8641b)) {
            m2284d();
        }
    }

    /* renamed from: a */
    public void m2290a() {
        this.f8640a = new ArrayList<>();
        m2284d();
    }

    /* renamed from: a */
    public final void m2288a(C1844a c1844a, boolean z) {
        if (z) {
            LogManager.m2432a("Stats", "sample start time, sample stop time, first detection time, last detection time, max millis between detections, detection count", new Object[0]);
        }
        LogManager.m2432a("Stats", "%s, %s, %s, %s, %s, %s", m2287a(c1844a.f8650e), m2287a(c1844a.f8651f), m2287a(c1844a.f8648c), m2287a(c1844a.f8649d), Long.valueOf(c1844a.f8647b), Long.valueOf(c1844a.f8646a));
    }

    /* renamed from: a */
    public final String m2287a(Date date) {
        String format;
        if (date != null) {
            synchronized (f8639h) {
                format = f8639h.format(date);
            }
            return format;
        }
        return "";
    }
}
