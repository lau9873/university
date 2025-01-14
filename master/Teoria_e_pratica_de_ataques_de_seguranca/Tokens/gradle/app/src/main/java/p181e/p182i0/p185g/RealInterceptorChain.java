package p181e.p182i0.p185g;

import java.util.List;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Connection;
import p181e.Interceptor;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.StreamAllocation;

/* renamed from: e.i0.g.g */
/* loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.InterfaceC1812a {

    /* renamed from: a */
    public final List<Interceptor> f8016a;

    /* renamed from: b */
    public final StreamAllocation f8017b;

    /* renamed from: c */
    public final HttpCodec f8018c;

    /* renamed from: d */
    public final RealConnection f8019d;

    /* renamed from: e */
    public final int f8020e;

    /* renamed from: f */
    public final C1737b0 f8021f;

    /* renamed from: g */
    public int f8022g;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, C1737b0 c1737b0) {
        this.f8016a = list;
        this.f8019d = realConnection;
        this.f8017b = streamAllocation;
        this.f8018c = httpCodec;
        this.f8020e = i;
        this.f8021f = c1737b0;
    }

    @Override // p181e.Interceptor.InterfaceC1812a
    /* renamed from: a */
    public C1737b0 mo2696a() {
        return this.f8021f;
    }

    @Override // p181e.Interceptor.InterfaceC1812a
    /* renamed from: b */
    public Connection mo2694b() {
        return this.f8019d;
    }

    /* renamed from: c */
    public HttpCodec m3059c() {
        return this.f8018c;
    }

    /* renamed from: d */
    public StreamAllocation m3058d() {
        return this.f8017b;
    }

    @Override // p181e.Interceptor.InterfaceC1812a
    /* renamed from: a */
    public C1744d0 mo2695a(C1737b0 c1737b0) {
        return m3060a(c1737b0, this.f8017b, this.f8018c, this.f8019d);
    }

    /* renamed from: a */
    public C1744d0 m3060a(C1737b0 c1737b0, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) {
        if (this.f8020e < this.f8016a.size()) {
            this.f8022g++;
            if (this.f8018c != null && !this.f8019d.m3117a(c1737b0.m3254g())) {
                throw new IllegalStateException("network interceptor " + this.f8016a.get(this.f8020e - 1) + " must retain the same host and port");
            } else if (this.f8018c != null && this.f8022g > 1) {
                throw new IllegalStateException("network interceptor " + this.f8016a.get(this.f8020e - 1) + " must call proceed() exactly once");
            } else {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f8016a, streamAllocation, httpCodec, realConnection, this.f8020e + 1, c1737b0);
                Interceptor interceptor = this.f8016a.get(this.f8020e);
                C1744d0 intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec != null && this.f8020e + 1 < this.f8016a.size() && realInterceptorChain.f8022g != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                }
            }
        }
        throw new AssertionError();
    }
}
