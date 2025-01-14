package d.c.g0;

import d.c.f0.j.h;
import d.c.s;
/* compiled from: SerializedObserver.java */
/* loaded from: classes.dex */
public final class b<T> implements s<T>, d.c.c0.b {

    /* renamed from: a  reason: collision with root package name */
    public final s<? super T> f5394a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5395b;

    /* renamed from: c  reason: collision with root package name */
    public d.c.c0.b f5396c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5397d;

    /* renamed from: e  reason: collision with root package name */
    public d.c.f0.j.a<Object> f5398e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5399f;

    public b(s<? super T> sVar) {
        this(sVar, false);
    }

    @Override // d.c.s
    public void a(d.c.c0.b bVar) {
        if (d.c.f0.a.b.a(this.f5396c, bVar)) {
            this.f5396c = bVar;
            this.f5394a.a((d.c.c0.b) this);
        }
    }

    @Override // d.c.c0.b
    public void b() {
        this.f5396c.b();
    }

    @Override // d.c.c0.b
    public boolean c() {
        return this.f5396c.c();
    }

    public void d() {
        d.c.f0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f5398e;
                if (aVar == null) {
                    this.f5397d = false;
                    return;
                }
                this.f5398e = null;
            }
        } while (!aVar.a((s<? super T>) this.f5394a));
    }

    public b(s<? super T> sVar, boolean z) {
        this.f5394a = sVar;
        this.f5395b = z;
    }

    @Override // d.c.s
    public void a(T t) {
        if (this.f5399f) {
            return;
        }
        if (t == null) {
            this.f5396c.b();
            a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f5399f) {
                return;
            }
            if (this.f5397d) {
                d.c.f0.j.a<Object> aVar = this.f5398e;
                if (aVar == null) {
                    aVar = new d.c.f0.j.a<>(4);
                    this.f5398e = aVar;
                }
                h.a(t);
                aVar.a((d.c.f0.j.a<Object>) t);
                return;
            }
            this.f5397d = true;
            this.f5394a.a((s<? super T>) t);
            d();
        }
    }

    @Override // d.c.s
    public void a(Throwable th) {
        if (this.f5399f) {
            d.c.h0.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f5399f) {
                if (this.f5397d) {
                    this.f5399f = true;
                    d.c.f0.j.a<Object> aVar = this.f5398e;
                    if (aVar == null) {
                        aVar = new d.c.f0.j.a<>(4);
                        this.f5398e = aVar;
                    }
                    Object a2 = h.a(th);
                    if (this.f5395b) {
                        aVar.a((d.c.f0.j.a<Object>) a2);
                    } else {
                        aVar.b(a2);
                    }
                    return;
                }
                this.f5399f = true;
                this.f5397d = true;
                z = false;
            }
            if (z) {
                d.c.h0.a.b(th);
            } else {
                this.f5394a.a(th);
            }
        }
    }

    @Override // d.c.s
    public void a() {
        if (this.f5399f) {
            return;
        }
        synchronized (this) {
            if (this.f5399f) {
                return;
            }
            if (this.f5397d) {
                d.c.f0.j.a<Object> aVar = this.f5398e;
                if (aVar == null) {
                    aVar = new d.c.f0.j.a<>(4);
                    this.f5398e = aVar;
                }
                aVar.a((d.c.f0.j.a<Object>) h.b());
                return;
            }
            this.f5399f = true;
            this.f5397d = true;
            this.f5394a.a();
        }
    }
}
