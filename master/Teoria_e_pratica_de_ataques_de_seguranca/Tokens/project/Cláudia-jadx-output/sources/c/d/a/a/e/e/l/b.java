package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class b implements x0 {

    /* renamed from: c  reason: collision with root package name */
    public final Map<c.d.a.a.e.e.a<?>, Boolean> f3260c;

    /* renamed from: d  reason: collision with root package name */
    public final j0 f3261d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f3262e;

    /* renamed from: f  reason: collision with root package name */
    public final Lock f3263f;

    /* renamed from: g  reason: collision with root package name */
    public final Looper f3264g;

    /* renamed from: h  reason: collision with root package name */
    public final c.d.a.a.e.m f3265h;

    /* renamed from: i  reason: collision with root package name */
    public final Condition f3266i;
    public final c.d.a.a.e.f.u0 j;
    public final boolean k;
    public final boolean l;
    public boolean n;
    public Map<g2<?>, c.d.a.a.e.a> o;
    public Map<g2<?>, c.d.a.a.e.a> p;
    public e q;
    public c.d.a.a.e.a r;

    /* renamed from: a  reason: collision with root package name */
    public final Map<a.d<?>, y2<?>> f3258a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<a.d<?>, y2<?>> f3259b = new HashMap();
    public final Queue<l2<?, ?>> m = new LinkedList();

    public b(Context context, Lock lock, Looper looper, c.d.a.a.e.m mVar, Map<a.d<?>, a.f> map, c.d.a.a.e.f.u0 u0Var, Map<c.d.a.a.e.e.a<?>, Boolean> map2, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar, ArrayList<s2> arrayList, a0 a0Var, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f3263f = lock;
        this.f3264g = looper;
        this.f3266i = lock.newCondition();
        this.f3265h = mVar;
        this.f3262e = a0Var;
        this.f3260c = map2;
        this.j = u0Var;
        this.k = z;
        HashMap hashMap = new HashMap();
        for (c.d.a.a.e.e.a<?> aVar : map2.keySet()) {
            hashMap.put(aVar.d(), aVar);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            s2 s2Var = arrayList.get(i2);
            i2++;
            s2 s2Var2 = s2Var;
            hashMap2.put(s2Var2.f3406a, s2Var2);
        }
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        for (Map.Entry<a.d<?>, a.f> entry : map.entrySet()) {
            c.d.a.a.e.e.a aVar2 = (c.d.a.a.e.e.a) hashMap.get(entry.getKey());
            a.f value = entry.getValue();
            if (value.g()) {
                z4 = z7;
                z3 = !this.f3260c.get(aVar2).booleanValue() ? true : z8;
                z2 = true;
            } else {
                z2 = z6;
                z3 = z8;
                z4 = false;
            }
            y2<?> y2Var = new y2<>(context, aVar2, looper, value, (s2) hashMap2.get(aVar2), u0Var, bVar);
            this.f3258a.put(entry.getKey(), y2Var);
            if (value.e()) {
                this.f3259b.put(entry.getKey(), y2Var);
            }
            z8 = z3;
            z7 = z4;
            z6 = z2;
        }
        this.l = (!z6 || z7 || z8) ? false : false;
        this.f3261d = j0.d();
    }

    public final c.d.a.a.e.a a(a.d<?> dVar) {
        this.f3263f.lock();
        try {
            y2<?> y2Var = this.f3258a.get(dVar);
            if (this.o == null || y2Var == null) {
                this.f3263f.unlock();
                return null;
            }
            return this.o.get(y2Var.d());
        } finally {
            this.f3263f.unlock();
        }
    }

    public final c.d.a.a.e.a a(c.d.a.a.e.e.a<?> aVar) {
        return a(aVar.d());
    }

    @Override // c.d.a.a.e.e.l.x0
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        a.d<A> h2 = t.h();
        if (this.k && b((b) t)) {
            return t;
        }
        this.f3262e.y.a(t);
        this.f3258a.get(h2).a((y2<?>) t);
        return t;
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void a() {
        this.f3263f.lock();
        try {
            this.n = false;
            this.o = null;
            this.p = null;
            if (this.q != null) {
                this.q.a();
                throw null;
            }
            this.r = null;
            while (!this.m.isEmpty()) {
                l2<?, ?> remove = this.m.remove();
                remove.a((b2) null);
                remove.a();
            }
            this.f3266i.signalAll();
        } finally {
            this.f3263f.unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final boolean a(y2<?> y2Var, c.d.a.a.e.a aVar) {
        return !aVar.f() && !aVar.e() && this.f3260c.get(y2Var.c()).booleanValue() && y2Var.f().g() && this.f3265h.b(aVar.b());
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void b() {
        this.f3263f.lock();
        try {
            if (!this.n) {
                this.n = true;
                this.o = null;
                this.p = null;
                this.q = null;
                this.r = null;
                this.f3261d.a();
                this.f3261d.a(this.f3258a.values()).a(new c.d.a.a.h.f(this.f3264g), new d(this));
            }
        } finally {
            this.f3263f.unlock();
        }
    }

    public final <T extends l2<? extends c.d.a.a.e.e.g, ? extends a.c>> boolean b(T t) {
        a.d<?> h2 = t.h();
        c.d.a.a.e.a a2 = a(h2);
        if (a2 == null || a2.b() != 4) {
            return false;
        }
        t.c(new Status(4, null, this.f3261d.a(this.f3258a.get(h2).d(), System.identityHashCode(this.f3262e))));
        return true;
    }

    @Override // c.d.a.a.e.e.l.x0
    public final boolean c() {
        boolean z;
        this.f3263f.lock();
        try {
            if (this.o != null) {
                if (this.r == null) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f3263f.unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void d() {
    }

    public final void e() {
        Set<Scope> hashSet;
        a0 a0Var;
        c.d.a.a.e.f.u0 u0Var = this.j;
        if (u0Var == null) {
            a0Var = this.f3262e;
            hashSet = Collections.emptySet();
        } else {
            hashSet = new HashSet<>(u0Var.c());
            Map<c.d.a.a.e.e.a<?>, c.d.a.a.e.f.w0> e2 = this.j.e();
            for (c.d.a.a.e.e.a<?> aVar : e2.keySet()) {
                c.d.a.a.e.a a2 = a(aVar);
                if (a2 != null && a2.f()) {
                    hashSet.addAll(e2.get(aVar).f3552a);
                }
            }
            a0Var = this.f3262e;
        }
        a0Var.q = hashSet;
    }

    public final void f() {
        while (!this.m.isEmpty()) {
            a((b) this.m.remove());
        }
        this.f3262e.a((Bundle) null);
    }

    public final c.d.a.a.e.a g() {
        c.d.a.a.e.a aVar = null;
        c.d.a.a.e.a aVar2 = null;
        int i2 = 0;
        int i3 = 0;
        for (y2<?> y2Var : this.f3258a.values()) {
            c.d.a.a.e.e.a<?> c2 = y2Var.c();
            c.d.a.a.e.a aVar3 = this.o.get(y2Var.d());
            if (!aVar3.f() && (!this.f3260c.get(c2).booleanValue() || aVar3.e() || this.f3265h.b(aVar3.b()))) {
                if (aVar3.b() == 4 && this.k) {
                    int a2 = c2.b().a();
                    if (aVar2 == null || i3 > a2) {
                        aVar2 = aVar3;
                        i3 = a2;
                    }
                } else {
                    int a3 = c2.b().a();
                    if (aVar == null || i2 > a3) {
                        aVar = aVar3;
                        i2 = a3;
                    }
                }
            }
        }
        return (aVar == null || aVar2 == null || i2 <= i3) ? aVar : aVar2;
    }
}
