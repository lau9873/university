package p070c.p071a.p072a.p073o;

import android.os.SystemClock;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p070c.p071a.p072a.Request;
import p070c.p071a.p072a.Response;

/* renamed from: c.a.a.o.n */
/* loaded from: classes.dex */
public class RequestFuture<T> implements Future<T>, Response.InterfaceC0790b<T>, Response.InterfaceC0789a {

    /* renamed from: a */
    public Request<?> f4645a;

    /* renamed from: b */
    public boolean f4646b = false;

    /* renamed from: c */
    public T f4647c;

    /* renamed from: d */
    public VolleyError f4648d;

    /* renamed from: a */
    public static <E> RequestFuture<E> m6090a() {
        return new RequestFuture<>();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f4645a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f4645a.mo6096b();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        try {
            return m6088a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.f4645a;
        if (request == null) {
            return false;
        }
        return request.m6192t();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f4646b && this.f4648d == null) {
            z = isCancelled();
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized T m6088a(Long l) {
        if (this.f4648d == null) {
            if (this.f4646b) {
                return this.f4647c;
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
            if (this.f4648d == null) {
                if (this.f4646b) {
                    return this.f4647c;
                }
                throw new TimeoutException();
            }
            throw new ExecutionException(this.f4648d);
        }
        throw new ExecutionException(this.f4648d);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return m6088a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // p070c.p071a.p072a.Response.InterfaceC0790b
    /* renamed from: a */
    public synchronized void mo6087a(T t) {
        this.f4646b = true;
        this.f4647c = t;
        notifyAll();
    }

    @Override // p070c.p071a.p072a.Response.InterfaceC0789a
    /* renamed from: a */
    public synchronized void mo6089a(VolleyError volleyError) {
        this.f4648d = volleyError;
        notifyAll();
    }
}
