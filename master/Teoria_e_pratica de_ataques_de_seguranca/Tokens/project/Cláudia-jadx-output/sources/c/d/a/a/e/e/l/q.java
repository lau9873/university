package c.d.a.a.e.e.l;

import android.content.Context;
import c.d.a.a.e.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class q extends x {

    /* renamed from: b  reason: collision with root package name */
    public final Map<a.f, p> f3390b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f3391c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n nVar, Map<a.f, p> map) {
        super(nVar, null);
        this.f3391c = nVar;
        this.f3390b = map;
    }

    public final int a(a.f fVar, Map<a.f, Integer> map) {
        int i2;
        Context context;
        c.d.a.a.e.f.c0.a(fVar);
        c.d.a.a.e.f.c0.a(map);
        if (fVar.g()) {
            if (map.containsKey(fVar)) {
                return map.get(fVar).intValue();
            }
            Iterator<a.f> it = map.keySet().iterator();
            if (it.hasNext()) {
                a.f next = it.next();
                next.d();
                fVar.d();
                i2 = map.get(next).intValue();
            } else {
                i2 = -1;
            }
            if (i2 == -1) {
                context = this.f3391c.f3356c;
                i2 = c.d.a.a.e.m.a(context, fVar.d());
            }
            map.put(fVar, Integer.valueOf(i2));
            return i2;
        }
        return 0;
    }

    @Override // c.d.a.a.e.e.l.x
    public final void a() {
        boolean z;
        f0 f0Var;
        c.d.a.a.h.x0 x0Var;
        f0 f0Var2;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f fVar : this.f3390b.keySet()) {
            if (fVar.g()) {
                z2 = this.f3390b.get(fVar).f3384c;
                if (!z2) {
                    arrayList.add(fVar);
                }
            }
            arrayList2.add(fVar);
        }
        HashMap hashMap = new HashMap(this.f3390b.size());
        int i2 = -1;
        int i3 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                i2 = a((a.f) obj, hashMap);
                if (i2 == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                i2 = a((a.f) obj2, hashMap);
                if (i2 != 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            c.d.a.a.e.a aVar = new c.d.a.a.e.a(i2, null);
            f0Var2 = this.f3391c.f3354a;
            f0Var2.a(new r(this, this.f3391c, aVar));
            return;
        }
        z = this.f3391c.m;
        if (z) {
            x0Var = this.f3391c.k;
            x0Var.b();
        }
        for (a.f fVar2 : this.f3390b.keySet()) {
            p pVar = this.f3390b.get(fVar2);
            if (!fVar2.g() || a(fVar2, hashMap) == 0) {
                fVar2.a(pVar);
            } else {
                f0Var = this.f3391c.f3354a;
                f0Var.a(new s(this, this.f3391c, pVar));
            }
        }
    }
}
