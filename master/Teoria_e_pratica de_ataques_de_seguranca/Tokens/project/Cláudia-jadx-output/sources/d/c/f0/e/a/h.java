package d.c.f0.e.a;

import java.util.concurrent.TimeUnit;
/* compiled from: CompletableDelay.java */
/* loaded from: classes.dex */
public final class h extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4693a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4694b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f4695c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.t f4696d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4697e;

    /* compiled from: CompletableDelay.java */
    /* loaded from: classes.dex */
    public class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f4698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4699b;

        /* compiled from: CompletableDelay.java */
        /* renamed from: d.c.f0.e.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0099a implements Runnable {
            public RunnableC0099a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f4699b.a();
            }
        }

        /* compiled from: CompletableDelay.java */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Throwable f4702a;

            public b(Throwable th) {
                this.f4702a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f4699b.a(this.f4702a);
            }
        }

        public a(d.c.c0.a aVar, d.c.d dVar) {
            this.f4698a = aVar;
            this.f4699b = dVar;
        }

        @Override // d.c.d
        public void a() {
            d.c.c0.a aVar = this.f4698a;
            d.c.t tVar = h.this.f4696d;
            RunnableC0099a runnableC0099a = new RunnableC0099a();
            h hVar = h.this;
            aVar.c(tVar.a(runnableC0099a, hVar.f4694b, hVar.f4695c));
        }

        @Override // d.c.d
        public void a(Throwable th) {
            d.c.c0.a aVar = this.f4698a;
            d.c.t tVar = h.this.f4696d;
            b bVar = new b(th);
            h hVar = h.this;
            aVar.c(tVar.a(bVar, hVar.f4697e ? hVar.f4694b : 0L, h.this.f4695c));
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4698a.c(bVar);
            this.f4699b.a(this.f4698a);
        }
    }

    public h(d.c.g gVar, long j, TimeUnit timeUnit, d.c.t tVar, boolean z) {
        this.f4693a = gVar;
        this.f4694b = j;
        this.f4695c = timeUnit;
        this.f4696d = tVar;
        this.f4697e = z;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4693a.subscribe(new a(new d.c.c0.a(), dVar));
    }
}
