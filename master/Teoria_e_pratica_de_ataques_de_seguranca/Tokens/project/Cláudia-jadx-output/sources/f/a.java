package f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends s {

    /* renamed from: h  reason: collision with root package name */
    public static final long f5987h = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: i  reason: collision with root package name */
    public static final long f5988i = TimeUnit.MILLISECONDS.toNanos(f5987h);
    public static a j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5989e;

    /* renamed from: f  reason: collision with root package name */
    public a f5990f;

    /* renamed from: g  reason: collision with root package name */
    public long f5991g;

    /* compiled from: AsyncTimeout.java */
    /* loaded from: classes.dex */
    public class b implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f5994a;

        public b(r rVar) {
            this.f5994a = rVar;
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            a.this.g();
            try {
                try {
                    long a2 = this.f5994a.a(cVar, j);
                    a.this.a(true);
                    return a2;
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // f.r
        public s b() {
            return a.this;
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                try {
                    this.f5994a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f5994a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    /* loaded from: classes.dex */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<f.a> r0 = f.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                f.a r1 = f.a.j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                f.a r2 = f.a.j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                f.a.j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.i()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: f.a.c.run():void");
        }
    }

    public static synchronized void a(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (j == null) {
                j = new a();
                new c().start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 != 0 && z) {
                aVar.f5991g = Math.min(j2, aVar.c() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                aVar.f5991g = j2 + nanoTime;
            } else if (z) {
                aVar.f5991g = aVar.c();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = j;
            while (aVar2.f5990f != null && b2 >= aVar2.f5990f.b(nanoTime)) {
                aVar2 = aVar2.f5990f;
            }
            aVar.f5990f = aVar2.f5990f;
            aVar2.f5990f = aVar;
            if (aVar2 == j) {
                a.class.notify();
            }
        }
    }

    public static a j() {
        a aVar = j.f5990f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f5987h);
            if (j.f5990f != null || System.nanoTime() - nanoTime < f5988i) {
                return null;
            }
            return j;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j2 = b2 / 1000000;
            a.class.wait(j2, (int) (b2 - (1000000 * j2)));
            return null;
        }
        j.f5990f = aVar.f5990f;
        aVar.f5990f = null;
        return aVar;
    }

    public final long b(long j2) {
        return this.f5991g - j2;
    }

    public final void g() {
        if (!this.f5989e) {
            long f2 = f();
            boolean d2 = d();
            if (f2 != 0 || d2) {
                this.f5989e = true;
                a(this, f2, d2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean h() {
        if (this.f5989e) {
            this.f5989e = false;
            return a(this);
        }
        return false;
    }

    public void i() {
    }

    public IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0122a implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f5992a;

        public C0122a(q qVar) {
            this.f5992a = qVar;
        }

        @Override // f.q
        public void b(f.c cVar, long j) {
            t.a(cVar.f5999b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                n nVar = cVar.f5998a;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    n nVar2 = cVar.f5998a;
                    j2 += nVar2.f6032c - nVar2.f6031b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    nVar = nVar.f6035f;
                }
                a.this.g();
                try {
                    try {
                        this.f5992a.b(cVar, j2);
                        j -= j2;
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }
        }

        @Override // f.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.g();
            try {
                try {
                    this.f5992a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // f.q, java.io.Flushable
        public void flush() {
            a.this.g();
            try {
                try {
                    this.f5992a.flush();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f5992a + ")";
        }

        @Override // f.q
        public s b() {
            return a.this;
        }
    }

    public static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = j; aVar2 != null; aVar2 = aVar2.f5990f) {
                if (aVar2.f5990f == aVar) {
                    aVar2.f5990f = aVar.f5990f;
                    aVar.f5990f = null;
                    return false;
                }
            }
            return true;
        }
    }

    public final q a(q qVar) {
        return new C0122a(qVar);
    }

    public final r a(r rVar) {
        return new b(rVar);
    }

    public final void a(boolean z) {
        if (h() && z) {
            throw b((IOException) null);
        }
    }

    public final IOException a(IOException iOException) {
        return !h() ? iOException : b(iOException);
    }
}
