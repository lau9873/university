package d.c.f0.e.e;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: SingleFlatMapIterableFlowable.java */
/* loaded from: classes.dex */
public final class w<T, R> extends d.c.j<R> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.z<T> f5248b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends Iterable<? extends R>> f5249c;

    public w(d.c.z<T> zVar, d.c.e0.n<? super T, ? extends Iterable<? extends R>> nVar) {
        this.f5248b = zVar;
        this.f5249c = nVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super R> cVar) {
        this.f5248b.subscribe(new a(cVar, this.f5249c));
    }

    /* compiled from: SingleFlatMapIterableFlowable.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends d.c.f0.i.a<R> implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super R> f5250a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends Iterable<? extends R>> f5251b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f5252c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public d.c.c0.b f5253d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Iterator<? extends R> f5254e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f5255f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5256g;

        public a(g.b.c<? super R> cVar, d.c.e0.n<? super T, ? extends Iterable<? extends R>> nVar) {
            this.f5250a = cVar;
            this.f5251b = nVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5253d, bVar)) {
                this.f5253d = bVar;
                this.f5250a.a((g.b.d) this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                Iterator<? extends R> it = this.f5251b.a(t).iterator();
                if (!it.hasNext()) {
                    this.f5250a.a();
                    return;
                }
                this.f5254e = it;
                b();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5250a.a(th);
            }
        }

        @Override // g.b.d
        public void cancel() {
            this.f5255f = true;
            this.f5253d.b();
            this.f5253d = d.c.f0.a.b.DISPOSED;
        }

        @Override // d.c.f0.c.n
        public void clear() {
            this.f5254e = null;
        }

        @Override // d.c.f0.c.n
        public boolean isEmpty() {
            return this.f5254e == null;
        }

        @Override // d.c.f0.c.n
        public R poll() {
            Iterator<? extends R> it = this.f5254e;
            if (it != null) {
                R next = it.next();
                d.c.f0.b.b.a(next, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.f5254e = null;
                }
                return next;
            }
            return null;
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5253d = d.c.f0.a.b.DISPOSED;
            this.f5250a.a(th);
        }

        @Override // g.b.d
        public void a(long j) {
            if (d.c.f0.i.g.c(j)) {
                d.c.f0.j.c.a(this.f5252c, j);
                b();
            }
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.b.c<? super R> cVar = this.f5250a;
            Iterator<? extends R> it = this.f5254e;
            if (this.f5256g && it != null) {
                cVar.a((g.b.c<? super R>) null);
                cVar.a();
                return;
            }
            int i2 = 1;
            while (true) {
                if (it != null) {
                    long j = this.f5252c.get();
                    if (j == Long.MAX_VALUE) {
                        a(cVar, it);
                        return;
                    }
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.f5255f) {
                            return;
                        }
                        try {
                            Object obj = (R) it.next();
                            d.c.f0.b.b.a(obj, "The iterator returned a null value");
                            cVar.a((g.b.c<? super R>) obj);
                            if (this.f5255f) {
                                return;
                            }
                            j2++;
                            try {
                                if (!it.hasNext()) {
                                    cVar.a();
                                    return;
                                }
                            } catch (Throwable th) {
                                d.c.d0.a.b(th);
                                cVar.a(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            d.c.d0.a.b(th2);
                            cVar.a(th2);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        d.c.f0.j.c.b(this.f5252c, j2);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (it == null) {
                    it = this.f5254e;
                }
            }
        }

        public void a(g.b.c<? super R> cVar, Iterator<? extends R> it) {
            while (!this.f5255f) {
                try {
                    cVar.a((g.b.c<? super R>) ((R) it.next()));
                    if (this.f5255f) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            cVar.a();
                            return;
                        }
                    } catch (Throwable th) {
                        d.c.d0.a.b(th);
                        cVar.a(th);
                        return;
                    }
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    cVar.a(th2);
                    return;
                }
            }
        }

        @Override // d.c.f0.c.j
        public int a(int i2) {
            if ((i2 & 2) != 0) {
                this.f5256g = true;
                return 2;
            }
            return 0;
        }
    }
}
