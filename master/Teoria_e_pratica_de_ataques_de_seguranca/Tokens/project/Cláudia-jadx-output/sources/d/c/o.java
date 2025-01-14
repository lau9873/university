package d.c;

import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* loaded from: classes.dex */
public abstract class o<T> implements r<T> {

    /* compiled from: Observable.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5439a = new int[d.c.a.values().length];

        static {
            try {
                f5439a[d.c.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5439a[d.c.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5439a[d.c.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5439a[d.c.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> o<T> a(r<? extends T> rVar, r<? extends T> rVar2) {
        return a(rVar, rVar2);
    }

    public static o<Long> b(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, d.c.j0.a.a());
    }

    public static int e() {
        return j.g();
    }

    public static <T> o<T> f() {
        return d.c.h0.a.a(d.c.f0.e.d.e.f4994a);
    }

    public abstract void b(s<? super T> sVar);

    public final u<T> c() {
        return d.c.h0.a.a(new d.c.f0.e.d.o(this, null));
    }

    public final d.c.c0.b d() {
        return a(d.c.f0.b.a.b(), d.c.f0.b.a.f4591e, d.c.f0.b.a.f4589c, d.c.f0.b.a.b());
    }

    public static <T> o<T> a(r<? extends T> rVar, r<? extends T> rVar2, r<? extends T> rVar3) {
        return a(rVar, rVar2, rVar3);
    }

    public static <T> o<T> b(r<T> rVar) {
        d.c.f0.b.b.a(rVar, "source is null");
        if (rVar instanceof o) {
            return d.c.h0.a.a((o) rVar);
        }
        return d.c.h0.a.a(new d.c.f0.e.d.h(rVar));
    }

    public static <T> o<T> a(r<? extends T>... rVarArr) {
        if (rVarArr.length == 0) {
            return f();
        }
        if (rVarArr.length == 1) {
            return b(rVarArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.d.b(a((Object[]) rVarArr), d.c.f0.b.a.c(), e(), d.c.f0.j.e.BOUNDARY));
    }

    public final l<T> b() {
        return d.c.h0.a.a(new d.c.f0.e.d.n(this));
    }

    public static <T> o<T> a(q<T> qVar) {
        d.c.f0.b.b.a(qVar, "source is null");
        return d.c.h0.a.a(new d.c.f0.e.d.c(qVar));
    }

    public static <T> o<T> a(T... tArr) {
        d.c.f0.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return f();
        }
        if (tArr.length == 1) {
            return a(tArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.d.g(tArr));
    }

    public static o<Long> a(long j, long j2, TimeUnit timeUnit, t tVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d.c.f0.e.d.k(Math.max(0L, j), Math.max(0L, j2), timeUnit, tVar));
    }

    public static o<Long> a(long j, TimeUnit timeUnit) {
        return a(j, j, timeUnit, d.c.j0.a.a());
    }

    public static <T> o<T> a(T t) {
        d.c.f0.b.b.a((Object) t, "The item is null");
        return d.c.h0.a.a((o) new d.c.f0.e.d.l(t));
    }

    public static o<Long> a(long j, TimeUnit timeUnit, t tVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d.c.f0.e.d.q(Math.max(j, 0L), timeUnit, tVar));
    }

    public final o<T> a(r<? extends T> rVar) {
        d.c.f0.b.b.a(rVar, "other is null");
        return a(this, rVar);
    }

    public final <R> o<R> a(d.c.e0.n<? super T, ? extends r<? extends R>> nVar) {
        return a((d.c.e0.n) nVar, false);
    }

    public final <R> o<R> a(d.c.e0.n<? super T, ? extends r<? extends R>> nVar, boolean z) {
        return a(nVar, z, Integer.MAX_VALUE);
    }

    public final <R> o<R> a(d.c.e0.n<? super T, ? extends r<? extends R>> nVar, boolean z, int i2) {
        return a(nVar, z, i2, e());
    }

    public final <R> o<R> a(d.c.e0.n<? super T, ? extends r<? extends R>> nVar, boolean z, int i2, int i3) {
        d.c.f0.b.b.a(nVar, "mapper is null");
        d.c.f0.b.b.a(i2, "maxConcurrency");
        d.c.f0.b.b.a(i3, "bufferSize");
        if (this instanceof d.c.f0.c.l) {
            Object call = ((d.c.f0.c.l) this).call();
            if (call == null) {
                return f();
            }
            return d.c.f0.e.d.m.a(call, nVar);
        }
        return d.c.h0.a.a(new d.c.f0.e.d.f(this, nVar, z, i2, i3));
    }

    public final b a() {
        return d.c.h0.a.a(new d.c.f0.e.d.j(this));
    }

    public final d.c.c0.b a(d.c.e0.f<? super T> fVar) {
        return a(fVar, d.c.f0.b.a.f4591e, d.c.f0.b.a.f4589c, d.c.f0.b.a.b());
    }

    public final d.c.c0.b a(d.c.e0.f<? super T> fVar, d.c.e0.f<? super Throwable> fVar2) {
        return a(fVar, fVar2, d.c.f0.b.a.f4589c, d.c.f0.b.a.b());
    }

    public final d.c.c0.b a(d.c.e0.f<? super T> fVar, d.c.e0.f<? super Throwable> fVar2, d.c.e0.a aVar, d.c.e0.f<? super d.c.c0.b> fVar3) {
        d.c.f0.b.b.a(fVar, "onNext is null");
        d.c.f0.b.b.a(fVar2, "onError is null");
        d.c.f0.b.b.a(aVar, "onComplete is null");
        d.c.f0.b.b.a(fVar3, "onSubscribe is null");
        d.c.f0.d.i iVar = new d.c.f0.d.i(fVar, fVar2, aVar, fVar3);
        a((s) iVar);
        return iVar;
    }

    @Override // d.c.r
    public final void a(s<? super T> sVar) {
        d.c.f0.b.b.a(sVar, "observer is null");
        try {
            s<? super T> a2 = d.c.h0.a.a(this, sVar);
            d.c.f0.b.b.a(a2, "Plugin returned null Observer");
            b(a2);
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

    public final o<T> a(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d.c.f0.e.d.p(this, tVar));
    }

    public final j<T> a(d.c.a aVar) {
        d.c.f0.e.b.l lVar = new d.c.f0.e.b.l(this);
        int i2 = a.f5439a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return lVar.b();
                    }
                    return d.c.h0.a.a(new d.c.f0.e.b.q(lVar));
                }
                return lVar;
            }
            return lVar.d();
        }
        return lVar.c();
    }
}
