package d.c.f0.e.b;
/* compiled from: FlowableFromArray.java */
/* loaded from: classes.dex */
public final class i<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T[] f4874b;

    /* compiled from: FlowableFromArray.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends c<T> {

        /* renamed from: d  reason: collision with root package name */
        public final d.c.f0.c.a<? super T> f4875d;

        public a(d.c.f0.c.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.f4875d = aVar;
        }

        @Override // d.c.f0.e.b.i.c
        public void a() {
            T[] tArr = this.f4877a;
            int length = tArr.length;
            d.c.f0.c.a<? super T> aVar = this.f4875d;
            for (int i2 = this.f4878b; i2 != length; i2++) {
                if (this.f4879c) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    aVar.a((Throwable) new NullPointerException("array element is null"));
                    return;
                }
                aVar.c(t);
            }
            if (this.f4879c) {
                return;
            }
            aVar.a();
        }

        @Override // d.c.f0.e.b.i.c
        public void b(long j) {
            T[] tArr = this.f4877a;
            int length = tArr.length;
            int i2 = this.f4878b;
            d.c.f0.c.a<? super T> aVar = this.f4875d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 == length) {
                            if (this.f4879c) {
                                return;
                            }
                            aVar.a();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f4878b = i2;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f4879c) {
                        return;
                    } else {
                        T t = tArr[i2];
                        if (t == null) {
                            aVar.a((Throwable) new NullPointerException("array element is null"));
                            return;
                        }
                        if (aVar.c(t)) {
                            j3++;
                        }
                        i2++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends c<T> {

        /* renamed from: d  reason: collision with root package name */
        public final g.b.c<? super T> f4876d;

        public b(g.b.c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.f4876d = cVar;
        }

        @Override // d.c.f0.e.b.i.c
        public void a() {
            T[] tArr = this.f4877a;
            int length = tArr.length;
            g.b.c<? super T> cVar = this.f4876d;
            for (int i2 = this.f4878b; i2 != length; i2++) {
                if (this.f4879c) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    cVar.a((Throwable) new NullPointerException("array element is null"));
                    return;
                }
                cVar.a((g.b.c<? super T>) t);
            }
            if (this.f4879c) {
                return;
            }
            cVar.a();
        }

        @Override // d.c.f0.e.b.i.c
        public void b(long j) {
            T[] tArr = this.f4877a;
            int length = tArr.length;
            int i2 = this.f4878b;
            g.b.c<? super T> cVar = this.f4876d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 == length) {
                            if (this.f4879c) {
                                return;
                            }
                            cVar.a();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f4878b = i2;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f4879c) {
                        return;
                    } else {
                        T t = tArr[i2];
                        if (t == null) {
                            cVar.a((Throwable) new NullPointerException("array element is null"));
                            return;
                        }
                        cVar.a((g.b.c<? super T>) t);
                        j3++;
                        i2++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* loaded from: classes.dex */
    public static abstract class c<T> extends d.c.f0.i.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T[] f4877a;

        /* renamed from: b  reason: collision with root package name */
        public int f4878b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f4879c;

        public c(T[] tArr) {
            this.f4877a = tArr;
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
            this.f4879c = true;
        }

        @Override // d.c.f0.c.n
        public final void clear() {
            this.f4878b = this.f4877a.length;
        }

        @Override // d.c.f0.c.n
        public final boolean isEmpty() {
            return this.f4878b == this.f4877a.length;
        }

        @Override // d.c.f0.c.n
        public final T poll() {
            int i2 = this.f4878b;
            T[] tArr = this.f4877a;
            if (i2 == tArr.length) {
                return null;
            }
            this.f4878b = i2 + 1;
            T t = tArr[i2];
            d.c.f0.b.b.a((Object) t, "array element is null");
            return t;
        }
    }

    public i(T[] tArr) {
        this.f4874b = tArr;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        if (cVar instanceof d.c.f0.c.a) {
            cVar.a((g.b.d) new a((d.c.f0.c.a) cVar, this.f4874b));
        } else {
            cVar.a((g.b.d) new b(cVar, this.f4874b));
        }
    }
}
