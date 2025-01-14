package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import p000a.p006b.p030g.p041g.TraceCompat;

/* renamed from: a.b.h.k.p0 */
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {

    /* renamed from: e */
    public static final ThreadLocal<GapWorker> f2846e = new ThreadLocal<>();

    /* renamed from: f */
    public static Comparator<C0491c> f2847f = new C0489a();

    /* renamed from: b */
    public long f2849b;

    /* renamed from: c */
    public long f2850c;

    /* renamed from: a */
    public ArrayList<RecyclerView> f2848a = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<C0491c> f2851d = new ArrayList<>();

    /* compiled from: GapWorker.java */
    /* renamed from: a.b.h.k.p0$a */
    /* loaded from: classes.dex */
    public static class C0489a implements Comparator<C0491c> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C0491c c0491c, C0491c c0491c2) {
            if ((c0491c.f2859d == null) != (c0491c2.f2859d == null)) {
                return c0491c.f2859d == null ? 1 : -1;
            }
            boolean z = c0491c.f2856a;
            if (z != c0491c2.f2856a) {
                return z ? -1 : 1;
            }
            int i = c0491c2.f2857b - c0491c.f2857b;
            if (i != 0) {
                return i;
            }
            int i2 = c0491c.f2858c - c0491c2.f2858c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* compiled from: GapWorker.java */
    /* renamed from: a.b.h.k.p0$c */
    /* loaded from: classes.dex */
    public static class C0491c {

        /* renamed from: a */
        public boolean f2856a;

        /* renamed from: b */
        public int f2857b;

        /* renamed from: c */
        public int f2858c;

        /* renamed from: d */
        public RecyclerView f2859d;

        /* renamed from: e */
        public int f2860e;

        /* renamed from: a */
        public void m8139a() {
            this.f2856a = false;
            this.f2857b = 0;
            this.f2858c = 0;
            this.f2859d = null;
            this.f2860e = 0;
        }
    }

    /* renamed from: a */
    public void m8151a(RecyclerView recyclerView) {
        this.f2848a.add(recyclerView);
    }

    /* renamed from: b */
    public void m8145b(RecyclerView recyclerView) {
        this.f2848a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.m9736a("RV Prefetch");
            if (!this.f2848a.isEmpty()) {
                int size = this.f2848a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f2848a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    m8146b(TimeUnit.MILLISECONDS.toNanos(j) + this.f2850c);
                }
            }
        } finally {
            this.f2849b = 0L;
            TraceCompat.m9737a();
        }
    }

    /* renamed from: a */
    public void m8149a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2849b == 0) {
            this.f2849b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f4149h0.m8140b(i, i2);
    }

    /* renamed from: b */
    public void m8146b(long j) {
        m8154a();
        m8153a(j);
    }

    /* renamed from: a */
    public final void m8154a() {
        C0491c c0491c;
        int size = this.f2848a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f2848a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f4149h0.m8141a(recyclerView, false);
                i += recyclerView.f4149h0.f2855d;
            }
        }
        this.f2851d.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f2848a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                C0490b c0490b = recyclerView2.f4149h0;
                int abs = Math.abs(c0490b.f2852a) + Math.abs(c0490b.f2853b);
                int i5 = i3;
                for (int i6 = 0; i6 < c0490b.f2855d * 2; i6 += 2) {
                    if (i5 >= this.f2851d.size()) {
                        c0491c = new C0491c();
                        this.f2851d.add(c0491c);
                    } else {
                        c0491c = this.f2851d.get(i5);
                    }
                    int i7 = c0490b.f2854c[i6 + 1];
                    c0491c.f2856a = i7 <= abs;
                    c0491c.f2857b = abs;
                    c0491c.f2858c = i7;
                    c0491c.f2859d = recyclerView2;
                    c0491c.f2860e = c0490b.f2854c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f2851d, f2847f);
    }

    /* compiled from: GapWorker.java */
    /* renamed from: a.b.h.k.p0$b */
    /* loaded from: classes.dex */
    public static class C0490b implements RecyclerView.AbstractC0722o.InterfaceC0725c {

        /* renamed from: a */
        public int f2852a;

        /* renamed from: b */
        public int f2853b;

        /* renamed from: c */
        public int[] f2854c;

        /* renamed from: d */
        public int f2855d;

        /* renamed from: a */
        public void m8141a(RecyclerView recyclerView, boolean z) {
            this.f2855d = 0;
            int[] iArr = this.f2854c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.AbstractC0722o abstractC0722o = recyclerView.f4159n;
            if (recyclerView.f4157m == null || abstractC0722o == null || !abstractC0722o.m6614v()) {
                return;
            }
            if (z) {
                if (!recyclerView.f4140d.m8467c()) {
                    abstractC0722o.mo6702a(recyclerView.f4157m.mo747a(), this);
                }
            } else if (!recyclerView.m6857p()) {
                abstractC0722o.mo6464a(this.f2852a, this.f2853b, recyclerView.f4151i0, this);
            }
            int i = this.f2855d;
            if (i > abstractC0722o.f4256m) {
                abstractC0722o.f4256m = i;
                abstractC0722o.f4257n = z;
                recyclerView.f4136b.m6544j();
            }
        }

        /* renamed from: b */
        public void m8140b(int i, int i2) {
            this.f2852a = i;
            this.f2853b = i2;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o.InterfaceC0725c
        /* renamed from: a */
        public void mo6605a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 >= 0) {
                int i3 = this.f2855d * 2;
                int[] iArr = this.f2854c;
                if (iArr == null) {
                    this.f2854c = new int[4];
                    Arrays.fill(this.f2854c, -1);
                } else if (i3 >= iArr.length) {
                    this.f2854c = new int[i3 * 2];
                    System.arraycopy(iArr, 0, this.f2854c, 0, iArr.length);
                }
                int[] iArr2 = this.f2854c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.f2855d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        /* renamed from: a */
        public boolean m8142a(int i) {
            if (this.f2854c != null) {
                int i2 = this.f2855d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2854c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: a */
        public void m8143a() {
            int[] iArr = this.f2854c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2855d = 0;
        }
    }

    /* renamed from: a */
    public static boolean m8150a(RecyclerView recyclerView, int i) {
        int m8370b = recyclerView.f4142e.m8370b();
        for (int i2 = 0; i2 < m8370b; i2++) {
            RecyclerView.AbstractC0708d0 m6860m = RecyclerView.m6860m(recyclerView.f4142e.m8362e(i2));
            if (m6860m.f4215c == i && !m6860m.m6799p()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final RecyclerView.AbstractC0708d0 m8148a(RecyclerView recyclerView, int i, long j) {
        if (m8150a(recyclerView, i)) {
            return null;
        }
        RecyclerView.C0734v c0734v = recyclerView.f4136b;
        try {
            recyclerView.m6969A();
            RecyclerView.AbstractC0708d0 m6577a = c0734v.m6577a(i, false, j);
            if (m6577a != null) {
                if (m6577a.m6800o() && !m6577a.m6799p()) {
                    c0734v.m6562b(m6577a.f4213a);
                } else {
                    c0734v.m6572a(m6577a, false);
                }
            }
            return m6577a;
        } finally {
            recyclerView.m6914a(false);
        }
    }

    /* renamed from: a */
    public final void m8147a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f4115E && recyclerView.f4142e.m8370b() != 0) {
            recyclerView.m6962H();
        }
        C0490b c0490b = recyclerView.f4149h0;
        c0490b.m8141a(recyclerView, true);
        if (c0490b.f2855d != 0) {
            try {
                TraceCompat.m9736a("RV Nested Prefetch");
                recyclerView.f4151i0.m6844a(recyclerView.f4157m);
                for (int i = 0; i < c0490b.f2855d * 2; i += 2) {
                    m8148a(recyclerView, c0490b.f2854c[i], j);
                }
            } finally {
                TraceCompat.m9737a();
            }
        }
    }

    /* renamed from: a */
    public final void m8152a(C0491c c0491c, long j) {
        RecyclerView.AbstractC0708d0 m8148a = m8148a(c0491c.f2859d, c0491c.f2860e, c0491c.f2856a ? Long.MAX_VALUE : j);
        if (m8148a == null || m8148a.f4214b == null || !m8148a.m6800o() || m8148a.m6799p()) {
            return;
        }
        m8147a(m8148a.f4214b.get(), j);
    }

    /* renamed from: a */
    public final void m8153a(long j) {
        for (int i = 0; i < this.f2851d.size(); i++) {
            C0491c c0491c = this.f2851d.get(i);
            if (c0491c.f2859d == null) {
                return;
            }
            m8152a(c0491c, j);
            c0491c.m8139a();
        }
    }
}
