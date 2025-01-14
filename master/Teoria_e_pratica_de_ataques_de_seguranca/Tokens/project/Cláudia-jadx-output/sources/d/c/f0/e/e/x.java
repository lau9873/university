package d.c.f0.e.e;

import java.util.Iterator;
/* compiled from: SingleFlatMapIterableObservable.java */
/* loaded from: classes.dex */
public final class x<T, R> extends d.c.o<R> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5257a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends Iterable<? extends R>> f5258b;

    public x(d.c.z<T> zVar, d.c.e0.n<? super T, ? extends Iterable<? extends R>> nVar) {
        this.f5257a = zVar;
        this.f5258b = nVar;
    }

    @Override // d.c.o
    public void b(d.c.s<? super R> sVar) {
        this.f5257a.subscribe(new a(sVar, this.f5258b));
    }

    /* compiled from: SingleFlatMapIterableObservable.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends d.c.f0.d.a<R> implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.s<? super R> f5259a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends Iterable<? extends R>> f5260b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f5261c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Iterator<? extends R> f5262d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f5263e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5264f;

        public a(d.c.s<? super R> sVar, d.c.e0.n<? super T, ? extends Iterable<? extends R>> nVar) {
            this.f5259a = sVar;
            this.f5260b = nVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5261c, bVar)) {
                this.f5261c = bVar;
                this.f5259a.a((d.c.c0.b) this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            d.c.s<? super R> sVar = this.f5259a;
            try {
                Iterator<? extends R> it = this.f5260b.a(t).iterator();
                if (!it.hasNext()) {
                    sVar.a();
                } else if (this.f5264f) {
                    this.f5262d = it;
                    sVar.a((d.c.s<? super R>) null);
                    sVar.a();
                } else {
                    while (!this.f5263e) {
                        try {
                            sVar.a((d.c.s<? super R>) ((R) it.next()));
                            if (this.f5263e) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    sVar.a();
                                    return;
                                }
                            } catch (Throwable th) {
                                d.c.d0.a.b(th);
                                sVar.a(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            d.c.d0.a.b(th2);
                            sVar.a(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                d.c.d0.a.b(th3);
                this.f5259a.a(th3);
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5263e;
        }

        @Override // d.c.f0.c.n
        public void clear() {
            this.f5262d = null;
        }

        @Override // d.c.f0.c.n
        public boolean isEmpty() {
            return this.f5262d == null;
        }

        @Override // d.c.f0.c.n
        public R poll() {
            Iterator<? extends R> it = this.f5262d;
            if (it != null) {
                R next = it.next();
                d.c.f0.b.b.a(next, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.f5262d = null;
                }
                return next;
            }
            return null;
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5261c = d.c.f0.a.b.DISPOSED;
            this.f5259a.a(th);
        }

        @Override // d.c.f0.c.j
        public int a(int i2) {
            if ((i2 & 2) != 0) {
                this.f5264f = true;
                return 2;
            }
            return 0;
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5263e = true;
            this.f5261c.b();
            this.f5261c = d.c.f0.a.b.DISPOSED;
        }
    }
}
