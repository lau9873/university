package d.c.g0;

import d.c.d;
import d.c.f0.c.i;
import d.c.m;
import d.c.s;
import d.c.w;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: TestObserver.java */
/* loaded from: classes.dex */
public class c<T> extends d.c.g0.a<T, c<T>> implements s<T>, d.c.c0.b, m<T>, w<T>, d {

    /* renamed from: h  reason: collision with root package name */
    public final s<? super T> f5400h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference<d.c.c0.b> f5401i;
    public i<T> j;

    /* compiled from: TestObserver.java */
    /* loaded from: classes.dex */
    public enum a implements s<Object> {
        INSTANCE;

        @Override // d.c.s
        public void a() {
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
        }

        @Override // d.c.s
        public void a(Object obj) {
        }

        @Override // d.c.s
        public void a(Throwable th) {
        }
    }

    public c() {
        this(a.INSTANCE);
    }

    @Override // d.c.s
    public void a(d.c.c0.b bVar) {
        Thread.currentThread();
        if (bVar == null) {
            this.f5389c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f5401i.compareAndSet(null, bVar)) {
            bVar.b();
            if (this.f5401i.get() != d.c.f0.a.b.DISPOSED) {
                this.f5389c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
            }
        } else {
            int i2 = this.f5392f;
            if (i2 != 0 && (bVar instanceof i)) {
                this.j = (i) bVar;
                int a2 = this.j.a(i2);
                this.f5393g = a2;
                if (a2 == 1) {
                    this.f5391e = true;
                    Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.j.poll();
                            if (poll != null) {
                                this.f5388b.add(poll);
                            } else {
                                this.f5390d++;
                                this.f5401i.lazySet(d.c.f0.a.b.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.f5389c.add(th);
                            return;
                        }
                    }
                }
            }
            this.f5400h.a(bVar);
        }
    }

    @Override // d.c.c0.b
    public final void b() {
        d.c.f0.a.b.a(this.f5401i);
    }

    @Override // d.c.c0.b
    public final boolean c() {
        return d.c.f0.a.b.a(this.f5401i.get());
    }

    public final void d() {
        b();
    }

    public c(s<? super T> sVar) {
        this.f5401i = new AtomicReference<>();
        this.f5400h = sVar;
    }

    @Override // d.c.w
    public void b(T t) {
        a((c<T>) t);
        a();
    }

    @Override // d.c.s
    public void a(T t) {
        if (!this.f5391e) {
            this.f5391e = true;
            if (this.f5401i.get() == null) {
                this.f5389c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.f5393g != 2) {
            this.f5388b.add(t);
            if (t == null) {
                this.f5389c.add(new NullPointerException("onNext received a null value"));
            }
            this.f5400h.a((s<? super T>) t);
            return;
        }
        while (true) {
            try {
                T poll = this.j.poll();
                if (poll == null) {
                    return;
                }
                this.f5388b.add(poll);
            } catch (Throwable th) {
                this.f5389c.add(th);
                return;
            }
        }
    }

    @Override // d.c.s
    public void a(Throwable th) {
        if (!this.f5391e) {
            this.f5391e = true;
            if (this.f5401i.get() == null) {
                this.f5389c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th == null) {
                this.f5389c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f5389c.add(th);
            }
            this.f5400h.a(th);
        } finally {
            this.f5387a.countDown();
        }
    }

    @Override // d.c.s
    public void a() {
        if (!this.f5391e) {
            this.f5391e = true;
            if (this.f5401i.get() == null) {
                this.f5389c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.f5390d++;
            this.f5400h.a();
        } finally {
            this.f5387a.countDown();
        }
    }
}
