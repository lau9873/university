package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.AvailabilityException;
import java.util.Map;
import java.util.Set;
import p000a.p006b.p030g.p044j.ArrayMap;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p104j.AbstractC1237c;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.i2 */
/* loaded from: classes.dex */
public final class C0969i2 {

    /* renamed from: d */
    public int f5199d;

    /* renamed from: b */
    public final ArrayMap<C0960g2<?>, String> f5197b = new ArrayMap<>();

    /* renamed from: c */
    public final C1238d<Map<C0960g2<?>, String>> f5198c = new C1238d<>();

    /* renamed from: e */
    public boolean f5200e = false;

    /* renamed from: a */
    public final ArrayMap<C0960g2<?>, C0900a> f5196a = new ArrayMap<>();

    public C0969i2(Iterable<? extends C0919c<?>> iterable) {
        for (C0919c<?> c0919c : iterable) {
            this.f5196a.put(c0919c.m5595d(), null);
        }
        this.f5199d = this.f5196a.keySet().size();
    }

    /* renamed from: a */
    public final AbstractC1237c<Map<C0960g2<?>, String>> m5511a() {
        return this.f5198c.m4981a();
    }

    /* renamed from: a */
    public final void m5510a(C0960g2<?> c0960g2, C0900a c0900a, String str) {
        this.f5196a.put(c0960g2, c0900a);
        this.f5197b.put(c0960g2, str);
        this.f5199d--;
        if (!c0900a.m5641f()) {
            this.f5200e = true;
        }
        if (this.f5199d == 0) {
            if (!this.f5200e) {
                this.f5198c.m4979a((C1238d<Map<C0960g2<?>, String>>) this.f5197b);
                return;
            }
            this.f5198c.m4980a(new AvailabilityException(this.f5196a));
        }
    }

    /* renamed from: b */
    public final Set<C0960g2<?>> m5509b() {
        return this.f5196a.keySet();
    }
}
