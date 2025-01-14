package g.a.a.n;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* compiled from: RangeState.java */
/* loaded from: classes.dex */
public class f implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f6109c = false;

    /* renamed from: a  reason: collision with root package name */
    public a f6110a;

    /* renamed from: b  reason: collision with root package name */
    public Map<g.a.a.c, g> f6111b = new HashMap();

    public f(a aVar) {
        this.f6110a = aVar;
    }

    public static boolean c() {
        return f6109c;
    }

    public void a(g.a.a.c cVar) {
        g gVar = this.f6111b.get(cVar);
        if (gVar != null) {
            if (g.a.a.m.d.a()) {
                g.a.a.m.d.a("RangeState", "adding %s to existing range for: %s", cVar, gVar);
            }
            gVar.a(cVar);
            return;
        }
        if (g.a.a.m.d.a()) {
            g.a.a.m.d.a("RangeState", "adding %s to new rangedBeacon", cVar);
        }
        this.f6111b.put(cVar, new g(cVar));
    }

    public a b() {
        return this.f6110a;
    }

    public synchronized Collection<g.a.a.c> a() {
        ArrayList arrayList;
        HashMap hashMap = new HashMap();
        arrayList = new ArrayList();
        synchronized (this.f6111b) {
            for (g.a.a.c cVar : this.f6111b.keySet()) {
                g gVar = this.f6111b.get(cVar);
                if (gVar != null) {
                    if (gVar.f()) {
                        gVar.a();
                        if (!gVar.g()) {
                            arrayList.add(gVar.b());
                        }
                    }
                    if (!gVar.g()) {
                        if (!f6109c || gVar.e()) {
                            gVar.a(false);
                        }
                        hashMap.put(cVar, gVar);
                    } else {
                        g.a.a.m.d.a("RangeState", "Dumping beacon from RangeState because it has no recent measurements.", new Object[0]);
                    }
                }
            }
            this.f6111b = hashMap;
        }
        return arrayList;
    }

    public static void a(boolean z) {
        f6109c = z;
    }
}
