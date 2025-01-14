package p181e.p182i0.p187i;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Headers;
import p181e.OkHttpClient;
import p181e.Protocol;
import p181e.ResponseBody;
import p181e.p182i0.Internal;
import p181e.p182i0.Util;
import p181e.p182i0.p184f.StreamAllocation;
import p181e.p182i0.p185g.HttpCodec;
import p181e.p182i0.p185g.RealResponseBody;
import p181e.p182i0.p185g.RequestLine;
import p181e.p182i0.p185g.StatusLine;
import p192f.C1822f;
import p192f.ForwardingSource;
import p192f.Okio;
import p192f.Sink;
import p192f.Source;

/* renamed from: e.i0.i.e */
/* loaded from: classes.dex */
public final class Http2Codec implements HttpCodec {

    /* renamed from: e */
    public static final C1822f f8096e = C1822f.m2596c("connection");

    /* renamed from: f */
    public static final C1822f f8097f = C1822f.m2596c("host");

    /* renamed from: g */
    public static final C1822f f8098g = C1822f.m2596c("keep-alive");

    /* renamed from: h */
    public static final C1822f f8099h = C1822f.m2596c("proxy-connection");

    /* renamed from: i */
    public static final C1822f f8100i = C1822f.m2596c("transfer-encoding");

    /* renamed from: j */
    public static final C1822f f8101j = C1822f.m2596c("te");

    /* renamed from: k */
    public static final C1822f f8102k = C1822f.m2596c("encoding");

    /* renamed from: l */
    public static final C1822f f8103l = C1822f.m2596c("upgrade");

    /* renamed from: m */
    public static final List<C1822f> f8104m = Util.m3156a(f8096e, f8097f, f8098g, f8099h, f8101j, f8100i, f8102k, f8103l, C1766b.f8066f, C1766b.f8067g, C1766b.f8068h, C1766b.f8069i);

    /* renamed from: n */
    public static final List<C1822f> f8105n = Util.m3156a(f8096e, f8097f, f8098g, f8099h, f8101j, f8100i, f8102k, f8103l);

    /* renamed from: a */
    public final OkHttpClient f8106a;

    /* renamed from: b */
    public final StreamAllocation f8107b;

    /* renamed from: c */
    public final Http2Connection f8108c;

    /* renamed from: d */
    public Http2Stream f8109d;

    /* compiled from: Http2Codec.java */
    /* renamed from: e.i0.i.e$a */
    /* loaded from: classes.dex */
    public class C1769a extends ForwardingSource {
        public C1769a(Source source) {
            super(source);
        }

        @Override // p192f.ForwardingSource, p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.f8107b.m3086a(false, (HttpCodec) http2Codec);
            super.close();
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f8106a = okHttpClient;
        this.f8107b = streamAllocation;
        this.f8108c = http2Connection;
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public Sink mo3000a(C1737b0 c1737b0, long j) {
        return this.f8109d.m2929d();
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: b */
    public void mo2996b() {
        this.f8108c.flush();
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.f8109d;
        if (http2Stream != null) {
            http2Stream.m2930c(ErrorCode.CANCEL);
        }
    }

    /* renamed from: b */
    public static List<C1766b> m2995b(C1737b0 c1737b0) {
        Headers m3258c = c1737b0.m3258c();
        ArrayList arrayList = new ArrayList(m3258c.m2762b() + 4);
        arrayList.add(new C1766b(C1766b.f8066f, c1737b0.m3256e()));
        arrayList.add(new C1766b(C1766b.f8067g, RequestLine.m3056a(c1737b0.m3254g())));
        String m3260a = c1737b0.m3260a("Host");
        if (m3260a != null) {
            arrayList.add(new C1766b(C1766b.f8069i, m3260a));
        }
        arrayList.add(new C1766b(C1766b.f8068h, c1737b0.m3254g().m2723n()));
        int m2762b = m3258c.m2762b();
        for (int i = 0; i < m2762b; i++) {
            C1822f m2596c = C1822f.m2596c(m3258c.m2766a(i).toLowerCase(Locale.US));
            if (!f8104m.contains(m2596c)) {
                arrayList.add(new C1766b(m2596c, m3258c.m2761b(i)));
            }
        }
        return arrayList;
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public void mo3001a(C1737b0 c1737b0) {
        if (this.f8109d != null) {
            return;
        }
        this.f8109d = this.f8108c.m2985a(m2995b(c1737b0), c1737b0.m3261a() != null);
        this.f8109d.m2924h().mo2521a(this.f8106a.m2660v(), TimeUnit.MILLISECONDS);
        this.f8109d.m2920l().mo2521a(this.f8106a.m2682A(), TimeUnit.MILLISECONDS);
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public void mo3002a() {
        this.f8109d.m2929d().close();
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public C1744d0.C1745a mo2997a(boolean z) {
        C1744d0.C1745a m2998a = m2998a(this.f8109d.m2922j());
        if (z && Internal.f7932a.mo2654a(m2998a) == 100) {
            return null;
        }
        return m2998a;
    }

    /* renamed from: a */
    public static C1744d0.C1745a m2998a(List<C1766b> list) {
        Headers.C1809a c1809a = new Headers.C1809a();
        int size = list.size();
        Headers.C1809a c1809a2 = c1809a;
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            C1766b c1766b = list.get(i);
            if (c1766b == null) {
                if (statusLine != null && statusLine.f8031b == 100) {
                    c1809a2 = new Headers.C1809a();
                    statusLine = null;
                }
            } else {
                C1822f c1822f = c1766b.f8070a;
                String mo2532i = c1766b.f8071b.mo2532i();
                if (c1822f.equals(C1766b.f8065e)) {
                    statusLine = StatusLine.m3046a("HTTP/1.1 " + mo2532i);
                } else if (!f8105n.contains(c1822f)) {
                    Internal.f7932a.mo2647a(c1809a2, c1822f.mo2532i(), mo2532i);
                }
            }
        }
        if (statusLine != null) {
            C1744d0.C1745a c1745a = new C1744d0.C1745a();
            c1745a.m3206a(Protocol.HTTP_2);
            c1745a.m3213a(statusLine.f8031b);
            c1745a.m3205a(statusLine.f8032c);
            c1745a.m3207a(c1809a2.m2759a());
            return c1745a;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // p181e.p182i0.p185g.HttpCodec
    /* renamed from: a */
    public ResponseBody mo2999a(C1744d0 c1744d0) {
        return new RealResponseBody(c1744d0.m3221n(), Okio.m2586a(new C1769a(this.f8109d.m2927e())));
    }
}
