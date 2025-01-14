package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1056f0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1090w0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1071n;
import p070c.p084d.p085a.p086a.p102h.C1166k1;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.n */
/* loaded from: classes.dex */
public final class C0986n implements InterfaceC0950e0 {

    /* renamed from: a */
    public final C0954f0 f5247a;

    /* renamed from: b */
    public final Lock f5248b;

    /* renamed from: c */
    public final Context f5249c;

    /* renamed from: d */
    public final C1109m f5250d;

    /* renamed from: e */
    public C0900a f5251e;

    /* renamed from: f */
    public int f5252f;

    /* renamed from: h */
    public int f5254h;

    /* renamed from: k */
    public InterfaceC1199x0 f5257k;

    /* renamed from: l */
    public boolean f5258l;

    /* renamed from: m */
    public boolean f5259m;

    /* renamed from: n */
    public boolean f5260n;

    /* renamed from: o */
    public InterfaceC1071n f5261o;

    /* renamed from: p */
    public boolean f5262p;

    /* renamed from: q */
    public boolean f5263q;

    /* renamed from: r */
    public final C1086u0 f5264r;

    /* renamed from: s */
    public final Map<C0905a<?>, Boolean> f5265s;

    /* renamed from: t */
    public final C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5266t;

    /* renamed from: g */
    public int f5253g = 0;

    /* renamed from: i */
    public final Bundle f5255i = new Bundle();

    /* renamed from: j */
    public final Set<C0905a.C0914d> f5256j = new HashSet();

    /* renamed from: u */
    public ArrayList<Future<?>> f5267u = new ArrayList<>();

    public C0986n(C0954f0 c0954f0, C1086u0 c1086u0, Map<C0905a<?>, Boolean> map, C1109m c1109m, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b, Lock lock, Context context) {
        this.f5247a = c0954f0;
        this.f5264r = c1086u0;
        this.f5265s = map;
        this.f5250d = c1109m;
        this.f5266t = abstractC0912b;
        this.f5248b = lock;
        this.f5249c = context;
    }

    /* renamed from: b */
    public static String m5423b(int i) {
        return i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5323a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final void mo5324a(C0900a c0900a, C0905a<?> c0905a, boolean z) {
        if (m5432a(1)) {
            m5421b(c0900a, c0905a, z);
            if (m5417d()) {
                m5413f();
            }
        }
    }

    /* renamed from: a */
    public final void m5425a(C1166k1 c1166k1) {
        if (m5432a(0)) {
            C0900a m5036b = c1166k1.m5036b();
            if (!m5036b.m5641f()) {
                if (!m5431a(m5036b)) {
                    m5422b(m5036b);
                    return;
                }
                m5411g();
                m5415e();
                return;
            }
            C1056f0 m5035c = c1166k1.m5035c();
            C0900a m5276b = m5035c.m5276b();
            if (m5276b.m5641f()) {
                this.f5260n = true;
                this.f5261o = m5035c.m5275c();
                this.f5262p = m5035c.m5274d();
                this.f5263q = m5035c.m5273e();
                m5415e();
                return;
            }
            String valueOf = String.valueOf(m5276b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
            m5422b(m5276b);
        }
    }

    /* renamed from: a */
    public final void m5424a(boolean z) {
        InterfaceC1199x0 interfaceC1199x0 = this.f5257k;
        if (interfaceC1199x0 != null) {
            if (interfaceC1199x0.m5610c() && z) {
                this.f5257k.mo5003f();
            }
            this.f5257k.mo5029a();
            this.f5261o = null;
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final boolean mo5325a() {
        m5409h();
        m5424a(true);
        this.f5247a.m5529a((C0900a) null);
        return true;
    }

    /* renamed from: a */
    public final boolean m5432a(int i) {
        if (this.f5253g != i) {
            Log.w("GoogleApiClientConnecting", this.f5247a.f5172m.m5569k());
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Unexpected callback in ");
            sb.append(valueOf);
            Log.w("GoogleApiClientConnecting", sb.toString());
            int i2 = this.f5254h;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("mRemainingConnections=");
            sb2.append(i2);
            Log.w("GoogleApiClientConnecting", sb2.toString());
            String m5423b = m5423b(this.f5253g);
            String m5423b2 = m5423b(i);
            StringBuilder sb3 = new StringBuilder(String.valueOf(m5423b).length() + 70 + String.valueOf(m5423b2).length());
            sb3.append("GoogleApiClient connecting is in step ");
            sb3.append(m5423b);
            sb3.append(" but received callback for step ");
            sb3.append(m5423b2);
            Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
            m5422b(new C0900a(8, null));
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean m5431a(C0900a c0900a) {
        return this.f5258l && !c0900a.m5642e();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: b */
    public final void mo5322b() {
    }

    /* renamed from: b */
    public final void m5422b(C0900a c0900a) {
        m5409h();
        m5424a(!c0900a.m5642e());
        this.f5247a.m5529a(c0900a);
        this.f5247a.f5173n.mo5318a(c0900a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if ((r5.m5642e() || r4.f5250d.m5114c(r5.m5645b()) != null) != false) goto L15;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5421b(p070c.p084d.p085a.p086a.p093e.C0900a r5, p070c.p084d.p085a.p086a.p093e.p094e.C0905a<?> r6, boolean r7) {
        /*
            r4 = this;
            c.d.a.a.e.e.a$e r0 = r6.m5621b()
            int r0 = r0.m5616a()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L24
            boolean r7 = r5.m5642e()
            if (r7 == 0) goto L14
        L12:
            r7 = 1
            goto L22
        L14:
            c.d.a.a.e.m r7 = r4.f5250d
            int r3 = r5.m5645b()
            android.content.Intent r7 = r7.m5114c(r3)
            if (r7 == 0) goto L21
            goto L12
        L21:
            r7 = 0
        L22:
            if (r7 == 0) goto L2d
        L24:
            c.d.a.a.e.a r7 = r4.f5251e
            if (r7 == 0) goto L2c
            int r7 = r4.f5252f
            if (r0 >= r7) goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == 0) goto L33
            r4.f5251e = r5
            r4.f5252f = r0
        L33:
            c.d.a.a.e.e.l.f0 r7 = r4.f5247a
            java.util.Map<c.d.a.a.e.e.a$d<?>, c.d.a.a.e.a> r7 = r7.f5166g
            c.d.a.a.e.e.a$d r6 = r6.m5619d()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0986n.m5421b(c.d.a.a.e.a, c.d.a.a.e.e.a, boolean):void");
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: c */
    public final void mo5321c() {
        this.f5247a.f5166g.clear();
        this.f5259m = false;
        this.f5251e = null;
        this.f5253g = 0;
        this.f5258l = true;
        this.f5260n = false;
        this.f5262p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (C0905a<?> c0905a : this.f5265s.keySet()) {
            C0905a.InterfaceC0916f interfaceC0916f = this.f5247a.f5165f.get(c0905a.m5619d());
            z |= c0905a.m5621b().m5616a() == 1;
            boolean booleanValue = this.f5265s.get(c0905a).booleanValue();
            if (interfaceC0916f.mo5043e()) {
                this.f5259m = true;
                if (booleanValue) {
                    this.f5256j.add(c0905a.m5619d());
                } else {
                    this.f5258l = false;
                }
            }
            hashMap.put(interfaceC0916f, new C0994p(this, c0905a, booleanValue));
        }
        if (z) {
            this.f5259m = false;
        }
        if (this.f5259m) {
            this.f5264r.m5180a(Integer.valueOf(System.identityHashCode(this.f5247a.f5172m)));
            C1022w c1022w = new C1022w(this, null);
            C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b = this.f5266t;
            Context context = this.f5249c;
            Looper mo5369c = this.f5247a.f5172m.mo5369c();
            C1086u0 c1086u0 = this.f5264r;
            this.f5257k = abstractC0912b.mo4987a(context, mo5369c, c1086u0, c1086u0.m5173h(), c1022w, c1022w);
        }
        this.f5254h = this.f5247a.f5165f.size();
        this.f5267u.add(C0967i0.m5512a().submit(new C0998q(this, hashMap)));
    }

    /* renamed from: d */
    public final boolean m5417d() {
        C0900a c0900a;
        this.f5254h--;
        int i = this.f5254h;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GoogleApiClientConnecting", this.f5247a.f5172m.m5569k());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            c0900a = new C0900a(8, null);
        } else {
            c0900a = this.f5251e;
            if (c0900a == null) {
                return true;
            }
            this.f5247a.f5171l = this.f5252f;
        }
        m5422b(c0900a);
        return false;
    }

    /* renamed from: e */
    public final void m5415e() {
        if (this.f5254h != 0) {
            return;
        }
        if (!this.f5259m || this.f5260n) {
            ArrayList arrayList = new ArrayList();
            this.f5253g = 1;
            this.f5254h = this.f5247a.f5165f.size();
            for (C0905a.C0914d<?> c0914d : this.f5247a.f5165f.keySet()) {
                if (!this.f5247a.f5166g.containsKey(c0914d)) {
                    arrayList.add(this.f5247a.f5165f.get(c0914d));
                } else if (m5417d()) {
                    m5413f();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f5267u.add(C0967i0.m5512a().submit(new C1010t(this, arrayList)));
        }
    }

    /* renamed from: f */
    public final void m5413f() {
        this.f5247a.m5523f();
        C0967i0.m5512a().execute(new RunnableC0990o(this));
        InterfaceC1199x0 interfaceC1199x0 = this.f5257k;
        if (interfaceC1199x0 != null) {
            if (this.f5262p) {
                interfaceC1199x0.mo5006a(this.f5261o, this.f5263q);
            }
            m5424a(false);
        }
        for (C0905a.C0914d<?> c0914d : this.f5247a.f5166g.keySet()) {
            this.f5247a.f5165f.get(c0914d).mo5029a();
        }
        this.f5247a.f5173n.mo5319a(this.f5255i.isEmpty() ? null : this.f5255i);
    }

    /* renamed from: g */
    public final void m5411g() {
        this.f5259m = false;
        this.f5247a.f5172m.f5111q = Collections.emptySet();
        for (C0905a.C0914d<?> c0914d : this.f5256j) {
            if (!this.f5247a.f5166g.containsKey(c0914d)) {
                this.f5247a.f5166g.put(c0914d, new C0900a(17, null));
            }
        }
    }

    /* renamed from: h */
    public final void m5409h() {
        ArrayList<Future<?>> arrayList = this.f5267u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.f5267u.clear();
    }

    /* renamed from: i */
    public final Set<Scope> m5407i() {
        C1086u0 c1086u0 = this.f5264r;
        if (c1086u0 == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(c1086u0.m5178c());
        Map<C0905a<?>, C1090w0> m5176e = this.f5264r.m5176e();
        for (C0905a<?> c0905a : m5176e.keySet()) {
            if (!this.f5247a.f5166g.containsKey(c0905a.m5619d())) {
                hashSet.addAll(m5176e.get(c0905a).f5485a);
            }
        }
        return hashSet;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    public final void onConnected(Bundle bundle) {
        if (m5432a(1)) {
            if (bundle != null) {
                this.f5255i.putAll(bundle);
            }
            if (m5417d()) {
                m5413f();
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    public final void onConnectionSuspended(int i) {
        m5422b(new C0900a(8, null));
    }
}
