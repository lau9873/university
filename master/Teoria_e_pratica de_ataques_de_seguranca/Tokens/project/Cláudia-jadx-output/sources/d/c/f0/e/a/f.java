package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableCreate.java */
/* loaded from: classes.dex */
public final class f extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.e f4674a;

    /* compiled from: CompletableCreate.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.c, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4675a;

        public a(d.c.d dVar) {
            this.f4675a = dVar;
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
                    this.f4675a.a(th);
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

    public f(d.c.e eVar) {
        this.f4674a = eVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        a aVar = new a(dVar);
        dVar.a(aVar);
        try {
            this.f4674a.a(aVar);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            aVar.a(th);
        }
    }
}
