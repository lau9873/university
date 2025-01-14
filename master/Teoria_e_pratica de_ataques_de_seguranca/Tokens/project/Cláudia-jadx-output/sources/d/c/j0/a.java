package d.c.j0;

import d.c.f0.g.i;
import d.c.f0.g.j;
import d.c.t;
import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final t f5427a;

    /* renamed from: b  reason: collision with root package name */
    public static final t f5428b;

    /* compiled from: Schedulers.java */
    /* renamed from: d.c.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class CallableC0114a implements Callable<t> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public t call() {
            return h.f5432a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static class b implements Callable<t> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public t call() {
            return e.f5429a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static class c implements Callable<t> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public t call() {
            return f.f5430a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static class d implements Callable<t> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public t call() {
            return g.f5431a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final t f5429a = new d.c.f0.g.a();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public static final t f5430a = new d.c.f0.g.b();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final t f5431a = new d.c.f0.g.c();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public static final t f5432a = new i();
    }

    static {
        d.c.h0.a.e(new CallableC0114a());
        f5427a = d.c.h0.a.b(new b());
        f5428b = d.c.h0.a.c(new c());
        j.b();
        d.c.h0.a.d(new d());
    }

    public static t a() {
        return d.c.h0.a.a(f5427a);
    }

    public static t b() {
        return d.c.h0.a.b(f5428b);
    }
}
