package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import p000a.p006b.p030g.p044j.ArrayMap;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.u2 */
/* loaded from: classes.dex */
public final class C1017u2 implements InterfaceC1027x0 {

    /* renamed from: a */
    public final Context f5327a;

    /* renamed from: b */
    public final C0934a0 f5328b;

    /* renamed from: c */
    public final C0954f0 f5329c;

    /* renamed from: d */
    public final C0954f0 f5330d;

    /* renamed from: e */
    public final Map<C0905a.C0914d<?>, C0954f0> f5331e;

    /* renamed from: g */
    public final C0905a.InterfaceC0916f f5333g;

    /* renamed from: h */
    public Bundle f5334h;

    /* renamed from: l */
    public final Lock f5338l;

    /* renamed from: f */
    public final Set<InterfaceC0984m1> f5332f = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: i */
    public C0900a f5335i = null;

    /* renamed from: j */
    public C0900a f5336j = null;

    /* renamed from: k */
    public boolean f5337k = false;

    /* renamed from: m */
    public int f5339m = 0;

    public C1017u2(Context context, C0934a0 c0934a0, Lock lock, Looper looper, C1109m c1109m, Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map, Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map2, C1086u0 c1086u0, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b, C0905a.InterfaceC0916f interfaceC0916f, ArrayList<C1009s2> arrayList, ArrayList<C1009s2> arrayList2, Map<C0905a<?>, Boolean> map3, Map<C0905a<?>, Boolean> map4) {
        this.f5327a = context;
        this.f5328b = c0934a0;
        this.f5338l = lock;
        this.f5333g = interfaceC0916f;
        this.f5329c = new C0954f0(context, this.f5328b, lock, looper, c1109m, map2, null, map4, null, arrayList2, new C1025w2(this, null));
        this.f5330d = new C0954f0(context, this.f5328b, lock, looper, c1109m, map, c1086u0, map3, abstractC0912b, arrayList, new C1029x2(this, null));
        ArrayMap arrayMap = new ArrayMap();
        for (C0905a.C0914d<?> c0914d : map2.keySet()) {
            arrayMap.put(c0914d, this.f5329c);
        }
        for (C0905a.C0914d<?> c0914d2 : map.keySet()) {
            arrayMap.put(c0914d2, this.f5330d);
        }
        this.f5331e = Collections.unmodifiableMap(arrayMap);
    }

    /* renamed from: a */
    public static C1017u2 m5364a(Context context, C0934a0 c0934a0, Lock lock, Looper looper, C1109m c1109m, Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map, C1086u0 c1086u0, Map<C0905a<?>, Boolean> map2, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b, ArrayList<C1009s2> arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        C0905a.InterfaceC0916f interfaceC0916f = null;
        for (Map.Entry<C0905a.C0914d<?>, C0905a.InterfaceC0916f> entry : map.entrySet()) {
            C0905a.InterfaceC0916f value = entry.getValue();
            if (value.m5606j()) {
                interfaceC0916f = value;
            }
            boolean mo5043e = value.mo5043e();
            C0905a.C0914d<?> key = entry.getKey();
            if (mo5043e) {
                arrayMap.put(key, value);
            } else {
                arrayMap2.put(key, value);
            }
        }
        C1049c0.m5285b(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (C0905a<?> c0905a : map2.keySet()) {
            C0905a.C0914d<?> m5619d = c0905a.m5619d();
            if (arrayMap.containsKey(m5619d)) {
                arrayMap3.put(c0905a, map2.get(c0905a));
            } else if (!arrayMap2.containsKey(m5619d)) {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            } else {
                arrayMap4.put(c0905a, map2.get(c0905a));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            C1009s2 c1009s2 = arrayList.get(i);
            i++;
            C1009s2 c1009s22 = c1009s2;
            if (arrayMap3.containsKey(c1009s22.f5315a)) {
                arrayList2.add(c1009s22);
            } else if (!arrayMap4.containsKey(c1009s22.f5315a)) {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            } else {
                arrayList3.add(c1009s22);
            }
        }
        return new C1017u2(context, c0934a0, lock, looper, c1109m, arrayMap, arrayMap2, c1086u0, abstractC0912b, interfaceC0916f, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* renamed from: b */
    public static boolean m5356b(C0900a c0900a) {
        return c0900a != null && c0900a.m5641f();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5330a(T t) {
        if (m5355b((AbstractC0981l2<? extends InterfaceC0928g, ? extends C0905a.InterfaceC0913c>) t)) {
            if (m5346g()) {
                t.m5436c(new Status(4, null, m5345h()));
                return t;
            }
            return (T) this.f5330d.mo5330a((C0954f0) t);
        }
        return (T) this.f5329c.mo5330a((C0954f0) t);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final void mo5331a() {
        this.f5336j = null;
        this.f5335i = null;
        this.f5339m = 0;
        this.f5329c.mo5331a();
        this.f5330d.mo5331a();
        m5348f();
    }

    /* renamed from: a */
    public final void m5365a(int i, boolean z) {
        this.f5328b.mo5320a(i, z);
        this.f5336j = null;
        this.f5335i = null;
    }

    /* renamed from: a */
    public final void m5363a(Bundle bundle) {
        Bundle bundle2 = this.f5334h;
        if (bundle2 == null) {
            this.f5334h = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    /* renamed from: a */
    public final void m5362a(C0900a c0900a) {
        int i = this.f5339m;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f5339m = 0;
            }
            this.f5328b.mo5318a(c0900a);
        }
        m5348f();
        this.f5339m = 0;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final void mo5329a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f5330d.mo5329a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f5329c.mo5329a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: b */
    public final void mo5328b() {
        this.f5339m = 2;
        this.f5337k = false;
        this.f5336j = null;
        this.f5335i = null;
        this.f5329c.mo5328b();
        this.f5330d.mo5328b();
    }

    /* renamed from: b */
    public final boolean m5355b(AbstractC0981l2<? extends InterfaceC0928g, ? extends C0905a.InterfaceC0913c> abstractC0981l2) {
        C0905a.C0914d<? extends C0905a.InterfaceC0913c> m5435h = abstractC0981l2.m5435h();
        C1049c0.m5289a(this.f5331e.containsKey(m5435h), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f5331e.get(m5435h).equals(this.f5330d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x001e, code lost:
        if (r2.f5339m == 1) goto L12;
     */
    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo5327c() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f5338l
            r0.lock()
            c.d.a.a.e.e.l.f0 r0 = r2.f5329c     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.mo5327c()     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r0 == 0) goto L21
            c.d.a.a.e.e.l.f0 r0 = r2.f5330d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.mo5327c()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            boolean r0 = r2.m5346g()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            int r0 = r2.f5339m     // Catch: java.lang.Throwable -> L28
            if (r0 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            java.util.concurrent.locks.Lock r0 = r2.f5338l
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.f5338l
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1017u2.mo5327c():boolean");
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: d */
    public final void mo5326d() {
        this.f5329c.mo5326d();
        this.f5330d.mo5326d();
    }

    /* renamed from: e */
    public final void m5350e() {
        C0900a c0900a;
        if (!m5356b(this.f5335i)) {
            if (this.f5335i != null && m5356b(this.f5336j)) {
                this.f5330d.mo5331a();
                m5362a(this.f5335i);
                return;
            }
            C0900a c0900a2 = this.f5335i;
            if (c0900a2 == null || (c0900a = this.f5336j) == null) {
                return;
            }
            if (this.f5330d.f5171l < this.f5329c.f5171l) {
                c0900a2 = c0900a;
            }
            m5362a(c0900a2);
        } else if (!m5356b(this.f5336j) && !m5346g()) {
            C0900a c0900a3 = this.f5336j;
            if (c0900a3 != null) {
                if (this.f5339m == 1) {
                    m5348f();
                    return;
                }
                m5362a(c0900a3);
                this.f5329c.mo5331a();
            }
        } else {
            int i = this.f5339m;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    this.f5339m = 0;
                }
                this.f5328b.mo5319a(this.f5334h);
            }
            m5348f();
            this.f5339m = 0;
        }
    }

    /* renamed from: f */
    public final void m5348f() {
        for (InterfaceC0984m1 interfaceC0984m1 : this.f5332f) {
            interfaceC0984m1.m5433a();
        }
        this.f5332f.clear();
    }

    /* renamed from: g */
    public final boolean m5346g() {
        C0900a c0900a = this.f5336j;
        return c0900a != null && c0900a.m5645b() == 4;
    }

    /* renamed from: h */
    public final PendingIntent m5345h() {
        if (this.f5333g == null) {
            return null;
        }
        System.identityHashCode(this.f5328b);
        this.f5333g.m5605k();
        throw null;
    }
}
