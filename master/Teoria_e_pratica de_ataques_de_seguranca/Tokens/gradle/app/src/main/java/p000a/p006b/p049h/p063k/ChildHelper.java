package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a.b.h.k.g0 */
/* loaded from: classes.dex */
public class ChildHelper {

    /* renamed from: a */
    public final InterfaceC0459b f2637a;

    /* renamed from: b */
    public final C0458a f2638b = new C0458a();

    /* renamed from: c */
    public final List<View> f2639c = new ArrayList();

    /* compiled from: ChildHelper.java */
    /* renamed from: a.b.h.k.g0$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0459b {
        /* renamed from: a */
        int mo6788a();

        /* renamed from: a */
        View mo6787a(int i);

        /* renamed from: a */
        void mo6786a(View view);

        /* renamed from: a */
        void mo6785a(View view, int i);

        /* renamed from: a */
        void mo6784a(View view, int i, ViewGroup.LayoutParams layoutParams);

        /* renamed from: b */
        RecyclerView.AbstractC0708d0 mo6781b(View view);

        /* renamed from: b */
        void mo6783b();

        /* renamed from: b */
        void mo6782b(int i);

        /* renamed from: c */
        void mo6780c(int i);

        /* renamed from: c */
        void mo6779c(View view);

        /* renamed from: d */
        int mo6778d(View view);
    }

    public ChildHelper(InterfaceC0459b interfaceC0459b) {
        this.f2637a = interfaceC0459b;
    }

    /* renamed from: a */
    public void m8371a(View view, boolean z) {
        m8372a(view, -1, z);
    }

    /* renamed from: b */
    public final void m8368b(View view) {
        this.f2639c.add(view);
        this.f2637a.mo6786a(view);
    }

    /* renamed from: c */
    public View m8366c(int i) {
        return this.f2637a.mo6787a(m8364d(i));
    }

    /* renamed from: d */
    public final int m8364d(int i) {
        if (i < 0) {
            return -1;
        }
        int mo6788a = this.f2637a.mo6788a();
        int i2 = i;
        while (i2 < mo6788a) {
            int m8352b = i - (i2 - this.f2638b.m8352b(i2));
            if (m8352b == 0) {
                while (this.f2638b.m8351c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += m8352b;
        }
        return -1;
    }

    /* renamed from: e */
    public void m8361e(View view) {
        int mo6778d = this.f2637a.mo6778d(view);
        if (mo6778d < 0) {
            return;
        }
        if (this.f2638b.m8350d(mo6778d)) {
            m8357h(view);
        }
        this.f2637a.mo6780c(mo6778d);
    }

    /* renamed from: f */
    public void m8360f(int i) {
        int m8364d = m8364d(i);
        View mo6787a = this.f2637a.mo6787a(m8364d);
        if (mo6787a == null) {
            return;
        }
        if (this.f2638b.m8350d(m8364d)) {
            m8357h(mo6787a);
        }
        this.f2637a.mo6780c(m8364d);
    }

    /* renamed from: g */
    public void m8358g(View view) {
        int mo6778d = this.f2637a.mo6778d(view);
        if (mo6778d >= 0) {
            if (this.f2638b.m8351c(mo6778d)) {
                this.f2638b.m8355a(mo6778d);
                m8357h(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* renamed from: h */
    public final boolean m8357h(View view) {
        if (this.f2639c.remove(view)) {
            this.f2637a.mo6779c(view);
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f2638b.toString() + ", hidden list:" + this.f2639c.size();
    }

    /* compiled from: ChildHelper.java */
    /* renamed from: a.b.h.k.g0$a */
    /* loaded from: classes.dex */
    public static class C0458a {

        /* renamed from: a */
        public long f2640a = 0;

        /* renamed from: b */
        public C0458a f2641b;

        /* renamed from: a */
        public final void m8356a() {
            if (this.f2641b == null) {
                this.f2641b = new C0458a();
            }
        }

        /* renamed from: b */
        public void m8353b() {
            this.f2640a = 0L;
            C0458a c0458a = this.f2641b;
            if (c0458a != null) {
                c0458a.m8353b();
            }
        }

        /* renamed from: c */
        public boolean m8351c(int i) {
            if (i < 64) {
                return (this.f2640a & (1 << i)) != 0;
            }
            m8356a();
            return this.f2641b.m8351c(i - 64);
        }

        /* renamed from: d */
        public boolean m8350d(int i) {
            if (i >= 64) {
                m8356a();
                return this.f2641b.m8350d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2640a & j) != 0;
            this.f2640a &= ~j;
            long j2 = j - 1;
            long j3 = this.f2640a;
            this.f2640a = Long.rotateRight(j3 & (~j2), 1) | (j3 & j2);
            C0458a c0458a = this.f2641b;
            if (c0458a != null) {
                if (c0458a.m8351c(0)) {
                    m8349e(63);
                }
                this.f2641b.m8350d(0);
            }
            return z;
        }

        /* renamed from: e */
        public void m8349e(int i) {
            if (i >= 64) {
                m8356a();
                this.f2641b.m8349e(i - 64);
                return;
            }
            this.f2640a |= 1 << i;
        }

        public String toString() {
            if (this.f2641b == null) {
                return Long.toBinaryString(this.f2640a);
            }
            return this.f2641b.toString() + "xx" + Long.toBinaryString(this.f2640a);
        }

        /* renamed from: a */
        public void m8355a(int i) {
            if (i >= 64) {
                C0458a c0458a = this.f2641b;
                if (c0458a != null) {
                    c0458a.m8355a(i - 64);
                    return;
                }
                return;
            }
            this.f2640a &= ~(1 << i);
        }

        /* renamed from: b */
        public int m8352b(int i) {
            C0458a c0458a = this.f2641b;
            if (c0458a == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2640a);
                }
                return Long.bitCount(this.f2640a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f2640a & ((1 << i) - 1));
            } else {
                return c0458a.m8352b(i - 64) + Long.bitCount(this.f2640a);
            }
        }

        /* renamed from: a */
        public void m8354a(int i, boolean z) {
            if (i >= 64) {
                m8356a();
                this.f2641b.m8354a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2640a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f2640a;
            this.f2640a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                m8349e(i);
            } else {
                m8355a(i);
            }
            if (z2 || this.f2641b != null) {
                m8356a();
                this.f2641b.m8354a(0, z2);
            }
        }
    }

    /* renamed from: a */
    public void m8372a(View view, int i, boolean z) {
        int m8364d;
        if (i < 0) {
            m8364d = this.f2637a.mo6788a();
        } else {
            m8364d = m8364d(i);
        }
        this.f2638b.m8354a(m8364d, z);
        if (z) {
            m8368b(view);
        }
        this.f2637a.mo6785a(view, m8364d);
    }

    /* renamed from: b */
    public View m8369b(int i) {
        int size = this.f2639c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f2639c.get(i2);
            RecyclerView.AbstractC0708d0 mo6781b = this.f2637a.mo6781b(view);
            if (mo6781b.m6804k() == i && !mo6781b.m6799p() && !mo6781b.m6797r()) {
                return view;
            }
        }
        return null;
    }

    /* renamed from: c */
    public void m8367c() {
        this.f2638b.m8353b();
        for (int size = this.f2639c.size() - 1; size >= 0; size--) {
            this.f2637a.mo6779c(this.f2639c.get(size));
            this.f2639c.remove(size);
        }
        this.f2637a.mo6783b();
    }

    /* renamed from: d */
    public boolean m8363d(View view) {
        return this.f2639c.contains(view);
    }

    /* renamed from: e */
    public View m8362e(int i) {
        return this.f2637a.mo6787a(i);
    }

    /* renamed from: f */
    public boolean m8359f(View view) {
        int mo6778d = this.f2637a.mo6778d(view);
        if (mo6778d == -1) {
            m8357h(view);
            return true;
        } else if (this.f2638b.m8351c(mo6778d)) {
            this.f2638b.m8350d(mo6778d);
            m8357h(view);
            this.f2637a.mo6780c(mo6778d);
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public void m8373a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int m8364d;
        if (i < 0) {
            m8364d = this.f2637a.mo6788a();
        } else {
            m8364d = m8364d(i);
        }
        this.f2638b.m8354a(m8364d, z);
        if (z) {
            m8368b(view);
        }
        this.f2637a.mo6784a(view, m8364d, layoutParams);
    }

    /* renamed from: c */
    public int m8365c(View view) {
        int mo6778d = this.f2637a.mo6778d(view);
        if (mo6778d == -1 || this.f2638b.m8351c(mo6778d)) {
            return -1;
        }
        return mo6778d - this.f2638b.m8352b(mo6778d);
    }

    /* renamed from: b */
    public int m8370b() {
        return this.f2637a.mo6788a();
    }

    /* renamed from: a */
    public int m8376a() {
        return this.f2637a.mo6788a() - this.f2639c.size();
    }

    /* renamed from: a */
    public void m8375a(int i) {
        int m8364d = m8364d(i);
        this.f2638b.m8350d(m8364d);
        this.f2637a.mo6782b(m8364d);
    }

    /* renamed from: a */
    public void m8374a(View view) {
        int mo6778d = this.f2637a.mo6778d(view);
        if (mo6778d >= 0) {
            this.f2638b.m8349e(mo6778d);
            m8368b(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }
}
