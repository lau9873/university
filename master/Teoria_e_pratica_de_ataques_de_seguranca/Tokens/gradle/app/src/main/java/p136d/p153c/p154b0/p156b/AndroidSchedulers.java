package p136d.p153c.p154b0.p156b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import p136d.p153c.Scheduler;
import p136d.p153c.p154b0.p155a.RxAndroidPlugins;

/* renamed from: d.c.b0.b.a */
/* loaded from: classes.dex */
public final class AndroidSchedulers {

    /* renamed from: a */
    public static final Scheduler f6862a = RxAndroidPlugins.m3672b(new CallableC1534a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: d.c.b0.b.a$a */
    /* loaded from: classes.dex */
    public static class CallableC1534a implements Callable<Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return C1535b.f6863a;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: d.c.b0.b.a$b */
    /* loaded from: classes.dex */
    public static final class C1535b {

        /* renamed from: a */
        public static final Scheduler f6863a = new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: a */
    public static Scheduler m3671a() {
        return RxAndroidPlugins.m3674a(f6862a);
    }
}
