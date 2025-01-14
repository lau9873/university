package p136d.p153c.p160f0.p164d;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p136d.p153c.CompletableObserver;
import p136d.p153c.MaybeObserver;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p175j.BlockingHelper;
import p136d.p153c.p160f0.p175j.ExceptionHelper;

/* renamed from: d.c.f0.d.d */
/* loaded from: classes.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: a */
    public T f6899a;

    /* renamed from: b */
    public Throwable f6900b;

    /* renamed from: c */
    public Disposable f6901c;

    /* renamed from: d */
    public volatile boolean f6902d;

    public BlockingMultiObserver() {
        super(1);
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3284a(Disposable disposable) {
        this.f6901c = disposable;
        if (this.f6902d) {
            disposable.mo578b();
        }
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        this.f6899a = t;
        countDown();
    }

    /* renamed from: c */
    public Throwable m3591c() {
        if (getCount() != 0) {
            try {
                BlockingHelper.m3414a();
                await();
            } catch (InterruptedException e) {
                m3590d();
                return e;
            }
        }
        return this.f6900b;
    }

    /* renamed from: d */
    public void m3590d() {
        this.f6902d = true;
        Disposable disposable = this.f6901c;
        if (disposable != null) {
            disposable.mo578b();
        }
    }

    /* renamed from: b */
    public T m3593b() {
        if (getCount() != 0) {
            try {
                BlockingHelper.m3414a();
                await();
            } catch (InterruptedException e) {
                m3590d();
                throw ExceptionHelper.m3413a(e);
            }
        }
        Throwable th = this.f6900b;
        if (th == null) {
            return this.f6899a;
        }
        throw ExceptionHelper.m3413a(th);
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3283a(Throwable th) {
        this.f6900b = th;
        countDown();
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3489a() {
        countDown();
    }

    /* renamed from: a */
    public boolean m3594a(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.m3414a();
                if (!await(j, timeUnit)) {
                    m3590d();
                    return false;
                }
            } catch (InterruptedException e) {
                m3590d();
                throw ExceptionHelper.m3413a(e);
            }
        }
        Throwable th = this.f6900b;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.m3413a(th);
    }

    /* renamed from: b */
    public Throwable m3592b(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.m3414a();
                if (!await(j, timeUnit)) {
                    m3590d();
                    throw ExceptionHelper.m3413a(new TimeoutException());
                }
            } catch (InterruptedException e) {
                m3590d();
                throw ExceptionHelper.m3413a(e);
            }
        }
        return this.f6900b;
    }
}
