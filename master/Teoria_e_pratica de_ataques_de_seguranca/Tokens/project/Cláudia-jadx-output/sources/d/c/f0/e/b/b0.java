package d.c.f0.e.b;

import d.c.t;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: FlowableSubscribeOn.java */
/* loaded from: classes.dex */
public final class b0<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.t f4807c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4808d;

    public b0(d.c.j<T> jVar, d.c.t tVar, boolean z) {
        super(jVar);
        this.f4807c = tVar;
        this.f4808d = z;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        t.c a2 = this.f4807c.a();
        a aVar = new a(cVar, a2, this.f4795b, this.f4808d);
        cVar.a((g.b.d) aVar);
        a2.a(aVar);
    }

    /* compiled from: FlowableSubscribeOn.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<Thread> implements d.c.k<T>, g.b.d, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4809a;

        /* renamed from: b  reason: collision with root package name */
        public final t.c f4810b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<g.b.d> f4811c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f4812d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4813e;

        /* renamed from: f  reason: collision with root package name */
        public g.b.b<T> f4814f;

        /* compiled from: FlowableSubscribeOn.java */
        /* renamed from: d.c.f0.e.b.b0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0102a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g.b.d f4815a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f4816b;

            public RunnableC0102a(a aVar, g.b.d dVar, long j) {
                this.f4815a = dVar;
                this.f4816b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4815a.a(this.f4816b);
            }
        }

        public a(g.b.c<? super T> cVar, t.c cVar2, g.b.b<T> bVar, boolean z) {
            this.f4809a = cVar;
            this.f4810b = cVar2;
            this.f4814f = bVar;
            this.f4813e = z;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4811c, dVar)) {
                long andSet = this.f4812d.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, dVar);
                }
            }
        }

        @Override // g.b.d
        public void cancel() {
            d.c.f0.i.g.a(this.f4811c);
            this.f4810b.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            g.b.b<T> bVar = this.f4814f;
            this.f4814f = null;
            bVar.a(this);
        }

        @Override // g.b.c
        public void a(T t) {
            this.f4809a.a((g.b.c<? super T>) t);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4809a.a(th);
            this.f4810b.b();
        }

        @Override // g.b.c
        public void a() {
            this.f4809a.a();
            this.f4810b.b();
        }

        @Override // g.b.d
        public void a(long j) {
            if (d.c.f0.i.g.c(j)) {
                g.b.d dVar = this.f4811c.get();
                if (dVar != null) {
                    a(j, dVar);
                    return;
                }
                d.c.f0.j.c.a(this.f4812d, j);
                g.b.d dVar2 = this.f4811c.get();
                if (dVar2 != null) {
                    long andSet = this.f4812d.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, dVar2);
                    }
                }
            }
        }

        public void a(long j, g.b.d dVar) {
            if (!this.f4813e && Thread.currentThread() != get()) {
                this.f4810b.a(new RunnableC0102a(this, dVar, j));
            } else {
                dVar.a(j);
            }
        }
    }
}
