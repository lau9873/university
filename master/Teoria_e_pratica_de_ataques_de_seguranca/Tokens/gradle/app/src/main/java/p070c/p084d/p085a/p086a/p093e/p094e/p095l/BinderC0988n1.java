package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1056f0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p102h.BinderC1142c1;
import p070c.p084d.p085a.p086a.p102h.C1166k1;
import p070c.p084d.p085a.p086a.p102h.C1193u0;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.n1 */
/* loaded from: classes.dex */
public final class BinderC0988n1 extends BinderC1142c1 implements AbstractC0921d.InterfaceC0923b, AbstractC0921d.InterfaceC0924c {

    /* renamed from: h */
    public static C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5269h = C1193u0.f5584c;

    /* renamed from: a */
    public final Context f5270a;

    /* renamed from: b */
    public final Handler f5271b;

    /* renamed from: c */
    public final C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5272c;

    /* renamed from: d */
    public Set<Scope> f5273d;

    /* renamed from: e */
    public C1086u0 f5274e;

    /* renamed from: f */
    public InterfaceC1199x0 f5275f;

    /* renamed from: g */
    public InterfaceC1000q1 f5276g;

    public BinderC0988n1(Context context, Handler handler, C1086u0 c1086u0) {
        this(context, handler, c1086u0, f5269h);
    }

    public BinderC0988n1(Context context, Handler handler, C1086u0 c1086u0, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b) {
        this.f5270a = context;
        this.f5271b = handler;
        C1049c0.m5293a(c1086u0, "ClientSettings must not be null");
        this.f5274e = c1086u0;
        this.f5273d = c1086u0.m5178c();
        this.f5272c = abstractC0912b;
    }

    /* renamed from: a */
    public final void m5402a(InterfaceC1000q1 interfaceC1000q1) {
        InterfaceC1199x0 interfaceC1199x0 = this.f5275f;
        if (interfaceC1199x0 != null) {
            interfaceC1199x0.mo5029a();
        }
        this.f5274e.m5180a(Integer.valueOf(System.identityHashCode(this)));
        C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b = this.f5272c;
        Context context = this.f5270a;
        Looper looper = this.f5271b.getLooper();
        C1086u0 c1086u0 = this.f5274e;
        this.f5275f = abstractC0912b.mo4987a(context, looper, c1086u0, c1086u0.m5173h(), this, this);
        this.f5276g = interfaceC1000q1;
        Set<Scope> set = this.f5273d;
        if (set == null || set.isEmpty()) {
            this.f5271b.post(new RunnableC0992o1(this));
        } else {
            this.f5275f.mo5004b();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1145d1
    /* renamed from: a */
    public final void mo5063a(C1166k1 c1166k1) {
        this.f5271b.post(new RunnableC0996p1(this, c1166k1));
    }

    /* renamed from: b */
    public final void m5401b(C1166k1 c1166k1) {
        C0900a m5036b = c1166k1.m5036b();
        if (m5036b.m5641f()) {
            C1056f0 m5035c = c1166k1.m5035c();
            m5036b = m5035c.m5276b();
            if (m5036b.m5641f()) {
                this.f5276g.mo5386a(m5035c.m5275c(), this.f5273d);
                this.f5275f.mo5029a();
            }
            String valueOf = String.valueOf(m5036b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("SignInCoordinator", sb.toString(), new Exception());
        }
        this.f5276g.mo5385b(m5036b);
        this.f5275f.mo5029a();
    }

    /* renamed from: h */
    public final InterfaceC1199x0 m5400h() {
        return this.f5275f;
    }

    /* renamed from: i */
    public final void m5399i() {
        InterfaceC1199x0 interfaceC1199x0 = this.f5275f;
        if (interfaceC1199x0 != null) {
            interfaceC1199x0.mo5029a();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnected(Bundle bundle) {
        this.f5275f.mo5005a(this);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c
    public final void onConnectionFailed(C0900a c0900a) {
        this.f5276g.mo5385b(c0900a);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnectionSuspended(int i) {
        this.f5275f.mo5029a();
    }
}
