package d.c.f0.e.b;

import java.util.Iterator;
/* compiled from: FlowableFromIterable.java */
/* loaded from: classes.dex */
public final class k<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends T> f4883b;

    /* compiled from: FlowableFromIterable.java */
    /* loaded from: classes.dex */
    public static abstract class a<T> extends d.c.f0.i.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public Iterator<? extends T> f4884a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f4885b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4886c;

        public a(Iterator<? extends T> it) {
            this.f4884a = it;
        }

        @Override // d.c.f0.c.j
        public final int a(int i2) {
            return i2 & 1;
        }

        public abstract void a();

        @Override // g.b.d
        public final void a(long j) {
            if (d.c.f0.i.g.c(j) && d.c.f0.j.c.a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j);
                }
            }
        }

        public abstract void b(long j);

        @Override // g.b.d
        public final void cancel() {
            this.f4885b = true;
        }

        @Override // d.c.f0.c.n
        public final void clear() {
            this.f4884a = null;
        }

        @Override // d.c.f0.c.n
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.f4884a;
            return it == null || !it.hasNext();
        }

        @Override // d.c.f0.c.n
        public final T poll() {
            Iterator<? extends T> it = this.f4884a;
            if (it == null) {
                return null;
            }
            if (!this.f4886c) {
                this.f4886c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            T next = this.f4884a.next();
            d.c.f0.b.b.a((Object) next, "Iterator.next() returned a null value");
            return next;
        }
    }

    /* compiled from: FlowableFromIterable.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends a<T> {

        /* renamed from: d  reason: collision with root package name */
        public final d.c.f0.c.a<? super T> f4887d;

        public b(d.c.f0.c.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.f4887d = aVar;
        }

        @Override // d.c.f0.e.b.k.a
        public void a() {
            Iterator<? extends T> it = this.f4884a;
            d.c.f0.c.a<? super T> aVar = this.f4887d;
            while (!this.f4885b) {
                try {
                    Object obj = (T) it.next();
                    if (this.f4885b) {
                        return;
                    }
                    if (obj == null) {
                        aVar.a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.c(obj);
                    if (this.f4885b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f4885b) {
                                return;
                            }
                            aVar.a();
                            return;
                        }
                    } catch (Throwable th) {
                        d.c.d0.a.b(th);
                        aVar.a(th);
                        return;
                    }
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    aVar.a(th2);
                    return;
                }
            }
        }

        @Override // d.c.f0.e.b.k.a
        public void b(long j) {
            Iterator<? extends T> it = this.f4884a;
            d.c.f0.c.a<? super T> aVar = this.f4887d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (this.f4885b) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.f4885b) {
                                return;
                            }
                            if (obj == null) {
                                aVar.a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean c2 = aVar.c(obj);
                            if (this.f4885b) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.f4885b) {
                                        return;
                                    }
                                    aVar.a();
                                    return;
                                } else if (c2) {
                                    j3++;
                                }
                            } catch (Throwable th) {
                                d.c.d0.a.b(th);
                                aVar.a(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            d.c.d0.a.b(th2);
                            aVar.a(th2);
                            return;
                        }
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromIterable.java */
    /* loaded from: classes.dex */
    public static final class c<T> extends a<T> {

        /* renamed from: d  reason: collision with root package name */
        public final g.b.c<? super T> f4888d;

        public c(g.b.c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.f4888d = cVar;
        }

        @Override // d.c.f0.e.b.k.a
        public void a() {
            Iterator<? extends T> it = this.f4884a;
            g.b.c<? super T> cVar = this.f4888d;
            while (!this.f4885b) {
                try {
                    Object obj = (T) it.next();
                    if (this.f4885b) {
                        return;
                    }
                    if (obj == null) {
                        cVar.a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    cVar.a((g.b.c<? super T>) obj);
                    if (this.f4885b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f4885b) {
                                return;
                            }
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

        @Override // d.c.f0.e.b.k.a
        public void b(long j) {
            Iterator<? extends T> it = this.f4884a;
            g.b.c<? super T> cVar = this.f4888d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (this.f4885b) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.f4885b) {
                                return;
                            }
                            if (obj == null) {
                                cVar.a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            cVar.a((g.b.c<? super T>) obj);
                            if (this.f4885b) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.f4885b) {
                                        return;
                                    }
                                    cVar.a();
                                    return;
                                }
                                j3++;
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
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }

    public k(Iterable<? extends T> iterable) {
        this.f4883b = iterable;
    }

    public static <T> void a(g.b.c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                d.c.f0.i.d.a(cVar);
            } else if (cVar instanceof d.c.f0.c.a) {
                cVar.a((g.b.d) new b((d.c.f0.c.a) cVar, it));
            } else {
                cVar.a((g.b.d) new c(cVar, it));
            }
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.i.d.a(th, cVar);
        }
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        try {
            a(cVar, this.f4883b.iterator());
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.i.d.a(th, cVar);
        }
    }
}
