package c.d.a.a.e.e.l;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class u2 implements x0 {

    /* renamed from: a */
    public final Context f3418a;

    /* renamed from: b */
    public final a0 f3419b;

    /* renamed from: c */
    public final f0 f3420c;

    /* renamed from: d */
    public final f0 f3421d;

    /* renamed from: e */
    public final Map<a.d<?>, f0> f3422e;

    /* renamed from: g */
    public final a.f f3424g;

    /* renamed from: h */
    public Bundle f3425h;
    public final Lock l;

    /* renamed from: f */
    public final Set<m1> f3423f = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: i */
    public c.d.a.a.e.a f3426i = null;
    public c.d.a.a.e.a j = null;
    public boolean k = false;
    public int m = 0;

    public u2(Context context, a0 a0Var, Lock lock, Looper looper, c.d.a.a.e.m mVar, Map<a.d<?>, a.f> map, Map<a.d<?>, a.f> map2, c.d.a.a.e.f.u0 u0Var, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar, a.f fVar, ArrayList<s2> arrayList, ArrayList<s2> arrayList2, Map<c.d.a.a.e.e.a<?>, Boolean> map3, Map<c.d.a.a.e.e.a<?>, Boolean> map4) {
        this.f3418a = context;
        this.f3419b = a0Var;
        this.l = lock;
        this.f3424g = fVar;
        this.f3420c = new f0(context, this.f3419b, lock, looper, mVar, map2, null, map4, null, arrayList2, new w2(this, null));
        this.f3421d = new f0(context, this.f3419b, lock, looper, mVar, map, u0Var, map3, bVar, arrayList, new x2(this, null));
        a.b.g.j.a aVar = new a.b.g.j.a();
        for (a.d<?> dVar : map2.keySet()) {
            aVar.put(dVar, this.f3420c);
        }
        for (a.d<?> dVar2 : map.keySet()) {
            aVar.put(dVar2, this.f3421d);
        }
        this.f3422e = Collections.unmodifiableMap(aVar);
    }

    public static u2 a(Context context, a0 a0Var, Lock lock, Looper looper, c.d.a.a.e.m mVar, Map<a.d<?>, a.f> map, c.d.a.a.e.f.u0 u0Var, Map<c.d.a.a.e.e.a<?>, Boolean> map2, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar, ArrayList<s2> arrayList) {
        a.b.g.j.a aVar = new a.b.g.j.a();
        a.b.g.j.a aVar2 = new a.b.g.j.a();
        a.f fVar = null;
        for (Map.Entry<a.d<?>, a.f> entry : map.entrySet()) {
            a.f value = entry.getValue();
            if (value.j()) {
                fVar = value;
            }
            boolean e2 = value.e();
            a.d<?> key = entry.getKey();
            if (e2) {
                aVar.put(key, value);
            } else {
                aVar2.put(key, value);
            }
        }
        c.d.a.a.e.f.c0.b(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        a.b.g.j.a aVar3 = new a.b.g.j.a();
        a.b.g.j.a aVar4 = new a.b.g.j.a();
        for (c.d.a.a.e.e.a<?> aVar5 : map2.keySet()) {
            a.d<?> d2 = aVar5.d();
            if (aVar.containsKey(d2)) {
                aVar3.put(aVar5, map2.get(aVar5));
            } else if (!aVar2.containsKey(d2)) {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            } else {
                aVar4.put(aVar5, map2.get(aVar5));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            s2 s2Var = arrayList.get(i2);
            i2++;
            s2 s2Var2 = s2Var;
            if (aVar3.containsKey(s2Var2.f3406a)) {
                arrayList2.add(s2Var2);
            } else if (!aVar4.containsKey(s2Var2.f3406a)) {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            } else {
                arrayList3.add(s2Var2);
            }
        }
        return new u2(context, a0Var, lock, looper, mVar, aVar, aVar2, u0Var, bVar, fVar, arrayList2, arrayList3, aVar3, aVar4);
    }

    public static boolean b(c.d.a.a.e.a aVar) {
        return aVar != null && aVar.f();
    }

    @Override // c.d.a.a.e.e.l.x0
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        if (b((l2<? extends c.d.a.a.e.e.g, ? extends a.c>) t)) {
            if (g()) {
                t.c(new Status(4, null, h()));
                return t;
            }
            return (T) this.f3421d.a((f0) t);
        }
        return (T) this.f3420c.a((f0) t);
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void a() {
        this.j = null;
        this.f3426i = null;
        this.m = 0;
        this.f3420c.a();
        this.f3421d.a();
        f();
    }

    public final void a(int i2, boolean z) {
        this.f3419b.a(i2, z);
        this.j = null;
        this.f3426i = null;
    }

    public final void a(Bundle bundle) {
        Bundle bundle2 = this.f3425h;
        if (bundle2 == null) {
            this.f3425h = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public final void a(c.d.a.a.e.a aVar) {
        int i2 = this.m;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.m = 0;
            }
            this.f3419b.a(aVar);
        }
        f();
        this.m = 0;
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f3421d.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f3420c.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void b() {
        this.m = 2;
        this.k = false;
        this.j = null;
        this.f3426i = null;
        this.f3420c.b();
        this.f3421d.b();
    }

    public final boolean b(l2<? extends c.d.a.a.e.e.g, ? extends a.c> l2Var) {
        a.d<? extends a.c> h2 = l2Var.h();
        c.d.a.a.e.f.c0.a(this.f3422e.containsKey(h2), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f3422e.get(h2).equals(this.f3421d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x001e, code lost:
        if (r2.m == 1) goto L12;
     */
    @Override // c.d.a.a.e.e.l.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.l
            r0.lock()
            c.d.a.a.e.e.l.f0 r0 = r2.f3420c     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r0 == 0) goto L21
            c.d.a.a.e.e.l.f0 r0 = r2.f3421d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            boolean r0 = r2.g()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            int r0 = r2.m     // Catch: java.lang.Throwable -> L28
            if (r0 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            java.util.concurrent.locks.Lock r0 = r2.l
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.l
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.e.e.l.u2.c():boolean");
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void d() {
        this.f3420c.d();
        this.f3421d.d();
    }

    public final void e() {
        c.d.a.a.e.a aVar;
        if (!b(this.f3426i)) {
            if (this.f3426i != null && b(this.j)) {
                this.f3421d.a();
                a(this.f3426i);
                return;
            }
            c.d.a.a.e.a aVar2 = this.f3426i;
            if (aVar2 == null || (aVar = this.j) == null) {
                return;
            }
            if (this.f3421d.l < this.f3420c.l) {
                aVar2 = aVar;
            }
            a(aVar2);
        } else if (!b(this.j) && !g()) {
            c.d.a.a.e.a aVar3 = this.j;
            if (aVar3 != null) {
                if (this.m == 1) {
                    f();
                    return;
                }
                a(aVar3);
                this.f3420c.a();
            }
        } else {
            int i2 = this.m;
            if (i2 != 1) {
                if (i2 != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    this.m = 0;
                }
                this.f3419b.a(this.f3425h);
            }
            f();
            this.m = 0;
        }
    }

    public final void f() {
        for (m1 m1Var : this.f3423f) {
            m1Var.a();
        }
        this.f3423f.clear();
    }

    public final boolean g() {
        c.d.a.a.e.a aVar = this.j;
        return aVar != null && aVar.b() == 4;
    }

    public final PendingIntent h() {
        if (this.f3424g == null) {
            return null;
        }
        System.identityHashCode(this.f3419b);
        this.f3424g.k();
        throw null;
    }
}
