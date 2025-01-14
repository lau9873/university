package d.c.b0.a;

import d.c.e0.n;
import d.c.t;
import java.util.concurrent.Callable;
/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile n<Callable<t>, t> f4567a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile n<t, t> f4568b;

    public static t a(t tVar) {
        if (tVar != null) {
            n<t, t> nVar = f4568b;
            return nVar == null ? tVar : (t) a(nVar, tVar);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static t b(Callable<t> callable) {
        if (callable != null) {
            n<Callable<t>, t> nVar = f4567a;
            if (nVar == null) {
                return a(callable);
            }
            return a(nVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static t a(Callable<t> callable) {
        try {
            t call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            d.c.d0.a.a(th);
            throw null;
        }
    }

    public static t a(n<Callable<t>, t> nVar, Callable<t> callable) {
        t tVar = (t) a((n<Callable<t>, Object>) nVar, callable);
        if (tVar != null) {
            return tVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static <T, R> R a(n<T, R> nVar, T t) {
        try {
            return nVar.a(t);
        } catch (Throwable th) {
            d.c.d0.a.a(th);
            throw null;
        }
    }
}
