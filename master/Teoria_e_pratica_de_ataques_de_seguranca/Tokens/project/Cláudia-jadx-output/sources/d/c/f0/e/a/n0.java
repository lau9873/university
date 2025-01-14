package d.c.f0.e.a;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableUsing.java */
/* loaded from: classes.dex */
public final class n0<R> extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<R> f4752a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super R, ? extends d.c.g> f4753b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.f<? super R> f4754c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4755d;

    public n0(Callable<R> callable, d.c.e0.n<? super R, ? extends d.c.g> nVar, d.c.e0.f<? super R> fVar, boolean z) {
        this.f4752a = callable;
        this.f4753b = nVar;
        this.f4754c = fVar;
        this.f4755d = z;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        try {
            R call = this.f4752a.call();
            try {
                d.c.g a2 = this.f4753b.a(call);
                d.c.f0.b.b.a(a2, "The completableFunction returned a null CompletableSource");
                a2.subscribe(new a(dVar, call, this.f4754c, this.f4755d));
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                if (this.f4755d) {
                    try {
                        this.f4754c.accept(call);
                    } catch (Throwable th2) {
                        d.c.d0.a.b(th2);
                        d.c.f0.a.c.a(new CompositeException(th, th2), dVar);
                        return;
                    }
                }
                d.c.f0.a.c.a(th, dVar);
                if (this.f4755d) {
                    return;
                }
                try {
                    this.f4754c.accept(call);
                } catch (Throwable th3) {
                    d.c.d0.a.b(th3);
                    d.c.h0.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            d.c.d0.a.b(th4);
            d.c.f0.a.c.a(th4, dVar);
        }
    }

    /* compiled from: CompletableUsing.java */
    /* loaded from: classes.dex */
    public static final class a<R> extends AtomicReference<Object> implements d.c.d, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4756a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.f<? super R> f4757b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4758c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c0.b f4759d;

        public a(d.c.d dVar, R r, d.c.e0.f<? super R> fVar, boolean z) {
            super(r);
            this.f4756a = dVar;
            this.f4757b = fVar;
            this.f4758c = z;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f4759d, bVar)) {
                this.f4759d = bVar;
                this.f4756a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4759d.b();
            this.f4759d = d.c.f0.a.b.DISPOSED;
            d();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4759d.c();
        }

        public void d() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f4757b.accept(andSet);
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    d.c.h0.a.b(th);
                }
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4759d = d.c.f0.a.b.DISPOSED;
            if (this.f4758c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f4757b.accept(andSet);
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f4756a.a(th);
            if (this.f4758c) {
                return;
            }
            d();
        }

        @Override // d.c.d
        public void a() {
            this.f4759d = d.c.f0.a.b.DISPOSED;
            if (this.f4758c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f4757b.accept(andSet);
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    this.f4756a.a(th);
                    return;
                }
            }
            this.f4756a.a();
            if (this.f4758c) {
                return;
            }
            d();
        }
    }
}
