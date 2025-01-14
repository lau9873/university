package d.c.k0;

import d.c.f0.i.g;
import d.c.f0.j.h;
import d.c.k;
import g.b.c;
import g.b.d;
/* compiled from: SerializedSubscriber.java */
/* loaded from: classes.dex */
public final class a<T> implements k<T>, d {

    /* renamed from: a  reason: collision with root package name */
    public final c<? super T> f5433a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5434b;

    /* renamed from: c  reason: collision with root package name */
    public d f5435c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5436d;

    /* renamed from: e  reason: collision with root package name */
    public d.c.f0.j.a<Object> f5437e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5438f;

    public a(c<? super T> cVar) {
        this(cVar, false);
    }

    @Override // g.b.c
    public void a(d dVar) {
        if (g.a(this.f5435c, dVar)) {
            this.f5435c = dVar;
            this.f5433a.a((d) this);
        }
    }

    public void b() {
        d.c.f0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f5437e;
                if (aVar == null) {
                    this.f5436d = false;
                    return;
                }
                this.f5437e = null;
            }
        } while (!aVar.a((c<? super T>) this.f5433a));
    }

    @Override // g.b.d
    public void cancel() {
        this.f5435c.cancel();
    }

    public a(c<? super T> cVar, boolean z) {
        this.f5433a = cVar;
        this.f5434b = z;
    }

    @Override // g.b.c
    public void a(T t) {
        if (this.f5438f) {
            return;
        }
        if (t == null) {
            this.f5435c.cancel();
            a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f5438f) {
                return;
            }
            if (this.f5436d) {
                d.c.f0.j.a<Object> aVar = this.f5437e;
                if (aVar == null) {
                    aVar = new d.c.f0.j.a<>(4);
                    this.f5437e = aVar;
                }
                h.a(t);
                aVar.a((d.c.f0.j.a<Object>) t);
                return;
            }
            this.f5436d = true;
            this.f5433a.a((c<? super T>) t);
            b();
        }
    }

    @Override // g.b.c
    public void a(Throwable th) {
        if (this.f5438f) {
            d.c.h0.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f5438f) {
                if (this.f5436d) {
                    this.f5438f = true;
                    d.c.f0.j.a<Object> aVar = this.f5437e;
                    if (aVar == null) {
                        aVar = new d.c.f0.j.a<>(4);
                        this.f5437e = aVar;
                    }
                    Object a2 = h.a(th);
                    if (this.f5434b) {
                        aVar.a((d.c.f0.j.a<Object>) a2);
                    } else {
                        aVar.b(a2);
                    }
                    return;
                }
                this.f5438f = true;
                this.f5436d = true;
                z = false;
            }
            if (z) {
                d.c.h0.a.b(th);
            } else {
                this.f5433a.a(th);
            }
        }
    }

    @Override // g.b.c
    public void a() {
        if (this.f5438f) {
            return;
        }
        synchronized (this) {
            if (this.f5438f) {
                return;
            }
            if (this.f5436d) {
                d.c.f0.j.a<Object> aVar = this.f5437e;
                if (aVar == null) {
                    aVar = new d.c.f0.j.a<>(4);
                    this.f5437e = aVar;
                }
                aVar.a((d.c.f0.j.a<Object>) h.b());
                return;
            }
            this.f5438f = true;
            this.f5436d = true;
            this.f5433a.a();
        }
    }

    @Override // g.b.d
    public void a(long j) {
        this.f5435c.a(j);
    }
}
