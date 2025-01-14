package d.c.f0.e.e;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleTakeUntil.java */
/* loaded from: classes.dex */
public final class m0<T, U> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5162a;

    /* renamed from: b  reason: collision with root package name */
    public final g.b.b<U> f5163b;

    /* compiled from: SingleTakeUntil.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5164a;

        /* renamed from: b  reason: collision with root package name */
        public final b f5165b = new b(this);

        public a(d.c.w<? super T> wVar) {
            this.f5164a = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this, bVar);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5165b.b();
            d.c.c0.b bVar = get();
            d.c.f0.a.b bVar2 = d.c.f0.a.b.DISPOSED;
            if (bVar != bVar2 && getAndSet(bVar2) != d.c.f0.a.b.DISPOSED) {
                this.f5164a.a(th);
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5165b.b();
            d.c.c0.b bVar = get();
            d.c.f0.a.b bVar2 = d.c.f0.a.b.DISPOSED;
            if (bVar == bVar2 || getAndSet(bVar2) == d.c.f0.a.b.DISPOSED) {
                return;
            }
            this.f5164a.b(t);
        }

        public void b(Throwable th) {
            d.c.c0.b andSet;
            d.c.c0.b bVar = get();
            d.c.f0.a.b bVar2 = d.c.f0.a.b.DISPOSED;
            if (bVar != bVar2 && (andSet = getAndSet(bVar2)) != d.c.f0.a.b.DISPOSED) {
                if (andSet != null) {
                    andSet.b();
                }
                this.f5164a.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }
    }

    public m0(d.c.z<T> zVar, g.b.b<U> bVar) {
        this.f5162a = zVar;
        this.f5163b = bVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.a(aVar);
        this.f5163b.a(aVar.f5165b);
        this.f5162a.subscribe(aVar);
    }

    /* compiled from: SingleTakeUntil.java */
    /* loaded from: classes.dex */
    public static final class b extends AtomicReference<g.b.d> implements d.c.k<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final a<?> f5166a;

        public b(a<?> aVar) {
            this.f5166a = aVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this, dVar)) {
                dVar.a(Long.MAX_VALUE);
            }
        }

        public void b() {
            d.c.f0.i.g.a(this);
        }

        @Override // g.b.c
        public void a(Object obj) {
            if (d.c.f0.i.g.a(this)) {
                this.f5166a.b((Throwable) new CancellationException());
            }
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f5166a.b(th);
        }

        @Override // g.b.c
        public void a() {
            g.b.d dVar = get();
            d.c.f0.i.g gVar = d.c.f0.i.g.CANCELLED;
            if (dVar != gVar) {
                lazySet(gVar);
                this.f5166a.b((Throwable) new CancellationException());
            }
        }
    }
}
