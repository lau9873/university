package d.c.f0.d;

import d.c.s;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* loaded from: classes.dex */
public final class i<T> extends AtomicReference<d.c.c0.b> implements s<T>, d.c.c0.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.e0.f<? super T> f4617a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super Throwable> f4618b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.a f4619c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.e0.f<? super d.c.c0.b> f4620d;

    public i(d.c.e0.f<? super T> fVar, d.c.e0.f<? super Throwable> fVar2, d.c.e0.a aVar, d.c.e0.f<? super d.c.c0.b> fVar3) {
        this.f4617a = fVar;
        this.f4618b = fVar2;
        this.f4619c = aVar;
        this.f4620d = fVar3;
    }

    @Override // d.c.s
    public void a(d.c.c0.b bVar) {
        if (d.c.f0.a.b.c(this, bVar)) {
            try {
                this.f4620d.accept(this);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                a(th);
            }
        }
    }

    @Override // d.c.c0.b
    public void b() {
        d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
    }

    @Override // d.c.c0.b
    public boolean c() {
        return get() == d.c.f0.a.b.DISPOSED;
    }

    @Override // d.c.s
    public void a(T t) {
        if (c()) {
            return;
        }
        try {
            this.f4617a.accept(t);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            a(th);
        }
    }

    @Override // d.c.s
    public void a(Throwable th) {
        if (c()) {
            return;
        }
        lazySet(d.c.f0.a.b.DISPOSED);
        try {
            this.f4618b.accept(th);
        } catch (Throwable th2) {
            d.c.d0.a.b(th2);
            d.c.h0.a.b(new CompositeException(th, th2));
        }
    }

    @Override // d.c.s
    public void a() {
        if (c()) {
            return;
        }
        lazySet(d.c.f0.a.b.DISPOSED);
        try {
            this.f4619c.run();
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.h0.a.b(th);
        }
    }
}
