package h.a.a;

import e.b0;
import e.d0;
import e.v;
/* compiled from: AuthenticationInterceptor.java */
/* loaded from: classes.dex */
public class d implements e.v {

    /* renamed from: a  reason: collision with root package name */
    public String f6271a;

    public d(String str) {
        this.f6271a = str;
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        b0.a f2 = aVar.a().f();
        f2.b("Authorization", this.f6271a);
        return aVar.a(f2.a());
    }
}
