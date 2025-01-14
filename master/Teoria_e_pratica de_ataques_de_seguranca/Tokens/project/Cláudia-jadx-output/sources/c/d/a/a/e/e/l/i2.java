package c.d.a.a.e.e.l;

import com.google.android.gms.common.api.AvailabilityException;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class i2 {

    /* renamed from: d  reason: collision with root package name */
    public int f3319d;

    /* renamed from: b  reason: collision with root package name */
    public final a.b.g.j.a<g2<?>, String> f3317b = new a.b.g.j.a<>();

    /* renamed from: c  reason: collision with root package name */
    public final c.d.a.a.j.d<Map<g2<?>, String>> f3318c = new c.d.a.a.j.d<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f3320e = false;

    /* renamed from: a  reason: collision with root package name */
    public final a.b.g.j.a<g2<?>, c.d.a.a.e.a> f3316a = new a.b.g.j.a<>();

    public i2(Iterable<? extends c.d.a.a.e.e.c<?>> iterable) {
        for (c.d.a.a.e.e.c<?> cVar : iterable) {
            this.f3316a.put(cVar.d(), null);
        }
        this.f3319d = this.f3316a.keySet().size();
    }

    public final c.d.a.a.j.c<Map<g2<?>, String>> a() {
        return this.f3318c.a();
    }

    public final void a(g2<?> g2Var, c.d.a.a.e.a aVar, String str) {
        this.f3316a.put(g2Var, aVar);
        this.f3317b.put(g2Var, str);
        this.f3319d--;
        if (!aVar.f()) {
            this.f3320e = true;
        }
        if (this.f3319d == 0) {
            if (!this.f3320e) {
                this.f3318c.a((c.d.a.a.j.d<Map<g2<?>, String>>) this.f3317b);
                return;
            }
            this.f3318c.a(new AvailabilityException(this.f3316a));
        }
    }

    public final Set<g2<?>> b() {
        return this.f3316a.keySet();
    }
}
