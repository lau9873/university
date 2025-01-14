package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C0902c;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0906a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.l0 */
/* loaded from: classes.dex */
public final class C0979l0<O extends C0905a.InterfaceC0906a> implements AbstractC0921d.InterfaceC0923b, AbstractC0921d.InterfaceC0924c, InterfaceC1013t2 {

    /* renamed from: b */
    public final C0905a.InterfaceC0916f f5231b;

    /* renamed from: c */
    public final C0905a.InterfaceC0913c f5232c;

    /* renamed from: d */
    public final C0960g2<O> f5233d;

    /* renamed from: e */
    public final C0953f f5234e;

    /* renamed from: h */
    public final int f5237h;

    /* renamed from: i */
    public final BinderC0988n1 f5238i;

    /* renamed from: j */
    public boolean f5239j;

    /* renamed from: l */
    public final /* synthetic */ C0971j0 f5241l;

    /* renamed from: a */
    public final Queue<AbstractC0933a> f5230a = new LinkedList();

    /* renamed from: f */
    public final Set<C0969i2> f5235f = new HashSet();

    /* renamed from: g */
    public final Map<C0955f1<?>, C0976k1> f5236g = new HashMap();

    /* renamed from: k */
    public C0900a f5240k = null;

    public C0979l0(C0971j0 c0971j0, C0919c<O> c0919c) {
        Handler handler;
        Context context;
        Handler handler2;
        this.f5241l = c0971j0;
        handler = c0971j0.f5218m;
        this.f5231b = c0919c.mo5313a(handler.getLooper(), this);
        this.f5232c = this.f5231b;
        this.f5233d = c0919c.m5595d();
        this.f5234e = new C0953f();
        this.f5237h = c0919c.m5602a();
        if (!this.f5231b.mo5043e()) {
            this.f5238i = null;
            return;
        }
        context = c0971j0.f5209d;
        handler2 = c0971j0.f5218m;
        this.f5238i = c0919c.mo5314a(context, handler2);
    }

    /* renamed from: a */
    public final void m5466a() {
        Handler handler;
        int i;
        Context context;
        C0902c unused;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        if (this.f5231b.m5610c() || this.f5231b.m5608h()) {
            return;
        }
        if (this.f5231b.m5609g()) {
            this.f5231b.mo5296d();
            i = this.f5241l.f5211f;
            if (i != 0) {
                unused = this.f5241l.f5210e;
                context = this.f5241l.f5209d;
                int m5122a = C1109m.m5122a(context, this.f5231b.mo5296d());
                this.f5231b.mo5296d();
                this.f5241l.f5211f = m5122a;
                if (m5122a != 0) {
                    onConnectionFailed(new C0900a(m5122a, null));
                    return;
                }
            }
        }
        C1003r0 c1003r0 = new C1003r0(this.f5241l, this.f5231b, this.f5233d);
        if (this.f5231b.mo5043e()) {
            this.f5238i.m5402a(c1003r0);
        }
        this.f5231b.m5614a(c1003r0);
    }

    /* renamed from: a */
    public final void m5465a(C0900a c0900a) {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        this.f5231b.mo5029a();
        onConnectionFailed(c0900a);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1013t2
    /* renamed from: a */
    public final void mo5368a(C0900a c0900a, C0905a<?> c0905a, boolean z) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f5241l.f5218m;
        if (myLooper == handler.getLooper()) {
            onConnectionFailed(c0900a);
            return;
        }
        handler2 = this.f5241l.f5218m;
        handler2.post(new RunnableC0991o0(this, c0900a));
    }

    /* renamed from: a */
    public final void m5464a(AbstractC0933a abstractC0933a) {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        if (this.f5231b.m5610c()) {
            m5458b(abstractC0933a);
            m5442p();
            return;
        }
        this.f5230a.add(abstractC0933a);
        C0900a c0900a = this.f5240k;
        if (c0900a == null || !c0900a.m5642e()) {
            m5466a();
        } else {
            onConnectionFailed(this.f5240k);
        }
    }

    /* renamed from: a */
    public final void m5463a(C0969i2 c0969i2) {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        this.f5235f.add(c0969i2);
    }

    /* renamed from: a */
    public final void m5461a(Status status) {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        for (AbstractC0933a abstractC0933a : this.f5230a) {
            abstractC0933a.mo5310a(status);
        }
        this.f5230a.clear();
    }

    /* renamed from: b */
    public final int m5460b() {
        return this.f5237h;
    }

    /* renamed from: b */
    public final void m5459b(C0900a c0900a) {
        for (C0969i2 c0969i2 : this.f5235f) {
            String str = null;
            if (c0900a == C0900a.f5050e) {
                str = this.f5231b.m5604l();
            }
            c0969i2.m5510a(this.f5233d, c0900a, str);
        }
        this.f5235f.clear();
    }

    /* renamed from: b */
    public final void m5458b(AbstractC0933a abstractC0933a) {
        abstractC0933a.mo5333a(this.f5234e, m5452f());
        try {
            abstractC0933a.mo5311a((C0979l0<?>) this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f5231b.mo5029a();
        }
    }

    /* renamed from: c */
    public final boolean m5456c() {
        return this.f5231b.m5610c();
    }

    /* renamed from: d */
    public final void m5454d() {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        if (this.f5239j) {
            m5466a();
        }
    }

    /* renamed from: e */
    public final void m5453e() {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        m5461a(C0971j0.f5202n);
        this.f5234e.m5532b();
        for (C0955f1 c0955f1 : (C0955f1[]) this.f5236g.keySet().toArray(new C0955f1[this.f5236g.size()])) {
            m5464a(new C0952e2(c0955f1, new C1238d()));
        }
        m5459b(new C0900a(4));
        if (this.f5231b.m5610c()) {
            this.f5231b.m5612a(new C0995p0(this));
        }
    }

    /* renamed from: f */
    public final boolean m5452f() {
        return this.f5231b.mo5043e();
    }

    /* renamed from: g */
    public final C0905a.InterfaceC0916f m5451g() {
        return this.f5231b;
    }

    /* renamed from: h */
    public final void m5450h() {
        Handler handler;
        C0902c c0902c;
        Context context;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        if (this.f5239j) {
            m5443o();
            c0902c = this.f5241l.f5210e;
            context = this.f5241l.f5209d;
            m5461a(c0902c.mo5123a(context) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.f5231b.mo5029a();
        }
    }

    /* renamed from: i */
    public final void m5449i() {
        this.f5241l.f5211f = -1;
    }

    /* renamed from: j */
    public final void m5448j() {
        m5445m();
        m5459b(C0900a.f5050e);
        m5443o();
        for (C0976k1 c0976k1 : this.f5236g.values()) {
            try {
                c0976k1.f5227a.m5475a(this.f5232c, new C1238d<>());
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f5231b.mo5029a();
            } catch (RemoteException unused2) {
            }
        }
        while (this.f5231b.m5610c() && !this.f5230a.isEmpty()) {
            m5458b(this.f5230a.remove());
        }
        m5442p();
    }

    /* renamed from: k */
    public final void m5447k() {
        Handler handler;
        Handler handler2;
        long j;
        Handler handler3;
        Handler handler4;
        long j2;
        m5445m();
        this.f5239j = true;
        this.f5234e.m5530c();
        handler = this.f5241l.f5218m;
        handler2 = this.f5241l.f5218m;
        Message obtain = Message.obtain(handler2, 9, this.f5233d);
        j = this.f5241l.f5206a;
        handler.sendMessageDelayed(obtain, j);
        handler3 = this.f5241l.f5218m;
        handler4 = this.f5241l.f5218m;
        Message obtain2 = Message.obtain(handler4, 11, this.f5233d);
        j2 = this.f5241l.f5207b;
        handler3.sendMessageDelayed(obtain2, j2);
        m5449i();
    }

    /* renamed from: l */
    public final Map<C0955f1<?>, C0976k1> m5446l() {
        return this.f5236g;
    }

    /* renamed from: m */
    public final void m5445m() {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        this.f5240k = null;
    }

    /* renamed from: n */
    public final C0900a m5444n() {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        return this.f5240k;
    }

    /* renamed from: o */
    public final void m5443o() {
        Handler handler;
        Handler handler2;
        if (this.f5239j) {
            handler = this.f5241l.f5218m;
            handler.removeMessages(11, this.f5233d);
            handler2 = this.f5241l.f5218m;
            handler2.removeMessages(9, this.f5233d);
            this.f5239j = false;
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnected(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f5241l.f5218m;
        if (myLooper == handler.getLooper()) {
            m5448j();
            return;
        }
        handler2 = this.f5241l.f5218m;
        handler2.post(new RunnableC0983m0(this));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c
    public final void onConnectionFailed(C0900a c0900a) {
        Handler handler;
        Object obj;
        C0966i c0966i;
        Handler handler2;
        Handler handler3;
        long j;
        Set set;
        C0966i c0966i2;
        Status status;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        BinderC0988n1 binderC0988n1 = this.f5238i;
        if (binderC0988n1 != null) {
            binderC0988n1.m5399i();
        }
        m5445m();
        m5449i();
        m5459b(c0900a);
        if (c0900a.m5645b() == 4) {
            status = C0971j0.f5203o;
            m5461a(status);
        } else if (this.f5230a.isEmpty()) {
            this.f5240k = c0900a;
        } else {
            obj = C0971j0.f5204p;
            synchronized (obj) {
                c0966i = this.f5241l.f5215j;
                if (c0966i != null) {
                    set = this.f5241l.f5216k;
                    if (set.contains(this.f5233d)) {
                        c0966i2 = this.f5241l.f5215j;
                        c0966i2.m5396b(c0900a, this.f5237h);
                        return;
                    }
                }
                if (this.f5241l.m5491b(c0900a, this.f5237h)) {
                    return;
                }
                if (c0900a.m5645b() == 18) {
                    this.f5239j = true;
                }
                if (this.f5239j) {
                    handler2 = this.f5241l.f5218m;
                    handler3 = this.f5241l.f5218m;
                    Message obtain = Message.obtain(handler3, 9, this.f5233d);
                    j = this.f5241l.f5206a;
                    handler2.sendMessageDelayed(obtain, j);
                    return;
                }
                String m5520a = this.f5233d.m5520a();
                StringBuilder sb = new StringBuilder(String.valueOf(m5520a).length() + 38);
                sb.append("API: ");
                sb.append(m5520a);
                sb.append(" is not available on this device.");
                m5461a(new Status(17, sb.toString()));
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnectionSuspended(int i) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f5241l.f5218m;
        if (myLooper == handler.getLooper()) {
            m5447k();
            return;
        }
        handler2 = this.f5241l.f5218m;
        handler2.post(new RunnableC0987n0(this));
    }

    /* renamed from: p */
    public final void m5442p() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j;
        handler = this.f5241l.f5218m;
        handler.removeMessages(12, this.f5233d);
        handler2 = this.f5241l.f5218m;
        handler3 = this.f5241l.f5218m;
        Message obtainMessage = handler3.obtainMessage(12, this.f5233d);
        j = this.f5241l.f5208c;
        handler2.sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: q */
    public final void m5441q() {
        Handler handler;
        handler = this.f5241l.f5218m;
        C1049c0.m5295a(handler);
        if (this.f5231b.m5610c() && this.f5236g.size() == 0) {
            if (this.f5234e.m5537a()) {
                m5442p();
            } else {
                this.f5231b.mo5029a();
            }
        }
    }

    /* renamed from: r */
    public final InterfaceC1199x0 m5440r() {
        BinderC0988n1 binderC0988n1 = this.f5238i;
        if (binderC0988n1 == null) {
            return null;
        }
        return binderC0988n1.m5400h();
    }
}
