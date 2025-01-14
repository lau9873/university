package p181e.p182i0.p186h;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Headers;
import p181e.HttpUrl;
import p181e.OkHttpClient;
import p181e.ResponseBody;
import p181e.p182i0.Internal;
import p181e.p182i0.Util;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.StreamAllocation;
import p181e.p182i0.p185g.HttpCodec;
import p181e.p182i0.p185g.HttpHeaders;
import p181e.p182i0.p185g.RealResponseBody;
import p181e.p182i0.p185g.RequestLine;
import p181e.p182i0.p185g.StatusLine;
import p192f.Buffer;
import p192f.BufferedSink;
import p192f.BufferedSource;
import p192f.ForwardingTimeout;
import p192f.Okio;
import p192f.Sink;
import p192f.Source;
import p192f.Timeout;

/* renamed from: e.i0.h.a */
/* loaded from: classes.dex */
public final class Http1Codec implements HttpCodec {

    /* renamed from: a */
    public final OkHttpClient f8033a;

    /* renamed from: b */
    public final StreamAllocation f8034b;

    /* renamed from: c */
    public final BufferedSource f8035c;

    /* renamed from: d */
    public final BufferedSink f8036d;

    /* renamed from: e */
    public int f8037e = 0;

    /* compiled from: Http1Codec.java */
    /* renamed from: e.i0.h.a$b */
    /* loaded from: classes.dex */
    public abstract class AbstractC1760b implements Source {

        /* renamed from: a */
        public final ForwardingTimeout f8038a;

        /* renamed from: b */
        public boolean f8039b;

        public AbstractC1760b() {
            this.f8038a = new ForwardingTimeout(Http1Codec.this.f8035c.mo2528b());
        }

        /* renamed from: a */
        public final void m3036a(boolean z) {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.f8037e;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                http1Codec.m3042a(this.f8038a);
                Http1Codec http1Codec2 = Http1Codec.this;
                http1Codec2.f8037e = 6;
                StreamAllocation streamAllocation = http1Codec2.f8034b;
                if (streamAllocation != null) {
                    streamAllocation.m3086a(!z, http1Codec2);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + Http1Codec.this.f8037e);
        }

        @Override // p192f.Source
        /* renamed from: b */
        public Timeout mo2528b() {
            return this.f8038a;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: e.i0.h.a$c */
    /* loaded from: classes.dex */
    public final class C1761c implements Sink {

        /* renamed from: a */
        public final ForwardingTimeout f8041a;

        /* renamed from: b */
        public boolean f8042b;

        public C1761c() {
            this.f8041a = new ForwardingTimeout(Http1Codec.this.f8036d.mo2530b());
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public Timeout mo2530b() {
            return this.f8041a;
        }

        @Override // p192f.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f8042b) {
                return;
            }
            this.f8042b = true;
            Http1Codec.this.f8036d.mo2573a("0\r\n\r\n");
            Http1Codec.this.m3042a(this.f8041a);
            Http1Codec.this.f8037e = 3;
        }

        @Override // p192f.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f8042b) {
                return;
            }
            Http1Codec.this.f8036d.flush();
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public void mo2529b(Buffer buffer, long j) {
            if (this.f8042b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1Codec.this.f8036d.mo2572e(j);
            Http1Codec.this.f8036d.mo2573a("\r\n");
            Http1Codec.this.f8036d.mo2529b(buffer, j);
            Http1Codec.this.f8036d.mo2573a("\r\n");
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: e.i0.h.a$d */
    /* loaded from: classes.dex */
    public class C1762d extends AbstractC1760b {

        /* renamed from: d */
        public final HttpUrl f8044d;

        /* renamed from: e */
        public long f8045e;

        /* renamed from: f */
        public boolean f8046f;

        public C1762d(HttpUrl httpUrl) {
            super();
            this.f8045e = -1L;
            this.f8046f = true;
            this.f8044d = httpUrl;
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            if (j >= 0) {
                if (!this.f8039b) {
                    if (this.f8046f) {
                        long j2 = this.f8045e;
                        if (j2 == 0 || j2 == -1) {
                            m3035i();
                            if (!this.f8046f) {
                                return -1L;
                            }
                        }
                        long mo673a = Http1Codec.this.f8035c.mo673a(buffer, Math.min(j, this.f8045e));
                        if (mo673a != -1) {
                            this.f8045e -= mo673a;
                            return mo673a;
                        }
                        m3036a(false);
                        throw new ProtocolException("unexpected end of stream");
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f8039b) {
                return;
            }
            if (this.f8046f && !Util.m3170a(this, 100, TimeUnit.MILLISECONDS)) {
                m3036a(false);
            }
            this.f8039b = true;
        }

        /* renamed from: i */
        public final void m3035i() {
            if (this.f8045e != -1) {
                Http1Codec.this.f8035c.mo2561c();
            }
            try {
                this.f8045e = Http1Codec.this.f8035c.mo2554g();
                String trim = Http1Codec.this.f8035c.mo2561c().trim();
                if (this.f8045e >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.f8045e == 0) {
                        this.f8046f = false;
                        HttpHeaders.m3072a(Http1Codec.this.f8033a.m2674f(), this.f8044d, Http1Codec.this.m3037e());
                        m3036a(true);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f8045e + trim + "\"");
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: e.i0.h.a$e */
    /* loaded from: classes.dex */
    public final class C1763e implements Sink {

        /* renamed from: a */
        public final ForwardingTimeout f8048a;

        /* renamed from: b */
        public boolean f8049b;

        /* renamed from: c */
        public long f8050c;

        public C1763e(long j) {
            this.f8048a = new ForwardingTimeout(Http1Codec.this.f8036d.mo2530b());
            this.f8050c = j;
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public Timeout mo2530b() {
            return this.f8048a;
        }

        @Override // p192f.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f8049b) {
                return;
            }
            this.f8049b = true;
            if (this.f8050c <= 0) {
                Http1Codec.this.m3042a(this.f8048a);
                Http1Codec.this.f8037e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // p192f.Sink, java.io.Flushable
        public void flush() {
            if (this.f8049b) {
                return;
            }
            Http1Codec.this.f8036d.flush();
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public void mo2529b(Buffer buffer, long j) {
            if (!this.f8049b) {
                Util.m3173a(buffer.m2605s(), 0L, j);
                if (j <= this.f8050c) {
                    Http1Codec.this.f8036d.mo2529b(buffer, j);
                    this.f8050c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f8050c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: e.i0.h.a$f */
    /* loaded from: classes.dex */
    public class C1764f extends AbstractC1760b {

        /* renamed from: d */
        public long f8052d;

        public C1764f(long j) {
            super();
            this.f8052d = j;
            if (this.f8052d == 0) {
                m3036a(true);
            }
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            if (j >= 0) {
                if (!this.f8039b) {
                    long j2 = this.f8052d;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long mo673a = Http1Codec.this.f8035c.mo673a(buffer, Math.min(j2, j));
                    if (mo673a != -1) {
                        this.f8052d -= mo673a;
                        if (this.f8052d == 0) {
                            m3036a(true);
                        }
                        return mo673a;
                    }
                    m3036a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f8039b) {
                return;
            }
            if (this.f8052d != 0 && !Util.m3170a(this, 100, TimeUnit.MILLISECONDS)) {
                m3036a(false);
            }
            this.f8039b = true;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: e.i0.h.a$g */
    /* loaded from: classes.dex */
    public class C1765g extends AbstractC1760b {

        /* renamed from: d */
        public boolean f8054d;

        public C1765g() {
            super();
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            if (j >= 0) {
                if (!this.f8039b) {
                    if (this.f8054d) {
                        return -1L;
                    }
                    long mo673a = Http1Codec.this.f8035c.mo673a(buffer, j);
                    if (mo673a == -1) {
                        this.f8054d = true;
                        m3036a(true);
                        return -1L;
                    }
                    return mo673a;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f8039b) {
                return;
            }
            if (!this.f8054d) {
                m3036a(false);
            }
            this.f8039b = true;
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f8033a = okHttpClient;
        this.f8034b = streamAllocation;
        this.f8035c = bufferedSource;
        this.f8036d = bufferedSink;
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public Sink mo3000a(C1737b0 c1737b0, long j) {
        if ("chunked".equalsIgnoreCase(c1737b0.m3260a("Transfer-Encoding"))) {
            return m3039c();
        }
        if (j != -1) {
            return m3045a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: b */
    public final Source m3040b(C1744d0 c1744d0) {
        if (!HttpHeaders.m3067b(c1744d0)) {
            return m3041b(0L);
        }
        if ("chunked".equalsIgnoreCase(c1744d0.m3226b("Transfer-Encoding"))) {
            return m3043a(c1744d0.m3216s().m3254g());
        }
        long m3073a = HttpHeaders.m3073a(c1744d0);
        if (m3073a != -1) {
            return m3041b(m3073a);
        }
        return m3038d();
    }

    /* renamed from: c */
    public Sink m3039c() {
        if (this.f8037e == 1) {
            this.f8037e = 2;
            return new C1761c();
        }
        throw new IllegalStateException("state: " + this.f8037e);
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    public void cancel() {
        RealConnection m3082c = this.f8034b.m3082c();
        if (m3082c != null) {
            m3082c.m3112c();
        }
    }

    /* renamed from: d */
    public Source m3038d() {
        if (this.f8037e == 4) {
            StreamAllocation streamAllocation = this.f8034b;
            if (streamAllocation != null) {
                this.f8037e = 5;
                streamAllocation.m3079e();
                return new C1765g();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f8037e);
    }

    /* renamed from: e */
    public Headers m3037e() {
        Headers.C1809a c1809a = new Headers.C1809a();
        while (true) {
            String mo2561c = this.f8035c.mo2561c();
            if (mo2561c.length() != 0) {
                Internal.f7932a.mo2648a(c1809a, mo2561c);
            } else {
                return c1809a.m2759a();
            }
        }
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public void mo3001a(C1737b0 c1737b0) {
        m3044a(c1737b0.m3258c(), RequestLine.m3057a(c1737b0, this.f8034b.m3082c().mo3114b().m3190b().type()));
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: b */
    public void mo2996b() {
        this.f8036d.flush();
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public ResponseBody mo2999a(C1744d0 c1744d0) {
        return new RealResponseBody(c1744d0.m3221n(), Okio.m2586a(m3040b(c1744d0)));
    }

    /* renamed from: b */
    public Source m3041b(long j) {
        if (this.f8037e == 4) {
            this.f8037e = 5;
            return new C1764f(j);
        }
        throw new IllegalStateException("state: " + this.f8037e);
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public void mo3002a() {
        this.f8036d.flush();
    }

    /* renamed from: a */
    public void m3044a(Headers headers, String str) {
        if (this.f8037e == 0) {
            this.f8036d.mo2573a(str).mo2573a("\r\n");
            int m2762b = headers.m2762b();
            for (int i = 0; i < m2762b; i++) {
                this.f8036d.mo2573a(headers.m2766a(i)).mo2573a(": ").mo2573a(headers.m2761b(i)).mo2573a("\r\n");
            }
            this.f8036d.mo2573a("\r\n");
            this.f8037e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f8037e);
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public C1744d0.C1745a mo2997a(boolean z) {
        int i = this.f8037e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f8037e);
        }
        try {
            StatusLine m3046a = StatusLine.m3046a(this.f8035c.mo2561c());
            C1744d0.C1745a c1745a = new C1744d0.C1745a();
            c1745a.m3206a(m3046a.f8030a);
            c1745a.m3213a(m3046a.f8031b);
            c1745a.m3205a(m3046a.f8032c);
            c1745a.m3207a(m3037e());
            if (z && m3046a.f8031b == 100) {
                return null;
            }
            this.f8037e = 4;
            return c1745a;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f8034b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    /* renamed from: a */
    public Sink m3045a(long j) {
        if (this.f8037e == 1) {
            this.f8037e = 2;
            return new C1763e(j);
        }
        throw new IllegalStateException("state: " + this.f8037e);
    }

    /* renamed from: a */
    public Source m3043a(HttpUrl httpUrl) {
        if (this.f8037e == 4) {
            this.f8037e = 5;
            return new C1762d(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f8037e);
    }

    /* renamed from: a */
    public void m3042a(ForwardingTimeout forwardingTimeout) {
        Timeout m2594g = forwardingTimeout.m2594g();
        forwardingTimeout.m2595a(Timeout.f8493d);
        m2594g.mo2527a();
        m2594g.mo2526b();
    }
}
