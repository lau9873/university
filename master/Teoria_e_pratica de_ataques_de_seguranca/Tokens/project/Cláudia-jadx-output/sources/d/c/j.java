package d.c;

import d.c.f0.e.b.b0;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* compiled from: Flowable.java */
/* loaded from: classes.dex */
public abstract class j<T> implements g.b.b<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5426a = Math.max(16, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static <T> j<T> a(g.b.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return h();
        }
        if (bVarArr.length == 1) {
            return b((g.b.b) bVarArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.b.b(bVarArr, false));
    }

    public static <T> j<T> b(g.b.b<? extends T> bVar) {
        if (bVar instanceof j) {
            return d.c.h0.a.a((j) bVar);
        }
        d.c.f0.b.b.a(bVar, "publisher is null");
        return d.c.h0.a.a(new d.c.f0.e.b.m(bVar));
    }

    public static int g() {
        return f5426a;
    }

    public static <T> j<T> h() {
        return d.c.h0.a.a(d.c.f0.e.b.f.f4847b);
    }

    public abstract void b(g.b.c<? super T> cVar);

    public final j<T> c() {
        return d.c.h0.a.a((j) new d.c.f0.e.b.p(this));
    }

    public final j<T> d() {
        return d.c.h0.a.a(new d.c.f0.e.b.r(this));
    }

    public final j<T> e() {
        return a(Long.MAX_VALUE);
    }

    public final j<T> f() {
        return a(Long.MAX_VALUE, d.c.f0.b.a.a());
    }

    public final j<T> c(d.c.e0.n<? super j<Throwable>, ? extends g.b.b<?>> nVar) {
        d.c.f0.b.b.a(nVar, "handler is null");
        return d.c.h0.a.a(new d.c.f0.e.b.x(this, nVar));
    }

    public static <T> j<T> b(T t) {
        d.c.f0.b.b.a((Object) t, "item is null");
        return d.c.h0.a.a((j) new d.c.f0.e.b.n(t));
    }

    public static <T> j<T> a(T... tArr) {
        d.c.f0.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return h();
        }
        if (tArr.length == 1) {
            return b(tArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.b.i(tArr));
    }

    public final j<T> b() {
        return a(g(), false, true);
    }

    public final j<T> b(d.c.e0.n<? super j<Object>, ? extends g.b.b<?>> nVar) {
        d.c.f0.b.b.a(nVar, "handler is null");
        return d.c.h0.a.a(new d.c.f0.e.b.u(this, nVar));
    }

    public final j<T> b(long j) {
        return a(j, d.c.f0.b.a.a());
    }

    public static <T> j<T> a(Future<? extends T> future) {
        d.c.f0.b.b.a(future, "future is null");
        return d.c.h0.a.a(new d.c.f0.e.b.j(future, 0L, null));
    }

    public static <T> j<T> a(Future<? extends T> future, long j, TimeUnit timeUnit) {
        d.c.f0.b.b.a(future, "future is null");
        d.c.f0.b.b.a(timeUnit, "unit is null");
        return d.c.h0.a.a(new d.c.f0.e.b.j(future, j, timeUnit));
    }

    public static <T> j<T> a(Future<? extends T> future, long j, TimeUnit timeUnit, t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return a(future, j, timeUnit).a(tVar);
    }

    public static <T> j<T> a(Future<? extends T> future, t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return a(future).a(tVar);
    }

    public static <T> j<T> a(Iterable<? extends T> iterable) {
        d.c.f0.b.b.a(iterable, "source is null");
        return d.c.h0.a.a(new d.c.f0.e.b.k(iterable));
    }

    public final <R> j<R> a(d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar) {
        return a((d.c.e0.n) nVar, false, g(), g());
    }

    public final <R> j<R> a(d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, boolean z, int i2, int i3) {
        d.c.f0.b.b.a(nVar, "mapper is null");
        if (this instanceof d.c.f0.c.l) {
            Object call = ((d.c.f0.c.l) this).call();
            if (call == null) {
                return h();
            }
            return d.c.f0.e.b.y.a(call, nVar);
        }
        d.c.f0.b.b.a(i2, "maxConcurrency");
        d.c.f0.b.b.a(i3, "bufferSize");
        return d.c.h0.a.a(new d.c.f0.e.b.g(this, nVar, z, i2, i3));
    }

    public final j<T> a(int i2, boolean z, boolean z2) {
        d.c.f0.b.b.a(i2, "bufferSize");
        return d.c.h0.a.a(new d.c.f0.e.b.o(this, i2, z2, z, d.c.f0.b.a.f4589c));
    }

    public final j<T> a(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (i2 == 0) {
                return h();
            }
            return d.c.h0.a.a(new d.c.f0.e.b.s(this, j));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final j<T> a(d.c.e0.e eVar) {
        d.c.f0.b.b.a(eVar, "stop is null");
        return d.c.h0.a.a(new d.c.f0.e.b.t(this, eVar));
    }

    public final j<T> a(d.c.e0.d<? super Integer, ? super Throwable> dVar) {
        d.c.f0.b.b.a(dVar, "predicate is null");
        return d.c.h0.a.a(new d.c.f0.e.b.v(this, dVar));
    }

    public final j<T> a(long j, d.c.e0.p<? super Throwable> pVar) {
        if (j >= 0) {
            d.c.f0.b.b.a(pVar, "predicate is null");
            return d.c.h0.a.a(new d.c.f0.e.b.w(this, j, pVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final j<T> a(d.c.e0.p<? super Throwable> pVar) {
        return a(Long.MAX_VALUE, pVar);
    }

    public final j<T> a(g.b.b<? extends T> bVar) {
        d.c.f0.b.b.a(bVar, "other is null");
        return a(bVar, this);
    }

    @Override // g.b.b
    public final void a(g.b.c<? super T> cVar) {
        if (cVar instanceof k) {
            a((k) ((k) cVar));
            return;
        }
        d.c.f0.b.b.a(cVar, "s is null");
        a((k) new d.c.f0.h.a(cVar));
    }

    public final void a(k<? super T> kVar) {
        d.c.f0.b.b.a(kVar, "s is null");
        try {
            g.b.c<? super T> a2 = d.c.h0.a.a(this, kVar);
            d.c.f0.b.b.a(a2, "Plugin returned null Subscriber");
            b((g.b.c) a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.h0.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final j<T> a(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new b0(this, tVar, false));
    }
}
