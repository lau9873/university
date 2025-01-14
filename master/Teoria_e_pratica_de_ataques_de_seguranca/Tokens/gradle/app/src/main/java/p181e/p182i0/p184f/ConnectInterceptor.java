package p181e.p182i0.p184f;

import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Interceptor;
import p181e.OkHttpClient;
import p181e.p182i0.p185g.RealInterceptorChain;

/* renamed from: e.i0.f.a */
/* loaded from: classes.dex */
public final class ConnectInterceptor implements Interceptor {

    /* renamed from: a */
    public final OkHttpClient f7971a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f7971a = okHttpClient;
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC1812a;
        C1737b0 mo2696a = realInterceptorChain.mo2696a();
        StreamAllocation m3058d = realInterceptorChain.m3058d();
        return realInterceptorChain.m3060a(mo2696a, m3058d, m3058d.m3088a(this.f7971a, !mo2696a.m3256e().equals("GET")), m3058d.m3082c());
    }
}
