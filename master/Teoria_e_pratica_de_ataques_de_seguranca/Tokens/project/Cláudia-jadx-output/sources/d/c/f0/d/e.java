package d.c.f0.d;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CallbackCompletableObserver.java */
/* loaded from: classes.dex */
public final class e extends AtomicReference<d.c.c0.b> implements d.c.d, d.c.c0.b, d.c.e0.f<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.e0.f<? super Throwable> f4610a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.a f4611b;

    public e(d.c.e0.a aVar) {
        this.f4610a = this;
        this.f4611b = aVar;
    }

    @Override // d.c.d
    public void a() {
        try {
            this.f4611b.run();
            lazySet(d.c.f0.a.b.DISPOSED);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            a(th);
        }
    }

    @Override // d.c.e0.f
    /* renamed from: b */
    public void accept(Throwable th) {
        d.c.h0.a.b(new OnErrorNotImplementedException(th));
    }

    @Override // d.c.c0.b
    public boolean c() {
        return get() == d.c.f0.a.b.DISPOSED;
    }

    @Override // d.c.c0.b
    public void b() {
        d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
    }

    public e(d.c.e0.f<? super Throwable> fVar, d.c.e0.a aVar) {
        this.f4610a = fVar;
        this.f4611b = aVar;
    }

    @Override // d.c.d
    public void a(Throwable th) {
        try {
            this.f4610a.accept(th);
        } catch (Throwable th2) {
            d.c.d0.a.b(th2);
            d.c.h0.a.b(th2);
        }
        lazySet(d.c.f0.a.b.DISPOSED);
    }

    @Override // d.c.d
    public void a(d.c.c0.b bVar) {
        d.c.f0.a.b.c(this, bVar);
    }
}
