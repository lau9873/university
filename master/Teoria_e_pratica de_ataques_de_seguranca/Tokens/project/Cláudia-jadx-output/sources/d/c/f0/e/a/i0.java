package d.c.f0.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: CompletableTimeout.java */
/* loaded from: classes.dex */
public final class i0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4715a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4716b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f4717c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.t f4718d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.g f4719e;

    /* compiled from: CompletableTimeout.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f4720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f4721b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4722c;

        /* compiled from: CompletableTimeout.java */
        /* renamed from: d.c.f0.e.a.i0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0100a implements d.c.d {
            public C0100a() {
            }

            @Override // d.c.d
            public void a(d.c.c0.b bVar) {
                a.this.f4721b.c(bVar);
            }

            @Override // d.c.d
            public void a(Throwable th) {
                a.this.f4721b.b();
                a.this.f4722c.a(th);
            }

            @Override // d.c.d
            public void a() {
                a.this.f4721b.b();
                a.this.f4722c.a();
            }
        }

        public a(AtomicBoolean atomicBoolean, d.c.c0.a aVar, d.c.d dVar) {
            this.f4720a = atomicBoolean;
            this.f4721b = aVar;
            this.f4722c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4720a.compareAndSet(false, true)) {
                this.f4721b.a();
                d.c.g gVar = i0.this.f4719e;
                if (gVar == null) {
                    this.f4722c.a(new TimeoutException());
                } else {
                    gVar.subscribe(new C0100a());
                }
            }
        }
    }

    /* compiled from: CompletableTimeout.java */
    /* loaded from: classes.dex */
    public class b implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f4725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f4726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4727c;

        public b(i0 i0Var, d.c.c0.a aVar, AtomicBoolean atomicBoolean, d.c.d dVar) {
            this.f4725a = aVar;
            this.f4726b = atomicBoolean;
            this.f4727c = dVar;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4725a.c(bVar);
        }

        @Override // d.c.d
        public void a(Throwable th) {
            if (this.f4726b.compareAndSet(false, true)) {
                this.f4725a.b();
                this.f4727c.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.d
        public void a() {
            if (this.f4726b.compareAndSet(false, true)) {
                this.f4725a.b();
                this.f4727c.a();
            }
        }
    }

    public i0(d.c.g gVar, long j, TimeUnit timeUnit, d.c.t tVar, d.c.g gVar2) {
        this.f4715a = gVar;
        this.f4716b = j;
        this.f4717c = timeUnit;
        this.f4718d = tVar;
        this.f4719e = gVar2;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.c0.a aVar = new d.c.c0.a();
        dVar.a(aVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        aVar.c(this.f4718d.a(new a(atomicBoolean, aVar, dVar), this.f4716b, this.f4717c));
        this.f4715a.subscribe(new b(this, aVar, atomicBoolean, dVar));
    }
}
