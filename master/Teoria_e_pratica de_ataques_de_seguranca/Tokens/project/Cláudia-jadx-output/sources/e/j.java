package e;

import e.i0.f.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: g  reason: collision with root package name */
    public static final Executor f5862g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.i0.c.a("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    public final int f5863a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5864b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f5865c;

    /* renamed from: d  reason: collision with root package name */
    public final Deque<e.i0.f.c> f5866d;

    /* renamed from: e  reason: collision with root package name */
    public final e.i0.f.d f5867e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5868f;

    /* compiled from: ConnectionPool.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a2 = j.this.a(System.nanoTime());
                if (a2 == -1) {
                    return;
                }
                if (a2 > 0) {
                    long j = a2 / 1000000;
                    long j2 = a2 - (1000000 * j);
                    synchronized (j.this) {
                        try {
                            j.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public e.i0.f.c a(e.a aVar, e.i0.f.f fVar, f0 f0Var) {
        for (e.i0.f.c cVar : this.f5866d) {
            if (cVar.a(aVar, f0Var)) {
                fVar.a(cVar);
                return cVar;
            }
        }
        return null;
    }

    public void b(e.i0.f.c cVar) {
        if (!this.f5868f) {
            this.f5868f = true;
            f5862g.execute(this.f5865c);
        }
        this.f5866d.add(cVar);
    }

    public j(int i2, long j, TimeUnit timeUnit) {
        this.f5865c = new a();
        this.f5866d = new ArrayDeque();
        this.f5867e = new e.i0.f.d();
        this.f5863a = i2;
        this.f5864b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    public Socket a(e.a aVar, e.i0.f.f fVar) {
        for (e.i0.f.c cVar : this.f5866d) {
            if (cVar.a(aVar, (f0) null) && cVar.f() && cVar != fVar.c()) {
                return fVar.c(cVar);
            }
        }
        return null;
    }

    public boolean a(e.i0.f.c cVar) {
        if (!cVar.k && this.f5863a != 0) {
            notifyAll();
            return false;
        }
        this.f5866d.remove(cVar);
        return true;
    }

    public long a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            e.i0.f.c cVar = null;
            int i2 = 0;
            int i3 = 0;
            for (e.i0.f.c cVar2 : this.f5866d) {
                if (a(cVar2, j) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f5864b && i2 <= this.f5863a) {
                if (i2 > 0) {
                    return this.f5864b - j2;
                } else if (i3 > 0) {
                    return this.f5864b;
                } else {
                    this.f5868f = false;
                    return -1L;
                }
            }
            this.f5866d.remove(cVar);
            e.i0.c.a(cVar.g());
            return 0L;
        }
    }

    public final int a(e.i0.f.c cVar, long j) {
        List<Reference<e.i0.f.f>> list = cVar.n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<e.i0.f.f> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                e.i0.j.e.b().a("A connection to " + cVar.b().a().k() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f5621a);
                list.remove(i2);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f5864b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
