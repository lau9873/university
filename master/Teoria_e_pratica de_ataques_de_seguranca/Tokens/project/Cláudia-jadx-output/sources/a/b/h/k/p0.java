package a.b.h.k;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class p0 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadLocal<p0> f1882e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    public static Comparator<c> f1883f = new a();

    /* renamed from: b  reason: collision with root package name */
    public long f1885b;

    /* renamed from: c  reason: collision with root package name */
    public long f1886c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<RecyclerView> f1884a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c> f1887d = new ArrayList<>();

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if ((cVar.f1895d == null) != (cVar2.f1895d == null)) {
                return cVar.f1895d == null ? 1 : -1;
            }
            boolean z = cVar.f1892a;
            if (z != cVar2.f1892a) {
                return z ? -1 : 1;
            }
            int i2 = cVar2.f1893b - cVar.f1893b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = cVar.f1894c - cVar2.f1894c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    }

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1892a;

        /* renamed from: b  reason: collision with root package name */
        public int f1893b;

        /* renamed from: c  reason: collision with root package name */
        public int f1894c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f1895d;

        /* renamed from: e  reason: collision with root package name */
        public int f1896e;

        public void a() {
            this.f1892a = false;
            this.f1893b = 0;
            this.f1894c = 0;
            this.f1895d = null;
            this.f1896e = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f1884a.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f1884a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.b.g.g.h.a("RV Prefetch");
            if (!this.f1884a.isEmpty()) {
                int size = this.f1884a.size();
                long j = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f1884a.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j) + this.f1886c);
                }
            }
        } finally {
            this.f1885b = 0L;
            a.b.g.g.h.a();
        }
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f1885b == 0) {
            this.f1885b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.h0.b(i2, i3);
    }

    public void b(long j) {
        a();
        a(j);
    }

    public final void a() {
        c cVar;
        int size = this.f1884a.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f1884a.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.h0.a(recyclerView, false);
                i2 += recyclerView.h0.f1891d;
            }
        }
        this.f1887d.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f1884a.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.h0;
                int abs = Math.abs(bVar.f1888a) + Math.abs(bVar.f1889b);
                int i6 = i4;
                for (int i7 = 0; i7 < bVar.f1891d * 2; i7 += 2) {
                    if (i6 >= this.f1887d.size()) {
                        cVar = new c();
                        this.f1887d.add(cVar);
                    } else {
                        cVar = this.f1887d.get(i6);
                    }
                    int i8 = bVar.f1890c[i7 + 1];
                    cVar.f1892a = i8 <= abs;
                    cVar.f1893b = abs;
                    cVar.f1894c = i8;
                    cVar.f1895d = recyclerView2;
                    cVar.f1896e = bVar.f1890c[i7];
                    i6++;
                }
                i4 = i6;
            }
        }
        Collections.sort(this.f1887d, f1883f);
    }

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        public int f1888a;

        /* renamed from: b  reason: collision with root package name */
        public int f1889b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f1890c;

        /* renamed from: d  reason: collision with root package name */
        public int f1891d;

        public void a(RecyclerView recyclerView, boolean z) {
            this.f1891d = 0;
            int[] iArr = this.f1890c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.n;
            if (recyclerView.m == null || oVar == null || !oVar.v()) {
                return;
            }
            if (z) {
                if (!recyclerView.f2555d.c()) {
                    oVar.a(recyclerView.m.a(), this);
                }
            } else if (!recyclerView.p()) {
                oVar.a(this.f1888a, this.f1889b, recyclerView.i0, this);
            }
            int i2 = this.f1891d;
            if (i2 > oVar.m) {
                oVar.m = i2;
                oVar.n = z;
                recyclerView.f2553b.j();
            }
        }

        public void b(int i2, int i3) {
            this.f1888a = i2;
            this.f1889b = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.o.c
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 >= 0) {
                int i4 = this.f1891d * 2;
                int[] iArr = this.f1890c;
                if (iArr == null) {
                    this.f1890c = new int[4];
                    Arrays.fill(this.f1890c, -1);
                } else if (i4 >= iArr.length) {
                    this.f1890c = new int[i4 * 2];
                    System.arraycopy(iArr, 0, this.f1890c, 0, iArr.length);
                }
                int[] iArr2 = this.f1890c;
                iArr2[i4] = i2;
                iArr2[i4 + 1] = i3;
                this.f1891d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        public boolean a(int i2) {
            if (this.f1890c != null) {
                int i3 = this.f1891d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f1890c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void a() {
            int[] iArr = this.f1890c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1891d = 0;
        }
    }

    public static boolean a(RecyclerView recyclerView, int i2) {
        int b2 = recyclerView.f2556e.b();
        for (int i3 = 0; i3 < b2; i3++) {
            RecyclerView.d0 m = RecyclerView.m(recyclerView.f2556e.e(i3));
            if (m.f2582c == i2 && !m.p()) {
                return true;
            }
        }
        return false;
    }

    public final RecyclerView.d0 a(RecyclerView recyclerView, int i2, long j) {
        if (a(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f2553b;
        try {
            recyclerView.A();
            RecyclerView.d0 a2 = vVar.a(i2, false, j);
            if (a2 != null) {
                if (a2.o() && !a2.p()) {
                    vVar.b(a2.f2580a);
                } else {
                    vVar.a(a2, false);
                }
            }
            return a2;
        } finally {
            recyclerView.a(false);
        }
    }

    public final void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.E && recyclerView.f2556e.b() != 0) {
            recyclerView.H();
        }
        b bVar = recyclerView.h0;
        bVar.a(recyclerView, true);
        if (bVar.f1891d != 0) {
            try {
                a.b.g.g.h.a("RV Nested Prefetch");
                recyclerView.i0.a(recyclerView.m);
                for (int i2 = 0; i2 < bVar.f1891d * 2; i2 += 2) {
                    a(recyclerView, bVar.f1890c[i2], j);
                }
            } finally {
                a.b.g.g.h.a();
            }
        }
    }

    public final void a(c cVar, long j) {
        RecyclerView.d0 a2 = a(cVar.f1895d, cVar.f1896e, cVar.f1892a ? Long.MAX_VALUE : j);
        if (a2 == null || a2.f2581b == null || !a2.o() || a2.p()) {
            return;
        }
        a(a2.f2581b.get(), j);
    }

    public final void a(long j) {
        for (int i2 = 0; i2 < this.f1887d.size(); i2++) {
            c cVar = this.f1887d.get(i2);
            if (cVar.f1895d == null) {
                return;
            }
            a(cVar, j);
            cVar.a();
        }
    }
}
