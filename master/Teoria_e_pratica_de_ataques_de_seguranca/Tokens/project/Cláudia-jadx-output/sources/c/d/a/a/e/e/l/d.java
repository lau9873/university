package c.d.a.a.e.e.l;

import android.util.Log;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class d implements c.d.a.a.j.a<Map<g2<?>, String>> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ b f3276a;

    public d(b bVar) {
        this.f3276a = bVar;
    }

    @Override // c.d.a.a.j.a
    public final void onComplete(c.d.a.a.j.c<Map<g2<?>, String>> cVar) {
        Lock lock;
        Lock lock2;
        boolean z;
        b bVar;
        c.d.a.a.e.a aVar;
        boolean z2;
        Map map;
        Map map2;
        boolean a2;
        Map map3;
        Map map4;
        c.d.a.a.e.a aVar2;
        a0 a0Var;
        c.d.a.a.e.a aVar3;
        Condition condition;
        Map map5;
        Map map6;
        c.d.a.a.e.a g2;
        Map map7;
        Map map8;
        Map map9;
        lock = this.f3276a.f3263f;
        lock.lock();
        try {
            z = this.f3276a.n;
            if (z) {
                if (cVar.c()) {
                    b bVar2 = this.f3276a;
                    map7 = this.f3276a.f3258a;
                    bVar2.o = new a.b.g.j.a(map7.size());
                    map8 = this.f3276a.f3258a;
                    for (y2 y2Var : map8.values()) {
                        map9 = this.f3276a.o;
                        map9.put(y2Var.d(), c.d.a.a.e.a.f3212e);
                    }
                } else {
                    if (cVar.a() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) cVar.a();
                        z2 = this.f3276a.l;
                        if (z2) {
                            b bVar3 = this.f3276a;
                            map = this.f3276a.f3258a;
                            bVar3.o = new a.b.g.j.a(map.size());
                            map2 = this.f3276a.f3258a;
                            for (y2 y2Var2 : map2.values()) {
                                Object d2 = y2Var2.d();
                                c.d.a.a.e.a a3 = availabilityException.a(y2Var2);
                                a2 = this.f3276a.a(y2Var2, a3);
                                if (a2) {
                                    map3 = this.f3276a.o;
                                    a3 = new c.d.a.a.e.a(16);
                                } else {
                                    map3 = this.f3276a.o;
                                }
                                map3.put(d2, a3);
                            }
                        } else {
                            this.f3276a.o = availabilityException.a();
                        }
                        bVar = this.f3276a;
                        aVar = this.f3276a.g();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", cVar.a());
                        this.f3276a.o = Collections.emptyMap();
                        bVar = this.f3276a;
                        aVar = new c.d.a.a.e.a(8);
                    }
                    bVar.r = aVar;
                }
                map4 = this.f3276a.p;
                if (map4 != null) {
                    map5 = this.f3276a.o;
                    map6 = this.f3276a.p;
                    map5.putAll(map6);
                    b bVar4 = this.f3276a;
                    g2 = this.f3276a.g();
                    bVar4.r = g2;
                }
                aVar2 = this.f3276a.r;
                if (aVar2 == null) {
                    this.f3276a.e();
                    this.f3276a.f();
                } else {
                    this.f3276a.n = false;
                    a0Var = this.f3276a.f3262e;
                    aVar3 = this.f3276a.r;
                    a0Var.a(aVar3);
                }
                condition = this.f3276a.f3266i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.f3276a.f3263f;
            lock2.unlock();
        }
    }
}
