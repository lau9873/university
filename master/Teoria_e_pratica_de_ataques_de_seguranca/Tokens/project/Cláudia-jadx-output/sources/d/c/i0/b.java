package d.c.i0;

import d.c.f0.j.h;
import g.b.d;
/* compiled from: SerializedProcessor.java */
/* loaded from: classes.dex */
public final class b<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    public final a<T> f5413b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5414c;

    /* renamed from: d  reason: collision with root package name */
    public d.c.f0.j.a<Object> f5415d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5416e;

    public b(a<T> aVar) {
        this.f5413b = aVar;
    }

    @Override // g.b.c
    public void a(d dVar) {
        boolean z = true;
        if (!this.f5416e) {
            synchronized (this) {
                if (!this.f5416e) {
                    if (this.f5414c) {
                        d.c.f0.j.a<Object> aVar = this.f5415d;
                        if (aVar == null) {
                            aVar = new d.c.f0.j.a<>(4);
                            this.f5415d = aVar;
                        }
                        aVar.a((d.c.f0.j.a<Object>) h.a(dVar));
                        return;
                    }
                    this.f5414c = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
            return;
        }
        this.f5413b.a(dVar);
        j();
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f5413b.a((g.b.c) cVar);
    }

    public void j() {
        d.c.f0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f5415d;
                if (aVar == null) {
                    this.f5414c = false;
                    return;
                }
                this.f5415d = null;
            }
            aVar.a((g.b.c) this.f5413b);
        }
    }

    @Override // g.b.c
    public void a(T t) {
        if (this.f5416e) {
            return;
        }
        synchronized (this) {
            if (this.f5416e) {
                return;
            }
            if (this.f5414c) {
                d.c.f0.j.a<Object> aVar = this.f5415d;
                if (aVar == null) {
                    aVar = new d.c.f0.j.a<>(4);
                    this.f5415d = aVar;
                }
                h.a(t);
                aVar.a((d.c.f0.j.a<Object>) t);
                return;
            }
            this.f5414c = true;
            this.f5413b.a((a<T>) t);
            j();
        }
    }

    @Override // g.b.c
    public void a(Throwable th) {
        boolean z;
        if (this.f5416e) {
            d.c.h0.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f5416e) {
                z = true;
            } else {
                this.f5416e = true;
                if (this.f5414c) {
                    d.c.f0.j.a<Object> aVar = this.f5415d;
                    if (aVar == null) {
                        aVar = new d.c.f0.j.a<>(4);
                        this.f5415d = aVar;
                    }
                    aVar.b(h.a(th));
                    return;
                }
                z = false;
                this.f5414c = true;
            }
            if (z) {
                d.c.h0.a.b(th);
            } else {
                this.f5413b.a(th);
            }
        }
    }

    @Override // g.b.c
    public void a() {
        if (this.f5416e) {
            return;
        }
        synchronized (this) {
            if (this.f5416e) {
                return;
            }
            this.f5416e = true;
            if (this.f5414c) {
                d.c.f0.j.a<Object> aVar = this.f5415d;
                if (aVar == null) {
                    aVar = new d.c.f0.j.a<>(4);
                    this.f5415d = aVar;
                }
                aVar.a((d.c.f0.j.a<Object>) h.b());
                return;
            }
            this.f5414c = true;
            this.f5413b.a();
        }
    }
}
