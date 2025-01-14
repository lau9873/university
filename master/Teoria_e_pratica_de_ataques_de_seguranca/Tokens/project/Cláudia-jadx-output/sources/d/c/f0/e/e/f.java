package d.c.f0.e.e;

import java.util.concurrent.TimeUnit;
/* compiled from: SingleDelay.java */
/* loaded from: classes.dex */
public final class f<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5090a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5091b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f5092c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.t f5093d;

    /* compiled from: SingleDelay.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.f0.a.e f5094a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5095b;

        /* compiled from: SingleDelay.java */
        /* renamed from: d.c.f0.e.e.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0109a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f5097a;

            public RunnableC0109a(Object obj) {
                this.f5097a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                a.this.f5095b.b(this.f5097a);
            }
        }

        /* compiled from: SingleDelay.java */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Throwable f5099a;

            public b(Throwable th) {
                this.f5099a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f5095b.a(this.f5099a);
            }
        }

        public a(d.c.f0.a.e eVar, d.c.w wVar) {
            this.f5094a = eVar;
            this.f5095b = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5094a.a(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            d.c.f0.a.e eVar = this.f5094a;
            d.c.t tVar = f.this.f5093d;
            RunnableC0109a runnableC0109a = new RunnableC0109a(t);
            f fVar = f.this;
            eVar.a(tVar.a(runnableC0109a, fVar.f5091b, fVar.f5092c));
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5094a.a(f.this.f5093d.a(new b(th), 0L, f.this.f5092c));
        }
    }

    public f(d.c.z<? extends T> zVar, long j, TimeUnit timeUnit, d.c.t tVar) {
        this.f5090a = zVar;
        this.f5091b = j;
        this.f5092c = timeUnit;
        this.f5093d = tVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        d.c.f0.a.e eVar = new d.c.f0.a.e();
        wVar.a(eVar);
        this.f5090a.subscribe(new a(eVar, wVar));
    }
}
