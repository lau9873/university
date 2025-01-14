package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C0902c;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1055f;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1057g;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.a0 */
/* loaded from: classes.dex */
public final class C0934a0 extends AbstractC0921d implements InterfaceC1031y0 {

    /* renamed from: b */
    public final Lock f5096b;

    /* renamed from: d */
    public final C1055f f5098d;

    /* renamed from: f */
    public final int f5100f;

    /* renamed from: g */
    public final Context f5101g;

    /* renamed from: h */
    public final Looper f5102h;

    /* renamed from: j */
    public volatile boolean f5104j;

    /* renamed from: m */
    public final HandlerC0942c0 f5107m;

    /* renamed from: n */
    public final C0902c f5108n;

    /* renamed from: o */
    public C1015u0 f5109o;

    /* renamed from: p */
    public final Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> f5110p;

    /* renamed from: r */
    public C1086u0 f5112r;

    /* renamed from: s */
    public Map<C0905a<?>, Boolean> f5113s;

    /* renamed from: t */
    public C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5114t;

    /* renamed from: v */
    public final ArrayList<C1009s2> f5116v;

    /* renamed from: w */
    public Integer f5117w;

    /* renamed from: y */
    public final C1032y1 f5119y;

    /* renamed from: e */
    public InterfaceC1027x0 f5099e = null;

    /* renamed from: i */
    public final Queue<AbstractC0981l2<?, ?>> f5103i = new LinkedList();

    /* renamed from: k */
    public long f5105k = 120000;

    /* renamed from: l */
    public long f5106l = 5000;

    /* renamed from: q */
    public Set<Scope> f5111q = new HashSet();

    /* renamed from: u */
    public final C0963h1 f5115u = new C0963h1();

    /* renamed from: x */
    public Set<C1020v1> f5118x = null;

    /* renamed from: z */
    public final InterfaceC1057g f5120z = new C0938b0(this);

    /* renamed from: c */
    public boolean f5097c = false;

    public C0934a0(Context context, Lock lock, Looper looper, C1086u0 c1086u0, C0902c c0902c, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b, Map<C0905a<?>, Boolean> map, List<AbstractC0921d.InterfaceC0923b> list, List<AbstractC0921d.InterfaceC0924c> list2, Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map2, int i, int i2, ArrayList<C1009s2> arrayList, boolean z) {
        this.f5117w = null;
        this.f5101g = context;
        this.f5096b = lock;
        this.f5098d = new C1055f(looper, this.f5120z);
        this.f5102h = looper;
        this.f5107m = new HandlerC0942c0(this, looper);
        this.f5108n = c0902c;
        this.f5100f = i;
        if (this.f5100f >= 0) {
            this.f5117w = Integer.valueOf(i2);
        }
        this.f5113s = map;
        this.f5110p = map2;
        this.f5116v = arrayList;
        this.f5119y = new C1032y1(this.f5110p);
        for (AbstractC0921d.InterfaceC0923b interfaceC0923b : list) {
            this.f5098d.m5280a(interfaceC0923b);
        }
        for (AbstractC0921d.InterfaceC0924c interfaceC0924c : list2) {
            this.f5098d.m5279a(interfaceC0924c);
        }
        this.f5112r = c1086u0;
        this.f5114t = abstractC0912b;
    }

    /* renamed from: a */
    public static int m5578a(Iterable<C0905a.InterfaceC0916f> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (C0905a.InterfaceC0916f interfaceC0916f : iterable) {
            if (interfaceC0916f.mo5043e()) {
                z2 = true;
            }
            if (interfaceC0916f.m5606j()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    /* renamed from: c */
    public static String m5575c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5371a(T t) {
        C1049c0.m5289a(t.m5435h() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f5110p.containsKey(t.m5435h());
        String m5622a = t.m5434i() != null ? t.m5434i().m5622a() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(m5622a).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(m5622a);
        sb.append(" required for this call.");
        C1049c0.m5289a(containsKey, sb.toString());
        this.f5096b.lock();
        try {
            if (this.f5099e != null) {
                if (this.f5104j) {
                    this.f5103i.add(t);
                    while (!this.f5103i.isEmpty()) {
                        AbstractC0981l2<?, ?> remove = this.f5103i.remove();
                        this.f5119y.m5316a(remove);
                        remove.m5436c(Status.f6107f);
                    }
                } else {
                    t = (T) this.f5099e.mo5330a(t);
                }
                return t;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f5096b.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final void mo5508a() {
        this.f5096b.lock();
        try {
            if (this.f5100f >= 0) {
                C1049c0.m5285b(this.f5117w != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f5117w == null) {
                this.f5117w = Integer.valueOf(m5578a((Iterable<C0905a.InterfaceC0916f>) this.f5110p.values(), false));
            } else if (this.f5117w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m5580a(this.f5117w.intValue());
        } finally {
            this.f5096b.unlock();
        }
    }

    /* renamed from: a */
    public final void m5580a(int i) {
        this.f5096b.lock();
        boolean z = true;
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            C1049c0.m5289a(z, sb.toString());
            m5577b(i);
            m5573g();
        } finally {
            this.f5096b.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5320a(int i, boolean z) {
        if (i == 1 && !z && !this.f5104j) {
            this.f5104j = true;
            if (this.f5109o == null) {
                this.f5109o = C0902c.m5630a(this.f5101g.getApplicationContext(), new C0946d0(this));
            }
            HandlerC0942c0 handlerC0942c0 = this.f5107m;
            handlerC0942c0.sendMessageDelayed(handlerC0942c0.obtainMessage(1), this.f5105k);
            HandlerC0942c0 handlerC0942c02 = this.f5107m;
            handlerC0942c02.sendMessageDelayed(handlerC0942c02.obtainMessage(2), this.f5106l);
        }
        this.f5119y.m5315b();
        this.f5098d.m5283a(i);
        this.f5098d.m5284a();
        if (i == 2) {
            m5573g();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5319a(Bundle bundle) {
        while (!this.f5103i.isEmpty()) {
            mo5371a((C0934a0) this.f5103i.remove());
        }
        this.f5098d.m5282a(bundle);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5318a(C0900a c0900a) {
        if (!C1109m.m5115b(this.f5101g, c0900a.m5645b())) {
            m5571i();
        }
        if (this.f5104j) {
            return;
        }
        this.f5098d.m5281a(c0900a);
        this.f5098d.m5284a();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final void mo5507a(AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        this.f5098d.m5279a(interfaceC0924c);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final void mo5370a(C1020v1 c1020v1) {
        String str;
        Exception exc;
        this.f5096b.lock();
        try {
            if (this.f5118x == null) {
                str = "Attempted to remove pending transform when no transforms are registered.";
                exc = new Exception();
            } else if (this.f5118x.remove(c1020v1)) {
                if (!m5570j()) {
                    this.f5099e.mo5326d();
                }
            } else {
                str = "Failed to remove pending transform - this may lead to memory leaks!";
                exc = new Exception();
            }
            Log.wtf("GoogleApiClientImpl", str, exc);
        } finally {
            this.f5096b.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final void mo5506a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f5101g);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f5104j);
        printWriter.append(" mWorkQueue.size()=").print(this.f5103i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f5119y.f5359a.size());
        InterfaceC1027x0 interfaceC1027x0 = this.f5099e;
        if (interfaceC1027x0 != null) {
            interfaceC1027x0.mo5329a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: b */
    public final void mo5505b() {
        this.f5096b.lock();
        try {
            this.f5119y.m5317a();
            if (this.f5099e != null) {
                this.f5099e.mo5331a();
            }
            this.f5115u.m5517a();
            for (AbstractC0981l2<?, ?> abstractC0981l2 : this.f5103i) {
                abstractC0981l2.m4364a((InterfaceC0940b2) null);
                abstractC0981l2.m4368a();
            }
            this.f5103i.clear();
            if (this.f5099e != null) {
                m5571i();
                this.f5098d.m5284a();
            }
        } finally {
            this.f5096b.unlock();
        }
    }

    /* renamed from: b */
    public final void m5577b(int i) {
        Integer num = this.f5117w;
        if (num == null) {
            this.f5117w = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String m5575c = m5575c(i);
            String m5575c2 = m5575c(this.f5117w.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(m5575c).length() + 51 + String.valueOf(m5575c2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(m5575c);
            sb.append(". Mode was already set to ");
            sb.append(m5575c2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f5099e != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (C0905a.InterfaceC0916f interfaceC0916f : this.f5110p.values()) {
            if (interfaceC0916f.mo5043e()) {
                z = true;
            }
            if (interfaceC0916f.m5606j()) {
                z2 = true;
            }
        }
        int intValue = this.f5117w.intValue();
        if (intValue != 1) {
            if (intValue == 2 && z) {
                if (this.f5097c) {
                    this.f5099e = new C0937b(this.f5101g, this.f5096b, this.f5102h, this.f5108n, this.f5110p, this.f5112r, this.f5113s, this.f5114t, this.f5116v, this, true);
                    return;
                } else {
                    this.f5099e = C1017u2.m5364a(this.f5101g, this, this.f5096b, this.f5102h, this.f5108n, this.f5110p, this.f5112r, this.f5113s, this.f5114t, this.f5116v);
                    return;
                }
            }
        } else if (!z) {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        } else {
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        }
        if (!this.f5097c || z2) {
            this.f5099e = new C0954f0(this.f5101g, this, this.f5096b, this.f5102h, this.f5108n, this.f5110p, this.f5112r, this.f5113s, this.f5114t, this.f5116v, this);
        } else {
            this.f5099e = new C0937b(this.f5101g, this.f5096b, this.f5102h, this.f5108n, this.f5110p, this.f5112r, this.f5113s, this.f5114t, this.f5116v, this, false);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: b */
    public final void mo5504b(AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        this.f5098d.m5277b(interfaceC0924c);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: c */
    public final Looper mo5369c() {
        return this.f5102h;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: d */
    public final boolean mo5503d() {
        InterfaceC1027x0 interfaceC1027x0 = this.f5099e;
        return interfaceC1027x0 != null && interfaceC1027x0.mo5327c();
    }

    /* renamed from: f */
    public final void m5574f() {
        this.f5096b.lock();
        try {
            if (this.f5104j) {
                m5573g();
            }
        } finally {
            this.f5096b.unlock();
        }
    }

    /* renamed from: g */
    public final void m5573g() {
        this.f5098d.m5278b();
        this.f5099e.mo5328b();
    }

    /* renamed from: h */
    public final void m5572h() {
        this.f5096b.lock();
        try {
            if (m5571i()) {
                m5573g();
            }
        } finally {
            this.f5096b.unlock();
        }
    }

    /* renamed from: i */
    public final boolean m5571i() {
        if (this.f5104j) {
            this.f5104j = false;
            this.f5107m.removeMessages(2);
            this.f5107m.removeMessages(1);
            C1015u0 c1015u0 = this.f5109o;
            if (c1015u0 != null) {
                c1015u0.m5367a();
                this.f5109o = null;
            }
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final boolean m5570j() {
        this.f5096b.lock();
        try {
            if (this.f5118x != null) {
                return !this.f5118x.isEmpty();
            }
            this.f5096b.unlock();
            return false;
        } finally {
            this.f5096b.unlock();
        }
    }

    /* renamed from: k */
    public final String m5569k() {
        StringWriter stringWriter = new StringWriter();
        mo5506a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
}
