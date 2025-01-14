package d.c.f0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: FlowableOnBackpressureBuffer.java */
/* loaded from: classes.dex */
public final class o<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final int f4894c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4895d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4896e;

    /* renamed from: f  reason: collision with root package name */
    public final d.c.e0.a f4897f;

    public o(d.c.j<T> jVar, int i2, boolean z, boolean z2, d.c.e0.a aVar) {
        super(jVar);
        this.f4894c = i2;
        this.f4895d = z;
        this.f4896e = z2;
        this.f4897f = aVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4795b.a((d.c.k) new a(cVar, this.f4894c, this.f4895d, this.f4896e, this.f4897f));
    }

    /* compiled from: FlowableOnBackpressureBuffer.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends d.c.f0.i.a<T> implements d.c.k<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4898a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.c.m<T> f4899b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4900c;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.e0.a f4901d;

        /* renamed from: e  reason: collision with root package name */
        public g.b.d f4902e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f4903f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f4904g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f4905h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f4906i = new AtomicLong();
        public boolean j;

        public a(g.b.c<? super T> cVar, int i2, boolean z, boolean z2, d.c.e0.a aVar) {
            d.c.f0.c.m<T> aVar2;
            this.f4898a = cVar;
            this.f4901d = aVar;
            this.f4900c = z2;
            if (z) {
                aVar2 = new d.c.f0.f.b<>(i2);
            } else {
                aVar2 = new d.c.f0.f.a<>(i2);
            }
            this.f4899b = aVar2;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4902e, dVar)) {
                this.f4902e = dVar;
                this.f4898a.a((g.b.d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        public void b() {
            int i2;
            if (getAndIncrement() == 0) {
                d.c.f0.c.m<T> mVar = this.f4899b;
                g.b.c<? super T> cVar = this.f4898a;
                int i3 = 1;
                while (!a(this.f4904g, mVar.isEmpty(), cVar)) {
                    long j = this.f4906i.get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.f4904g;
                        Object obj = (T) mVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.a((g.b.c<? super T>) obj);
                        j2++;
                    }
                    if (i2 == 0 && a(this.f4904g, mVar.isEmpty(), cVar)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.f4906i.addAndGet(-j2);
                    }
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.d
        public void cancel() {
            if (this.f4903f) {
                return;
            }
            this.f4903f = true;
            this.f4902e.cancel();
            if (getAndIncrement() == 0) {
                this.f4899b.clear();
            }
        }

        @Override // d.c.f0.c.n
        public void clear() {
            this.f4899b.clear();
        }

        @Override // d.c.f0.c.n
        public boolean isEmpty() {
            return this.f4899b.isEmpty();
        }

        @Override // d.c.f0.c.n
        public T poll() {
            return this.f4899b.poll();
        }

        @Override // g.b.c
        public void a(T t) {
            if (!this.f4899b.offer(t)) {
                this.f4902e.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f4901d.run();
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    missingBackpressureException.initCause(th);
                }
                a((Throwable) missingBackpressureException);
            } else if (this.j) {
                this.f4898a.a((g.b.c<? super T>) null);
            } else {
                b();
            }
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4905h = th;
            this.f4904g = true;
            if (this.j) {
                this.f4898a.a(th);
            } else {
                b();
            }
        }

        @Override // g.b.c
        public void a() {
            this.f4904g = true;
            if (this.j) {
                this.f4898a.a();
            } else {
                b();
            }
        }

        @Override // g.b.d
        public void a(long j) {
            if (this.j || !d.c.f0.i.g.c(j)) {
                return;
            }
            d.c.f0.j.c.a(this.f4906i, j);
            b();
        }

        public boolean a(boolean z, boolean z2, g.b.c<? super T> cVar) {
            if (this.f4903f) {
                this.f4899b.clear();
                return true;
            } else if (z) {
                if (this.f4900c) {
                    if (z2) {
                        Throwable th = this.f4905h;
                        if (th != null) {
                            cVar.a(th);
                        } else {
                            cVar.a();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f4905h;
                if (th2 != null) {
                    this.f4899b.clear();
                    cVar.a(th2);
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

        @Override // d.c.f0.c.j
        public int a(int i2) {
            if ((i2 & 2) != 0) {
                this.j = true;
                return 2;
            }
            return 0;
        }
    }
}
