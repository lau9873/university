package g.a.a.n;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* compiled from: RunningAverageRssiFilter.java */
/* loaded from: classes.dex */
public class k implements j {

    /* renamed from: b  reason: collision with root package name */
    public static long f6124b = 20000;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f6125a = new ArrayList<>();

    /* compiled from: RunningAverageRssiFilter.java */
    /* loaded from: classes.dex */
    public class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public Integer f6126a;

        /* renamed from: b  reason: collision with root package name */
        public long f6127b;

        public b(k kVar) {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            return this.f6126a.compareTo(bVar.f6126a);
        }
    }

    @Override // g.a.a.n.j
    public void a(Integer num) {
        b bVar = new b();
        bVar.f6126a = num;
        bVar.f6127b = SystemClock.elapsedRealtime();
        this.f6125a.add(bVar);
    }

    @Override // g.a.a.n.j
    public double b() {
        int i2;
        d();
        int size = this.f6125a.size();
        int i3 = size - 1;
        if (size > 2) {
            int i4 = size / 10;
            i2 = i4 + 1;
            i3 = (size - i4) - 2;
        } else {
            i2 = 0;
        }
        double d2 = 0.0d;
        for (int i5 = i2; i5 <= i3; i5++) {
            d2 += this.f6125a.get(i5).f6126a.intValue();
        }
        double d3 = d2 / ((i3 - i2) + 1);
        g.a.a.m.d.a("RunningAverageRssiFilter", "Running average mRssi based on %s measurements: %s", Integer.valueOf(size), Double.valueOf(d3));
        return d3;
    }

    @Override // g.a.a.n.j
    public int c() {
        return this.f6125a.size();
    }

    public final synchronized void d() {
        ArrayList<b> arrayList = new ArrayList<>();
        Iterator<b> it = this.f6125a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (SystemClock.elapsedRealtime() - next.f6127b < f6124b) {
                arrayList.add(next);
            }
        }
        this.f6125a = arrayList;
        Collections.sort(this.f6125a);
    }

    @Override // g.a.a.n.j
    public boolean a() {
        return this.f6125a.size() == 0;
    }
}
