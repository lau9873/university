package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.q */
/* loaded from: classes.dex */
public final class C0998q extends AbstractRunnableC1026x {

    /* renamed from: b */
    public final Map<C0905a.InterfaceC0916f, C0994p> f5295b;

    /* renamed from: c */
    public final /* synthetic */ C0986n f5296c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0998q(C0986n c0986n, Map<C0905a.InterfaceC0916f, C0994p> map) {
        super(c0986n, null);
        this.f5296c = c0986n;
        this.f5295b = map;
    }

    /* renamed from: a */
    public final int m5390a(C0905a.InterfaceC0916f interfaceC0916f, Map<C0905a.InterfaceC0916f, Integer> map) {
        int i;
        Context context;
        C1049c0.m5294a(interfaceC0916f);
        C1049c0.m5294a(map);
        if (interfaceC0916f.m5609g()) {
            if (map.containsKey(interfaceC0916f)) {
                return map.get(interfaceC0916f).intValue();
            }
            Iterator<C0905a.InterfaceC0916f> it = map.keySet().iterator();
            if (it.hasNext()) {
                C0905a.InterfaceC0916f next = it.next();
                next.mo5296d();
                interfaceC0916f.mo5296d();
                i = map.get(next).intValue();
            } else {
                i = -1;
            }
            if (i == -1) {
                context = this.f5296c.f5249c;
                i = C1109m.m5122a(context, interfaceC0916f.mo5296d());
            }
            map.put(interfaceC0916f, Integer.valueOf(i));
            return i;
        }
        return 0;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractRunnableC1026x
    /* renamed from: a */
    public final void mo5332a() {
        boolean z;
        C0954f0 c0954f0;
        InterfaceC1199x0 interfaceC1199x0;
        C0954f0 c0954f02;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C0905a.InterfaceC0916f interfaceC0916f : this.f5295b.keySet()) {
            if (interfaceC0916f.m5609g()) {
                z2 = this.f5295b.get(interfaceC0916f).f5289c;
                if (!z2) {
                    arrayList.add(interfaceC0916f);
                }
            }
            arrayList2.add(interfaceC0916f);
        }
        HashMap hashMap = new HashMap(this.f5295b.size());
        int i = -1;
        int i2 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                i = m5390a((C0905a.InterfaceC0916f) obj, hashMap);
                if (i == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i2 < size2) {
                Object obj2 = arrayList.get(i2);
                i2++;
                i = m5390a((C0905a.InterfaceC0916f) obj2, hashMap);
                if (i != 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            C0900a c0900a = new C0900a(i, null);
            c0954f02 = this.f5296c.f5247a;
            c0954f02.m5527a(new C1002r(this, this.f5296c, c0900a));
            return;
        }
        z = this.f5296c.f5259m;
        if (z) {
            interfaceC1199x0 = this.f5296c.f5257k;
            interfaceC1199x0.mo5004b();
        }
        for (C0905a.InterfaceC0916f interfaceC0916f2 : this.f5295b.keySet()) {
            C0994p c0994p = this.f5295b.get(interfaceC0916f2);
            if (!interfaceC0916f2.m5609g() || m5390a(interfaceC0916f2, hashMap) == 0) {
                interfaceC0916f2.m5614a(c0994p);
            } else {
                c0954f0 = this.f5296c.f5247a;
                c0954f0.m5527a(new C1006s(this, this.f5296c, c0994p));
            }
        }
    }
}
