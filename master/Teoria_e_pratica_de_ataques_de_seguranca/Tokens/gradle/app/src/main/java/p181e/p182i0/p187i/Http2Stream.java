package p181e.p182i0.p187i;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.StreamResetException;
import p192f.AsyncTimeout;
import p192f.Buffer;
import p192f.BufferedSource;
import p192f.Sink;
import p192f.Source;
import p192f.Timeout;

/* renamed from: e.i0.i.h */
/* loaded from: classes.dex */
public final class Http2Stream {

    /* renamed from: b */
    public long f8184b;

    /* renamed from: c */
    public final int f8185c;

    /* renamed from: d */
    public final Http2Connection f8186d;

    /* renamed from: e */
    public List<C1766b> f8187e;

    /* renamed from: f */
    public boolean f8188f;

    /* renamed from: g */
    public final C1787b f8189g;

    /* renamed from: h */
    public final C1786a f8190h;

    /* renamed from: a */
    public long f8183a = 0;

    /* renamed from: i */
    public final C1788c f8191i = new C1788c();

    /* renamed from: j */
    public final C1788c f8192j = new C1788c();

    /* renamed from: k */
    public ErrorCode f8193k = null;

    /* compiled from: Http2Stream.java */
    /* renamed from: e.i0.i.h$c */
    /* loaded from: classes.dex */
    public class C1788c extends AsyncTimeout {
        public C1788c() {
        }

        @Override // p192f.AsyncTimeout
        /* renamed from: b */
        public IOException mo2577b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p192f.AsyncTimeout
        /* renamed from: i */
        public void mo2576i() {
            Http2Stream.this.m2930c(ErrorCode.CANCEL);
        }

        /* renamed from: k */
        public void m2915k() {
            if (m2630h()) {
                throw mo2577b((IOException) null);
            }
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<C1766b> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f8185c = i;
            this.f8186d = http2Connection;
            this.f8184b = http2Connection.f8125o.m2879c();
            this.f8189g = new C1787b(http2Connection.f8124n.m2879c());
            this.f8190h = new C1786a();
            this.f8189g.f8202e = z2;
            this.f8190h.f8196c = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    /* renamed from: a */
    public void m2936a(ErrorCode errorCode) {
        if (m2932b(errorCode)) {
            this.f8186d.m2981b(this.f8185c, errorCode);
        }
    }

    /* renamed from: b */
    public final boolean m2932b(ErrorCode errorCode) {
        synchronized (this) {
            if (this.f8193k != null) {
                return false;
            }
            if (this.f8189g.f8202e && this.f8190h.f8196c) {
                return false;
            }
            this.f8193k = errorCode;
            notifyAll();
            this.f8186d.m2976d(this.f8185c);
            return true;
        }
    }

    /* renamed from: c */
    public int m2931c() {
        return this.f8185c;
    }

    /* renamed from: d */
    public Sink m2929d() {
        synchronized (this) {
            if (!this.f8188f && !m2926f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f8190h;
    }

    /* renamed from: e */
    public Source m2927e() {
        return this.f8189g;
    }

    /* renamed from: f */
    public boolean m2926f() {
        return this.f8186d.f8112a == ((this.f8185c & 1) == 1);
    }

    /* renamed from: g */
    public synchronized boolean m2925g() {
        if (this.f8193k != null) {
            return false;
        }
        if ((this.f8189g.f8202e || this.f8189g.f8201d) && (this.f8190h.f8196c || this.f8190h.f8195b)) {
            if (this.f8188f) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public Timeout m2924h() {
        return this.f8191i;
    }

    /* renamed from: i */
    public void m2923i() {
        boolean m2925g;
        synchronized (this) {
            this.f8189g.f8202e = true;
            m2925g = m2925g();
            notifyAll();
        }
        if (m2925g) {
            return;
        }
        this.f8186d.m2976d(this.f8185c);
    }

    /* renamed from: j */
    public synchronized List<C1766b> m2922j() {
        List<C1766b> list;
        if (m2926f()) {
            this.f8191i.m2631g();
            while (this.f8187e == null && this.f8193k == null) {
                m2921k();
            }
            this.f8191i.m2915k();
            list = this.f8187e;
            if (list != null) {
                this.f8187e = null;
            } else {
                throw new StreamResetException(this.f8193k);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* renamed from: k */
    public void m2921k() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* renamed from: l */
    public Timeout m2920l() {
        return this.f8192j;
    }

    /* renamed from: c */
    public void m2930c(ErrorCode errorCode) {
        if (m2932b(errorCode)) {
            this.f8186d.m2977c(this.f8185c, errorCode);
        }
    }

    /* compiled from: Http2Stream.java */
    /* renamed from: e.i0.i.h$a */
    /* loaded from: classes.dex */
    public final class C1786a implements Sink {

        /* renamed from: a */
        public final Buffer f8194a = new Buffer();

        /* renamed from: b */
        public boolean f8195b;

        /* renamed from: c */
        public boolean f8196c;

        public C1786a() {
        }

        /* renamed from: a */
        public final void m2919a(boolean z) {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f8192j.m2631g();
                while (Http2Stream.this.f8184b <= 0 && !this.f8196c && !this.f8195b && Http2Stream.this.f8193k == null) {
                    Http2Stream.this.m2921k();
                }
                Http2Stream.this.f8192j.m2915k();
                Http2Stream.this.m2933b();
                min = Math.min(Http2Stream.this.f8184b, this.f8194a.m2605s());
                Http2Stream.this.f8184b -= min;
            }
            Http2Stream.this.f8192j.m2631g();
            try {
                Http2Stream.this.f8186d.m2988a(Http2Stream.this.f8185c, z && min == this.f8194a.m2605s(), this.f8194a, min);
            } finally {
                Http2Stream.this.f8192j.m2915k();
            }
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public void mo2529b(Buffer buffer, long j) {
            this.f8194a.mo2529b(buffer, j);
            while (this.f8194a.m2605s() >= 16384) {
                m2919a(false);
            }
        }

        @Override // p192f.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Http2Stream.this) {
                if (this.f8195b) {
                    return;
                }
                if (!Http2Stream.this.f8190h.f8196c) {
                    if (this.f8194a.m2605s() > 0) {
                        while (this.f8194a.m2605s() > 0) {
                            m2919a(true);
                        }
                    } else {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.f8186d.m2988a(http2Stream.f8185c, true, (Buffer) null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f8195b = true;
                }
                Http2Stream.this.f8186d.flush();
                Http2Stream.this.m2938a();
            }
        }

        @Override // p192f.Sink, java.io.Flushable
        public void flush() {
            synchronized (Http2Stream.this) {
                Http2Stream.this.m2933b();
            }
            while (this.f8194a.m2605s() > 0) {
                m2919a(false);
                Http2Stream.this.f8186d.flush();
            }
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public Timeout mo2530b() {
            return Http2Stream.this.f8192j;
        }
    }

    /* renamed from: a */
    public void m2934a(List<C1766b> list) {
        boolean z;
        synchronized (this) {
            z = true;
            this.f8188f = true;
            if (this.f8187e == null) {
                this.f8187e = list;
                z = m2925g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f8187e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f8187e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f8186d.m2976d(this.f8185c);
    }

    /* renamed from: d */
    public synchronized void m2928d(ErrorCode errorCode) {
        if (this.f8193k == null) {
            this.f8193k = errorCode;
            notifyAll();
        }
    }

    /* renamed from: b */
    public void m2933b() {
        C1786a c1786a = this.f8190h;
        if (!c1786a.f8195b) {
            if (!c1786a.f8196c) {
                ErrorCode errorCode = this.f8193k;
                if (errorCode != null) {
                    throw new StreamResetException(errorCode);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    /* renamed from: a */
    public void m2935a(BufferedSource bufferedSource, int i) {
        this.f8189g.m2918a(bufferedSource, i);
    }

    /* renamed from: a */
    public void m2938a() {
        boolean z;
        boolean m2925g;
        synchronized (this) {
            z = !this.f8189g.f8202e && this.f8189g.f8201d && (this.f8190h.f8196c || this.f8190h.f8195b);
            m2925g = m2925g();
        }
        if (z) {
            m2936a(ErrorCode.CANCEL);
        } else if (m2925g) {
        } else {
            this.f8186d.m2976d(this.f8185c);
        }
    }

    /* compiled from: Http2Stream.java */
    /* renamed from: e.i0.i.h$b */
    /* loaded from: classes.dex */
    public final class C1787b implements Source {

        /* renamed from: a */
        public final Buffer f8198a = new Buffer();

        /* renamed from: b */
        public final Buffer f8199b = new Buffer();

        /* renamed from: c */
        public final long f8200c;

        /* renamed from: d */
        public boolean f8201d;

        /* renamed from: e */
        public boolean f8202e;

        public C1787b(long j) {
            this.f8200c = j;
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            if (j >= 0) {
                synchronized (Http2Stream.this) {
                    m2916j();
                    m2917i();
                    if (this.f8199b.m2605s() == 0) {
                        return -1L;
                    }
                    long mo673a = this.f8199b.mo673a(buffer, Math.min(j, this.f8199b.m2605s()));
                    Http2Stream.this.f8183a += mo673a;
                    if (Http2Stream.this.f8183a >= Http2Stream.this.f8186d.f8124n.m2879c() / 2) {
                        Http2Stream.this.f8186d.m2993a(Http2Stream.this.f8185c, Http2Stream.this.f8183a);
                        Http2Stream.this.f8183a = 0L;
                    }
                    synchronized (Http2Stream.this.f8186d) {
                        Http2Stream.this.f8186d.f8122k += mo673a;
                        if (Http2Stream.this.f8186d.f8122k >= Http2Stream.this.f8186d.f8124n.m2879c() / 2) {
                            Http2Stream.this.f8186d.m2993a(0, Http2Stream.this.f8186d.f8122k);
                            Http2Stream.this.f8186d.f8122k = 0L;
                        }
                    }
                    return mo673a;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // p192f.Source
        /* renamed from: b */
        public Timeout mo2528b() {
            return Http2Stream.this.f8191i;
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Http2Stream.this) {
                this.f8201d = true;
                this.f8199b.m2612l();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.m2938a();
        }

        /* renamed from: i */
        public final void m2917i() {
            if (!this.f8201d) {
                ErrorCode errorCode = Http2Stream.this.f8193k;
                if (errorCode != null) {
                    throw new StreamResetException(errorCode);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        /* renamed from: j */
        public final void m2916j() {
            Http2Stream.this.f8191i.m2631g();
            while (this.f8199b.m2605s() == 0 && !this.f8202e && !this.f8201d && Http2Stream.this.f8193k == null) {
                try {
                    Http2Stream.this.m2921k();
                } finally {
                    Http2Stream.this.f8191i.m2915k();
                }
            }
        }

        /* renamed from: a */
        public void m2918a(BufferedSource bufferedSource, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.f8202e;
                    z2 = true;
                    z3 = this.f8199b.m2605s() + j > this.f8200c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    Http2Stream.this.m2930c(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long mo673a = bufferedSource.mo673a(this.f8198a, j);
                    if (mo673a != -1) {
                        j -= mo673a;
                        synchronized (Http2Stream.this) {
                            if (this.f8199b.m2605s() != 0) {
                                z2 = false;
                            }
                            this.f8199b.mo2574a((Source) this.f8198a);
                            if (z2) {
                                Http2Stream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m2937a(long j) {
        this.f8184b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
