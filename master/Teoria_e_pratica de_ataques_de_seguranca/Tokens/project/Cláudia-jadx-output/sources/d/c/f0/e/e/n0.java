package d.c.f0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: SingleTimeout.java */
/* loaded from: classes.dex */
public final class n0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5171a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5172b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f5173c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.t f5174d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.z<? extends T> f5175e;

    /* compiled from: SingleTimeout.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f5176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f5177b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5178c;

        public a(AtomicBoolean atomicBoolean, d.c.c0.a aVar, d.c.w wVar) {
            this.f5176a = atomicBoolean;
            this.f5177b = aVar;
            this.f5178c = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5176a.compareAndSet(false, true)) {
                if (n0.this.f5175e != null) {
                    this.f5177b.a();
                    n0.this.f5175e.subscribe(new C0110a());
                    return;
                }
                this.f5177b.b();
                this.f5178c.a(new TimeoutException());
            }
        }

        /* compiled from: SingleTimeout.java */
        /* renamed from: d.c.f0.e.e.n0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0110a implements d.c.w<T> {
            public C0110a() {
            }

            @Override // d.c.w
            public void a(Throwable th) {
                a.this.f5177b.b();
                a.this.f5178c.a(th);
            }

            @Override // d.c.w
            public void b(T t) {
                a.this.f5177b.b();
                a.this.f5178c.b(t);
            }

            @Override // d.c.w
            public void a(d.c.c0.b bVar) {
                a.this.f5177b.c(bVar);
            }
        }
    }

    public n0(d.c.z<T> zVar, long j, TimeUnit timeUnit, d.c.t tVar, d.c.z<? extends T> zVar2) {
        this.f5171a = zVar;
        this.f5172b = j;
        this.f5173c = timeUnit;
        this.f5174d = tVar;
        this.f5175e = zVar2;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        d.c.c0.a aVar = new d.c.c0.a();
        wVar.a(aVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        aVar.c(this.f5174d.a(new a(atomicBoolean, aVar, wVar), this.f5172b, this.f5173c));
        this.f5171a.subscribe(new b(this, atomicBoolean, aVar, wVar));
    }

    /* compiled from: SingleTimeout.java */
    /* loaded from: classes.dex */
    public class b implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f5181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f5182b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5183c;

        public b(n0 n0Var, AtomicBoolean atomicBoolean, d.c.c0.a aVar, d.c.w wVar) {
            this.f5181a = atomicBoolean;
            this.f5182b = aVar;
            this.f5183c = wVar;
        }

        @Override // d.c.w
        public void a(Throwable th) {
            if (this.f5181a.compareAndSet(false, true)) {
                this.f5182b.b();
                this.f5183c.a(th);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            if (this.f5181a.compareAndSet(false, true)) {
                this.f5182b.b();
                this.f5183c.b(t);
            }
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5182b.c(bVar);
        }
    }
}
