package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
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
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1090w0;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.ExecutorC1149f;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.b */
/* loaded from: classes.dex */
public final class C0937b implements InterfaceC1027x0 {

    /* renamed from: c */
    public final Map<C0905a<?>, Boolean> f5126c;

    /* renamed from: d */
    public final C0971j0 f5127d;

    /* renamed from: e */
    public final C0934a0 f5128e;

    /* renamed from: f */
    public final Lock f5129f;

    /* renamed from: g */
    public final Looper f5130g;

    /* renamed from: h */
    public final C1109m f5131h;

    /* renamed from: i */
    public final Condition f5132i;

    /* renamed from: j */
    public final C1086u0 f5133j;

    /* renamed from: k */
    public final boolean f5134k;

    /* renamed from: l */
    public final boolean f5135l;

    /* renamed from: n */
    public boolean f5137n;

    /* renamed from: o */
    public Map<C0960g2<?>, C0900a> f5138o;

    /* renamed from: p */
    public Map<C0960g2<?>, C0900a> f5139p;

    /* renamed from: q */
    public C0949e f5140q;

    /* renamed from: r */
    public C0900a f5141r;

    /* renamed from: a */
    public final Map<C0905a.C0914d<?>, C1033y2<?>> f5124a = new HashMap();

    /* renamed from: b */
    public final Map<C0905a.C0914d<?>, C1033y2<?>> f5125b = new HashMap();

    /* renamed from: m */
    public final Queue<AbstractC0981l2<?, ?>> f5136m = new LinkedList();

    public C0937b(Context context, Lock lock, Looper looper, C1109m c1109m, Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map, C1086u0 c1086u0, Map<C0905a<?>, Boolean> map2, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b, ArrayList<C1009s2> arrayList, C0934a0 c0934a0, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f5129f = lock;
        this.f5130g = looper;
        this.f5132i = lock.newCondition();
        this.f5131h = c1109m;
        this.f5128e = c0934a0;
        this.f5126c = map2;
        this.f5133j = c1086u0;
        this.f5134k = z;
        HashMap hashMap = new HashMap();
        for (C0905a<?> c0905a : map2.keySet()) {
            hashMap.put(c0905a.m5619d(), c0905a);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            C1009s2 c1009s2 = arrayList.get(i);
            i++;
            C1009s2 c1009s22 = c1009s2;
            hashMap2.put(c1009s22.f5315a, c1009s22);
        }
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        for (Map.Entry<C0905a.C0914d<?>, C0905a.InterfaceC0916f> entry : map.entrySet()) {
            C0905a c0905a2 = (C0905a) hashMap.get(entry.getKey());
            C0905a.InterfaceC0916f value = entry.getValue();
            if (value.m5609g()) {
                z4 = z7;
                z3 = !this.f5126c.get(c0905a2).booleanValue() ? true : z8;
                z2 = true;
            } else {
                z2 = z6;
                z3 = z8;
                z4 = false;
            }
            C1033y2<?> c1033y2 = new C1033y2<>(context, c0905a2, looper, value, (C1009s2) hashMap2.get(c0905a2), c1086u0, abstractC0912b);
            this.f5124a.put(entry.getKey(), c1033y2);
            if (value.mo5043e()) {
                this.f5125b.put(entry.getKey(), c1033y2);
            }
            z8 = z3;
            z7 = z4;
            z6 = z2;
        }
        this.f5135l = (!z6 || z7 || z8) ? false : false;
        this.f5127d = C0971j0.m5486d();
    }

    /* renamed from: a */
    public final C0900a m5567a(C0905a.C0914d<?> c0914d) {
        this.f5129f.lock();
        try {
            C1033y2<?> c1033y2 = this.f5124a.get(c0914d);
            if (this.f5138o == null || c1033y2 == null) {
                this.f5129f.unlock();
                return null;
            }
            return this.f5138o.get(c1033y2.m5595d());
        } finally {
            this.f5129f.unlock();
        }
    }

    /* renamed from: a */
    public final C0900a m5566a(C0905a<?> c0905a) {
        return m5567a(c0905a.m5619d());
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5330a(T t) {
        C0905a.C0914d<A> m5435h = t.m5435h();
        if (this.f5134k && m5558b((C0937b) t)) {
            return t;
        }
        this.f5128e.f5119y.m5316a(t);
        this.f5124a.get(m5435h).m5599a((C1033y2<?>) t);
        return t;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final void mo5331a() {
        this.f5129f.lock();
        try {
            this.f5137n = false;
            this.f5138o = null;
            this.f5139p = null;
            if (this.f5140q != null) {
                this.f5140q.m5538a();
                throw null;
            }
            this.f5141r = null;
            while (!this.f5136m.isEmpty()) {
                AbstractC0981l2<?, ?> remove = this.f5136m.remove();
                remove.m4364a((InterfaceC0940b2) null);
                remove.m4368a();
            }
            this.f5132i.signalAll();
        } finally {
            this.f5129f.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final void mo5329a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public final boolean m5560a(C1033y2<?> c1033y2, C0900a c0900a) {
        return !c0900a.m5641f() && !c0900a.m5642e() && this.f5126c.get(c1033y2.m5596c()).booleanValue() && c1033y2.m5312f().m5609g() && this.f5131h.mo5117b(c0900a.m5645b());
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: b */
    public final void mo5328b() {
        this.f5129f.lock();
        try {
            if (!this.f5137n) {
                this.f5137n = true;
                this.f5138o = null;
                this.f5139p = null;
                this.f5140q = null;
                this.f5141r = null;
                this.f5127d.m5502a();
                this.f5127d.m5493a(this.f5124a.values()).mo4965a(new ExecutorC1149f(this.f5130g), new C0945d(this));
            }
        } finally {
            this.f5129f.unlock();
        }
    }

    /* renamed from: b */
    public final <T extends AbstractC0981l2<? extends InterfaceC0928g, ? extends C0905a.InterfaceC0913c>> boolean m5558b(T t) {
        C0905a.C0914d<?> m5435h = t.m5435h();
        C0900a m5567a = m5567a(m5435h);
        if (m5567a == null || m5567a.m5645b() != 4) {
            return false;
        }
        t.m5436c(new Status(4, null, this.f5127d.m5496a(this.f5124a.get(m5435h).m5595d(), System.identityHashCode(this.f5128e))));
        return true;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: c */
    public final boolean mo5327c() {
        boolean z;
        this.f5129f.lock();
        try {
            if (this.f5138o != null) {
                if (this.f5141r == null) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f5129f.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: d */
    public final void mo5326d() {
    }

    /* renamed from: e */
    public final void m5555e() {
        Set<Scope> hashSet;
        C0934a0 c0934a0;
        C1086u0 c1086u0 = this.f5133j;
        if (c1086u0 == null) {
            c0934a0 = this.f5128e;
            hashSet = Collections.emptySet();
        } else {
            hashSet = new HashSet<>(c1086u0.m5178c());
            Map<C0905a<?>, C1090w0> m5176e = this.f5133j.m5176e();
            for (C0905a<?> c0905a : m5176e.keySet()) {
                C0900a m5566a = m5566a(c0905a);
                if (m5566a != null && m5566a.m5641f()) {
                    hashSet.addAll(m5176e.get(c0905a).f5485a);
                }
            }
            c0934a0 = this.f5128e;
        }
        c0934a0.f5111q = hashSet;
    }

    /* renamed from: f */
    public final void m5553f() {
        while (!this.f5136m.isEmpty()) {
            mo5330a((C0937b) this.f5136m.remove());
        }
        this.f5128e.mo5319a((Bundle) null);
    }

    /* renamed from: g */
    public final C0900a m5551g() {
        C0900a c0900a = null;
        C0900a c0900a2 = null;
        int i = 0;
        int i2 = 0;
        for (C1033y2<?> c1033y2 : this.f5124a.values()) {
            C0905a<?> m5596c = c1033y2.m5596c();
            C0900a c0900a3 = this.f5138o.get(c1033y2.m5595d());
            if (!c0900a3.m5641f() && (!this.f5126c.get(m5596c).booleanValue() || c0900a3.m5642e() || this.f5131h.mo5117b(c0900a3.m5645b()))) {
                if (c0900a3.m5645b() == 4 && this.f5134k) {
                    int m5616a = m5596c.m5621b().m5616a();
                    if (c0900a2 == null || i2 > m5616a) {
                        c0900a2 = c0900a3;
                        i2 = m5616a;
                    }
                } else {
                    int m5616a2 = m5596c.m5621b().m5616a();
                    if (c0900a == null || i > m5616a2) {
                        c0900a = c0900a3;
                        i = m5616a2;
                    }
                }
            }
        }
        return (c0900a == null || c0900a2 == null || i <= i2) ? c0900a : c0900a2;
    }
}
