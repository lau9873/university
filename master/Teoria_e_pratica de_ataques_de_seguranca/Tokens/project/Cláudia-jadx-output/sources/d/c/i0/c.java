package d.c.i0;

import d.c.f0.i.g;
import g.b.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: UnicastProcessor.java */
/* loaded from: classes.dex */
public final class c<T> extends d.c.i0.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.f0.f.b<T> f5417b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Runnable> f5418c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5419d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f5420e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<g.b.c<? super T>> f5421f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f5422g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f5423h;

    /* renamed from: i  reason: collision with root package name */
    public final d.c.f0.i.a<T> f5424i;
    public final AtomicLong j;
    public boolean k;

    /* compiled from: UnicastProcessor.java */
    /* loaded from: classes.dex */
    public final class a extends d.c.f0.i.a<T> {
        public a() {
        }

        @Override // d.c.f0.c.j
        public int a(int i2) {
            if ((i2 & 2) != 0) {
                c.this.k = true;
                return 2;
            }
            return 0;
        }

        @Override // g.b.d
        public void cancel() {
            if (c.this.f5422g) {
                return;
            }
            c cVar = c.this;
            cVar.f5422g = true;
            cVar.j();
            c cVar2 = c.this;
            if (cVar2.k || cVar2.f5424i.getAndIncrement() != 0) {
                return;
            }
            c.this.f5417b.clear();
            c.this.f5421f.lazySet(null);
        }

        @Override // d.c.f0.c.n
        public void clear() {
            c.this.f5417b.clear();
        }

        @Override // d.c.f0.c.n
        public boolean isEmpty() {
            return c.this.f5417b.isEmpty();
        }

        @Override // d.c.f0.c.n
        public T poll() {
            return c.this.f5417b.poll();
        }

        @Override // g.b.d
        public void a(long j) {
            if (g.c(j)) {
                d.c.f0.j.c.a(c.this.j, j);
                c.this.k();
            }
        }
    }

    public c(int i2) {
        d.c.f0.b.b.a(i2, "capacityHint");
        this.f5417b = new d.c.f0.f.b<>(i2);
        this.f5418c = new AtomicReference<>();
        this.f5421f = new AtomicReference<>();
        this.f5423h = new AtomicBoolean();
        this.f5424i = new a();
        this.j = new AtomicLong();
    }

    public static <T> c<T> a(int i2) {
        return new c<>(i2);
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        if (!this.f5423h.get() && this.f5423h.compareAndSet(false, true)) {
            cVar.a((d) this.f5424i);
            this.f5421f.set(cVar);
            if (this.f5422g) {
                this.f5421f.lazySet(null);
                return;
            } else {
                k();
                return;
            }
        }
        d.c.f0.i.d.a(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
    }

    public void c(g.b.c<? super T> cVar) {
        d.c.f0.f.b<T> bVar = this.f5417b;
        int i2 = 1;
        while (!this.f5422g) {
            boolean z = this.f5419d;
            cVar.a((g.b.c<? super T>) null);
            if (z) {
                this.f5421f.lazySet(null);
                Throwable th = this.f5420e;
                if (th != null) {
                    cVar.a(th);
                    return;
                } else {
                    cVar.a();
                    return;
                }
            }
            i2 = this.f5424i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        bVar.clear();
        this.f5421f.lazySet(null);
    }

    public void d(g.b.c<? super T> cVar) {
        int i2;
        d.c.f0.f.b<T> bVar = this.f5417b;
        int i3 = 1;
        do {
            long j = this.j.get();
            long j2 = 0;
            while (true) {
                i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
                boolean z = this.f5419d;
                T poll = bVar.poll();
                boolean z2 = poll == null;
                if (a(z, z2, cVar, bVar)) {
                    return;
                }
                if (z2) {
                    break;
                }
                cVar.a((g.b.c<? super T>) poll);
                j2++;
            }
            if (i2 == 0 && a(this.f5419d, bVar.isEmpty(), cVar, bVar)) {
                return;
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.j.addAndGet(-j2);
            }
            i3 = this.f5424i.addAndGet(-i3);
        } while (i3 != 0);
    }

    public void j() {
        Runnable runnable = this.f5418c.get();
        if (runnable == null || !this.f5418c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void k() {
        if (this.f5424i.getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        g.b.c<? super T> cVar = this.f5421f.get();
        while (cVar == null) {
            i2 = this.f5424i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            cVar = this.f5421f.get();
        }
        if (this.k) {
            c(cVar);
        } else {
            d(cVar);
        }
    }

    public boolean a(boolean z, boolean z2, g.b.c<? super T> cVar, d.c.f0.f.b<T> bVar) {
        if (this.f5422g) {
            bVar.clear();
            this.f5421f.lazySet(null);
            return true;
        } else if (z && z2) {
            Throwable th = this.f5420e;
            this.f5421f.lazySet(null);
            if (th != null) {
                cVar.a(th);
            } else {
                cVar.a();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // g.b.c
    public void a(d dVar) {
        if (!this.f5419d && !this.f5422g) {
            dVar.a(Long.MAX_VALUE);
        } else {
            dVar.cancel();
        }
    }

    @Override // g.b.c
    public void a(T t) {
        if (this.f5419d || this.f5422g) {
            return;
        }
        if (t == null) {
            a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.f5417b.offer(t);
        k();
    }

    @Override // g.b.c
    public void a(Throwable th) {
        if (!this.f5419d && !this.f5422g) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f5420e = th;
            this.f5419d = true;
            j();
            k();
            return;
        }
        d.c.h0.a.b(th);
    }

    @Override // g.b.c
    public void a() {
        if (this.f5419d || this.f5422g) {
            return;
        }
        this.f5419d = true;
        j();
        k();
    }
}
