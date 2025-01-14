package d.c.f0.d;

import d.c.w;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ConsumerSingleObserver.java */
/* loaded from: classes.dex */
public final class f<T> extends AtomicReference<d.c.c0.b> implements w<T>, d.c.c0.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.e0.f<? super T> f4612a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super Throwable> f4613b;

    public f(d.c.e0.f<? super T> fVar, d.c.e0.f<? super Throwable> fVar2) {
        this.f4612a = fVar;
        this.f4613b = fVar2;
    }

    @Override // d.c.w
    public void a(Throwable th) {
        try {
            this.f4613b.accept(th);
        } catch (Throwable th2) {
            d.c.d0.a.b(th2);
            d.c.h0.a.b(new CompositeException(th, th2));
        }
    }

    @Override // d.c.w
    public void b(T t) {
        try {
            this.f4612a.accept(t);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.h0.a.b(th);
        }
    }

    @Override // d.c.c0.b
    public boolean c() {
        return get() == d.c.f0.a.b.DISPOSED;
    }

    @Override // d.c.w
    public void a(d.c.c0.b bVar) {
        d.c.f0.a.b.c(this, bVar);
    }

    @Override // d.c.c0.b
    public void b() {
        d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
    }
}
