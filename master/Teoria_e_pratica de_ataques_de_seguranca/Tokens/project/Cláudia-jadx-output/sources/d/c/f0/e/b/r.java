package d.c.f0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes.dex */
public final class r<T> extends d.c.f0.e.b.a<T, T> {
    public r(d.c.j<T> jVar) {
        super(jVar);
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4795b.a((d.c.k) new a(cVar));
    }

    /* compiled from: FlowableOnBackpressureLatest.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.k<T>, g.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4915a;

        /* renamed from: b  reason: collision with root package name */
        public g.b.d f4916b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f4917c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f4918d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f4919e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f4920f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<T> f4921g = new AtomicReference<>();

        public a(g.b.c<? super T> cVar) {
            this.f4915a = cVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4916b, dVar)) {
                this.f4916b = dVar;
                this.f4915a.a((g.b.d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.b.c<? super T> cVar = this.f4915a;
            AtomicLong atomicLong = this.f4920f;
            AtomicReference<T> atomicReference = this.f4921g;
            int i2 = 1;
            do {
                long j = 0;
                while (true) {
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.f4917c;
                    Object obj = (T) atomicReference.getAndSet(null);
                    boolean z2 = obj == null;
                    if (a(z, z2, cVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.a((g.b.c<? super T>) obj);
                    j++;
                }
                if (j == atomicLong.get()) {
                    if (a(this.f4917c, atomicReference.get() == null, cVar, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    d.c.f0.j.c.b(atomicLong, j);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // g.b.d
        public void cancel() {
            if (this.f4919e) {
                return;
            }
            this.f4919e = true;
            this.f4916b.cancel();
            if (getAndIncrement() == 0) {
                this.f4921g.lazySet(null);
            }
        }

        @Override // g.b.c
        public void a(T t) {
            this.f4921g.lazySet(t);
            b();
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4918d = th;
            this.f4917c = true;
            b();
        }

        @Override // g.b.c
        public void a() {
            this.f4917c = true;
            b();
        }

        @Override // g.b.d
        public void a(long j) {
            if (d.c.f0.i.g.c(j)) {
                d.c.f0.j.c.a(this.f4920f, j);
                b();
            }
        }

        public boolean a(boolean z, boolean z2, g.b.c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.f4919e) {
                atomicReference.lazySet(null);
                return true;
            } else if (z) {
                Throwable th = this.f4918d;
                if (th != null) {
                    atomicReference.lazySet(null);
                    cVar.a(th);
                    return true;
                } else if (z2) {
                    cVar.a();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
