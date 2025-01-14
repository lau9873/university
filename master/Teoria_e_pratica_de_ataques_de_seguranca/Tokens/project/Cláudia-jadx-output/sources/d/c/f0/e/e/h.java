package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleDelayWithObservable.java */
/* loaded from: classes.dex */
public final class h<T, U> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5111a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.r<U> f5112b;

    public h(d.c.z<T> zVar, d.c.r<U> rVar) {
        this.f5111a = zVar;
        this.f5112b = rVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5112b.a(new a(wVar, this.f5111a));
    }

    /* compiled from: SingleDelayWithObservable.java */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<d.c.c0.b> implements d.c.s<U>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5113a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.z<T> f5114b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5115c;

        public a(d.c.w<? super T> wVar, d.c.z<T> zVar) {
            this.f5113a = wVar;
            this.f5114b = zVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.b(this, bVar)) {
                this.f5113a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.s
        public void a(U u) {
            get().b();
            a();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.f5115c) {
                d.c.h0.a.b(th);
                return;
            }
            this.f5115c = true;
            this.f5113a.a(th);
        }

        @Override // d.c.s
        public void a() {
            if (this.f5115c) {
                return;
            }
            this.f5115c = true;
            this.f5114b.subscribe(new d.c.f0.d.j(this, this.f5113a));
        }
    }
}
