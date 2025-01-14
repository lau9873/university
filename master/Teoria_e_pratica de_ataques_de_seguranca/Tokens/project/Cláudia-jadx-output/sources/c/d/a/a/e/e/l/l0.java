package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.a.InterfaceC0057a;
import c.d.a.a.e.e.d;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public final class l0<O extends a.InterfaceC0057a> implements d.b, d.c, t2 {

    /* renamed from: b  reason: collision with root package name */
    public final a.f f3343b;

    /* renamed from: c  reason: collision with root package name */
    public final a.c f3344c;

    /* renamed from: d  reason: collision with root package name */
    public final g2<O> f3345d;

    /* renamed from: e  reason: collision with root package name */
    public final f f3346e;

    /* renamed from: h  reason: collision with root package name */
    public final int f3349h;

    /* renamed from: i  reason: collision with root package name */
    public final n1 f3350i;
    public boolean j;
    public final /* synthetic */ j0 l;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f3342a = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final Set<i2> f3347f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public final Map<f1<?>, k1> f3348g = new HashMap();
    public c.d.a.a.e.a k = null;

    public l0(j0 j0Var, c.d.a.a.e.e.c<O> cVar) {
        Handler handler;
        Context context;
        Handler handler2;
        this.l = j0Var;
        handler = j0Var.m;
        this.f3343b = cVar.a(handler.getLooper(), this);
        this.f3344c = this.f3343b;
        this.f3345d = cVar.d();
        this.f3346e = new f();
        this.f3349h = cVar.a();
        if (!this.f3343b.e()) {
            this.f3350i = null;
            return;
        }
        context = j0Var.f3325d;
        handler2 = j0Var.m;
        this.f3350i = cVar.a(context, handler2);
    }

    public final void a() {
        Handler handler;
        int i2;
        Context context;
        c.d.a.a.e.c unused;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        if (this.f3343b.c() || this.f3343b.h()) {
            return;
        }
        if (this.f3343b.g()) {
            this.f3343b.d();
            i2 = this.l.f3327f;
            if (i2 != 0) {
                unused = this.l.f3326e;
                context = this.l.f3325d;
                int a2 = c.d.a.a.e.m.a(context, this.f3343b.d());
                this.f3343b.d();
                this.l.f3327f = a2;
                if (a2 != 0) {
                    onConnectionFailed(new c.d.a.a.e.a(a2, null));
                    return;
                }
            }
        }
        r0 r0Var = new r0(this.l, this.f3343b, this.f3345d);
        if (this.f3343b.e()) {
            this.f3350i.a(r0Var);
        }
        this.f3343b.a(r0Var);
    }

    public final void a(c.d.a.a.e.a aVar) {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        this.f3343b.a();
        onConnectionFailed(aVar);
    }

    @Override // c.d.a.a.e.e.l.t2
    public final void a(c.d.a.a.e.a aVar, c.d.a.a.e.e.a<?> aVar2, boolean z) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.l.m;
        if (myLooper == handler.getLooper()) {
            onConnectionFailed(aVar);
            return;
        }
        handler2 = this.l.m;
        handler2.post(new o0(this, aVar));
    }

    public final void a(a aVar) {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        if (this.f3343b.c()) {
            b(aVar);
            p();
            return;
        }
        this.f3342a.add(aVar);
        c.d.a.a.e.a aVar2 = this.k;
        if (aVar2 == null || !aVar2.e()) {
            a();
        } else {
            onConnectionFailed(this.k);
        }
    }

    public final void a(i2 i2Var) {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        this.f3347f.add(i2Var);
    }

    public final void a(Status status) {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        for (a aVar : this.f3342a) {
            aVar.a(status);
        }
        this.f3342a.clear();
    }

    public final int b() {
        return this.f3349h;
    }

    public final void b(c.d.a.a.e.a aVar) {
        for (i2 i2Var : this.f3347f) {
            String str = null;
            if (aVar == c.d.a.a.e.a.f3212e) {
                str = this.f3343b.l();
            }
            i2Var.a(this.f3345d, aVar, str);
        }
        this.f3347f.clear();
    }

    public final void b(a aVar) {
        aVar.a(this.f3346e, f());
        try {
            aVar.a((l0<?>) this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f3343b.a();
        }
    }

    public final boolean c() {
        return this.f3343b.c();
    }

    public final void d() {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        if (this.j) {
            a();
        }
    }

    public final void e() {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        a(j0.n);
        this.f3346e.b();
        for (f1 f1Var : (f1[]) this.f3348g.keySet().toArray(new f1[this.f3348g.size()])) {
            a(new e2(f1Var, new c.d.a.a.j.d()));
        }
        b(new c.d.a.a.e.a(4));
        if (this.f3343b.c()) {
            this.f3343b.a(new p0(this));
        }
    }

    public final boolean f() {
        return this.f3343b.e();
    }

    public final a.f g() {
        return this.f3343b;
    }

    public final void h() {
        Handler handler;
        c.d.a.a.e.c cVar;
        Context context;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        if (this.j) {
            o();
            cVar = this.l.f3326e;
            context = this.l.f3325d;
            a(cVar.a(context) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.f3343b.a();
        }
    }

    public final void i() {
        this.l.f3327f = -1;
    }

    public final void j() {
        m();
        b(c.d.a.a.e.a.f3212e);
        o();
        for (k1 k1Var : this.f3348g.values()) {
            try {
                k1Var.f3339a.a(this.f3344c, new c.d.a.a.j.d<>());
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f3343b.a();
            } catch (RemoteException unused2) {
            }
        }
        while (this.f3343b.c() && !this.f3342a.isEmpty()) {
            b(this.f3342a.remove());
        }
        p();
    }

    public final void k() {
        Handler handler;
        Handler handler2;
        long j;
        Handler handler3;
        Handler handler4;
        long j2;
        m();
        this.j = true;
        this.f3346e.c();
        handler = this.l.m;
        handler2 = this.l.m;
        Message obtain = Message.obtain(handler2, 9, this.f3345d);
        j = this.l.f3322a;
        handler.sendMessageDelayed(obtain, j);
        handler3 = this.l.m;
        handler4 = this.l.m;
        Message obtain2 = Message.obtain(handler4, 11, this.f3345d);
        j2 = this.l.f3323b;
        handler3.sendMessageDelayed(obtain2, j2);
        i();
    }

    public final Map<f1<?>, k1> l() {
        return this.f3348g;
    }

    public final void m() {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        this.k = null;
    }

    public final c.d.a.a.e.a n() {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        return this.k;
    }

    public final void o() {
        Handler handler;
        Handler handler2;
        if (this.j) {
            handler = this.l.m;
            handler.removeMessages(11, this.f3345d);
            handler2 = this.l.m;
            handler2.removeMessages(9, this.f3345d);
            this.j = false;
        }
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnected(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.l.m;
        if (myLooper == handler.getLooper()) {
            j();
            return;
        }
        handler2 = this.l.m;
        handler2.post(new m0(this));
    }

    @Override // c.d.a.a.e.e.d.c
    public final void onConnectionFailed(c.d.a.a.e.a aVar) {
        Handler handler;
        Object obj;
        i iVar;
        Handler handler2;
        Handler handler3;
        long j;
        Set set;
        i iVar2;
        Status status;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        n1 n1Var = this.f3350i;
        if (n1Var != null) {
            n1Var.i();
        }
        m();
        i();
        b(aVar);
        if (aVar.b() == 4) {
            status = j0.o;
            a(status);
        } else if (this.f3342a.isEmpty()) {
            this.k = aVar;
        } else {
            obj = j0.p;
            synchronized (obj) {
                iVar = this.l.j;
                if (iVar != null) {
                    set = this.l.k;
                    if (set.contains(this.f3345d)) {
                        iVar2 = this.l.j;
                        iVar2.b(aVar, this.f3349h);
                        return;
                    }
                }
                if (this.l.b(aVar, this.f3349h)) {
                    return;
                }
                if (aVar.b() == 18) {
                    this.j = true;
                }
                if (this.j) {
                    handler2 = this.l.m;
                    handler3 = this.l.m;
                    Message obtain = Message.obtain(handler3, 9, this.f3345d);
                    j = this.l.f3322a;
                    handler2.sendMessageDelayed(obtain, j);
                    return;
                }
                String a2 = this.f3345d.a();
                StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 38);
                sb.append("API: ");
                sb.append(a2);
                sb.append(" is not available on this device.");
                a(new Status(17, sb.toString()));
            }
        }
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnectionSuspended(int i2) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.l.m;
        if (myLooper == handler.getLooper()) {
            k();
            return;
        }
        handler2 = this.l.m;
        handler2.post(new n0(this));
    }

    public final void p() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j;
        handler = this.l.m;
        handler.removeMessages(12, this.f3345d);
        handler2 = this.l.m;
        handler3 = this.l.m;
        Message obtainMessage = handler3.obtainMessage(12, this.f3345d);
        j = this.l.f3324c;
        handler2.sendMessageDelayed(obtainMessage, j);
    }

    public final void q() {
        Handler handler;
        handler = this.l.m;
        c.d.a.a.e.f.c0.a(handler);
        if (this.f3343b.c() && this.f3348g.size() == 0) {
            if (this.f3346e.a()) {
                p();
            } else {
                this.f3343b.a();
            }
        }
    }

    public final c.d.a.a.h.x0 r() {
        n1 n1Var = this.f3350i;
        if (n1Var == null) {
            return null;
        }
        return n1Var.h();
    }
}
