package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleCreate.java */
/* loaded from: classes.dex */
public final class d<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.x<T> f5080a;

    /* compiled from: SingleCreate.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.v<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5081a;

        public a(d.c.w<? super T> wVar) {
            this.f5081a = wVar;
        }

        public void a(Throwable th) {
            d.c.c0.b andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            d.c.c0.b bVar = get();
            d.c.f0.a.b bVar2 = d.c.f0.a.b.DISPOSED;
            if (bVar != bVar2 && (andSet = getAndSet(bVar2)) != d.c.f0.a.b.DISPOSED) {
                try {
                    this.f5081a.a(th);
                    if (andSet != null) {
                        return;
                    }
                    return;
                } finally {
                    if (andSet != null) {
                        andSet.b();
                    }
                }
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }
    }

    public d(d.c.x<T> xVar) {
        this.f5080a = xVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.a(aVar);
        try {
            this.f5080a.a(aVar);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            aVar.a(th);
        }
    }
}
