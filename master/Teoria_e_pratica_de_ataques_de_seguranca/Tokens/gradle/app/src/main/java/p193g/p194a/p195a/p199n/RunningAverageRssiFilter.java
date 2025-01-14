package p193g.p194a.p195a.p199n;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.k */
/* loaded from: classes.dex */
public class RunningAverageRssiFilter implements RssiFilter {

    /* renamed from: b */
    public static long f8586b = 20000;

    /* renamed from: a */
    public ArrayList<C1838b> f8587a = new ArrayList<>();

    /* compiled from: RunningAverageRssiFilter.java */
    /* renamed from: g.a.a.n.k$b */
    /* loaded from: classes.dex */
    public class C1838b implements Comparable<C1838b> {

        /* renamed from: a */
        public Integer f8588a;

        /* renamed from: b */
        public long f8589b;

        public C1838b(RunningAverageRssiFilter runningAverageRssiFilter) {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C1838b c1838b) {
            return this.f8588a.compareTo(c1838b.f8588a);
        }
    }

    @Override // p193g.p194a.p195a.p199n.RssiFilter
    /* renamed from: a */
    public void mo2360a(Integer num) {
        C1838b c1838b = new C1838b();
        c1838b.f8588a = num;
        c1838b.f8589b = SystemClock.elapsedRealtime();
        this.f8587a.add(c1838b);
    }

    @Override // p193g.p194a.p195a.p199n.RssiFilter
    /* renamed from: b */
    public double mo2359b() {
        int i;
        m2357d();
        int size = this.f8587a.size();
        int i2 = size - 1;
        if (size > 2) {
            int i3 = size / 10;
            i = i3 + 1;
            i2 = (size - i3) - 2;
        } else {
            i = 0;
        }
        double d = 0.0d;
        for (int i4 = i; i4 <= i2; i4++) {
            d += this.f8587a.get(i4).f8588a.intValue();
        }
        double d2 = d / ((i2 - i) + 1);
        LogManager.m2432a("RunningAverageRssiFilter", "Running average mRssi based on %s measurements: %s", Integer.valueOf(size), Double.valueOf(d2));
        return d2;
    }

    @Override // p193g.p194a.p195a.p199n.RssiFilter
    /* renamed from: c */
    public int mo2358c() {
        return this.f8587a.size();
    }

    /* renamed from: d */
    public final synchronized void m2357d() {
        ArrayList<C1838b> arrayList = new ArrayList<>();
        Iterator<C1838b> it = this.f8587a.iterator();
        while (it.hasNext()) {
            C1838b next = it.next();
            if (SystemClock.elapsedRealtime() - next.f8589b < f8586b) {
                arrayList.add(next);
            }
        }
        this.f8587a = arrayList;
        Collections.sort(this.f8587a);
    }

    @Override // p193g.p194a.p195a.p199n.RssiFilter
    /* renamed from: a */
    public boolean mo2361a() {
        return this.f8587a.size() == 0;
    }
}
