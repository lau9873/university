package d.c.c0;

import java.util.concurrent.Future;
/* compiled from: Disposables.java */
/* loaded from: classes.dex */
public final class c {
    public static b a(Runnable runnable) {
        d.c.f0.b.b.a(runnable, "run is null");
        return new f(runnable);
    }

    public static b b() {
        return a(d.c.f0.b.a.f4588b);
    }

    public static b a(Future<?> future) {
        d.c.f0.b.b.a(future, "future is null");
        return a(future, true);
    }

    public static b a(Future<?> future, boolean z) {
        d.c.f0.b.b.a(future, "future is null");
        return new d(future, z);
    }

    public static b a() {
        return d.c.f0.a.c.INSTANCE;
    }
}
