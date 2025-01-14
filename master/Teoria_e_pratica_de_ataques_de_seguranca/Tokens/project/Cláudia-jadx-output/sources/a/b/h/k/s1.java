package a.b.h.k;

import android.support.v7.widget.RecyclerView;
/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class s1 {

    /* renamed from: a  reason: collision with root package name */
    public final a.b.g.j.a<RecyclerView.d0, a> f1957a = new a.b.g.j.a<>();

    /* renamed from: b  reason: collision with root package name */
    public final a.b.g.j.f<RecyclerView.d0> f1958b = new a.b.g.j.f<>();

    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    public void a() {
        this.f1957a.clear();
        this.f1958b.a();
    }

    public boolean b(RecyclerView.d0 d0Var) {
        a aVar = this.f1957a.get(d0Var);
        return (aVar == null || (aVar.f1960a & 1) == 0) ? false : true;
    }

    public void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1957a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1957a.put(d0Var, aVar);
        }
        aVar.f1961b = cVar;
        aVar.f1960a |= 4;
    }

    public void d(RecyclerView.d0 d0Var) {
        g(d0Var);
    }

    public RecyclerView.l.c e(RecyclerView.d0 d0Var) {
        return a(d0Var, 8);
    }

    public RecyclerView.l.c f(RecyclerView.d0 d0Var) {
        return a(d0Var, 4);
    }

    public void g(RecyclerView.d0 d0Var) {
        a aVar = this.f1957a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f1960a &= -2;
    }

    public void h(RecyclerView.d0 d0Var) {
        int c2 = this.f1958b.c() - 1;
        while (true) {
            if (c2 < 0) {
                break;
            } else if (d0Var == this.f1958b.c(c2)) {
                this.f1958b.b(c2);
                break;
            } else {
                c2--;
            }
        }
        a remove = this.f1957a.remove(d0Var);
        if (remove != null) {
            a.a(remove);
        }
    }

    public final RecyclerView.l.c a(RecyclerView.d0 d0Var, int i2) {
        a e2;
        RecyclerView.l.c cVar;
        int a2 = this.f1957a.a(d0Var);
        if (a2 >= 0 && (e2 = this.f1957a.e(a2)) != null) {
            int i3 = e2.f1960a;
            if ((i3 & i2) != 0) {
                e2.f1960a = (~i2) & i3;
                if (i2 == 4) {
                    cVar = e2.f1961b;
                } else if (i2 == 8) {
                    cVar = e2.f1962c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((e2.f1960a & 12) == 0) {
                    this.f1957a.d(a2);
                    a.a(e2);
                }
                return cVar;
            }
        }
        return null;
    }

    public void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1957a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1957a.put(d0Var, aVar);
        }
        aVar.f1962c = cVar;
        aVar.f1960a |= 8;
    }

    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static a.b.g.j.j<a> f1959d = new a.b.g.j.k(20);

        /* renamed from: a  reason: collision with root package name */
        public int f1960a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.l.c f1961b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.l.c f1962c;

        public static void a(a aVar) {
            aVar.f1960a = 0;
            aVar.f1961b = null;
            aVar.f1962c = null;
            f1959d.a(aVar);
        }

        public static a b() {
            a a2 = f1959d.a();
            return a2 == null ? new a() : a2;
        }

        public static void a() {
            do {
            } while (f1959d.a() != null);
        }
    }

    public boolean c(RecyclerView.d0 d0Var) {
        a aVar = this.f1957a.get(d0Var);
        return (aVar == null || (aVar.f1960a & 4) == 0) ? false : true;
    }

    public void b() {
        a.a();
    }

    public void a(long j, RecyclerView.d0 d0Var) {
        this.f1958b.c(j, d0Var);
    }

    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1957a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1957a.put(d0Var, aVar);
        }
        aVar.f1960a |= 2;
        aVar.f1961b = cVar;
    }

    public RecyclerView.d0 a(long j) {
        return this.f1958b.b(j);
    }

    public void a(RecyclerView.d0 d0Var) {
        a aVar = this.f1957a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1957a.put(d0Var, aVar);
        }
        aVar.f1960a |= 1;
    }

    public void a(b bVar) {
        for (int size = this.f1957a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 c2 = this.f1957a.c(size);
            a d2 = this.f1957a.d(size);
            int i2 = d2.f1960a;
            if ((i2 & 3) == 3) {
                bVar.a(c2);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.c cVar = d2.f1961b;
                if (cVar == null) {
                    bVar.a(c2);
                } else {
                    bVar.b(c2, cVar, d2.f1962c);
                }
            } else if ((i2 & 14) == 14) {
                bVar.c(c2, d2.f1961b, d2.f1962c);
            } else if ((i2 & 12) == 12) {
                bVar.a(c2, d2.f1961b, d2.f1962c);
            } else if ((i2 & 4) != 0) {
                bVar.b(c2, d2.f1961b, null);
            } else if ((i2 & 8) != 0) {
                bVar.c(c2, d2.f1961b, d2.f1962c);
            }
            a.a(d2);
        }
    }
}
