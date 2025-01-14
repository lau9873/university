package d.c.f0.e.b;

import java.util.concurrent.Callable;
/* compiled from: FlowableScalarXMap.java */
/* loaded from: classes.dex */
public final class y {

    /* compiled from: FlowableScalarXMap.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends d.c.j<R> {

        /* renamed from: b  reason: collision with root package name */
        public final T f4953b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends g.b.b<? extends R>> f4954c;

        public a(T t, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar) {
            this.f4953b = t;
            this.f4954c = nVar;
        }

        @Override // d.c.j
        public void b(g.b.c<? super R> cVar) {
            try {
                g.b.b<? extends R> a2 = this.f4954c.a((T) this.f4953b);
                d.c.f0.b.b.a(a2, "The mapper returned a null Publisher");
                g.b.b<? extends R> bVar = a2;
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call == null) {
                            d.c.f0.i.d.a(cVar);
                            return;
                        } else {
                            cVar.a((g.b.d) new d.c.f0.i.e(cVar, call));
                            return;
                        }
                    } catch (Throwable th) {
                        d.c.d0.a.b(th);
                        d.c.f0.i.d.a(th, cVar);
                        return;
                    }
                }
                bVar.a(cVar);
            } catch (Throwable th2) {
                d.c.f0.i.d.a(th2, cVar);
            }
        }
    }

    public static <T, R> boolean a(g.b.b<T> bVar, g.b.c<? super R> cVar, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar) {
        if (bVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) bVar).call();
                if (obj == 0) {
                    d.c.f0.i.d.a(cVar);
                    return true;
                }
                try {
                    g.b.b<? extends R> a2 = nVar.a(obj);
                    d.c.f0.b.b.a(a2, "The mapper returned a null Publisher");
                    g.b.b<? extends R> bVar2 = a2;
                    if (bVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) bVar2).call();
                            if (call == null) {
                                d.c.f0.i.d.a(cVar);
                                return true;
                            }
                            cVar.a((g.b.d) new d.c.f0.i.e(cVar, call));
                        } catch (Throwable th) {
                            d.c.d0.a.b(th);
                            d.c.f0.i.d.a(th, cVar);
                            return true;
                        }
                    } else {
                        bVar2.a(cVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    d.c.f0.i.d.a(th2, cVar);
                    return true;
                }
            } catch (Throwable th3) {
                d.c.d0.a.b(th3);
                d.c.f0.i.d.a(th3, cVar);
                return true;
            }
        }
        return false;
    }

    public static <T, U> d.c.j<U> a(T t, d.c.e0.n<? super T, ? extends g.b.b<? extends U>> nVar) {
        return d.c.h0.a.a(new a(t, nVar));
    }
}
