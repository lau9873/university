package p205h.p206a.p207a;

import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Interceptor;

/* renamed from: h.a.a.d */
/* loaded from: classes.dex */
public class AuthenticationInterceptor implements Interceptor {

    /* renamed from: a */
    public String f8768a;

    public AuthenticationInterceptor(String str) {
        this.f8768a = str;
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        C1737b0.C1738a m3255f = interfaceC1812a.mo2696a().m3255f();
        m3255f.m3247b("Authorization", this.f8768a);
        return interfaceC1812a.mo2695a(m3255f.m3253a());
    }
}
