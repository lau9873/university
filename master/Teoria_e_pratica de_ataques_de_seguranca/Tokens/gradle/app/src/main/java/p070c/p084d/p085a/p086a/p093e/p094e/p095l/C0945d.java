package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.util.Log;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import p000a.p006b.p030g.p044j.ArrayMap;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p104j.AbstractC1237c;
import p070c.p084d.p085a.p086a.p104j.InterfaceC1235a;

/* renamed from: c.d.a.a.e.e.l.d */
/* loaded from: classes.dex */
public final class C0945d implements InterfaceC1235a<Map<C0960g2<?>, String>> {

    /* renamed from: a */
    public /* synthetic */ C0937b f5151a;

    public C0945d(C0937b c0937b) {
        this.f5151a = c0937b;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1235a
    public final void onComplete(AbstractC1237c<Map<C0960g2<?>, String>> abstractC1237c) {
        Lock lock;
        Lock lock2;
        boolean z;
        C0937b c0937b;
        C0900a c0900a;
        boolean z2;
        Map map;
        Map map2;
        boolean m5560a;
        Map map3;
        Map map4;
        C0900a c0900a2;
        C0934a0 c0934a0;
        C0900a c0900a3;
        Condition condition;
        Map map5;
        Map map6;
        C0900a m5551g;
        Map map7;
        Map map8;
        Map map9;
        lock = this.f5151a.f5129f;
        lock.lock();
        try {
            z = this.f5151a.f5137n;
            if (z) {
                if (abstractC1237c.mo4961c()) {
                    C0937b c0937b2 = this.f5151a;
                    map7 = this.f5151a.f5124a;
                    c0937b2.f5138o = new ArrayMap(map7.size());
                    map8 = this.f5151a.f5124a;
                    for (C1033y2 c1033y2 : map8.values()) {
                        map9 = this.f5151a.f5138o;
                        map9.put(c1033y2.m5595d(), C0900a.f5050e);
                    }
                } else {
                    if (abstractC1237c.mo4970a() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) abstractC1237c.mo4970a();
                        z2 = this.f5151a.f5135l;
                        if (z2) {
                            C0937b c0937b3 = this.f5151a;
                            map = this.f5151a.f5124a;
                            c0937b3.f5138o = new ArrayMap(map.size());
                            map2 = this.f5151a.f5124a;
                            for (C1033y2 c1033y22 : map2.values()) {
                                Object m5595d = c1033y22.m5595d();
                                C0900a m4377a = availabilityException.m4377a(c1033y22);
                                m5560a = this.f5151a.m5560a(c1033y22, m4377a);
                                if (m5560a) {
                                    map3 = this.f5151a.f5138o;
                                    m4377a = new C0900a(16);
                                } else {
                                    map3 = this.f5151a.f5138o;
                                }
                                map3.put(m5595d, m4377a);
                            }
                        } else {
                            this.f5151a.f5138o = availabilityException.m4378a();
                        }
                        c0937b = this.f5151a;
                        c0900a = this.f5151a.m5551g();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", abstractC1237c.mo4970a());
                        this.f5151a.f5138o = Collections.emptyMap();
                        c0937b = this.f5151a;
                        c0900a = new C0900a(8);
                    }
                    c0937b.f5141r = c0900a;
                }
                map4 = this.f5151a.f5139p;
                if (map4 != null) {
                    map5 = this.f5151a.f5138o;
                    map6 = this.f5151a.f5139p;
                    map5.putAll(map6);
                    C0937b c0937b4 = this.f5151a;
                    m5551g = this.f5151a.m5551g();
                    c0937b4.f5141r = m5551g;
                }
                c0900a2 = this.f5151a.f5141r;
                if (c0900a2 == null) {
                    this.f5151a.m5555e();
                    this.f5151a.m5553f();
                } else {
                    this.f5151a.f5137n = false;
                    c0934a0 = this.f5151a.f5128e;
                    c0900a3 = this.f5151a.f5141r;
                    c0934a0.mo5318a(c0900a3);
                }
                condition = this.f5151a.f5132i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.f5151a.f5129f;
            lock2.unlock();
        }
    }
}
