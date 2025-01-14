package c.a.a.o;

import android.os.SystemClock;
import c.a.a.k;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: RequestFuture.java */
/* loaded from: classes.dex */
public class n<T> implements Future<T>, k.b<T>, k.a {

    /* renamed from: a  reason: collision with root package name */
    public c.a.a.i<?> f2844a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2845b = false;

    /* renamed from: c  reason: collision with root package name */
    public T f2846c;

    /* renamed from: d  reason: collision with root package name */
    public VolleyError f2847d;

    public static <E> n<E> a() {
        return new n<>();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f2844a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f2844a.b();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        c.a.a.i<?> iVar = this.f2844a;
        if (iVar == null) {
            return false;
        }
        return iVar.t();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f2845b && this.f2847d == null) {
            z = isCancelled();
        }
        return z;
    }

    public final synchronized T a(Long l) {
        if (this.f2847d == null) {
            if (this.f2845b) {
                return this.f2846c;
            }
            if (l == null) {
                while (!isDone()) {
                    wait(0L);
                }
            } else if (l.longValue() > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                long longValue = l.longValue() + uptimeMillis;
                while (!isDone() && uptimeMillis < longValue) {
                    wait(longValue - uptimeMillis);
                    uptimeMillis = SystemClock.uptimeMillis();
                }
            }
            if (this.f2847d == null) {
                if (this.f2845b) {
                    return this.f2846c;
                }
                throw new TimeoutException();
            }
            throw new ExecutionException(this.f2847d);
        }
        throw new ExecutionException(this.f2847d);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // c.a.a.k.b
    public synchronized void a(T t) {
        this.f2845b = true;
        this.f2846c = t;
        notifyAll();
    }

    @Override // c.a.a.k.a
    public synchronized void a(VolleyError volleyError) {
        this.f2847d = volleyError;
        notifyAll();
    }
}
