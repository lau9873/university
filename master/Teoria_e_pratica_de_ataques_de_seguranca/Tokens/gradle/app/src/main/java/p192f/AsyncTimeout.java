package p192f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: f.a */
/* loaded from: classes.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: h */
    public static final long f8437h = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: i */
    public static final long f8438i = TimeUnit.MILLISECONDS.toNanos(f8437h);

    /* renamed from: j */
    public static AsyncTimeout f8439j;

    /* renamed from: e */
    public boolean f8440e;

    /* renamed from: f */
    public AsyncTimeout f8441f;

    /* renamed from: g */
    public long f8442g;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: f.a$b */
    /* loaded from: classes.dex */
    public class C1818b implements Source {

        /* renamed from: a */
        public final /* synthetic */ Source f8445a;

        public C1818b(Source source) {
            this.f8445a = source;
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            AsyncTimeout.this.m2631g();
            try {
                try {
                    long mo673a = this.f8445a.mo673a(buffer, j);
                    AsyncTimeout.this.m2633a(true);
                    return mo673a;
                } catch (IOException e) {
                    throw AsyncTimeout.this.m2634a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m2633a(false);
                throw th;
            }
        }

        @Override // p192f.Source
        /* renamed from: b */
        public Timeout mo2528b() {
            return AsyncTimeout.this;
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                try {
                    this.f8445a.close();
                    AsyncTimeout.this.m2633a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.m2634a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m2633a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f8445a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: f.a$c */
    /* loaded from: classes.dex */
    public static final class C1819c extends Thread {
        public C1819c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.mo2576i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<f.a> r0 = p192f.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                f.a r1 = p192f.AsyncTimeout.m2629j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                f.a r2 = p192f.AsyncTimeout.f8439j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                p192f.AsyncTimeout.f8439j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.mo2576i()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: p192f.AsyncTimeout.C1819c.run():void");
        }
    }

    /* renamed from: a */
    public static synchronized void m2637a(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (f8439j == null) {
                f8439j = new AsyncTimeout();
                new C1819c().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.f8442g = Math.min(j, asyncTimeout.mo2525c() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.f8442g = j + nanoTime;
            } else if (z) {
                asyncTimeout.f8442g = asyncTimeout.mo2525c();
            } else {
                throw new AssertionError();
            }
            long m2632b = asyncTimeout.m2632b(nanoTime);
            AsyncTimeout asyncTimeout2 = f8439j;
            while (asyncTimeout2.f8441f != null && m2632b >= asyncTimeout2.f8441f.m2632b(nanoTime)) {
                asyncTimeout2 = asyncTimeout2.f8441f;
            }
            asyncTimeout.f8441f = asyncTimeout2.f8441f;
            asyncTimeout2.f8441f = asyncTimeout;
            if (asyncTimeout2 == f8439j) {
                AsyncTimeout.class.notify();
            }
        }
    }

    /* renamed from: j */
    public static AsyncTimeout m2629j() {
        AsyncTimeout asyncTimeout = f8439j.f8441f;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(f8437h);
            if (f8439j.f8441f != null || System.nanoTime() - nanoTime < f8438i) {
                return null;
            }
            return f8439j;
        }
        long m2632b = asyncTimeout.m2632b(System.nanoTime());
        if (m2632b > 0) {
            long j = m2632b / 1000000;
            AsyncTimeout.class.wait(j, (int) (m2632b - (1000000 * j)));
            return null;
        }
        f8439j.f8441f = asyncTimeout.f8441f;
        asyncTimeout.f8441f = null;
        return asyncTimeout;
    }

    /* renamed from: b */
    public final long m2632b(long j) {
        return this.f8442g - j;
    }

    /* renamed from: g */
    public final void m2631g() {
        if (!this.f8440e) {
            long m2523f = m2523f();
            boolean mo2524d = mo2524d();
            if (m2523f != 0 || mo2524d) {
                this.f8440e = true;
                m2637a(this, m2523f, mo2524d);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: h */
    public final boolean m2630h() {
        if (this.f8440e) {
            this.f8440e = false;
            return m2638a(this);
        }
        return false;
    }

    /* renamed from: i */
    public void mo2576i() {
    }

    /* renamed from: b */
    public IOException mo2577b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: f.a$a */
    /* loaded from: classes.dex */
    public class C1817a implements Sink {

        /* renamed from: a */
        public final /* synthetic */ Sink f8443a;

        public C1817a(Sink sink) {
            this.f8443a = sink;
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public void mo2529b(Buffer buffer, long j) {
            C1828t.m2518a(buffer.f8450b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                Segment segment = buffer.f8449a;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    Segment segment2 = buffer.f8449a;
                    j2 += segment2.f8484c - segment2.f8483b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    segment = segment.f8487f;
                }
                AsyncTimeout.this.m2631g();
                try {
                    try {
                        this.f8443a.mo2529b(buffer, j2);
                        j -= j2;
                        AsyncTimeout.this.m2633a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m2634a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m2633a(false);
                    throw th;
                }
            }
        }

        @Override // p192f.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            AsyncTimeout.this.m2631g();
            try {
                try {
                    this.f8443a.close();
                    AsyncTimeout.this.m2633a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.m2634a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m2633a(false);
                throw th;
            }
        }

        @Override // p192f.Sink, java.io.Flushable
        public void flush() {
            AsyncTimeout.this.m2631g();
            try {
                try {
                    this.f8443a.flush();
                    AsyncTimeout.this.m2633a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.m2634a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m2633a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f8443a + ")";
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public Timeout mo2530b() {
            return AsyncTimeout.this;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m2638a(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = f8439j; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.f8441f) {
                if (asyncTimeout2.f8441f == asyncTimeout) {
                    asyncTimeout2.f8441f = asyncTimeout.f8441f;
                    asyncTimeout.f8441f = null;
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public final Sink m2636a(Sink sink) {
        return new C1817a(sink);
    }

    /* renamed from: a */
    public final Source m2635a(Source source) {
        return new C1818b(source);
    }

    /* renamed from: a */
    public final void m2633a(boolean z) {
        if (m2630h() && z) {
            throw mo2577b((IOException) null);
        }
    }

    /* renamed from: a */
    public final IOException m2634a(IOException iOException) {
        return !m2630h() ? iOException : mo2577b(iOException);
    }
}
