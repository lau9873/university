package d.c.f0.d;

import d.c.w;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: FutureSingleObserver.java */
/* loaded from: classes.dex */
public final class h<T> extends CountDownLatch implements w<T>, Future<T>, d.c.c0.b {

    /* renamed from: a  reason: collision with root package name */
    public T f4614a;

    /* renamed from: b  reason: collision with root package name */
    public Throwable f4615b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<d.c.c0.b> f4616c;

    public h() {
        super(1);
        this.f4616c = new AtomicReference<>();
    }

    @Override // d.c.w
    public void a(d.c.c0.b bVar) {
        d.c.f0.a.b.c(this.f4616c, bVar);
    }

    @Override // d.c.c0.b
    public void b() {
    }

    @Override // d.c.w
    public void b(T t) {
        d.c.c0.b bVar = this.f4616c.get();
        if (bVar == d.c.f0.a.b.DISPOSED) {
            return;
        }
        this.f4614a = t;
        this.f4616c.compareAndSet(bVar, this);
        countDown();
    }

    @Override // d.c.c0.b
    public boolean c() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        d.c.c0.b bVar;
        d.c.f0.a.b bVar2;
        do {
            bVar = this.f4616c.get();
            if (bVar == this || bVar == (bVar2 = d.c.f0.a.b.DISPOSED)) {
                return false;
            }
        } while (!this.f4616c.compareAndSet(bVar, bVar2));
        if (bVar != null) {
            bVar.b();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        if (getCount() != 0) {
            d.c.f0.j.d.a();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f4615b;
            if (th == null) {
                return this.f4614a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return d.c.f0.a.b.a(this.f4616c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // d.c.w
    public void a(Throwable th) {
        d.c.c0.b bVar;
        do {
            bVar = this.f4616c.get();
            if (bVar == d.c.f0.a.b.DISPOSED) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4615b = th;
        } while (!this.f4616c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            d.c.f0.j.d.a();
            if (!await(j, timeUnit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f4615b;
            if (th == null) {
                return this.f4614a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
