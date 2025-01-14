package p181e.p182i0.p185g;

import java.net.ProtocolException;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Interceptor;
import p181e.p182i0.Util;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.StreamAllocation;
import p192f.BufferedSink;
import p192f.Okio;

/* renamed from: e.i0.g.b */
/* loaded from: classes.dex */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a */
    public final boolean f8012a;

    public CallServerInterceptor(boolean z) {
        this.f8012a = z;
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        C1744d0 m3214a;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC1812a;
        HttpCodec m3059c = realInterceptorChain.m3059c();
        StreamAllocation m3058d = realInterceptorChain.m3058d();
        RealConnection realConnection = (RealConnection) realInterceptorChain.mo2694b();
        C1737b0 mo2696a = realInterceptorChain.mo2696a();
        long currentTimeMillis = System.currentTimeMillis();
        m3059c.mo3001a(mo2696a);
        C1744d0.C1745a c1745a = null;
        if (C1758f.m3064b(mo2696a.m3256e()) && mo2696a.m3261a() != null) {
            if ("100-continue".equalsIgnoreCase(mo2696a.m3260a("Expect"))) {
                m3059c.mo2996b();
                c1745a = m3059c.mo2997a(true);
            }
            if (c1745a == null) {
                BufferedSink m2587a = Okio.m2587a(m3059c.mo3000a(mo2696a, mo2696a.m3261a().mo645a()));
                mo2696a.m3261a().mo644a(m2587a);
                m2587a.close();
            } else if (!realConnection.m3109f()) {
                m3058d.m3079e();
            }
        }
        m3059c.mo3002a();
        if (c1745a == null) {
            c1745a = m3059c.mo2997a(false);
        }
        c1745a.m3211a(mo2696a);
        c1745a.m3208a(m3058d.m3082c().m3110e());
        c1745a.m3202b(currentTimeMillis);
        c1745a.m3212a(System.currentTimeMillis());
        C1744d0 m3214a2 = c1745a.m3214a();
        int m3223l = m3214a2.m3223l();
        if (this.f8012a && m3223l == 101) {
            C1744d0.C1745a m3218q = m3214a2.m3218q();
            m3218q.m3209a(Util.f7936c);
            m3214a = m3218q.m3214a();
        } else {
            C1744d0.C1745a m3218q2 = m3214a2.m3218q();
            m3218q2.m3209a(m3059c.mo2999a(m3214a2));
            m3214a = m3218q2.m3214a();
        }
        if ("close".equalsIgnoreCase(m3214a.m3216s().m3260a("Connection")) || "close".equalsIgnoreCase(m3214a.m3226b("Connection"))) {
            m3058d.m3079e();
        }
        if ((m3223l == 204 || m3223l == 205) && m3214a.m3225j().mo672l() > 0) {
            throw new ProtocolException("HTTP " + m3223l + " had non-zero Content-Length: " + m3214a.m3225j().mo672l());
        }
        return m3214a;
    }
}
