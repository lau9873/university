package d.c.f0.e.e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleUsing.java */
/* loaded from: classes.dex */
public final class r0<T, U> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<U> f5210a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super U, ? extends d.c.z<? extends T>> f5211b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.f<? super U> f5212c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5213d;

    public r0(Callable<U> callable, d.c.e0.n<? super U, ? extends d.c.z<? extends T>> nVar, d.c.e0.f<? super U> fVar, boolean z) {
        this.f5210a = callable;
        this.f5211b = nVar;
        this.f5212c = fVar;
        this.f5213d = z;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        try {
            U call = this.f5210a.call();
            try {
                d.c.z<? extends T> a2 = this.f5211b.a(call);
                d.c.f0.b.b.a(a2, "The singleFunction returned a null SingleSource");
                a2.subscribe(new a(wVar, call, this.f5213d, this.f5212c));
            } catch (Throwable th) {
                th = th;
                d.c.d0.a.b(th);
                if (this.f5213d) {
                    try {
                        this.f5212c.accept(call);
                    } catch (Throwable th2) {
                        d.c.d0.a.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                d.c.f0.a.c.a(th, wVar);
                if (this.f5213d) {
                    return;
                }
                try {
                    this.f5212c.accept(call);
                } catch (Throwable th3) {
                    d.c.d0.a.b(th3);
                    d.c.h0.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            d.c.d0.a.b(th4);
            d.c.f0.a.c.a(th4, wVar);
        }
    }

    /* compiled from: SingleUsing.java */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<Object> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5214a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.f<? super U> f5215b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5216c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c0.b f5217d;

        public a(d.c.w<? super T> wVar, U u, boolean z, d.c.e0.f<? super U> fVar) {
            super(u);
            this.f5214a = wVar;
            this.f5216c = z;
            this.f5215b = fVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5217d, bVar)) {
                this.f5217d = bVar;
                this.f5214a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5217d.b();
            this.f5217d = d.c.f0.a.b.DISPOSED;
            a();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5217d.c();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5217d = d.c.f0.a.b.DISPOSED;
            if (this.f5216c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f5215b.accept(andSet);
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f5214a.a(th);
            if (this.f5216c) {
                return;
            }
            a();
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5217d = d.c.f0.a.b.DISPOSED;
            if (this.f5216c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f5215b.accept(andSet);
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    this.f5214a.a(th);
                    return;
                }
            }
            this.f5214a.b(t);
            if (this.f5216c) {
                return;
            }
            a();
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f5215b.accept(andSet);
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    d.c.h0.a.b(th);
                }
            }
        }
    }
}
