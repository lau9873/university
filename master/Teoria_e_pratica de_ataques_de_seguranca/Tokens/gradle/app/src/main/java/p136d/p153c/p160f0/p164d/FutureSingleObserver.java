package p136d.p153c.p160f0.p164d;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p175j.BlockingHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.d.h */
/* loaded from: classes.dex */
public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {

    /* renamed from: a */
    public T f6907a;

    /* renamed from: b */
    public Throwable f6908b;

    /* renamed from: c */
    public final AtomicReference<Disposable> f6909c;

    public FutureSingleObserver() {
        super(1);
        this.f6909c = new AtomicReference<>();
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3284a(Disposable disposable) {
        DisposableHelper.m3644c(this.f6909c, disposable);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        Disposable disposable = this.f6909c.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return;
        }
        this.f6907a = t;
        this.f6909c.compareAndSet(disposable, this);
        countDown();
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f6909c.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f6909c.compareAndSet(disposable, disposableHelper));
        if (disposable != null) {
            disposable.mo578b();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        if (getCount() != 0) {
            BlockingHelper.m3414a();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f6908b;
            if (th == null) {
                return this.f6907a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.m3649a(this.f6909c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3283a(Throwable th) {
        Disposable disposable;
        do {
            disposable = this.f6909c.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f6908b = th;
        } while (!this.f6909c.compareAndSet(disposable, this));
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            BlockingHelper.m3414a();
            if (!await(j, timeUnit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f6908b;
            if (th == null) {
                return this.f6907a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
