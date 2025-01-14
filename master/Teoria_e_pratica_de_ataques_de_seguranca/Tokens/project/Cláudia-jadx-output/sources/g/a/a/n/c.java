package g.a.a.n;

import java.io.Serializable;
import java.util.HashMap;
/* compiled from: ExtraDataBeaconTracker.java */
/* loaded from: classes.dex */
public class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, HashMap<Integer, g.a.a.c>> f6099a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6100b;

    public c() {
        this(true);
    }

    public final String a(g.a.a.c cVar) {
        if (this.f6100b) {
            return cVar.b() + cVar.j();
        }
        return cVar.b();
    }

    public synchronized g.a.a.c b(g.a.a.c cVar) {
        if (cVar.m() || cVar.j() != -1) {
            cVar = c(cVar);
        }
        return cVar;
    }

    public final g.a.a.c c(g.a.a.c cVar) {
        if (cVar.l()) {
            d(cVar);
            return null;
        }
        String a2 = a(cVar);
        HashMap<Integer, g.a.a.c> hashMap = this.f6099a.get(a2);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        } else {
            cVar.a(hashMap.values().iterator().next().f());
        }
        hashMap.put(Integer.valueOf(cVar.hashCode()), cVar);
        this.f6099a.put(a2, hashMap);
        return cVar;
    }

    public final void d(g.a.a.c cVar) {
        HashMap<Integer, g.a.a.c> hashMap = this.f6099a.get(a(cVar));
        if (hashMap != null) {
            for (g.a.a.c cVar2 : hashMap.values()) {
                cVar2.c(cVar.i());
                cVar2.a(cVar.d());
            }
        }
    }

    public c(boolean z) {
        this.f6099a = new HashMap<>();
        this.f6100b = z;
    }
}
