package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.Map;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1071n;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1072n0;

/* renamed from: c.d.a.a.e.e.l.r0 */
/* loaded from: classes.dex */
public final class C1003r0 implements InterfaceC1000q1, InterfaceC1072n0 {

    /* renamed from: a */
    public final C0905a.InterfaceC0916f f5302a;

    /* renamed from: b */
    public final C0960g2<?> f5303b;

    /* renamed from: c */
    public InterfaceC1071n f5304c = null;

    /* renamed from: d */
    public Set<Scope> f5305d = null;

    /* renamed from: e */
    public boolean f5306e = false;

    /* renamed from: f */
    public final /* synthetic */ C0971j0 f5307f;

    public C1003r0(C0971j0 c0971j0, C0905a.InterfaceC0916f interfaceC0916f, C0960g2<?> c0960g2) {
        this.f5307f = c0971j0;
        this.f5302a = interfaceC0916f;
        this.f5303b = c0960g2;
    }

    /* renamed from: a */
    public final void m5389a() {
        InterfaceC1071n interfaceC1071n;
        if (!this.f5306e || (interfaceC1071n = this.f5304c) == null) {
            return;
        }
        this.f5302a.m5613a(interfaceC1071n, this.f5305d);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1072n0
    /* renamed from: a */
    public final void mo5188a(C0900a c0900a) {
        Handler handler;
        handler = this.f5307f.f5218m;
        handler.post(new RunnableC1007s0(this, c0900a));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1000q1
    /* renamed from: a */
    public final void mo5386a(InterfaceC1071n interfaceC1071n, Set<Scope> set) {
        if (interfaceC1071n == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            mo5385b(new C0900a(4));
            return;
        }
        this.f5304c = interfaceC1071n;
        this.f5305d = set;
        m5389a();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1000q1
    /* renamed from: b */
    public final void mo5385b(C0900a c0900a) {
        Map map;
        map = this.f5307f.f5214i;
        ((C0979l0) map.get(this.f5303b)).m5465a(c0900a);
    }
}
