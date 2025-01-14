package a.b.h.k;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f1726a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1727b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f1728c = new ArrayList();

    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        View a(int i2);

        void a(View view);

        void a(View view, int i2);

        void a(View view, int i2, ViewGroup.LayoutParams layoutParams);

        RecyclerView.d0 b(View view);

        void b();

        void b(int i2);

        void c(int i2);

        void c(View view);

        int d(View view);
    }

    public g0(b bVar) {
        this.f1726a = bVar;
    }

    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    public final void b(View view) {
        this.f1728c.add(view);
        this.f1726a.a(view);
    }

    public View c(int i2) {
        return this.f1726a.a(d(i2));
    }

    public final int d(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int a2 = this.f1726a.a();
        int i3 = i2;
        while (i3 < a2) {
            int b2 = i2 - (i3 - this.f1727b.b(i3));
            if (b2 == 0) {
                while (this.f1727b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    public void e(View view) {
        int d2 = this.f1726a.d(view);
        if (d2 < 0) {
            return;
        }
        if (this.f1727b.d(d2)) {
            h(view);
        }
        this.f1726a.c(d2);
    }

    public void f(int i2) {
        int d2 = d(i2);
        View a2 = this.f1726a.a(d2);
        if (a2 == null) {
            return;
        }
        if (this.f1727b.d(d2)) {
            h(a2);
        }
        this.f1726a.c(d2);
    }

    public void g(View view) {
        int d2 = this.f1726a.d(view);
        if (d2 >= 0) {
            if (this.f1727b.c(d2)) {
                this.f1727b.a(d2);
                h(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final boolean h(View view) {
        if (this.f1728c.remove(view)) {
            this.f1726a.c(view);
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f1727b.toString() + ", hidden list:" + this.f1728c.size();
    }

    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f1729a = 0;

        /* renamed from: b  reason: collision with root package name */
        public a f1730b;

        public final void a() {
            if (this.f1730b == null) {
                this.f1730b = new a();
            }
        }

        public void b() {
            this.f1729a = 0L;
            a aVar = this.f1730b;
            if (aVar != null) {
                aVar.b();
            }
        }

        public boolean c(int i2) {
            if (i2 < 64) {
                return (this.f1729a & (1 << i2)) != 0;
            }
            a();
            return this.f1730b.c(i2 - 64);
        }

        public boolean d(int i2) {
            if (i2 >= 64) {
                a();
                return this.f1730b.d(i2 - 64);
            }
            long j = 1 << i2;
            boolean z = (this.f1729a & j) != 0;
            this.f1729a &= ~j;
            long j2 = j - 1;
            long j3 = this.f1729a;
            this.f1729a = Long.rotateRight(j3 & (~j2), 1) | (j3 & j2);
            a aVar = this.f1730b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f1730b.d(0);
            }
            return z;
        }

        public void e(int i2) {
            if (i2 >= 64) {
                a();
                this.f1730b.e(i2 - 64);
                return;
            }
            this.f1729a |= 1 << i2;
        }

        public String toString() {
            if (this.f1730b == null) {
                return Long.toBinaryString(this.f1729a);
            }
            return this.f1730b.toString() + "xx" + Long.toBinaryString(this.f1729a);
        }

        public void a(int i2) {
            if (i2 >= 64) {
                a aVar = this.f1730b;
                if (aVar != null) {
                    aVar.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f1729a &= ~(1 << i2);
        }

        public int b(int i2) {
            a aVar = this.f1730b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f1729a);
                }
                return Long.bitCount(this.f1729a & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.f1729a & ((1 << i2) - 1));
            } else {
                return aVar.b(i2 - 64) + Long.bitCount(this.f1729a);
            }
        }

        public void a(int i2, boolean z) {
            if (i2 >= 64) {
                a();
                this.f1730b.a(i2 - 64, z);
                return;
            }
            boolean z2 = (this.f1729a & Long.MIN_VALUE) != 0;
            long j = (1 << i2) - 1;
            long j2 = this.f1729a;
            this.f1729a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                e(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f1730b != null) {
                a();
                this.f1730b.a(0, z2);
            }
        }
    }

    public void a(View view, int i2, boolean z) {
        int d2;
        if (i2 < 0) {
            d2 = this.f1726a.a();
        } else {
            d2 = d(i2);
        }
        this.f1727b.a(d2, z);
        if (z) {
            b(view);
        }
        this.f1726a.a(view, d2);
    }

    public View b(int i2) {
        int size = this.f1728c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f1728c.get(i3);
            RecyclerView.d0 b2 = this.f1726a.b(view);
            if (b2.k() == i2 && !b2.p() && !b2.r()) {
                return view;
            }
        }
        return null;
    }

    public void c() {
        this.f1727b.b();
        for (int size = this.f1728c.size() - 1; size >= 0; size--) {
            this.f1726a.c(this.f1728c.get(size));
            this.f1728c.remove(size);
        }
        this.f1726a.b();
    }

    public boolean d(View view) {
        return this.f1728c.contains(view);
    }

    public View e(int i2) {
        return this.f1726a.a(i2);
    }

    public boolean f(View view) {
        int d2 = this.f1726a.d(view);
        if (d2 == -1) {
            h(view);
            return true;
        } else if (this.f1727b.c(d2)) {
            this.f1727b.d(d2);
            h(view);
            this.f1726a.c(d2);
            return true;
        } else {
            return false;
        }
    }

    public void a(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int d2;
        if (i2 < 0) {
            d2 = this.f1726a.a();
        } else {
            d2 = d(i2);
        }
        this.f1727b.a(d2, z);
        if (z) {
            b(view);
        }
        this.f1726a.a(view, d2, layoutParams);
    }

    public int c(View view) {
        int d2 = this.f1726a.d(view);
        if (d2 == -1 || this.f1727b.c(d2)) {
            return -1;
        }
        return d2 - this.f1727b.b(d2);
    }

    public int b() {
        return this.f1726a.a();
    }

    public int a() {
        return this.f1726a.a() - this.f1728c.size();
    }

    public void a(int i2) {
        int d2 = d(i2);
        this.f1727b.d(d2);
        this.f1726a.b(d2);
    }

    public void a(View view) {
        int d2 = this.f1726a.d(view);
        if (d2 >= 0) {
            this.f1727b.e(d2);
            b(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }
}
