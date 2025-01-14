package d.c.f0.d;

import d.c.m;
import d.c.w;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes.dex */
public final class d<T> extends CountDownLatch implements w<T>, d.c.d, m<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f4606a;

    /* renamed from: b  reason: collision with root package name */
    public Throwable f4607b;

    /* renamed from: c  reason: collision with root package name */
    public d.c.c0.b f4608c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4609d;

    public d() {
        super(1);
    }

    @Override // d.c.w
    public void a(d.c.c0.b bVar) {
        this.f4608c = bVar;
        if (this.f4609d) {
            bVar.b();
        }
    }

    @Override // d.c.w
    public void b(T t) {
        this.f4606a = t;
        countDown();
    }

    public Throwable c() {
        if (getCount() != 0) {
            try {
                d.c.f0.j.d.a();
                await();
            } catch (InterruptedException e2) {
                d();
                return e2;
            }
        }
        return this.f4607b;
    }

    public void d() {
        this.f4609d = true;
        d.c.c0.b bVar = this.f4608c;
        if (bVar != null) {
            bVar.b();
        }
    }

    public T b() {
        if (getCount() != 0) {
            try {
                d.c.f0.j.d.a();
                await();
            } catch (InterruptedException e2) {
                d();
                throw d.c.f0.j.f.a(e2);
            }
        }
        Throwable th = this.f4607b;
        if (th == null) {
            return this.f4606a;
        }
        throw d.c.f0.j.f.a(th);
    }

    @Override // d.c.w
    public void a(Throwable th) {
        this.f4607b = th;
        countDown();
    }

    @Override // d.c.d
    public void a() {
        countDown();
    }

    public boolean a(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                d.c.f0.j.d.a();
                if (!await(j, timeUnit)) {
                    d();
                    return false;
                }
            } catch (InterruptedException e2) {
                d();
                throw d.c.f0.j.f.a(e2);
            }
        }
        Throwable th = this.f4607b;
        if (th == null) {
            return true;
        }
        throw d.c.f0.j.f.a(th);
    }

    public Throwable b(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                d.c.f0.j.d.a();
                if (!await(j, timeUnit)) {
                    d();
                    throw d.c.f0.j.f.a(new TimeoutException());
                }
            } catch (InterruptedException e2) {
                d();
                throw d.c.f0.j.f.a(e2);
            }
        }
        return this.f4607b;
    }
}
