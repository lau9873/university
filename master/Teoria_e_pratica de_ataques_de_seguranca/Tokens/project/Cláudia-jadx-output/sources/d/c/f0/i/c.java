package d.c.f0.i;
/* compiled from: DeferredScalarSubscription.java */
/* loaded from: classes.dex */
public class c<T> extends a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final g.b.c<? super T> f5352a;

    /* renamed from: b  reason: collision with root package name */
    public T f5353b;

    public c(g.b.c<? super T> cVar) {
        this.f5352a = cVar;
    }

    @Override // g.b.d
    public final void a(long j) {
        T t;
        if (g.c(j)) {
            do {
                int i2 = get();
                if ((i2 & (-2)) != 0) {
                    return;
                }
                if (i2 == 1) {
                    if (!compareAndSet(1, 3) || (t = this.f5353b) == null) {
                        return;
                    }
                    this.f5353b = null;
                    g.b.c<? super T> cVar = this.f5352a;
                    cVar.a((g.b.c<? super T>) t);
                    if (get() != 4) {
                        cVar.a();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final boolean b() {
        return get() == 4;
    }

    public void cancel() {
        set(4);
        this.f5353b = null;
    }

    @Override // d.c.f0.c.n
    public final void clear() {
        lazySet(32);
        this.f5353b = null;
    }

    public final void d(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & (-3)) != 0) {
                return;
            }
            if (i2 == 2) {
                lazySet(3);
                g.b.c<? super T> cVar = this.f5352a;
                cVar.a((g.b.c<? super T>) t);
                if (get() != 4) {
                    cVar.a();
                    return;
                }
                return;
            }
            this.f5353b = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i2 = get();
            if (i2 == 4) {
                this.f5353b = null;
                return;
            }
        }
        this.f5353b = t;
        lazySet(16);
        g.b.c<? super T> cVar2 = this.f5352a;
        cVar2.a((g.b.c<? super T>) t);
        if (get() != 4) {
            cVar2.a();
        }
    }

    @Override // d.c.f0.c.n
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // d.c.f0.c.n
    public final T poll() {
        if (get() == 16) {
            lazySet(32);
            T t = this.f5353b;
            this.f5353b = null;
            return t;
        }
        return null;
    }

    @Override // d.c.f0.c.j
    public final int a(int i2) {
        if ((i2 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }
}
