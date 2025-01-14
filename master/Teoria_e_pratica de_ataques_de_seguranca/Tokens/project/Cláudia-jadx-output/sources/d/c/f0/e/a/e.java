package d.c.f0.e.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableConcatIterable.java */
/* loaded from: classes.dex */
public final class e extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Iterable<? extends d.c.g> f4666a;

    /* compiled from: CompletableConcatIterable.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicInteger implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4667a;

        /* renamed from: b  reason: collision with root package name */
        public final Iterator<? extends d.c.g> f4668b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c.f0.a.e f4669c = new d.c.f0.a.e();

        public a(d.c.d dVar, Iterator<? extends d.c.g> it) {
            this.f4667a = dVar;
            this.f4668b = it;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4669c.b(bVar);
        }

        public void b() {
            if (!this.f4669c.c() && getAndIncrement() == 0) {
                Iterator<? extends d.c.g> it = this.f4668b;
                while (!this.f4669c.c()) {
                    try {
                        if (!it.hasNext()) {
                            this.f4667a.a();
                            return;
                        }
                        try {
                            d.c.g next = it.next();
                            d.c.f0.b.b.a(next, "The CompletableSource returned is null");
                            next.subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            d.c.d0.a.b(th);
                            this.f4667a.a(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        d.c.d0.a.b(th2);
                        this.f4667a.a(th2);
                        return;
                    }
                }
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4667a.a(th);
        }

        @Override // d.c.d
        public void a() {
            b();
        }
    }

    public e(Iterable<? extends d.c.g> iterable) {
        this.f4666a = iterable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        try {
            Iterator<? extends d.c.g> it = this.f4666a.iterator();
            d.c.f0.b.b.a(it, "The iterator returned is null");
            a aVar = new a(dVar, it);
            dVar.a(aVar.f4669c);
            aVar.b();
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.a.c.a(th, dVar);
        }
    }
}
