package p136d.p153c.p154b0.p155a;

import java.util.concurrent.Callable;
import p136d.p153c.Scheduler;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;

/* renamed from: d.c.b0.a.a */
/* loaded from: classes.dex */
public final class RxAndroidPlugins {

    /* renamed from: a */
    public static volatile Function<Callable<Scheduler>, Scheduler> f6860a;

    /* renamed from: b */
    public static volatile Function<Scheduler, Scheduler> f6861b;

    /* renamed from: a */
    public static Scheduler m3674a(Scheduler scheduler) {
        if (scheduler != null) {
            Function<Scheduler, Scheduler> function = f6861b;
            return function == null ? scheduler : (Scheduler) m3676a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: b */
    public static Scheduler m3672b(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = f6860a;
            if (function == null) {
                return m3673a(callable);
            }
            return m3675a(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: a */
    public static Scheduler m3673a(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            Exceptions.m3661a(th);
            throw null;
        }
    }

    /* renamed from: a */
    public static Scheduler m3675a(Function<Callable<Scheduler>, Scheduler> function, Callable<Scheduler> callable) {
        Scheduler scheduler = (Scheduler) m3676a((Function<Callable<Scheduler>, Object>) function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: a */
    public static <T, R> R m3676a(Function<T, R> function, T t) {
        try {
            return function.mo3490a(t);
        } catch (Throwable th) {
            Exceptions.m3661a(th);
            throw null;
        }
    }
}
