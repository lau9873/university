package d.c.h0;

import d.c.b;
import d.c.d;
import d.c.e0.c;
import d.c.e0.e;
import d.c.e0.f;
import d.c.e0.n;
import d.c.j;
import d.c.l;
import d.c.o;
import d.c.s;
import d.c.t;
import d.c.u;
import d.c.w;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;
/* compiled from: RxJavaPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f<? super Throwable> f5404a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile n<? super Runnable, ? extends Runnable> f5405b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile n<? super Callable<t>, ? extends t> f5406c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile n<? super Callable<t>, ? extends t> f5407d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile n<? super Callable<t>, ? extends t> f5408e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile n<? super Callable<t>, ? extends t> f5409f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile n<? super t, ? extends t> f5410g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile n<? super t, ? extends t> f5411h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile n<? super j, ? extends j> f5412i;
    public static volatile n<? super o, ? extends o> j;
    public static volatile n<? super l, ? extends l> k;
    public static volatile n<? super u, ? extends u> l;
    public static volatile n<? super b, ? extends b> m;
    public static volatile c<? super j, ? super g.b.c, ? extends g.b.c> n;
    public static volatile c<? super o, ? super s, ? extends s> o;
    public static volatile c<? super u, ? super w, ? extends w> p;
    public static volatile c<? super b, ? super d, ? extends d> q;
    public static volatile e r;
    public static volatile boolean s;
    public static volatile boolean t;

    public static boolean a() {
        return t;
    }

    public static t b(Callable<t> callable) {
        d.c.f0.b.b.a(callable, "Scheduler Callable can't be null");
        n<? super Callable<t>, ? extends t> nVar = f5406c;
        if (nVar == null) {
            return a(callable);
        }
        return a(nVar, callable);
    }

    public static t c(Callable<t> callable) {
        d.c.f0.b.b.a(callable, "Scheduler Callable can't be null");
        n<? super Callable<t>, ? extends t> nVar = f5408e;
        if (nVar == null) {
            return a(callable);
        }
        return a(nVar, callable);
    }

    public static t d(Callable<t> callable) {
        d.c.f0.b.b.a(callable, "Scheduler Callable can't be null");
        n<? super Callable<t>, ? extends t> nVar = f5409f;
        if (nVar == null) {
            return a(callable);
        }
        return a(nVar, callable);
    }

    public static t e(Callable<t> callable) {
        d.c.f0.b.b.a(callable, "Scheduler Callable can't be null");
        n<? super Callable<t>, ? extends t> nVar = f5407d;
        if (nVar == null) {
            return a(callable);
        }
        return a(nVar, callable);
    }

    public static t a(t tVar) {
        n<? super t, ? extends t> nVar = f5410g;
        return nVar == null ? tVar : (t) a((n<t, Object>) nVar, tVar);
    }

    public static boolean a(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static void b(Throwable th) {
        f<? super Throwable> fVar = f5404a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new UndeliverableException(th);
        }
        if (fVar != null) {
            try {
                fVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    public static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Runnable a(Runnable runnable) {
        n<? super Runnable, ? extends Runnable> nVar = f5405b;
        return nVar == null ? runnable : (Runnable) a((n<Runnable, Object>) nVar, runnable);
    }

    public static void a(f<? super Throwable> fVar) {
        if (!s) {
            f5404a = fVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static t b(t tVar) {
        n<? super t, ? extends t> nVar = f5411h;
        return nVar == null ? tVar : (t) a((n<t, Object>) nVar, tVar);
    }

    public static <T> g.b.c<? super T> a(j<T> jVar, g.b.c<? super T> cVar) {
        c<? super j, ? super g.b.c, ? extends g.b.c> cVar2 = n;
        return cVar2 != null ? (g.b.c) a(cVar2, jVar, cVar) : cVar;
    }

    public static boolean b() {
        e eVar = r;
        if (eVar != null) {
            try {
                return eVar.a();
            } catch (Throwable th) {
                throw d.c.f0.j.f.a(th);
            }
        }
        return false;
    }

    public static <T> s<? super T> a(o<T> oVar, s<? super T> sVar) {
        c<? super o, ? super s, ? extends s> cVar = o;
        return cVar != null ? (s) a(cVar, oVar, sVar) : sVar;
    }

    public static <T> w<? super T> a(u<T> uVar, w<? super T> wVar) {
        c<? super u, ? super w, ? extends w> cVar = p;
        return cVar != null ? (w) a(cVar, uVar, wVar) : wVar;
    }

    public static d a(b bVar, d dVar) {
        c<? super b, ? super d, ? extends d> cVar = q;
        return cVar != null ? (d) a(cVar, bVar, dVar) : dVar;
    }

    public static <T> l<T> a(l<T> lVar) {
        n<? super l, ? extends l> nVar = k;
        return nVar != null ? (l) a((n<l<T>, Object>) nVar, lVar) : lVar;
    }

    public static <T> j<T> a(j<T> jVar) {
        n<? super j, ? extends j> nVar = f5412i;
        return nVar != null ? (j) a((n<j<T>, Object>) nVar, jVar) : jVar;
    }

    public static <T> o<T> a(o<T> oVar) {
        n<? super o, ? extends o> nVar = j;
        return nVar != null ? (o) a((n<o<T>, Object>) nVar, oVar) : oVar;
    }

    public static <T> u<T> a(u<T> uVar) {
        n<? super u, ? extends u> nVar = l;
        return nVar != null ? (u) a((n<u<T>, Object>) nVar, uVar) : uVar;
    }

    public static b a(b bVar) {
        n<? super b, ? extends b> nVar = m;
        return nVar != null ? (b) a((n<b, Object>) nVar, bVar) : bVar;
    }

    public static <T, R> R a(n<T, R> nVar, T t2) {
        try {
            return nVar.a(t2);
        } catch (Throwable th) {
            throw d.c.f0.j.f.a(th);
        }
    }

    public static <T, U, R> R a(c<T, U, R> cVar, T t2, U u) {
        try {
            return cVar.a(t2, u);
        } catch (Throwable th) {
            throw d.c.f0.j.f.a(th);
        }
    }

    public static t a(Callable<t> callable) {
        try {
            t call = callable.call();
            d.c.f0.b.b.a(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw d.c.f0.j.f.a(th);
        }
    }

    public static t a(n<? super Callable<t>, ? extends t> nVar, Callable<t> callable) {
        Object a2 = a((n<Callable<t>, Object>) nVar, callable);
        d.c.f0.b.b.a(a2, "Scheduler Callable result can't be null");
        return (t) a2;
    }
}
