package p181e;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p181e.p182i0.Util;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.RouteDatabase;
import p181e.p182i0.p184f.StreamAllocation;
import p181e.p182i0.p188j.Platform;

/* renamed from: e.j */
/* loaded from: classes.dex */
public final class ConnectionPool {

    /* renamed from: g */
    public static final Executor f8270g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m3162a("OkHttp ConnectionPool", true));

    /* renamed from: a */
    public final int f8271a;

    /* renamed from: b */
    public final long f8272b;

    /* renamed from: c */
    public final Runnable f8273c;

    /* renamed from: d */
    public final Deque<RealConnection> f8274d;

    /* renamed from: e */
    public final RouteDatabase f8275e;

    /* renamed from: f */
    public boolean f8276f;

    /* compiled from: ConnectionPool.java */
    /* renamed from: e.j$a */
    /* loaded from: classes.dex */
    public class RunnableC1798a implements Runnable {
        public RunnableC1798a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long m2824a = ConnectionPool.this.m2824a(System.nanoTime());
                if (m2824a == -1) {
                    return;
                }
                if (m2824a > 0) {
                    long j = m2824a / 1000000;
                    long j2 = m2824a - (1000000 * j);
                    synchronized (ConnectionPool.this) {
                        try {
                            ConnectionPool.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* renamed from: a */
    public RealConnection m2822a(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection realConnection : this.f8274d) {
            if (realConnection.m3119a(address, route)) {
                streamAllocation.m3089a(realConnection);
                return realConnection;
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m2819b(RealConnection realConnection) {
        if (!this.f8276f) {
            this.f8276f = true;
            f8270g.execute(this.f8273c);
        }
        this.f8274d.add(realConnection);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f8273c = new RunnableC1798a();
        this.f8274d = new ArrayDeque();
        this.f8275e = new RouteDatabase();
        this.f8271a = i;
        this.f8272b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* renamed from: a */
    public Socket m2823a(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.f8274d) {
            if (realConnection.m3119a(address, (Route) null) && realConnection.m3109f() && realConnection != streamAllocation.m3082c()) {
                return streamAllocation.m3081c(realConnection);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m2821a(RealConnection realConnection) {
        if (!realConnection.f7985k && this.f8271a != 0) {
            notifyAll();
            return false;
        }
        this.f8274d.remove(realConnection);
        return true;
    }

    /* renamed from: a */
    public long m2824a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            RealConnection realConnection = null;
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection2 : this.f8274d) {
                if (m2820a(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.f7989o;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f8272b && i <= this.f8271a) {
                if (i > 0) {
                    return this.f8272b - j2;
                } else if (i2 > 0) {
                    return this.f8272b;
                } else {
                    this.f8276f = false;
                    return -1L;
                }
            }
            this.f8274d.remove(realConnection);
            Util.m3160a(realConnection.m3108g());
            return 0L;
        }
    }

    /* renamed from: a */
    public final int m2820a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.f7988n;
        int i = 0;
        while (i < list.size()) {
            Reference<StreamAllocation> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.m2853b().mo2859a("A connection to " + realConnection.mo3114b().m3191a().m3268k() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.C1756a) reference).f8010a);
                list.remove(i);
                realConnection.f7985k = true;
                if (list.isEmpty()) {
                    realConnection.f7989o = j - this.f8272b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
