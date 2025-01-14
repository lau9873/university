package d.c.f0.b;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* compiled from: Functions.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d.c.e0.n<Object, Object> f4587a = new t();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f4588b = new RunnableC0095a();

    /* renamed from: c  reason: collision with root package name */
    public static final d.c.e0.a f4589c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final d.c.e0.f<Object> f4590d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final d.c.e0.f<Throwable> f4591e;

    /* renamed from: f  reason: collision with root package name */
    public static final d.c.e0.p<Object> f4592f;

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0095a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class b implements d.c.e0.a {
        @Override // d.c.e0.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class c implements d.c.e0.f<Object> {
        @Override // d.c.e0.f
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class d implements d.c.e0.f<Throwable> {
        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            d.c.h0.a.b(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class e implements d.c.e0.f<Throwable> {
        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            d.c.h0.a.b(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class f implements d.c.e0.o {
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class g implements d.c.e0.p<Object> {
        @Override // d.c.e0.p
        public boolean a(Object obj) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class h implements d.c.e0.p<Object> {
        @Override // d.c.e0.p
        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class i implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class j implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class k implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.c f4593a;

        public k(d.c.e0.c cVar) {
            this.f4593a = cVar;
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f4593a.a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class l implements d.c.e0.f<g.b.d> {
        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(g.b.d dVar) {
            dVar.a(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class m implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.g f4594a;

        public m(d.c.e0.g gVar) {
            this.f4594a = gVar;
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 3) {
                return this.f4594a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class n implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.h f4595a;

        public n(d.c.e0.h hVar) {
            this.f4595a = hVar;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 4) {
                return this.f4595a.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class o implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.i f4596a;

        public o(d.c.e0.i iVar) {
            this.f4596a = iVar;
        }

        /* JADX WARN: Type inference failed for: r9v3, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 5) {
                return this.f4596a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class p implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.j f4597a;

        public p(d.c.e0.j jVar) {
            this.f4597a = jVar;
        }

        /* JADX WARN: Type inference failed for: r10v3, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 6) {
                return this.f4597a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class q implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.k f4598a;

        public q(d.c.e0.k kVar) {
            this.f4598a = kVar;
        }

        /* JADX WARN: Type inference failed for: r11v3, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 7) {
                return this.f4598a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class r implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.l f4599a;

        public r(d.c.e0.l lVar) {
            this.f4599a = lVar;
        }

        /* JADX WARN: Type inference failed for: r12v3, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 8) {
                return this.f4599a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class s implements d.c.e0.n<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.e0.m f4600a;

        public s(d.c.e0.m mVar) {
            this.f4600a = mVar;
        }

        /* JADX WARN: Type inference failed for: r13v3, types: [R, java.lang.Object] */
        @Override // d.c.e0.n
        public R a(Object[] objArr) {
            if (objArr.length == 9) {
                return this.f4600a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class t implements d.c.e0.n<Object, Object> {
        @Override // d.c.e0.n
        public Object a(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static final class u<T, U> implements d.c.e0.n<T, U> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<U> f4601a;

        public u(Class<U> cls) {
            this.f4601a = cls;
        }

        @Override // d.c.e0.n
        public U a(T t) {
            return this.f4601a.cast(t);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static final class v implements d.c.e0.a {

        /* renamed from: a  reason: collision with root package name */
        public final Future<?> f4602a;

        public v(Future<?> future) {
            this.f4602a = future;
        }

        @Override // d.c.e0.a
        public void run() {
            this.f4602a.get();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static final class w<T, U> implements Callable<U>, d.c.e0.n<T, U> {

        /* renamed from: a  reason: collision with root package name */
        public final U f4603a;

        public w(U u) {
            this.f4603a = u;
        }

        @Override // d.c.e0.n
        public U a(T t) {
            return this.f4603a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.f4603a;
        }
    }

    static {
        new d();
        f4591e = new e();
        new f();
        f4592f = new g();
        new h();
        new i();
        new j();
        new l();
    }

    public static <T1, T2, R> d.c.e0.n<Object[], R> a(d.c.e0.c<? super T1, ? super T2, ? extends R> cVar) {
        d.c.f0.b.b.a(cVar, "f is null");
        return new k(cVar);
    }

    public static <T> d.c.e0.f<T> b() {
        return (d.c.e0.f<T>) f4590d;
    }

    public static <T> d.c.e0.n<T, T> c() {
        return (d.c.e0.n<T, T>) f4587a;
    }

    public static <T, U> d.c.e0.n<T, U> b(U u2) {
        return new w(u2);
    }

    public static <T1, T2, T3, R> d.c.e0.n<Object[], R> a(d.c.e0.g<T1, T2, T3, R> gVar) {
        d.c.f0.b.b.a(gVar, "f is null");
        return new m(gVar);
    }

    public static <T1, T2, T3, T4, R> d.c.e0.n<Object[], R> a(d.c.e0.h<T1, T2, T3, T4, R> hVar) {
        d.c.f0.b.b.a(hVar, "f is null");
        return new n(hVar);
    }

    public static <T1, T2, T3, T4, T5, R> d.c.e0.n<Object[], R> a(d.c.e0.i<T1, T2, T3, T4, T5, R> iVar) {
        d.c.f0.b.b.a(iVar, "f is null");
        return new o(iVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> d.c.e0.n<Object[], R> a(d.c.e0.j<T1, T2, T3, T4, T5, T6, R> jVar) {
        d.c.f0.b.b.a(jVar, "f is null");
        return new p(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> d.c.e0.n<Object[], R> a(d.c.e0.k<T1, T2, T3, T4, T5, T6, T7, R> kVar) {
        d.c.f0.b.b.a(kVar, "f is null");
        return new q(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d.c.e0.n<Object[], R> a(d.c.e0.l<T1, T2, T3, T4, T5, T6, T7, T8, R> lVar) {
        d.c.f0.b.b.a(lVar, "f is null");
        return new r(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d.c.e0.n<Object[], R> a(d.c.e0.m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mVar) {
        d.c.f0.b.b.a(mVar, "f is null");
        return new s(mVar);
    }

    public static <T> d.c.e0.p<T> a() {
        return (d.c.e0.p<T>) f4592f;
    }

    public static d.c.e0.a a(Future<?> future) {
        return new v(future);
    }

    public static <T> Callable<T> a(T t2) {
        return new w(t2);
    }

    public static <T, U> d.c.e0.n<T, U> a(Class<U> cls) {
        return new u(cls);
    }
}
