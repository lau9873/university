package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.d;
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
/* loaded from: classes.dex */
public final class a0 extends c.d.a.a.e.e.d implements y0 {

    /* renamed from: b  reason: collision with root package name */
    public final Lock f3247b;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.a.a.e.f.f f3249d;

    /* renamed from: f  reason: collision with root package name */
    public final int f3251f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f3252g;

    /* renamed from: h  reason: collision with root package name */
    public final Looper f3253h;
    public volatile boolean j;
    public final c0 m;
    public final c.d.a.a.e.c n;
    public u0 o;
    public final Map<a.d<?>, a.f> p;
    public c.d.a.a.e.f.u0 r;
    public Map<c.d.a.a.e.e.a<?>, Boolean> s;
    public a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> t;
    public final ArrayList<s2> v;
    public Integer w;
    public final y1 y;

    /* renamed from: e  reason: collision with root package name */
    public x0 f3250e = null;

    /* renamed from: i  reason: collision with root package name */
    public final Queue<l2<?, ?>> f3254i = new LinkedList();
    public long k = 120000;
    public long l = 5000;
    public Set<Scope> q = new HashSet();
    public final h1 u = new h1();
    public Set<v1> x = null;
    public final c.d.a.a.e.f.g z = new b0(this);

    /* renamed from: c  reason: collision with root package name */
    public boolean f3248c = false;

    public a0(Context context, Lock lock, Looper looper, c.d.a.a.e.f.u0 u0Var, c.d.a.a.e.c cVar, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar, Map<c.d.a.a.e.e.a<?>, Boolean> map, List<d.b> list, List<d.c> list2, Map<a.d<?>, a.f> map2, int i2, int i3, ArrayList<s2> arrayList, boolean z) {
        this.w = null;
        this.f3252g = context;
        this.f3247b = lock;
        this.f3249d = new c.d.a.a.e.f.f(looper, this.z);
        this.f3253h = looper;
        this.m = new c0(this, looper);
        this.n = cVar;
        this.f3251f = i2;
        if (this.f3251f >= 0) {
            this.w = Integer.valueOf(i3);
        }
        this.s = map;
        this.p = map2;
        this.v = arrayList;
        this.y = new y1(this.p);
        for (d.b bVar2 : list) {
            this.f3249d.a(bVar2);
        }
        for (d.c cVar2 : list2) {
            this.f3249d.a(cVar2);
        }
        this.r = u0Var;
        this.t = bVar;
    }

    public static int a(Iterable<a.f> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (a.f fVar : iterable) {
            if (fVar.e()) {
                z2 = true;
            }
            if (fVar.j()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    public static String c(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    @Override // c.d.a.a.e.e.d
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        c.d.a.a.e.f.c0.a(t.h() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.p.containsKey(t.h());
        String a2 = t.i() != null ? t.i().a() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(a2);
        sb.append(" required for this call.");
        c.d.a.a.e.f.c0.a(containsKey, sb.toString());
        this.f3247b.lock();
        try {
            if (this.f3250e != null) {
                if (this.j) {
                    this.f3254i.add(t);
                    while (!this.f3254i.isEmpty()) {
                        l2<?, ?> remove = this.f3254i.remove();
                        this.y.a(remove);
                        remove.c(Status.f4068f);
                    }
                } else {
                    t = (T) this.f3250e.a(t);
                }
                return t;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f3247b.unlock();
        }
    }

    @Override // c.d.a.a.e.e.d
    public final void a() {
        this.f3247b.lock();
        try {
            if (this.f3251f >= 0) {
                c.d.a.a.e.f.c0.b(this.w != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.w == null) {
                this.w = Integer.valueOf(a((Iterable<a.f>) this.p.values(), false));
            } else if (this.w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.w.intValue());
        } finally {
            this.f3247b.unlock();
        }
    }

    public final void a(int i2) {
        this.f3247b.lock();
        boolean z = true;
        if (i2 != 3 && i2 != 1 && i2 != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            c.d.a.a.e.f.c0.a(z, sb.toString());
            b(i2);
            g();
        } finally {
            this.f3247b.unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(int i2, boolean z) {
        if (i2 == 1 && !z && !this.j) {
            this.j = true;
            if (this.o == null) {
                this.o = c.d.a.a.e.c.a(this.f3252g.getApplicationContext(), new d0(this));
            }
            c0 c0Var = this.m;
            c0Var.sendMessageDelayed(c0Var.obtainMessage(1), this.k);
            c0 c0Var2 = this.m;
            c0Var2.sendMessageDelayed(c0Var2.obtainMessage(2), this.l);
        }
        this.y.b();
        this.f3249d.a(i2);
        this.f3249d.a();
        if (i2 == 2) {
            g();
        }
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(Bundle bundle) {
        while (!this.f3254i.isEmpty()) {
            a((a0) this.f3254i.remove());
        }
        this.f3249d.a(bundle);
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(c.d.a.a.e.a aVar) {
        if (!c.d.a.a.e.m.b(this.f3252g, aVar.b())) {
            i();
        }
        if (this.j) {
            return;
        }
        this.f3249d.a(aVar);
        this.f3249d.a();
    }

    @Override // c.d.a.a.e.e.d
    public final void a(d.c cVar) {
        this.f3249d.a(cVar);
    }

    @Override // c.d.a.a.e.e.d
    public final void a(v1 v1Var) {
        String str;
        Exception exc;
        this.f3247b.lock();
        try {
            if (this.x == null) {
                str = "Attempted to remove pending transform when no transforms are registered.";
                exc = new Exception();
            } else if (this.x.remove(v1Var)) {
                if (!j()) {
                    this.f3250e.d();
                }
            } else {
                str = "Failed to remove pending transform - this may lead to memory leaks!";
                exc = new Exception();
            }
            Log.wtf("GoogleApiClientImpl", str, exc);
        } finally {
            this.f3247b.unlock();
        }
    }

    @Override // c.d.a.a.e.e.d
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f3252g);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.j);
        printWriter.append(" mWorkQueue.size()=").print(this.f3254i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.y.f3446a.size());
        x0 x0Var = this.f3250e;
        if (x0Var != null) {
            x0Var.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // c.d.a.a.e.e.d
    public final void b() {
        this.f3247b.lock();
        try {
            this.y.a();
            if (this.f3250e != null) {
                this.f3250e.a();
            }
            this.u.a();
            for (l2<?, ?> l2Var : this.f3254i) {
                l2Var.a((b2) null);
                l2Var.a();
            }
            this.f3254i.clear();
            if (this.f3250e != null) {
                i();
                this.f3249d.a();
            }
        } finally {
            this.f3247b.unlock();
        }
    }

    public final void b(int i2) {
        Integer num = this.w;
        if (num == null) {
            this.w = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String c2 = c(i2);
            String c3 = c(this.w.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 51 + String.valueOf(c3).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(c2);
            sb.append(". Mode was already set to ");
            sb.append(c3);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f3250e != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (a.f fVar : this.p.values()) {
            if (fVar.e()) {
                z = true;
            }
            if (fVar.j()) {
                z2 = true;
            }
        }
        int intValue = this.w.intValue();
        if (intValue != 1) {
            if (intValue == 2 && z) {
                if (this.f3248c) {
                    this.f3250e = new b(this.f3252g, this.f3247b, this.f3253h, this.n, this.p, this.r, this.s, this.t, this.v, this, true);
                    return;
                } else {
                    this.f3250e = u2.a(this.f3252g, this, this.f3247b, this.f3253h, this.n, this.p, this.r, this.s, this.t, this.v);
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
        if (!this.f3248c || z2) {
            this.f3250e = new f0(this.f3252g, this, this.f3247b, this.f3253h, this.n, this.p, this.r, this.s, this.t, this.v, this);
        } else {
            this.f3250e = new b(this.f3252g, this.f3247b, this.f3253h, this.n, this.p, this.r, this.s, this.t, this.v, this, false);
        }
    }

    @Override // c.d.a.a.e.e.d
    public final void b(d.c cVar) {
        this.f3249d.b(cVar);
    }

    @Override // c.d.a.a.e.e.d
    public final Looper c() {
        return this.f3253h;
    }

    @Override // c.d.a.a.e.e.d
    public final boolean d() {
        x0 x0Var = this.f3250e;
        return x0Var != null && x0Var.c();
    }

    public final void f() {
        this.f3247b.lock();
        try {
            if (this.j) {
                g();
            }
        } finally {
            this.f3247b.unlock();
        }
    }

    public final void g() {
        this.f3249d.b();
        this.f3250e.b();
    }

    public final void h() {
        this.f3247b.lock();
        try {
            if (i()) {
                g();
            }
        } finally {
            this.f3247b.unlock();
        }
    }

    public final boolean i() {
        if (this.j) {
            this.j = false;
            this.m.removeMessages(2);
            this.m.removeMessages(1);
            u0 u0Var = this.o;
            if (u0Var != null) {
                u0Var.a();
                this.o = null;
            }
            return true;
        }
        return false;
    }

    public final boolean j() {
        this.f3247b.lock();
        try {
            if (this.x != null) {
                return !this.x.isEmpty();
            }
            this.f3247b.unlock();
            return false;
        } finally {
            this.f3247b.unlock();
        }
    }

    public final String k() {
        StringWriter stringWriter = new StringWriter();
        a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
}
