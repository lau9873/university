package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import p000a.p006b.p030g.p044j.ArrayMap;
import p000a.p006b.p030g.p044j.C0274k;
import p000a.p006b.p030g.p044j.InterfaceC0273j;
import p000a.p006b.p030g.p044j.LongSparseArray;

/* renamed from: a.b.h.k.s1 */
/* loaded from: classes.dex */
public class ViewInfoStore {

    /* renamed from: a */
    public final ArrayMap<RecyclerView.AbstractC0708d0, C0502a> f2952a = new ArrayMap<>();

    /* renamed from: b */
    public final LongSparseArray<RecyclerView.AbstractC0708d0> f2953b = new LongSparseArray<>();

    /* compiled from: ViewInfoStore.java */
    /* renamed from: a.b.h.k.s1$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0503b {
        /* renamed from: a */
        void mo6829a(RecyclerView.AbstractC0708d0 abstractC0708d0);

        /* renamed from: a */
        void mo6828a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2);

        /* renamed from: b */
        void mo6827b(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2);

        /* renamed from: c */
        void mo6826c(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2);
    }

    /* renamed from: a */
    public void m8067a() {
        this.f2952a.clear();
        this.f2953b.m9665a();
    }

    /* renamed from: b */
    public boolean m8059b(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        return (c0502a == null || (c0502a.f2955a & 1) == 0) ? false : true;
    }

    /* renamed from: c */
    public void m8056c(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        if (c0502a == null) {
            c0502a = C0502a.m8048b();
            this.f2952a.put(abstractC0708d0, c0502a);
        }
        c0502a.f2956b = c0719c;
        c0502a.f2955a |= 4;
    }

    /* renamed from: d */
    public void m8055d(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8052g(abstractC0708d0);
    }

    /* renamed from: e */
    public RecyclerView.AbstractC0716l.C0719c m8054e(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        return m8062a(abstractC0708d0, 8);
    }

    /* renamed from: f */
    public RecyclerView.AbstractC0716l.C0719c m8053f(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        return m8062a(abstractC0708d0, 4);
    }

    /* renamed from: g */
    public void m8052g(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        if (c0502a == null) {
            return;
        }
        c0502a.f2955a &= -2;
    }

    /* renamed from: h */
    public void m8051h(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        int m9657c = this.f2953b.m9657c() - 1;
        while (true) {
            if (m9657c < 0) {
                break;
            } else if (abstractC0708d0 == this.f2953b.m9656c(m9657c)) {
                this.f2953b.m9660b(m9657c);
                break;
            } else {
                m9657c--;
            }
        }
        C0502a remove = this.f2952a.remove(abstractC0708d0);
        if (remove != null) {
            C0502a.m8049a(remove);
        }
    }

    /* renamed from: a */
    public final RecyclerView.AbstractC0716l.C0719c m8062a(RecyclerView.AbstractC0708d0 abstractC0708d0, int i) {
        C0502a m9607e;
        RecyclerView.AbstractC0716l.C0719c c0719c;
        int m9615a = this.f2952a.m9615a(abstractC0708d0);
        if (m9615a >= 0 && (m9607e = this.f2952a.m9607e(m9615a)) != null) {
            int i2 = m9607e.f2955a;
            if ((i2 & i) != 0) {
                m9607e.f2955a = (~i) & i2;
                if (i == 4) {
                    c0719c = m9607e.f2956b;
                } else if (i == 8) {
                    c0719c = m9607e.f2957c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((m9607e.f2955a & 12) == 0) {
                    this.f2952a.m9608d(m9615a);
                    C0502a.m8049a(m9607e);
                }
                return c0719c;
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m8058b(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        if (c0502a == null) {
            c0502a = C0502a.m8048b();
            this.f2952a.put(abstractC0708d0, c0502a);
        }
        c0502a.f2957c = c0719c;
        c0502a.f2955a |= 8;
    }

    /* compiled from: ViewInfoStore.java */
    /* renamed from: a.b.h.k.s1$a */
    /* loaded from: classes.dex */
    public static class C0502a {

        /* renamed from: d */
        public static InterfaceC0273j<C0502a> f2954d = new C0274k(20);

        /* renamed from: a */
        public int f2955a;

        /* renamed from: b */
        public RecyclerView.AbstractC0716l.C0719c f2956b;

        /* renamed from: c */
        public RecyclerView.AbstractC0716l.C0719c f2957c;

        /* renamed from: a */
        public static void m8049a(C0502a c0502a) {
            c0502a.f2955a = 0;
            c0502a.f2956b = null;
            c0502a.f2957c = null;
            f2954d.mo9623a(c0502a);
        }

        /* renamed from: b */
        public static C0502a m8048b() {
            C0502a mo9624a = f2954d.mo9624a();
            return mo9624a == null ? new C0502a() : mo9624a;
        }

        /* renamed from: a */
        public static void m8050a() {
            do {
            } while (f2954d.mo9624a() != null);
        }
    }

    /* renamed from: c */
    public boolean m8057c(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        return (c0502a == null || (c0502a.f2955a & 4) == 0) ? false : true;
    }

    /* renamed from: b */
    public void m8060b() {
        C0502a.m8050a();
    }

    /* renamed from: a */
    public void m8065a(long j, RecyclerView.AbstractC0708d0 abstractC0708d0) {
        this.f2953b.m9654c(j, abstractC0708d0);
    }

    /* renamed from: a */
    public void m8061a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        if (c0502a == null) {
            c0502a = C0502a.m8048b();
            this.f2952a.put(abstractC0708d0, c0502a);
        }
        c0502a.f2955a |= 2;
        c0502a.f2956b = c0719c;
    }

    /* renamed from: a */
    public RecyclerView.AbstractC0708d0 m8066a(long j) {
        return this.f2953b.m9659b(j);
    }

    /* renamed from: a */
    public void m8063a(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        C0502a c0502a = this.f2952a.get(abstractC0708d0);
        if (c0502a == null) {
            c0502a = C0502a.m8048b();
            this.f2952a.put(abstractC0708d0, c0502a);
        }
        c0502a.f2955a |= 1;
    }

    /* renamed from: a */
    public void m8064a(InterfaceC0503b interfaceC0503b) {
        for (int size = this.f2952a.size() - 1; size >= 0; size--) {
            RecyclerView.AbstractC0708d0 m9609c = this.f2952a.m9609c(size);
            C0502a m9608d = this.f2952a.m9608d(size);
            int i = m9608d.f2955a;
            if ((i & 3) == 3) {
                interfaceC0503b.mo6829a(m9609c);
            } else if ((i & 1) != 0) {
                RecyclerView.AbstractC0716l.C0719c c0719c = m9608d.f2956b;
                if (c0719c == null) {
                    interfaceC0503b.mo6829a(m9609c);
                } else {
                    interfaceC0503b.mo6827b(m9609c, c0719c, m9608d.f2957c);
                }
            } else if ((i & 14) == 14) {
                interfaceC0503b.mo6826c(m9609c, m9608d.f2956b, m9608d.f2957c);
            } else if ((i & 12) == 12) {
                interfaceC0503b.mo6828a(m9609c, m9608d.f2956b, m9608d.f2957c);
            } else if ((i & 4) != 0) {
                interfaceC0503b.mo6827b(m9609c, m9608d.f2956b, null);
            } else if ((i & 8) != 0) {
                interfaceC0503b.mo6826c(m9609c, m9608d.f2956b, m9608d.f2957c);
            }
            C0502a.m8049a(m9608d);
        }
    }
}
