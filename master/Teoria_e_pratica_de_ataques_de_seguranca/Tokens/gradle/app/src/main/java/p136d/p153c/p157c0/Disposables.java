package p136d.p153c.p157c0;

import java.util.concurrent.Future;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.Functions;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.c0.c */
/* loaded from: classes.dex */
public final class Disposables {
    /* renamed from: a */
    public static Disposable m3667a(Runnable runnable) {
        ObjectHelper.m3598a(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    /* renamed from: b */
    public static Disposable m3664b() {
        return m3667a(Functions.f6881b);
    }

    /* renamed from: a */
    public static Disposable m3666a(Future<?> future) {
        ObjectHelper.m3598a(future, "future is null");
        return m3665a(future, true);
    }

    /* renamed from: a */
    public static Disposable m3665a(Future<?> future, boolean z) {
        ObjectHelper.m3598a(future, "future is null");
        return new FutureDisposable(future, z);
    }

    /* renamed from: a */
    public static Disposable m3668a() {
        return EmptyDisposable.INSTANCE;
    }
}
