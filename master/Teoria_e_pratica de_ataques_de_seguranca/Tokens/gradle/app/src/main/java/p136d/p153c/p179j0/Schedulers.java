package p136d.p153c.p179j0;

import java.util.concurrent.Callable;
import p136d.p153c.Scheduler;
import p136d.p153c.p160f0.p172g.ComputationScheduler;
import p136d.p153c.p160f0.p172g.IoScheduler;
import p136d.p153c.p160f0.p172g.NewThreadScheduler;
import p136d.p153c.p160f0.p172g.SingleScheduler;
import p136d.p153c.p160f0.p172g.TrampolineScheduler;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.j0.a */
/* loaded from: classes.dex */
public final class Schedulers {

    /* renamed from: a */
    public static final Scheduler f7777a;

    /* renamed from: b */
    public static final Scheduler f7778b;

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$a */
    /* loaded from: classes.dex */
    public static class CallableC1721a implements Callable<Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return C1728h.f7782a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$b */
    /* loaded from: classes.dex */
    public static class CallableC1722b implements Callable<Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return C1725e.f7779a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$c */
    /* loaded from: classes.dex */
    public static class CallableC1723c implements Callable<Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return C1726f.f7780a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$d */
    /* loaded from: classes.dex */
    public static class CallableC1724d implements Callable<Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return C1727g.f7781a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$e */
    /* loaded from: classes.dex */
    public static final class C1725e {

        /* renamed from: a */
        public static final Scheduler f7779a = new ComputationScheduler();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$f */
    /* loaded from: classes.dex */
    public static final class C1726f {

        /* renamed from: a */
        public static final Scheduler f7780a = new IoScheduler();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$g */
    /* loaded from: classes.dex */
    public static final class C1727g {

        /* renamed from: a */
        public static final Scheduler f7781a = new NewThreadScheduler();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$h */
    /* loaded from: classes.dex */
    public static final class C1728h {

        /* renamed from: a */
        public static final Scheduler f7782a = new SingleScheduler();
    }

    static {
        RxJavaPlugins.m3366e(new CallableC1721a());
        f7777a = RxJavaPlugins.m3370b(new CallableC1722b());
        f7778b = RxJavaPlugins.m3368c(new CallableC1723c());
        TrampolineScheduler.m3445b();
        RxJavaPlugins.m3367d(new CallableC1724d());
    }

    /* renamed from: a */
    public static Scheduler m3324a() {
        return RxJavaPlugins.m3379a(f7777a);
    }

    /* renamed from: b */
    public static Scheduler m3323b() {
        return RxJavaPlugins.m3372b(f7778b);
    }
}
